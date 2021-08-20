<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="com.laurie.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户密码管理</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/passwordManage.css">
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

<%
    String message = (String) session.getAttribute("message");
    if (message == null || message.length() == 0){
        message = "";
    }
%>

<div class="body">
    <h3>密码管理</h3>
    <div class="modifyBox">
        <form action="${pageContext.request.contextPath}/user" method="post">
            <div class="item">
                <h2 style="color: red;font-size: 20px"><%=message%></h2>
                <label for="pwd1">请输入原密码:</label>
                <input type="password" id="pwd1" name="password1">
            </div>
            <div class="item">
                <label for="pwd2">请输入新密码:</label>
                <input type="password" id="pwd2" name="password2">
            </div>
            <input type="hidden" name="method" value="modifyPwd">
            <button type="submit" class="button">修改</button>
        </form>
    </div>

</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>

</body>
</html>
