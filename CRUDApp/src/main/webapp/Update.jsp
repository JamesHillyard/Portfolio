<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 25/03/2021
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="UpdateData" method="get">
    <p>ID: <input type="number" name="ID">
    <p>New Company Name: <input type="text" name="companyName">
    <p><input type="submit" name="Submit">
</form>
<form style="color: darkred">
    ${ErrorMessage}
</body>
</html>
