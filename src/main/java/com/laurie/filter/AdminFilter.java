package com.laurie.filter;

import com.laurie.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =  (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String admin = "admin";
        User user = (User) req.getSession().getAttribute("USER_SESSION");
        if(user.getUsername().equals(admin)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{

            resp.sendRedirect(req.getContextPath() + "/error1.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
