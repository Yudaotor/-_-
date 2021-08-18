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

/**
 * @author Laurie
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        String login = "login";
        String register = "register";
        String logout = "logout";
        String modifyPwd = "modifyPwd";
        if (login.equals(method)){
            login(req,resp);
        }else if (register.equals(method)) {
            register(req,resp);
        }else if (logout.equals(method)) {
            logout(req,resp);
        }else if (modifyPwd.equals(method)){
            modifyPwd(req,resp);
        }
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String admin = "admin";
        UserService userservice = new UserServiceImpl();
        boolean rs = userservice.login(username, password);
        HttpSession session = req.getSession();
        if (rs) {
            User user = new User();
            UserDao userDao = new UserDaoImpl();
            user = userDao.getUserByNamePwd(username, password);
            session.setAttribute("USER_SESSION", user);
            session.setMaxInactiveInterval(6000);
            if(admin.equals(user.getUsername())){
                resp.sendRedirect("../admin/welcome1.jsp");
            }else {
                resp.sendRedirect("../jsp/welcome.jsp");
            }
        } else {
            session.setAttribute("message", "用户名或密码不正确");
            resp.sendRedirect("login.jsp");
        }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String cellphone = req.getParameter("cellphone");
        UserService userService = new UserServiceImpl();
        userService.register(username, password, email, cellphone);
        resp.sendRedirect("login.jsp");
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().removeAttribute("USER_SESSION");
        resp.sendRedirect("login.jsp");
    }
    protected void modifyPwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        User user = new User();
        user = (User) req.getSession().getAttribute("USER_SESSION");
        int id = user.getId();
        UserService userService = new UserServiceImpl();
        if(!userService.modify(id,password1,password2)){
            req.getSession().setAttribute("message", "原密码输入错误,请重新输入");
        }else{
            req.getSession().setAttribute("message", "密码修改成功!");
        }
        resp.sendRedirect("/user/passwordManage.jsp");

    }
}
