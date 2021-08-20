package com.laurie.servlet;

import com.laurie.dao.Impl.UserDaoImpl;
import com.laurie.dao.UserDao;
import com.laurie.pojo.Talk1;
import com.laurie.pojo.Topic;
import com.laurie.pojo.User;
import com.laurie.service.Impl.TalkServiceImpl;
import com.laurie.service.TalkService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Laurie
 */
public class TalkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String create1 = "create1";
        String create2 = "create2";
        String method = req.getParameter("method");
        if(method.equals(create1)){
            create1(req,resp);
        }else if(method.equals(create2)){
            create2(req,resp);
        }
    }
    protected void create1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Topic topic = (Topic) req.getSession().getAttribute("TOPIC_SESSION");
        User user = (User) req.getSession().getAttribute("USER_SESSION");
        int talkerId2 = topic.getUserId();
        int talkerId1 = user.getId();
        String topicName = topic.getTopicName();
        String talkContent = req.getParameter("talkContent");
        TalkService talkService = new TalkServiceImpl();
        talkService.create(topicName,talkerId1,talkerId2,talkContent);
        resp.sendRedirect(req.getContextPath() + "/jsp/topicShow.jsp");
    }
    protected void create2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Topic topic = (Topic) req.getSession().getAttribute("TOPIC_SESSION");
        User user = (User) req.getSession().getAttribute("USER_SESSION");
        String talkerName2 = req.getParameter("talkerName2");
        UserDao userDao = new UserDaoImpl();
        User user2 = userDao.getUserByName(talkerName2);
        int talkerId2 = user2.getId();
        int talkerId1 = user.getId();
        String topicName = topic.getTopicName();
        String talkContent = req.getParameter("talkContent");
        TalkService talkService = new TalkServiceImpl();
        talkService.create(topicName,talkerId1,talkerId2,talkContent);
        resp.sendRedirect(req.getContextPath() + "/jsp/topicShow.jsp");
    }
}
