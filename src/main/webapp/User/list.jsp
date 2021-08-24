<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/24/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list from</title>
</head>
<body>
<a href="/UserController?action=create">Create User</a>
<br><br>
<form action="UserController" method="get">
    <fieldset>
        <legend>User List Form</legend>
        <table border="1" width="60%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th colspan="2">Action</th>
            </tr>
            <c:forEach items="${list}" var="list1">
                <tr>
                    <td>${list1.getId()}</td>
                    <td>${list1.getName()}</td>
                    <td>${list1.getEmail()}</td>
                    <td>${list1.getCountry()}</td>
                    <td><a href="/UserController?action=remove&id=${list1.getId()}">Remove</a></td>
                    <td><a href="/UserController?action=update&id=${list1.getId()}">Update</a></td>

                </tr>
            </c:forEach>




        </table>
    </fieldset>
</form>

</body>
</html>
