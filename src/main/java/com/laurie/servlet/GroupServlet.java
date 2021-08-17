package com.laurie.servlet;

import com.laurie.dao.GroupDao;
import com.laurie.dao.Impl.GroupDaoImpl;
import com.laurie.pojo.User;
import com.laurie.service.GroupService;
import com.laurie.service.Impl.GroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Laurie
 */
public class GroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        String join1 = "join1";
        String join2 = "join2";
        String create = "create";
        if (join1.equals(method)){
            join1(req,resp);
        }else if (join2.equals(method)) {
            join2(req,resp);
        }else if(create.equals(method)) {
            create(req,resp);
        }
    }
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String groupName = req.getParameter("groupName");
        String groupInfo = req.getParameter("groupInfo");
        String admin = "admin";
        User user = (User) req.getSession().getAttribute("USER_SESSION");
        int memberid = user.getId();
        GroupService groupService = new GroupServiceImpl();
        groupService.create(groupName,groupInfo,memberid);
        if (user.getUsername().equals(admin)) {
            resp.sendRedirect(req.getContextPath() + "/admin/group1.jsp");
        }else {
            resp.sendRedirect(req.getContextPath() + "/jsp/group.jsp");
        }

    }
    protected void join1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String groupName = req.getParameter("groupName");
        String admin = "admin";
        User user = (User) req.getSession().getAttribute("USER_SESSION");
        int memberid = user.getId();
        GroupService groupService = new GroupServiceImpl();
        groupService.join(groupName, memberid);
        if (user.getUsername().equals(admin)) {
            resp.sendRedirect(req.getContextPath() + "/admin/group1.jsp");
        }else {
            resp.sendRedirect(req.getContextPath() + "/jsp/group.jsp");
        }
    }
    protected void join2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String groupName = req.getParameter("groupName");
        String admin = "admin";
        User user = (User) req.getSession().getAttribute("USER_SESSION");
        int memberid = user.getId();
        GroupService groupService = new GroupServiceImpl();
        groupService.join(groupName,memberid);
        if (user.getUsername().equals(admin)) {
            resp.sendRedirect(req.getContextPath() + "/admin/group1.jsp");
        }else {
            resp.sendRedirect(req.getContextPath() + "/jsp/group.jsp");
        }
    }
}
