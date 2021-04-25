package com.aniikiki.abms.controller.system;

import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ResultMessage;
import com.aniikiki.abms.controller.BaseController;
import com.aniikiki.abms.dto.system.MenuDto;
import com.aniikiki.abms.entity.system.MenuEntity;
import com.aniikiki.abms.service.system.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单管理
 * @author aniikiki
 * @date 2021-04-22 10:18:59
 */
@RestController
@RequestMapping("/menu")
@Api(tags = "菜单管理")
@Slf4j
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("菜单列表")
    @PostMapping("/list")
    public CommonResult<List<MenuEntity>> getMenuList(@RequestBody MenuDto dto) {
        dto.setExcludeStatus(DataStatus.DELETION.getCode());
        List<MenuEntity> menuList = menuService.getMenuList(dto);
        return CommonResult.success(menuList);
    }

    @ApiOperation("菜单信息")
    @GetMapping("/info/{menuId}")
    public CommonResult<MenuEntity> getMenuInfo(@PathVariable(value = "menuId") String menuId) {
        MenuEntity menu = menuService.getMenuInfo(menuId);
        if (menu != null) {
            return CommonResult.success(menu);
        } else {
            return CommonResult.failed(ResultMessage.SYS_MENU_NOT_FOUND);
        }
    }

    @ApiOperation("新增菜单")
    @PostMapping("/create")
    public CommonResult createMenu(@RequestBody MenuEntity menu) {
        if (!validCreateParam(menu)) {
            return CommonResult.validateFailed();
        }

        menu.setCreateUser(this.getCurrentUserId());
        int count = menuService.createMenu(menu);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改菜单")
    @PostMapping("/update/{menuId}")
    public CommonResult updateMenu(@PathVariable( value = "menuId") String menuId, @RequestBody MenuEntity menu) {
        if (!validUpdateParam(menu)) {
            return CommonResult.validateFailed();
        }

        menu.setUpdateUser(this.getCurrentUserId());
        int count = menuService.updateMenu(menu);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除菜单及其所有子菜单")
    @PostMapping("/delete/{menuId}")
    public CommonResult deleteMenu(@PathVariable( value = "menuId") String menuId) {
        int count = menuService.deleteMenu(menuId, this.getCurrentUserId());
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    private boolean validCreateParam(MenuEntity menu) {
        String menuName = menu.getMenuName();
        String menuType = menu.getMenuType();
        String menuUrl = menu.getMenuUrl();
        String menuIcon = menu.getMenuIcon();
        Integer sort = menu.getSort();

        if (StringUtils.isBlank(menuName) || StringUtils.isBlank(menuType) || StringUtils.isBlank(menuUrl)
                || StringUtils.isBlank(menuIcon) || sort == null) {
            return false;
        }

        return true;
    }

    private boolean validUpdateParam(MenuEntity menu) {
        String menuId = menu.getMenuId();

        if (StringUtils.isBlank(menuId)) {
            return false;
        }

        return true;
    }
}
