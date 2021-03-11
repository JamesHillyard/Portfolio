<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "ProcessInput" method = "GET">
First Name: <input type = "text" name = "first_name">
<p>${errorMessage}</p>
</form> 
</body>
</html>