package com.aniikiki.abms.exception;

import com.aniikiki.abms.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 * @author aniikiki
 * @date 2021-04-15 22:05:52
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public CommonResult commonExceptionHandler(HttpServletResponse res, Throwable e) {
        log.error("SYS-ERR", e);

        res.setStatus(500);
        CommonResult result = CommonResult.failed("SYS-ERR");
        result.setData("系统错误，请联系管理员!");

        return result;
    }

}
