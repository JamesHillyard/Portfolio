<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15/03/2021
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("http://localhost:8080/ImplicitObjects/Session/Home.jsp");
%>
</body>
</html>
