package com.aniikiki.abms.constant;

public class CommonConstants {

    public static final String LOGIN_USER = "loginUser";

    public static final String NO_INTERCEPTOR_PATH = ".*/((login$)|(logout)|(register)|(swagger)|(api-docs)|(doc\\.html)|(webjars)).*";	//不对匹配该值的访问路径拦截（正则）

}
