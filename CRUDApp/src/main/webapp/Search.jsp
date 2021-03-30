<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 24/03/2021
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action="IDSearch" method="get">
        ID: <input type="number" name="searchID">
</form>
${testName}
${idRetrieved}
${nameRetrieved}
<form style="color: darkred">
    ${ErrorMessage}
</form>
</body>
</html>
