package com.aniikiki.abms.interceptor;

import com.alibaba.fastjson.JSON;
import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.CommonConstants;
import com.aniikiki.abms.entity.system.UserEntity;
import com.aniikiki.abms.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录拦截器
 * @author aniikiki
 * @date 2021-04-13 23:18:49
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();

        if (path.matches(CommonConstants.NO_INTERCEPTOR_PATH)) {
            return true;
        } else {
            HttpSession session = request.getSession();
            String loginUserId = (String) session.getAttribute(CommonConstants.LOGIN_USER_ID);

            if (StringUtils.isNotEmpty(loginUserId)) {
                return true;
            }

            CommonUtil.writeReturn(response, CommonResult.unauthorized(null));
            return false;
        }
    }

}
