package com.aniikiki.abms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigure implements WebMvcConfigurer {

    private static final String ALLOWED_HEADERS = "x-requested-with, authorization, authorizationdata, Content-Type, Authorization";
    private static final String ALLOWED_ORIGIN = "*";
    private static final String ALLOWED_METHODS = "*";
    private static final String EXPOSE_HEADERS = "*";
    private static final int MAX_AGE = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns(ALLOWED_ORIGIN)
                .allowedMethods(ALLOWED_METHODS)
                .allowedHeaders(ALLOWED_HEADERS)
                .exposedHeaders(EXPOSE_HEADERS)
                .maxAge(MAX_AGE)
                .allowCredentials(true)
                .maxAge(3600);

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
