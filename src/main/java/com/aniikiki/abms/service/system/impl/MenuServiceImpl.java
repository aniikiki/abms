package com.aniikiki.abms.service.system.impl;

import com.alibaba.fastjson.JSON;
import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ModelOpType;
import com.aniikiki.abms.dao.system.MenuDao;
import com.aniikiki.abms.dto.system.MenuDto;
import com.aniikiki.abms.entity.system.MenuEntity;
import com.aniikiki.abms.service.system.MenuService;
import com.aniikiki.abms.utils.ModelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MenuEntity> getMenuList(MenuDto dto) {
        return menuDao.selectByCriteria(dto);
    }

    @Override
    public MenuEntity getMenuInfo(String menuId) {
        return menuDao.selectByPrimaryKey(menuId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int createMenu(MenuEntity menu) {
        ModelUtil.setBasicModelData(menu, menu.getCreateUser(), DataStatus.ENABLE.getCode(), ModelOpType.CREATE);
        return menuDao.insert(menu);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int update(MenuEntity menu) {
        ModelUtil.setBasicModelData(menu, menu.getUpdateUser(), ModelOpType.UPDATE);
        return menuDao.updateByPrimaryKeySelective(menu);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int updateMenu(MenuEntity menu) {
        int count = this.update(menu);

        /** 如果是禁用该菜单并且有子菜单，则递归禁用所有子菜单 **/
        if (DataStatus.UNABLE.getCode().equals(menu.getStatus())) {
            MenuDto dto = new MenuDto();
            dto.setStatus(DataStatus.ENABLE.getCode());
            dto.setPid(menu.getMenuId());
            List<MenuEntity> menuList = menuDao.selectByCriteria(dto);

            if (menuList != null && menuList.size() > 0) {
                dto.setPid(null);
                menuList = menuDao.selectByCriteria(dto);

                List<String> descendantList = new ArrayList<>();
                getDescendantMenuId(menuList, menu.getMenuId(), descendantList);

                dto.setStatus(DataStatus.UNABLE.getCode());
                dto.setUpdateUser(menu.getUpdateUser());
                ModelUtil.setBasicModelData(dto, dto.getUpdateUser(), ModelOpType.UPDATE);
                dto.setDescendantList(descendantList);
                count += menuDao.updateStatusBatch(dto);
            }
        }

        return count;
    }

    /**
     * 删除菜单及其所有子菜单
     * @param menuId
     * @param userId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int deleteMenu(String menuId, String userId) {
        int count = 0;

        /** 删除所选菜单 **/
        MenuEntity menu = new MenuEntity();
        menu.setMenuId(menuId);
        menu.setStatus(DataStatus.DELETION.getCode());
        menu.setUpdateUser(userId);
        count += this.update(menu);


        MenuDto dto = new MenuDto();
        dto.setExcludeStatus(DataStatus.DELETION.getCode());
        dto.setPid(menuId);
        List<MenuEntity> menuList = menuDao.selectByCriteria(dto);

        /** 如果有子菜单，则递归删除所有子菜单 **/
        if (menuList != null && menuList.size() > 0) {
            dto.setPid(null);
            menuList = menuDao.selectByCriteria(dto);

            if (menuList != null && menuList.size() > 0) {
                List<String> descendantList = new ArrayList<>();
                getDescendantMenuId(menuList, menuId, descendantList);

                dto.setStatus(DataStatus.DELETION.getCode());
                dto.setUpdateUser(userId);
                ModelUtil.setBasicModelData(dto, dto.getUpdateUser(), ModelOpType.UPDATE);
                dto.setDescendantList(descendantList);
                count += menuDao.updateStatusBatch(dto);
            }
        }

        return count;
    }

    private void getDescendantMenuId(List<MenuEntity> menuList, String menuId, List<String> descendantList) {
        for (MenuEntity menuEntity : menuList) {
            if (menuId.equals(menuEntity.getPid())) {
                descendantList.add(menuEntity.getMenuId());
                getDescendantMenuId(menuList, menuEntity.getMenuId(), descendantList);
            }
        }
    }

}
