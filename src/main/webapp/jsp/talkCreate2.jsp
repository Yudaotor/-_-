
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>讨论发表</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/talkCreate.css">
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
<%
    String talkerName2 = request.getParameter("talkerName2");
%>

<div class="body">
    <h3>发表讨论</h3>
    <div class="talkBox">
        <div class="form">
            <form method="post" action="${pageContext.request.contextPath}/talk">
                <div class="item">
                    <label for="talkContent">评论内容:</label>
                    <input type="text" name="talkContent" id="talkContent">
                </div>
                <br>
                <input type="hidden" name="method" value="create2">
                <input type="hidden" name="talkerName2" value=<%=talkerName2%>>
                <button type="submit" class="buttonCreate">发表</button>
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
