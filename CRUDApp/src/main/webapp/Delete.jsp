<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 25/03/2021
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action="DeleteData" method="get">
    ID: <input type="number" name="ID">
</form>
${Deleted}
<form style="color: darkred">
    ${ErrorMessage}
</form>
</body>
</html>
