<%@ page import="ru.job4j.webarchitecturejsp.logic.ValidateService" %>
<%@ page import="ru.job4j.webarchitecturejsp.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 06.01.2019
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
<p><h2>Users List</h2></p>
<p><a href="<%=request.getContextPath()%>/addjsp">new User</a></p>
<p><a href="<%=request.getContextPath()%>/signout">sign Out</a></p>

<table style="border: 1px solid black;" cellpadding="1"; border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th>E-mail</th>
        <th>Create date</th>
        <th>Role</th>
        <th>Country</th>
        <th>City</th>
        <th>Edit user</th>
        <th>Delete user</th>
    </tr>
    <%--<%for (User user : ValidateService.getValidateService().findAll()) {%>--%>
    <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.id}"></c:out></td>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.login}"></c:out></td>
        <td><c:out value="${user.password}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td><c:out value="${user.createDate}"></c:out></td>
        <td><c:out value="${user.role}"></c:out></td>
        <td><c:out value="${user.country}"></c:out></td>
        <td><c:out value="${user.city}"></c:out></td>
        <%--<td><%=user.getId()%></td>--%>
        <%--<td><%=user.getName()%></td>--%>
        <%--<td><%=user.getLogin()%></td>--%>
        <%--<td><%=user.getEmail()%></td>--%>
        <%--<td><%=user.getCreateDate()%></td>--%>
        <%--<td><a href="<%=request.getContextPath()%>/editjsp?id=<%=user.getId()%>">edit</a></td>--%>
        <td><a href="<%=request.getContextPath()%>/editjsp?id=<c:out value="${user.id}"></c:out>">edit</a></td>
        <td>
        <form method="get" action="<%=request.getContextPath()%>/deletejsp" style="display: inline"/>
            <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
        <%--<input type="hidden" name="id" value="<%=user.getId()%>">--%>
        <input type="submit" value="Delete">
        </form>
        </td>
    </tr>
    </c:forEach>
    <%--<%}%>--%>
</table>
</body>
</html>
