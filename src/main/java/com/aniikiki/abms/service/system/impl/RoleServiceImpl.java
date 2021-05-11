package com.aniikiki.abms.service.system.impl;

import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ModelOpType;
import com.aniikiki.abms.dao.system.RoleDao;
import com.aniikiki.abms.dao.system.RoleMenuRelDao;
import com.aniikiki.abms.dto.system.RoleDto;
import com.aniikiki.abms.entity.system.RoleEntity;
import com.aniikiki.abms.entity.system.RoleMenuRelEntity;
import com.aniikiki.abms.service.system.RoleService;
import com.aniikiki.abms.utils.ModelUtil;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMenuRelDao roleMenuRelDao;

    @Override
    public List<RoleEntity> getRoleList(RoleDto dto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return roleDao.selectByCriteria(dto);
    }

    @Override
    public List<RoleEntity> getRoleList(RoleDto dto) {
        return roleDao.selectByCriteria(dto);
    }

    @Override
    public RoleEntity getRoleInfo(String roleId) {
        return roleDao.selectByPrimaryKey(roleId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int createRole(RoleEntity role) {
        ModelUtil.setBasicModelData(role, role.getCreateUser(), DataStatus.ENABLE.getCode(), ModelOpType.CREATE);
        return roleDao.insert(role);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int updateRole(RoleEntity role) {
        ModelUtil.setBasicModelData(role, role.getUpdateUser(), ModelOpType.UPDATE);
        return roleDao.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<RoleEntity> getRoleListByRoleName(String excludeRoleId, String roleName) {
        RoleDto dto = new RoleDto();
        dto.setRoleName(roleName);
        dto.setExcludeRoleId(excludeRoleId);
        return roleDao.selectByCriteria(dto);
    }

    @Override
    public List<RoleMenuRelEntity> getRoleMenuList(String roleId) {
        return roleMenuRelDao.selectByCriteria(roleId, null);
    }

    @Override
    public boolean assignMenu(String roleId, String[] menuIdArr, String currentUserId) {
        //与之前分配的菜单解除关联
        roleMenuRelDao.updateStatusByCriteria(roleId, null, DataStatus.DELETION.getCode(), currentUserId, ModelUtil.now());

        //关联新分配的菜单
        if (menuIdArr.length > 0) {
            RoleDto dto = new RoleDto();
            dto.setRoleId(roleId);
            dto.setMenuIdArr(menuIdArr);
            ModelUtil.setBasicModelData(dto, currentUserId, DataStatus.ENABLE.getCode(), ModelOpType.CREATE);

            int count = roleMenuRelDao.insertBatch(dto);
        }

        return true;
    }
}
