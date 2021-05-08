package com.aniikiki.abms.controller.system;

import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.CommonConstants;
import com.aniikiki.abms.controller.BaseController;
import com.aniikiki.abms.dto.system.UserDto;
import com.aniikiki.abms.entity.system.UserEntity;
import com.aniikiki.abms.service.system.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 * @author aniikiki
 * @date 2021-04-14 10:09:31
 */
@RestController
@RequestMapping("/login")
@Api(tags = "用户登录")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResult<UserEntity> login(@RequestBody UserDto dto) {
        if (!validLoginParam(dto)) {
            return CommonResult.validateFailed();
        }

        UserEntity user = userService.login(dto, this.getIp());

        if (user != null) {
            this.getSession().setAttribute(CommonConstants.LOGIN_USER, user);
            return CommonResult.success(user);
        } else {
            return CommonResult.failed("用户名或密码错误");
        }
    }

    @ApiOperation("获取登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult<UserEntity> getLoginInfo() {
        return CommonResult.success(this.getCurrentUser());
    }

    @ApiOperation("注销")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public CommonResult logout() {
        this.getSession().removeAttribute(CommonConstants.LOGIN_USER);
        return CommonResult.success("");
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public CommonResult changePassword(@RequestBody UserDto dto) {
        if (!validChangePasswordParam(dto)) {
            return CommonResult.validateFailed();
        }

        dto.setUserId(this.getCurrentUserId());
        String msg = userService.updatePassword(dto);

        if (StringUtils.isEmpty(msg)) {
            return this.logout();
        } else {
            return CommonResult.failed(msg);
        }
    }

    private boolean validLoginParam(UserDto dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return false;
        }

        return true;
    }

    private boolean validChangePasswordParam(UserDto dto) {
        String password = dto.getPassword();
        String newPassword = dto.getNewPassword();

        if (StringUtils.isBlank(password) || StringUtils.isBlank(newPassword)) {
            return false;
        }

        return true;
    }

}
