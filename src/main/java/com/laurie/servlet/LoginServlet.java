package com.laurie.servlet;

import com.laurie.dao.Impl.UserDaoImpl;
import com.laurie.dao.UserDao;
import com.laurie.pojo.User;
import com.laurie.service.Impl.UserServiceImpl;
import com.laurie.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingDeque;

/**
 * 登录功能Servlet
 * @author Laurie
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userservice = new UserServiceImpl();
        boolean rs = userservice.login(username, password);
        HttpSession session = req.getSession();
        if (rs){
            User user = new User();
            UserDao userDao = new UserDaoImpl();
            user = userDao.getUserByNamePwd(username, password);
            session.setAttribute("USER_SESSION", user);
            session.setMaxInactiveInterval(6000);
            resp.sendRedirect("../jsp/welcome.jsp");
        }else{
            req.setAttribute("message", "用户名或密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
