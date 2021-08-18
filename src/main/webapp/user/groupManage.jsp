<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="com.laurie.pojo.User" %>
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
        <li><a href="${pageContext.request.contextPath}/jsp/welcome.jsp">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/userManage.jsp">我的</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/group.jsp">小组</a></li>
        <li><a href="#">话题</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/about.jsp">关于</a></li>
    </ul>
</div>
<div class="NavigationBar2">
    <ul>
        <li><a href="passwordManage.jsp">密码管理</a></li>
        <li><a href="groupManage.jsp">小组管理</a></li>
        <li><a href="#">话题管理</a></li>
    </ul>
</div>

<div class="body">
    <h3>小组管理</h3>
        <div style="font-size: 20px">
            您当前所加入的小组有:
        </div>
    <table>
        <tr>
            <th>小组名称</th>
            <th>操作</th>
        </tr>
        <%
            User user = new User();
            user = (User) session.getAttribute("USER_SESSION");
            int memberId = user.getId();
            GroupDao groupDao = new GroupDaoImpl();
            List<String> list = groupDao.selectGroupByMemberId(memberId);
            for (String li : list){

        %>
        <form action="${pageContext.request.contextPath}/group" method="post" id="<%=li%>">
            <input type="hidden" name="method" value="exit">
            <input type="hidden" name="groupName" value="<%=li%>">
        </form>

        <tr>
            <td><%=li%></td>
            <td><a href="javascript:document:<%=li%>.submit();">退出</a></td>
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
