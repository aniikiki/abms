package com.aniikiki.abms.interceptor;

import com.alibaba.fastjson.JSON;
import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.CommonConstants;
import com.aniikiki.abms.entity.system.UserEntity;
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
            UserEntity loginUser = (UserEntity) session.getAttribute(CommonConstants.LOGIN_USER);

            if (loginUser != null) {
                return true;
            }

            writeReturn(response, CommonResult.unauthorized(null));
            return false;
        }
    }

    public void writeReturn(HttpServletResponse response, CommonResult result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println(JSON.toJSONString(result));
    }

}
