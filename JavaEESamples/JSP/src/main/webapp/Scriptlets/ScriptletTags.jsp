<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15/03/2021
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scriptlets</title>
</head>
<body>
<h3>
    Scriptlet Information
</h3>
<p>
    No modifier is a scriptlet tag, used to execute java source code within JSP
    <a href="https://www.javatpoint.com/jsp-scriptlet-tag">More info </a> <br>
    = is a JSP Expression tag, will print the value of the variable or method
    <a href="https://www.javatpoint.com/jsp-expression-tag">More info </a> <br>
    ! is a JSP Declaration tag, used to declare methods and fields
    <a href="https://www.javatpoint.com/jsp-declaration-tag">More info </a>
</p>
<p>
    <%! int a = 3; %>
    <% int b = 2; %>
    Total: <%= a+b%>
</p>
<p>
    <%! String str = "Hello World"; %>
    <% str=str.substring(0,5); %>
    <%= str %>
</p>
</body>
</html>
