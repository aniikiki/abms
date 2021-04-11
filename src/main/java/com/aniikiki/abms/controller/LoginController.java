package com.aniikiki.abms.controller;

import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.CommonConstants;
import com.aniikiki.abms.dto.UserDto;
import com.aniikiki.abms.entity.UserEntity;
import com.aniikiki.abms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult login(UserDto dto) throws Exception {
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

    private boolean validLoginParam(UserDto dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        String verifyCode = dto.getVerifyCode(); //验证码

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return false;
        }

        return true;
    }

}
