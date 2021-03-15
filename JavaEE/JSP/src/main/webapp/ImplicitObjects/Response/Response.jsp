<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15/03/2021
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String input = request.getParameter("input"); %>
<%
    if(input.equals("Google")){
        response.sendRedirect("http://www.google.com");
    }
    if(input.equals("Payara")){
        response.sendRedirect("https://payara.fish");
    }
%>

</body>
</html>
