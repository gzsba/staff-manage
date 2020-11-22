package com.staff.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        //用户登录成功后,应该有自己的session
        Object session = request.getSession().getAttribute( "LoginUser" );
        if (session==null){
            request.setAttribute( "msg","权限不够，请先登录" );
            request.getRequestDispatcher( "index.html" ).forward( request,response );
            return false;
        }
        return true;
    }
}
