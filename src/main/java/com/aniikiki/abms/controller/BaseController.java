package com.aniikiki.abms.controller;

import com.aniikiki.abms.constant.CommonConstants;
import com.aniikiki.abms.entity.system.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {

    @Autowired
    HttpServletRequest request;

    protected HttpSession getSession() {
        return request.getSession();
    }

    protected String getIp() {
        return request.getRemoteAddr();
    }

    protected String getCurrentUserId() {
        return (String) getSession().getAttribute(CommonConstants.LOGIN_USER_ID);
    }

}
