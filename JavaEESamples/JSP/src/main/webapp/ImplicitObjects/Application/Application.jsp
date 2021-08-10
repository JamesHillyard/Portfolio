<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15/03/2021
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    View the application scoped variable, Creator.
</head>
<body>
<p>
    <%
        String creator = application.getInitParameter("Creator");
        out.print("Init Parameter, Creator, is: "+creator);
    %>
</p>
</body>
</html>
