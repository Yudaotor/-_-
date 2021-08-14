package com.laurie.filter;

import com.laurie.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Laurie
 */
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =  (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        User user = (User) req.getSession().getAttribute("USER_SESSION");
        if(user == null){
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
