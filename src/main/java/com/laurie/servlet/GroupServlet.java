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
        String groupName = req.getParameter("groupName");
        String groupInfo = req.getParameter("groupInfo");
        User user = (User) req.getSession().getAttribute("USER_SESSION");
        int memberid = user.getId();
        GroupService groupService = new GroupServiceImpl();
        groupService.create(groupName,groupInfo,memberid);
        resp.sendRedirect(req.getContextPath() + "/group.jsp");
    }
}
