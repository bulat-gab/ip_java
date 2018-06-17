<%@ page import="java.util.Random" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="qwe" type="java.lang.Integer"--%>
<%--
  Created by IntelliJ IDEA.
  User: mail4
  Date: 27.02.2018
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    Random r = new Random();
    request.setAttribute("ints", r.ints(10).toArray());
%>

<c:forEach items="${ints}" var="zzz">
    <c:out value="${zzz}"/>
</c:forEach>
</body>
</html>
