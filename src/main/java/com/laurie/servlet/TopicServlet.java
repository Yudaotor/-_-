package com.laurie.servlet;

import com.laurie.pojo.Topic;
import com.laurie.pojo.User;
import com.laurie.service.Impl.TopicServiceImpl;
import com.laurie.service.TopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Laurie
 */
public class TopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String look = "look";
        String create = "create";
        String delete = "delete";
        String method = req.getParameter("method");
        if (look.equals(method)){
            look(req,resp);
        }else if (create.equals(method)){
            create(req,resp);
        }else if (delete.equals(method)){
            delete(req,resp);
        }
    }
    protected void look(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int topicId=Integer.parseInt(req.getParameter("topicId"));
        TopicService topicService = new TopicServiceImpl();
        Topic topic = topicService.selectTopicByTopicId(topicId);
        HttpSession session = req.getSession();
        session.setAttribute("TOPIC_SESSION",topic);
        resp.sendRedirect(req.getContextPath() + "/jsp/topicShow.jsp");
    }
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String topicName = req.getParameter("topicName");
        String topicContent = req.getParameter("topicContent");
        String groupName = req.getParameter("groupName");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        int userId = user.getId();
        String userName = user.getUsername();
        TopicService topicService = new TopicServiceImpl();
        topicService.createTopic(userId,groupName,userName,topicName,topicContent);
        resp.sendRedirect(req.getContextPath() + "/jsp/topic.jsp");
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int topicId = Integer.parseInt(req.getParameter("topicId"));
        TopicService topicService = new TopicServiceImpl();
        topicService.deleteTopic(topicId);
        resp.sendRedirect(req.getContextPath() + "/user/topicManage.jsp");
    }
}
