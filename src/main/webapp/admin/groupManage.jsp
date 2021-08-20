<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="com.laurie.pojo.User" %>
<%@ page import="com.laurie.pojo.Topic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户小组管理</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/groupManage.css">
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
    <h3>小组管理</h3>
    <table>
        <tr>
            <th>小组名称</th>
            <th>小组人数</th>
            <th>操作</th>
        </tr>
        <%
            GroupDao groupDao = new GroupDaoImpl();
            List<Group> list = groupDao.selectGroupAll();
            for (Group li : list){

        %>
        <form action="${pageContext.request.contextPath}/manage" method="post" id="<%=li.getGroupName()%>">
            <input type="hidden" name="method" value="deleteGroup">
            <input type="hidden" name="groupName" value="<%=li.getGroupName()%>">
        </form>

        <tr>
            <td><%=li.getGroupName()%></td>
            <td><%=li.getGroupSize()%></td>
            <td><a href="javascript:document:<%=li.getGroupName()%>.submit();">删除</a></td>
        </tr>
        <%
            }
        %>
    </table>

</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>

</body>
</html>
