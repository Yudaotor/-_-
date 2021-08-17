
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <link rel="stylesheet" href="recourse/css/frame.css">
    <link rel="stylesheet" href="recourse/css/login.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_2720133_c6jxk2g9ngr.css">
    <link rel="icon" href="https://cdnjson.com/images/2021/08/06/-SVG-66.png" type="image/x-icon" />
</head>
<body>
<div class="header">
    <h1>YUDAOTOR</h1>
    <p>Only action can change destiny.</p>
</div>

<div class="NavigationBar">
    <ul>
        <!--登陆界面不管点什么都是会回到登陆界面-->
        <li><a href="login.jsp">首页</a></li>
        <li><a href="login.jsp">我的</a></li>
        <li><a href="login.jsp">小组</a></li>
        <li><a href="login.jsp">话题</a></li>
        <li><a href="login.jsp">关于</a></li>
    </ul>
</div>


<%
    String message = (String) session.getAttribute("message");
    if (message == null || message.length() == 0){
        message = "";
    }
%>

<div class="body">
    <h3>登录</h3>
    <div class="loginBox">
        <div class="form">
            <span id="tip"><%=message%></span>
            <form action="${pageContext.request.contextPath}/user" method="post">
                <div class="item">
                    <label for="username">用户名:<i class="iconfont icon-username" ></i></label>
                    <input type="text" placeholder="username" name="username" id="username" required>
                </div>
                <div class="item">
                    <label for="password">密码:<i class="iconfont icon-password" id="pwd"></i></label>
                    <input type="password" placeholder="password" name="password" id="password" required>
                </div>
                <br>
                <input type="hidden" name="method" value="login">
                <button type="submit" class="buttonLogin">Login</button>
            </form>
        </div>
    </div>
    <div id="back">
        <h3>还没有账号?<a href="register.jsp">点击注册</a></h3>
    </div>
</div>
<br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
