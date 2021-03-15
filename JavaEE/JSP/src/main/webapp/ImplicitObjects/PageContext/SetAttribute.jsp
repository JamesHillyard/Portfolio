<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15/03/2021
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("PageScoped","PageData",PageContext.PAGE_SCOPE);
    pageContext.setAttribute("RequestScoped","RequestData",PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("SessionScoped","SessionData",PageContext.SESSION_SCOPE);
    pageContext.setAttribute("ApplicationScoped","ApplicationData",PageContext.APPLICATION_SCOPE);
%>
<a href="http://localhost:8080/ImplicitObjects/PageContext/GetAttribute.jsp"> Get Attributes </a>
</body>
</html>
