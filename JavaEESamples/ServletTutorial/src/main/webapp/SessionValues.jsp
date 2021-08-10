<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Demo</title>
</head>
<body>
	<p>Admin Password: ${adminPassword} </p>
	<p>Edited: ${Edited}</p>
</body>
<p>
	<form action = "StartSession" method = "GET">
		<input type = "submit" value = "Start Session" />
	</form>
	<form action = "EditSession" method = "GET">
		<input type = "submit" value = "Edit Session" />
	</form>
	<form action = "DeleteSession" method = "GET">
		<input type = "submit" value = "Delete Session" />
	</form>
</p>
</html>