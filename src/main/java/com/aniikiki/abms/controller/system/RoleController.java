package com.aniikiki.abms.controller.system;

import com.aniikiki.abms.common.CommonPage;
import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ResultMessage;
import com.aniikiki.abms.controller.BaseController;
import com.aniikiki.abms.dto.system.RoleDto;
import com.aniikiki.abms.entity.system.RoleEntity;
import com.aniikiki.abms.service.system.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 * @author aniikiki
 * @date 2021-04-21 11:00:15
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
@Slf4j
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("角色列表")
    @PostMapping("/list")
    public CommonResult<CommonPage<RoleEntity>> getRoleList(@RequestBody RoleDto dto,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<RoleEntity> roleList = roleService.getRoleList(dto, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("角色信息")
    @GetMapping("/info/{roleId}")
    public CommonResult<RoleEntity> getRoleInfo(@PathVariable(value = "roleId") String roleId) {
        RoleEntity role = roleService.getRoleInfo(roleId);
        if (role != null && !DataStatus.DELETION.getCode().equals(role.getStatus())) {
            return CommonResult.success(role);
        } else {
            return CommonResult.failed(ResultMessage.SYS_ROLE_NOT_FOUND);
        }
    }

    @ApiOperation("新增角色")
    @PostMapping("/create")
    public CommonResult createRole(@RequestBody RoleEntity role) {
        if (!validCreateParam(role)) {
            return CommonResult.validateFailed();
        }

        List<RoleEntity> roleList = roleService.getRoleListByRoleName(null, role.getRoleName());
        if (roleList != null && roleList.size() > 0) {
            return CommonResult.failed(ResultMessage.SYS_ROLE_NAME_ALREADY_EXISTS);
        }

        role.setCreateUser(this.getCurrentUserId());
        int count = roleService.createRole(role);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改角色")
    @PostMapping("/update/{roleId}")
    public CommonResult updateRole(@PathVariable( value = "roleId") String roleId, @RequestBody RoleEntity role) {
        if (!validUpdateParam(role)) {
            return CommonResult.validateFailed();
        }

        if (StringUtils.isNotEmpty(role.getRoleName())) {
            List<RoleEntity> roleList = roleService.getRoleListByRoleName(roleId, role.getRoleName());
            if (roleList != null && roleList.size() > 0) {
                return CommonResult.failed(ResultMessage.SYS_ROLE_NAME_ALREADY_EXISTS);
            }
        }

        role.setUpdateUser(this.getCurrentUserId());
        int count = roleService.updateRole(role);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除角色")
    @PostMapping("/delete/{roleId}")
    public CommonResult deleteRole(@PathVariable( value = "roleId") String roleId) {
        RoleEntity role = new RoleEntity();
        role.setRoleId(roleId);
        role.setStatus(DataStatus.DELETION.getCode());
        role.setUpdateUser(this.getCurrentUserId());

        int count = roleService.updateRole(role);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    private boolean validCreateParam(RoleEntity role) {
        String roleName = role.getRoleName();
        String roleDesc = role.getRoleDesc();

        if (StringUtils.isBlank(roleName) || StringUtils.isBlank(roleDesc)) {
            return false;
        }

        return true;
    }

    private boolean validUpdateParam(RoleEntity role) {
        String roleId = role.getRoleId();

        if (StringUtils.isBlank(roleId)) {
            return false;
        }

        return true;
    }
}
