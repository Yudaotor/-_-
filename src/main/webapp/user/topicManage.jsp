<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="com.laurie.pojo.User" %>
<%@ page import="com.laurie.pojo.Topic" %>
<%@ page import="com.laurie.dao.TopicDao" %>
<%@ page import="com.laurie.dao.Impl.TopicDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>话题管理</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/topicManage.css">
    <link rel="icon" href="https://cdnjson.com/images/2021/08/06/-SVG-66.png" type="image/x-icon" />
</head>
<body>
<div class="header">
    <h1>YUDAOTOR</h1>
    <p>Only action can change destiny.</p>
</div>


<div class="NavigationBar">
    <ul>
        <li><a href="${pageContext.request.contextPath}/jsp/welcome.jsp">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/userManage.jsp">我的</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/group.jsp">小组</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/topic.jsp">话题</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/about.jsp">关于</a></li>
    </ul>
</div>
<div class="NavigationBar2">
    <ul>
        <li><a href="passwordManage.jsp">密码管理</a></li>
        <li><a href="groupManage.jsp">小组管理</a></li>
        <li><a href="topicManage.jsp">话题管理</a></li>
    </ul>
</div>



<div class="body">
    <h3>话题管理</h3>
    <table>
        <tr>
            <th>话题标题</th>
            <th>发起人</th>
            <th>所属小组</th>
            <th>操作</th>
        </tr>
        <%
            TopicDao topicDao = new TopicDaoImpl();
            User user = (User) session.getAttribute("USER_SESSION");
            int memberId = user.getId();
            List<Topic> list = topicDao.selectTopicByUserId(memberId);
                for (Topic li : list){

        %>
        <form action="${pageContext.request.contextPath}/topic" method="post" id="话题<%=li.getTopicId()%>">
            <input type="hidden" name="method" value="delete">
            <input type="hidden" name="topicId" value="<%=li.getTopicId()%>">
        </form>

        <tr>
            <td><%=li.getTopicName()%></td>
            <td><%=li.getUserName()%></td>
            <td><%=li.getGroupName()%></td>
            <td><a href="javascript:document:话题<%=li.getTopicId()%>.submit();">删除</a></td>
        </tr>
        <%
            }
        %>

    </table>

</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>

</body>
</html>
