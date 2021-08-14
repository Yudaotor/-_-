package com.laurie.servlet;

import com.laurie.dao.Impl.UserDaoImpl;
import com.laurie.dao.UserDao;
import com.laurie.service.Impl.UserServiceImpl;
import com.laurie.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Laurie
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String cellphone = req.getParameter("cellphone");
        UserService userService = new UserServiceImpl();
        userService.register(username, password, email, cellphone);
        resp.sendRedirect("login.jsp");
    }
}
