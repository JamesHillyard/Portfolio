<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15/03/2021
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ImplicitObjects: Out</title>
</head>
<body>
<% out.print("Today is: "+java.util.Calendar.getInstance().getTime()); %>
</body>
</html>
