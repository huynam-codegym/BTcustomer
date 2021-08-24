<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/24/2021
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>remove from</title>
</head>
<body>
<form action="" method="post">
    <fieldset>
        <legend>Remove User Form</legend>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
            </tr>
            <tr>
                <td><input type="number" value="${user.id}"></td>
                <td><input type="text" value="${user.name}"></td>
                <td><input type="text" value="${user.email}"></td>
                <td><input type="text" value="">${user.country}</td>
                <td><input type="submit" value="Remove"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
