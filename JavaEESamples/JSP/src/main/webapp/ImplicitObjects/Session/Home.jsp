<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Sessions</title>
</head>
<body>
    <p> Session Attributes:
        <%="Name: "+session.getAttribute("name") %>
        <%="\nSurname: "+session.getAttribute("surname")%>
    </p>
    Set Attributes
    <a href="http://localhost:8080/ImplicitObjects/Session/SetAttribute.jsp">More info </a> <br>
    Edit Attributes
    <a href="http://localhost:8080/ImplicitObjects/Session/EditAttribute.jsp">More info </a> <br>
    Invalidate Session
    <a href="http://localhost:8080/ImplicitObjects/Session/InvalidateSession.jsp">More info </a> <br>
</body>
</html>