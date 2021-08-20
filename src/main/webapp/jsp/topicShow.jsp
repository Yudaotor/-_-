
<%@ page import="java.util.List" %>
<%@ page import="com.laurie.pojo.Topic" %>
<%@ page import="com.laurie.dao.TopicDao" %>
<%@ page import="com.laurie.dao.Impl.TopicDaoImpl" %>
<%@ page import="com.laurie.dao.UserDao" %>
<%@ page import="com.laurie.dao.Impl.UserDaoImpl" %>
<%@ page import="com.laurie.dao.TalkDao" %>
<%@ page import="com.laurie.dao.Impl.TalkDaoImpl" %>
<%@ page import="com.laurie.pojo.Talk1" %>
<%@ page import="com.laurie.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>话题</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/topicShow.css">
    <link rel="icon" href="https://cdnjson.com/images/2021/08/06/-SVG-66.png" type="image/x-icon" />
</head>
<body>
<div class="header">
    <h1>YUDAOTOR</h1>
    <p>Only action can change destiny.</p>
</div>


<div class="NavigationBar">
    <ul>
        <li><a href="welcome.jsp">首页</a></li>
        <li><a href="userManage.jsp">我的</a></li>
        <li><a href="group.jsp">小组</a></li>
        <li><a href="topic.jsp">话题</a></li>
        <li><a href="about.jsp">关于</a></li>
    </ul>
</div>

<div class="body">
    <h3>话题</h3>
        <%
            Topic topic = (Topic) session.getAttribute("TOPIC_SESSION");
        %>
    <div class="mainBox">
        <h1><%=topic.getTopicName()%></h1>
        <hr>
        <h4>发起人:<%=topic.getUserName()%></h4>
        <hr>
        <div class="contentBox">
            <h2><%=topic.getTopicContent()%></h2>
        </div>
    </div>

    <button type="submit" class="button"><a href="./talkCreate1.jsp">发表评论</a></button>
    <br>
    <hr>
    <br>
    <div class="talkBox">
        <h4 style="font-size: 25px">评论区:</h4>
    </div>

    <%
        TalkDao talkDao = new TalkDaoImpl();
        List<Talk1> list = talkDao.selectTalkByTopicName(topic.getTopicName());
        for(Talk1 li :list){
            UserDao userDao = new UserDaoImpl();
            User user1 = userDao.getUserById(li.getTalkId1());
            User user2 = userDao.getUserById(li.getTalkId2());

    %>
    <div class="chatBox">
        <h4><%=li.getTalkTime()%></h4>
        <h4><%=user1.getUsername()%>--><%=user2.getUsername()%>:</h4><br>
        <h2><%=li.getTalkContent()%></h2>
        <form action="./talkCreate2.jsp" method="post" >
            <input type="hidden" name="talkerName2" value="<%=user1.getUsername()%>">
            <button type="submit" class="button1">回复</button>
        </form>
    </div>


    <%
        }
    %>
</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
