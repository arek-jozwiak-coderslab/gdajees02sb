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
<form:form method="post" modelAttribute="personDTO">
    login:    <form:input path="login"/>
    password: <form:input path="password"/>
    email:    <form:input path="email"/>
    firstName:<form:input path="firstName"/>
    lastName: <form:input path="lastName"/>
    gender:   <form:radiobutton path="gender" value="gender"/>
    country:  <form:select path="country" items="${countryItems}"/>
    notes:    <form:textarea path="notes" rows="3" cols="20"/>
    mailingList:        <form:checkbox path="mailingList"/>
    programmingSkills:  <form:select path="programmingSkills" items="${skills}" multiple="true"/>
    hobbies   <form:checkboxes path="hobbies" items="${hobbies}"  />
    <input type="submit" value="Save">
</form:form>

</body>
</html>