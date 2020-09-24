package com.example.mvccontinuation.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("greeting", "Hey!! We hope you have a scary and fun filled halloween!");

        String locationName =request.getParameter("locationName");
        if (locationName != null) request.setAttribute("locationName", locationName);
        return true;
    }
}
