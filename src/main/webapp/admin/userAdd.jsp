
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户添加</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/userModify.css">
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
    <h3>用户添加</h3>
    <div class="modifyBox">
        <div class="form">
            <form method="post" action="${pageContext.request.contextPath}/manage">
                <div class="item">
                    <label for="userName">用户名:</label>
                    <input type="text" name="userName" id="userName" placeholder="user name>">
                </div>
                <div class="item">
                    <label for="password">密码:</label>
                    <input type="text" name="password" id="password" placeholder="password>">
                </div>
                <div class="item">
                    <label for="email">邮箱:</label>
                    <input type="text" name="email" id="email">
                </div>
                <div class="item">
                    <label for="cellphone">手机号码:</label>
                    <input type="text" name="cellphone" id="cellphone">
                </div>
                <br>
                <input type="hidden" name="method" value="add">
                <button type="submit" class="buttonModify">添加</button>
            </form>
        </div>
    </div>
</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
