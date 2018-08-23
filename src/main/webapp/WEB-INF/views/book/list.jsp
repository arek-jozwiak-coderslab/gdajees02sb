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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"  ></script>
</head>
<body>
<h1>Student List</h1>
<h3>Groups list:</h3>

<table>
    <thead>
    <tr>
        <td>Title</td>
        <td>Publisher</td>
        <td>Action</td>
    </tr>
    </thead>
    <c:forEach items="${books}" var="book">
        <tr>
            <td> ${book.title} </td>
            <td> ${book.publisher.firstName} ${book.publisher.lastName}</td>
            <td>
                <a href="/book/delete/${book.id}">delete</a>
                <a class="confirm" href="/book/edit/${book.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>
<script type="text/javascript">
    $(".confirm").on("click", function () {
        console.log("some click");
        if (confirm('Are you sure')) {
            window.location = $(this).href;
        }
    });
</script>
</body>
</html>
