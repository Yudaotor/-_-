<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="com.laurie.pojo.User" %>
<%@ page import="com.laurie.pojo.Topic" %>
<%@ page import="com.laurie.dao.TopicDao" %>
<%@ page import="com.laurie.dao.Impl.TopicDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.laurie.dao.UserDao" %>
<%@ page import="com.laurie.dao.Impl.UserDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" href="../recourse/css/frame.css">
    <link rel="stylesheet" href="../recourse/css/userManage.css">
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
    <h3>用户管理</h3>
    <table>
        <tr>
            <th>用户编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th>手机号码</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <%
            List<User> list = new ArrayList<User>();
            UserDao userDao = new UserDaoImpl();
            list = userDao.selectAll();
            for (User li : list){

        %>
        <form action="${pageContext.request.contextPath}/manage" method="post" id="用户删除<%=li.getId()%>">
            <input type="hidden" name="method" value="delete">
            <input type="hidden" name="userId" value="<%=li.getId()%>">
        </form>
        <form action="./userModify.jsp" method="post" id="用户修改<%=li.getId()%>">
            <input type="hidden" name="userId" value="<%=li.getId()%>">
        </form>

        <tr>
            <td><%=li.getId()%></td>
            <td><%=li.getUsername()%></td>
            <td><%=li.getPassword()%></td>
            <td><%=li.getEmail()%></td>
            <td><%=li.getCellphone()%></td>
            <td><a href="javascript:document:用户修改<%=li.getId()%>.submit();">修改</a></td>
            <td><a href="javascript:document:用户删除<%=li.getId()%>.submit();">删除</a></td>
        </tr>
        <%
            }
        %>

    </table>
    <button class="button"><a href="userAdd.jsp">添加用户</a></button>

</div>

<br><br><br><br><br><br><br>
<div class="footer">
    <h2>copyright:@浙江师范大学软件创新实验室</h2>
</div>

</body>
</html>
