<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 06.01.2019
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<h1>Add new User</h1>
<form method="post">
    <label>Name</label><br>
    <input name="name" /><br><br>
    <label>Login</label><br>
    <input name="login" /><br><br>
    <label>Password</label><br>
    <input name="password"><br><br>
    <label>E-mail</label><br>
    <input name="email" /><br><br>
    <label>Create date</label><br>
    <input name="date" /><br><br>
    <label>Role</label><br>
    <input name="role" /><br><br>
    <input type="submit" value="add">
</form>
</body>
</html>
