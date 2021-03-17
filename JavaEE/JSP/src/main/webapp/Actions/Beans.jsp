<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 16/03/2021
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
    <jsp:useBean id = "bean" class = "action.JSPBean" />
    <jsp:setProperty name="bean" property="message" value="Hello James"/>
    <p><b>Got Message:</b></p>
    <jsp:getProperty name="bean" property="message"/>
</div>
</body>
</html>
