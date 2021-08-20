
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
    <link rel="stylesheet" href="./recourse/css/frame.css">
    <link rel="stylesheet" href="./recourse/css/error.css">
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

<div class="body">
    <h3>错误</h3>
    <div class="errorBox">
        <br><br>
        <h1>您不是管理员,无法进入管理界面</h1>
        <button type="button" class="buttonError"><a href="${pageContext.request.contextPath }/login.jsp">返回</a></button>

    </div>

</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>

</body>
</html>
