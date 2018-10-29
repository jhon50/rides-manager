package com.springframework.ridesmanager.domain;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class RequestInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//        //your custom logic here.
////        if ("POST".equalsIgnoreCase(request.getMethod()))
////        {
////            String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
////        }
//        return true;
//    }
}


