<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15/03/2021
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String pageData = (String) pageContext.getAttribute("PageScoped", 1);
    String requestScoped = (String) pageContext.getAttribute("RequestScoped", 2);
    String sessionScoped = (String) pageContext.getAttribute("SessionScoped", 3);
    String applicationScoped = (String) pageContext.getAttribute("ApplicationScoped", 4);
    String applicationDataPageScoped = (String) pageContext.getAttribute("ApplicationScoped", 3);
    out.print("Page Scoped "+pageData);
    out.print("Request Scoped "+requestScoped);
    out.print("Session Scoped "+sessionScoped);
    out.print("Application Scoped "+applicationScoped);
    out.print("Application Scoped, Page Scoped "+applicationDataPageScoped);
%>
</body>
</html>
