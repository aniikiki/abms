package com.aniikiki.abms.service.system;

import com.aniikiki.abms.dto.system.MenuDto;
import com.aniikiki.abms.entity.system.MenuEntity;

import java.util.List;

public interface MenuService {

    List<MenuEntity> getMenuList(MenuDto dto);

    MenuEntity getMenuInfo(String menuId);

    int createMenu(MenuEntity menu);

    int update(MenuEntity menu);

    int updateMenu(MenuEntity menu);

    int deleteMenu(String menuId, String userId);
}
