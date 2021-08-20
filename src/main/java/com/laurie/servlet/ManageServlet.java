package com.laurie.servlet;

import com.laurie.dao.Impl.UserDaoImpl;
import com.laurie.dao.UserDao;
import com.laurie.service.Impl.ManageServiceImpl;
import com.laurie.service.ManageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Laurie
 */
public class ManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delete = "delete";
        String modify = "modify";
        String add = "add";
        String deleteGroup = "deleteGroup";
        String method = req.getParameter("method");
        if(method.equals(delete)){
            delete(req,resp);
        }else if(method.equals(modify)){
            modify(req,resp);
        }else if (method.equals(add)){
            add(req,resp);
        }else if(method.equals(deleteGroup)){
            deleteGroup(req,resp);
        }
    }
    protected void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String cellphone = req.getParameter("cellphone");
        ManageService manageService = new ManageServiceImpl();
        manageService.modifyUser(userId,userName,password,email,cellphone);
        resp.sendRedirect(req.getContextPath() + "/admin/userManage.jsp");
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        ManageService manageService = new ManageServiceImpl();
        manageService.deleteUserById(userId);
        resp.sendRedirect(req.getContextPath() + "/admin/userManage.jsp");
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String cellphone = req.getParameter("cellphone");
        ManageService manageService = new ManageServiceImpl();
        manageService.register(userName,password,email,cellphone);
        resp.sendRedirect(req.getContextPath() + "/admin/userManage.jsp");
    }
    protected void deleteGroup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManageService manageService = new ManageServiceImpl();
        String groupName = req.getParameter("groupName");
        manageService.deleteGroup(groupName);
        resp.sendRedirect(req.getContextPath() + "/admin/groupManage.jsp");
    }
}
