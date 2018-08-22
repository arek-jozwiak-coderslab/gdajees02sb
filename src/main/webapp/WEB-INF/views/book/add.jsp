<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Add student</h1>
<form:form method="post" modelAttribute="book">
    <form:input path="title"/>
    <form:select itemLabel="firstName" path="publisher" items="${publishers}" />
    <input type="submit" value="Save">
</form:form>

</body>
</html>