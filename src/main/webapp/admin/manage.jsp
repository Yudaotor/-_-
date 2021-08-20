<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="com.laurie.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/manage.css">
    <link rel="icon" href="https://cdnjson.com/images/2021/08/06/-SVG-66.png" type="image/x-icon" />
</head>
<body>
<div class="header">
    <h1>YUDAOTOR</h1>
    <p>Only action can change destiny.</p>
</div>


<div class="NavigationBar">
    <ul>
        <li><a href="welcome1.jsp">首页</a></li>
        <li><a href="manage.jsp">管理</a></li>
        <li><a href="about1.jsp">关于</a></li>
    </ul>
</div>
<div class="NavigationBar2">
    <ul>
        <li><a href="userManage.jsp">用户管理</a></li>
        <li><a href="groupManage.jsp">小组管理</a></li>
    </ul>
</div>

<div class="body">
    <h3>管理员</h3>
    <div class="manageBox">
        <div style="font-size: 30px">
            <br>管理员<br>您好,欢迎来到管理界面!<br><br>
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
