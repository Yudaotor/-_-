<%--
  Created by IntelliJ IDEA.
  User: Laurie
  Date: 2021/8/14
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link rel="stylesheet" href="recourse/css/frame.css">
    <link rel="stylesheet" href="recourse/css/register.css">
    <%--网页图标    --%>
    <link rel="icon" href="https://cdnjson.com/images/2021/08/06/-SVG-66.png" type="image/x-icon" />
    <%--阿里图标库    --%>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_2720133_c6jxk2g9ngr.css">
</head>
<body>
<div class="header">
    <h1>YUDAOTOR</h1>
    <p>Only action can change destiny.</p>
</div>


<div class="NavigationBar">
    <ul>
        <!--注册界面不管点什么都是会回到注册界面-->
        <li><a href="register.jsp">首页</a></li>
        <li><a href="register.jsp">我的</a></li>
        <li><a href="register.jsp">小组</a></li>
        <li><a href="register.jsp">话题</a></li>
        <li><a href="register.jsp">管理</a></li>
        <li><a href="register.jsp">关于</a></li>
    </ul>
</div>



<div class="body">
    <h3>注册</h3>
    <div class="registerBox">
        <div class="form">
            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="item">
                    <label for="username">用户名:<i class="iconfont icon-username"></i></label>
                    <input type="text" name="username" id="username" placeholder="username" required>
                </div>
                <div class="item">
                    <label for="password">密   码:<i class="iconfont icon-password" id="pwd"></i></label>
                    <input type="password" name="password" id="password" placeholder="password" required>
                </div>
                <div class="item">
                    <label for="email">邮箱:<i class="iconfont icon-email" id="eml"></i></label>
                    <input type="text" name="email" id="email" placeholder="email" required>
                </div>
                <div class="item">
                    <label for="cellphone">手机号:<i class="iconfont icon-cellphone" id="num"></i></label>
                    <input type="text" name="cellphone" id="cellphone" placeholder="cellphone" required>
                </div>
                <br>
                <button class="buttonRegister">注册</button>
            </form>
        </div>
    </div>
    <h3><a href="login.jsp" id="back">返回登录界面</a></h3>
</div>


<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>

</body>
</html>
