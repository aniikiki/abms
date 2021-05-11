package com.aniikiki.abms.controller.system;

import com.aniikiki.abms.common.CommonPage;
import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ResultMessage;
import com.aniikiki.abms.controller.BaseController;
import com.aniikiki.abms.dto.system.UserDto;
import com.aniikiki.abms.entity.system.UserEntity;
import com.aniikiki.abms.entity.system.UserRoleRelEntity;
import com.aniikiki.abms.service.system.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理
 * @author aniikiki
 * @date 2021-04-16 11:12:01
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户列表")
    @PostMapping("/list")
    public CommonResult<CommonPage<UserEntity>> getUserList(@RequestBody UserDto dto,
                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<UserEntity> userList = userService.getUserList(dto, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(userList));
    }

    @ApiOperation("新增用户")
    @PostMapping("/create")
    public CommonResult createUser(@RequestBody UserEntity user) {
        if (!validCreateParam(user)) {
            return CommonResult.validateFailed();
        }

        List<UserEntity> userList = userService.getUserListByUsername(null, user.getUsername());
        if (userList != null && userList.size() > 0) {
            return CommonResult.failed(ResultMessage.SYS_USERNAME_ALREADY_EXISTS);
        }

        user.setCreateUser(this.getCurrentUserId());
        int count = userService.createUser(user);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改用户")
    @PostMapping("/update/{userId}")
    public CommonResult updateUser(@PathVariable( value = "userId") String userId, @RequestBody UserEntity user) {
        if (!validUpdateParam(user)) {
            return CommonResult.validateFailed();
        }

        if (StringUtils.isNotEmpty(user.getUsername())) {
            List<UserEntity> userList = userService.getUserListByUsername(userId, user.getUsername());
            if (userList != null && userList.size() > 0) {
                return CommonResult.failed(ResultMessage.SYS_USERNAME_ALREADY_EXISTS);
            }
        }

        user.setUpdateUser(this.getCurrentUserId());
        int count = userService.updateUser(user);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("用户信息")
    @GetMapping("/info/{userId}")
    public CommonResult<UserEntity> getUserInfo(@PathVariable(value = "userId") String userId) {
        UserEntity user = userService.getUserInfo(userId);
        if (user != null && !DataStatus.DELETION.getCode().equals(user.getStatus())) {
            return CommonResult.success(user);
        } else {
            return CommonResult.failed(ResultMessage.SYS_USER_NOT_FOUND);
        }
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete/{userId}")
    public CommonResult deleteUser(@PathVariable( value = "userId") String userId) {
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        user.setStatus(DataStatus.DELETION.getCode());
        user.setUpdateUser(this.getCurrentUserId());

        int count = userService.updateUser(user);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取用户分配的角色信息")
    @GetMapping("/role/{userId}")
    public CommonResult<List<UserRoleRelEntity>> getUserRoleList(@PathVariable(value = "userId") String userId) {
        List<UserRoleRelEntity> userRoleList = userService.getUserRoleList(userId);
        return CommonResult.success(userRoleList);
    }

    @ApiOperation("分配角色")
    @PostMapping("/assign/{userId}")
    public CommonResult assignRole(@PathVariable( value = "userId") String userId, @RequestBody String[] roleIdArr) {
        UserEntity user = userService.getUserInfo(userId);
        if (user == null || DataStatus.DELETION.getCode().equals(user.getStatus())) {
            return CommonResult.failed(ResultMessage.SYS_USER_NOT_FOUND);
        }

        boolean flag = userService.assignRole(userId, roleIdArr, this.getCurrentUserId());
        if (flag) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    private boolean validCreateParam(UserEntity user) {
        String username = user.getUsername();
        String password = user.getPassword();

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return false;
        }

        return true;
    }

    private boolean validUpdateParam(UserEntity user) {
        String userId = user.getUserId();

        if (StringUtils.isBlank(userId)) {
            return false;
        }

        return true;
    }
}
