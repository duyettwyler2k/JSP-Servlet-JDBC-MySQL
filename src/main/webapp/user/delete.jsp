<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Form</title>
</head>
<body>
<a href="/users"> Back</a>
<form method="post">
    <table>

        <tr>
            <td> Name:</td>
            <td> <c:out value="${user.name}"></c:out> </td>
        </tr>
        <tr>
            <td> Email:</td>
            <td> <c:out value="${user.email}"></c:out> </td>
        </tr>
        <tr>
            <td> Country:</td>
            <td> <c:out value="${user.country}"></c:out> </td>
        </tr>
        <tr>
            <td>
            </td>
            <td> <input type="submit" value="Delete "> </td>
        </tr>
    </table>
</form>
</body>
</html>
