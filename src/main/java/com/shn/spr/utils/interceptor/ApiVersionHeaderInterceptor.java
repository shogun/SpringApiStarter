package com.shn.spr.utils.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApiVersionHeaderInterceptor extends HandlerInterceptorAdapter {

    private String version;

    public ApiVersionHeaderInterceptor(String version) {
        this.version = version;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.addHeader("X-API-Version", version);

        return true;
    }
}
