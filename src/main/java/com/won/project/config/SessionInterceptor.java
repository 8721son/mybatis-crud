package com.won.project.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.won.project.utils.Script;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter{

    //컨트롤러보다 먼저 수행되는 메소드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            System.out.println("=======================");
            response.sendRedirect("/user/loginForm");
            return false;
        }
        System.out.println("++++++++++++++++++++++++++");
        return true;
    }
}