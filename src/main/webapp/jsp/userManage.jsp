<%@ page import="com.laurie.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/userManage.css">
    <link rel="icon" href="https://cdnjson.com/images/2021/08/06/-SVG-66.png" type="image/x-icon" />
</head>
<body>
<div class="header">
    <h1>YUDAOTOR</h1>
    <p>Only action can change destiny.</p>
</div>

<%
    User user = new User();
    user = (User) session.getAttribute("USER_SESSION");
%>
<div class="NavigationBar">
    <ul>
        <li><a href="welcome.jsp">首页</a></li>
        <li><a href="userManage.jsp">我的</a></li>
        <li><a href="group.jsp">小组</a></li>
        <li><a href="#">话题</a></li>
        <li><a href="about.jsp">关于</a></li>
    </ul>
</div>

<div class="NavigationBar2">
    <ul>
        <li><a href="../user/passwordManage.jsp">密码管理</a></li>
        <li><a href="../user/groupManage.jsp">小组管理</a></li>
        <li><a href="#">话题管理</a></li>
    </ul>
</div>

<div class="body">
    <h3>用户信息</h3>
    <div class="userBox">
        <div style="font-size: 30px">
            <br>用户<%=user.getUsername()%><br>你好,欢迎来到用户管理界面!<br><br>
        </div>
        <div style="font-size: 25px">请根据上方导航栏进行操作</div>

    </div>
</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
