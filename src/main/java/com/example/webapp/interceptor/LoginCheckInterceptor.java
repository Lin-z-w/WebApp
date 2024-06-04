package com.example.webapp.interceptor;

import com.example.webapp.rest.dto.ErrorDto;
import com.example.webapp.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        String jwt = request.getHeader("token");

        if (!StringUtils.hasLength(jwt)) {
            System.out.println("JWT is missing in the request header");
            ErrorDto error = new ErrorDto(-2, "NOT_LOGIN");
            response.setStatus(401);
            response.getWriter().write(error.toString());
            return false;
        }

        try {
            JwtUtils.parseToken(jwt);
        } catch (Exception e) {
            System.out.println("JWT is invalid");
            ErrorDto error = new ErrorDto(-2, "INVALID_JWT");
            response.setStatus(401);
            response.getWriter().write(error.toString());
            return false;
        }

        System.out.println("request is valid");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
