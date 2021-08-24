<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/24/2021
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update from</title>
</head>
<body>
<form action="" method="post">
    <fieldset>
        <legend>Update User Form</legend>
        <table>
            <tr>

                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
            </tr>
            <tr>

                <td><input type="text" value="${user.name}" name="name"></td>
                <td><input type="text" value="${user.email}" name="email"></td>
                <td><input type="text" value="${user.country}" name="country"></td>
                <td><input type="submit" value="Update"></td>

            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
