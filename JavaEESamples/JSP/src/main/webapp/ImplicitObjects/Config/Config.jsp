<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15/03/2021
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InitParams</title>
</head>
<body>
<p>
    Using an initialization parameter defined in the web.xml file, only applies to this JSP page.
</p>
<% String creator=config.getInitParameter("Creator");
    out.print("Init Parameter, Creator, is: "+creator); %>
</body>
</html>
