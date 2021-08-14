
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小组</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/group.css">
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
        <li><a href="#">我的</a></li>
        <li><a href="group.jsp">小组</a></li>
        <li><a href="#">话题</a></li>
        <li><a href="#">管理</a></li>
        <li><a href="about.jsp">关于</a></li>
    </ul>
</div>


<div class="body">
    <h3>小组列表</h3>

    <table>
        <thead>
        <tr>
            <th>编号</th>
            <th>小组名称</th>
            <th>人数</th>
            <th>简介</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>物理</td>
            <td>3至4人</td>
            <td>挺好</td>
            <td>
                <a href="#">加入</a>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>项目技术人员</td>
            <td>1人</td>
            <td>洞头</td>
            <td>
                <a href="#">加入</a>
            </td>
        </tr>
        <tr>
            <td>3</td>
            <td>总经理助理</td>
            <td>1人</td>
            <td>温州</td>
            <td>
                <a href="#">加入</a>
            </td>
        </tr>
        </tbody>
    </table>
    <div id="tip">
        没有感兴趣的学习小组?点它↓自己来创建一个吧!
    </div>
    <a href="groupCreate.jsp"><button class="button">创建小组</button></a>
</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
