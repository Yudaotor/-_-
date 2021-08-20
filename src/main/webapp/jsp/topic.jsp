
<%@ page import="java.util.List" %>
<%@ page import="com.laurie.pojo.Topic" %>
<%@ page import="com.laurie.dao.TopicDao" %>
<%@ page import="com.laurie.dao.Impl.TopicDaoImpl" %>

<%@ page import="com.laurie.pojo.User" %>
<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>话题</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/topic.css">
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
    <table>
        <tr>
            <th>话题标题</th>
            <th>发起人</th>
            <th>所属小组</th>
            <th>操作</th>
        </tr>
        <%
            TopicDao topicDao = new TopicDaoImpl();
            GroupDao groupDao = new GroupDaoImpl();
            User user = (User) session.getAttribute("USER_SESSION");
            int memberId = user.getId();
            List<String> group = groupDao.selectGroupByMemberId(memberId);
            for(String gr:group){
            List<Topic> list = topicDao.selectTopicByGroupName(gr);

            for (Topic li : list){

        %>
        <form action="${pageContext.request.contextPath}/topic" method="post" id="话题<%=li.getTopicId()%>">
            <input type="hidden" name="method" value="look">
            <input type="hidden" name="topicId" value="<%=li.getTopicId()%>">
        </form>

        <tr>
            <td><%=li.getTopicName()%></td>
            <td><%=li.getUserName()%></td>
            <td><%=gr%></td>
            <td><a href="javascript:document:话题<%=li.getTopicId()%>.submit();">查看</a></td>
        </tr>
        <%
            }
        %>

    <%
        }
    %>
    </table>
    <button class="button"><a href="topicCreate.jsp">创建话题</a></button>
</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
