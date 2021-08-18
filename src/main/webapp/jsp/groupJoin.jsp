<%@ page import="com.laurie.pojo.User" %>
<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关于</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/groupJoin.css">
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
        <li><a href="#">话题</a></li>
        <li><a href="about.jsp">关于</a></li>
    </ul>
</div>

<div class="body">
    <h3>加入小组</h3>

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
    <form action="${pageContext.request.contextPath}/group" method="post">
        <div id="joinPart">
            <label for="groupName">小组名称:</label>
            <input type="text" name="groupName" id="groupName" placeholder="group name">
            <h2 >请确认小组名输入无误!</h2>
        </div>
        <br>
        <input type="hidden" name="method" value="join1">
        <button type="submit" class="buttonJoin">加入</button>
    </form>
</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>
</body>
</html>
