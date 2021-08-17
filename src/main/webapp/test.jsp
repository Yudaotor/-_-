<%@ page import="com.laurie.dao.GroupDao" %>
<%@ page import="com.laurie.dao.Impl.GroupDaoImpl" %>
<%@ page import="com.laurie.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.size());
            Group li = list.get(i);
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
</body>
</html>
