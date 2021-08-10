<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 12/03/2021
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<%
    String name=request.getParameter("name");
    out.print("Welcome "+name);
%>

<%@include file="CreatedBy.jsp" %>
</body>
</html>
