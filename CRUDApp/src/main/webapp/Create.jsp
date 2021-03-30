<%@ page import="util.PropertiesReader" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 25/03/2021
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<div align="left">
    <form action="AddData" method="get">
            <p>ID: <input type="number" name="ID">
            <p>Company Name: <input type="text" name="companyName">
            <p><input type="submit" name="Submit">
    </form>
${idAdded}
${nameAdded}
<form style="color: darkred">
    ${ErrorMessage}
</div>
</body>
</html>
