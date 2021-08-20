<%@ page import="com.laurie.pojo.User" %>
<%@ page import="com.laurie.dao.UserDao" %>
<%@ page import="com.laurie.dao.Impl.UserDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登陆</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/welcome.css">
</head>
<body>
<!--得到存在session中的用户信息-->
<%
    User user = new User();
    user = (User) session.getAttribute("USER_SESSION");
%>
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
    <h3>首页</h3>
    <div class="indexBox">
        <h2><%=user.getUsername()%> 欢迎登陆!</h2>
        <br>
        <h2>这里是浙江师范大学软件创新实验室官网</h2>
        <form action="${pageContext.request.contextPath}/user" method="post">
            <input type="hidden" name="method" value="logout">
            <button type="submit" class="buttonLogout"><a href="/user">退出登录</a></button>
        </form>

    </div>
</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
