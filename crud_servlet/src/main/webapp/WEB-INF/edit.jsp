<%@ page import="ru.job4j.webarchitecturejsp.model.User" %>
<%@ page import="ru.job4j.webarchitecturejsp.logic.ValidateService" %><%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 06.01.2019
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h2>Edit user</h2>
<form method="post">
    <input type="hidden" value="<%=request.getAttribute("id")%>" name="id" />
    <label>Name</label><br>
    <input name="name" value="<%=request.getAttribute("name")%>" /><br><br>
    <label>Login</label><br>
    <input name="login" value="<%=request.getAttribute("login")%>" /><br><br>
    <label>Password</label><br>
    <input name="password" value="<%=request.getAttribute("password")%>" /><br><br>
    <label>E-mail</label><br>
    <input name="email" value="<%=request.getAttribute("email")%>" /><br><br>
    <label>Create date</label><br>
    <input name="date" value="<%=request.getAttribute("date")%>" /><br><br>
    <label>Role</label><br>
    <select name="role">
        <option value="admin">admin</option>
        <option value="user">user</option>
    </select> <br><br>
    <label>Country</label><br>
    <select name="country">
        <option selected="selected" value="<%=request.getAttribute("country")%>">Not change</option>
        <option value="France">France</option>
        <option value="Kyrgyzstan">Kyrgyzstan</option>
        <option value="Rassia">Russia</option>
        <option value="Ukraine">Ukraine</option>
    </select><br><br />
    <label>City</label><br />
    <input name="city" value="<%=request.getAttribute("city")%>" /><br><br>

    <input type="submit" value="Send" />
</form>
</body>
</html>