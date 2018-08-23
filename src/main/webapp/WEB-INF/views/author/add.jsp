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
<style type="text/css">
    .classError {color: red; font-size: small; border: aqua solid 3px}
</style>
<body>
<h1>Add student</h1>
<form:form method="post" modelAttribute="author">
    <form:hidden path="id"/>
    Title:
    <form:input path="yearOfBirth"/><form:errors path="yearOfBirth" cssClass="classError" /><br/>
    Description:
    <form:input path="firstName"/><br/>

    <input type="submit" value="Save">
</form:form>

</body>
</html>