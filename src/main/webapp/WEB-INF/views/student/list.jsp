<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 22.08.18
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student List</h1>
<h3>Groups list:</h3>
<ul>
<c:forEach items="${groups}" var="group">
    <li>${group.name}</li>
</c:forEach>


</ul>
</body>
</html>
