package com.aniikiki.abms.utils;

import com.alibaba.fastjson.JSON;
import com.aniikiki.abms.common.CommonResult;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CommonUtil {

    public static void writeReturn(HttpServletResponse response, CommonResult result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println(JSON.toJSONString(result));
    }

}
