<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<a href="/users?action=create">Create new user</a>

<table>
<tr>
    <td>id</td>
    <td>name</td>
    <td>email</td>
    <td>country</td>
</tr>
<c:forEach items="${users}" var="user">
<tr>
    <td><c:out value="${user.id}"></c:out></td>
    <td><c:out value="${user.name}"></c:out></td>
    <td><c:out value="${user.email}"></c:out></td>
    <td><c:out value="${user.country}"></c:out></td>
    <td><a href="/users?action=update&id=${user.id}">Edit</a></td>
    <td><a href="/users?action=delete&id=${user.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
