<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>Create new user</h1>
<a href="/users">List user</a>
<form action="/users?action=create" method="post">
<table>
    <tr>
        <td>name</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>email</td>
        <td><input type="text" name="email"></td>
    </tr>
    <tr>
        <td>country</td>
        <td><input type="text" name="country"></td>
    </tr>
    <tr>
        <td><button>Create</button></td>
    </tr>
</table>
</form>
</body>
</html>
