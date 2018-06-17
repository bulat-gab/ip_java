<%--
  Created by IntelliJ IDEA.
  User: mail4
  Date: 06.03.2018
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    sdsgdf
    <form action="/login" method="post">
        <input name="login" type="text">
        <input name="password" type="password">
        <input type="submit">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</body>
</html>
