<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
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
        <li><a href="welcome1.jsp">首页</a></li>
        <li><a href="#">我的</a></li>
        <li><a href="group1.jsp">小组</a></li>
        <li><a href="#">话题</a></li>
        <li><a href="about1.jsp">关于</a></li>
    </ul>
</div>


<div class="body">
    <h3>小组列表</h3>

    <table>

        <tr>
            <th>小组名称</th>
            <th>人数</th>
            <th>简介</th>
            <th>操作</th>

        </tr>
        <%
            GroupDao groupDao = new GroupDaoImpl();
            List<Group> list = groupDao.selectGroupAll();
            for (Group li : list){

        %>
        <form action="${pageContext.request.contextPath}/group" method="post" id="<%=li.getGroupName()%>">
            <input type="hidden" name="method" value="join2">
            <input type="hidden" name="groupName" value="<%=li.getGroupName()%>">
        </form>

        <tr>
            <td><%=li.getGroupName()%></td>
            <td><%=li.getGroupSize()%></td>
            <td><%=li.getGroupInfo()%></td>
            <td><a href="javascript:document:<%=li.getGroupName()%>.submit();">加入</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <button class="button"><a href="groupJoin1.jsp">加入小组</a></button>

    <div id="tip">
        没有感兴趣的学习小组?点它↓自己来创建一个吧!
    </div>
    <button class="button"><a href="groupCreate1.jsp">创建小组</a></button>

</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
