<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 16/03/2021
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Core</title>
    <h2>
        All core tags begin with c:
    </h2>
</head>
<body>
<p style="color:crimson"> <b> c:out </b> </p>
<%! String str = null; %>
<c:out value="${str}" default="Hello from a core out tag. Works like %= but for expressions." />

<p style="color:crimson"> <b> c:set </b> </p>
<c:set var="name" scope="page" value="James" />
<c:out value="Name: ${name}" />

<p style="color:crimson"> <b> c:remove </b> </p>
<c:remove var="name" scope="page" />
<c:out value="Name: ${name}" />

<p style="color:crimson"> <b> c:if </b> </p>
<c:set var="age" value="19" scope="page"/>
<c:if test="${age >= 18}">
    <c:out value="You are eligible to vote"/>
</c:if>
<c:if test="${age < 18}">
    <c:out value="You are not eligible for voting!"/>
</c:if>

<p style="color:crimson"> <b> c:choose c:when and c:otherwise </b> </p>
<c:set var="number1" value="2"/>
<c:set var="number2" value="12"/>
<c:choose>
    <c:when test="${number1 < number2}">
        ${"Number 1 is less than Number 2"}
    </c:when>
    <c:when test="${number1 == number2}">
        ${"Number 1 and Number 2 are the same"}
    </c:when>
    <c:otherwise>
        ${"Number 1 is largest number!"}
    </c:otherwise>
</c:choose>

<p style="color:crimson"> <b> c:catch </b> </p>
<%!
    int num1=10;
    int num2=0; %>
<c:catch var ="errormsg">
    <% int res = num1/num2;
        out.println(res);%>
</c:catch>
<c:if test = "${errormsg != null}">
    <p>There has been an exception: ${errormsg}</p>
</c:if>

<p style="color:crimson"> <b> c:import </b> </p>
<c:import url="http://localhost:8080/CreatedBy.jsp" var="creator" />
<c:out value="${creator}" />

<p style="color:crimson"> <b> c:forEach </b> </p>
<c:forEach var="counter" begin="1" end="3">
    <c:out value="${counter}"/>
</c:forEach>

<p style="color:crimson"> <b> c:forTokens </b> </p>
<c:forTokens items="www.payara.fish" delims="." var="data">
    <c:out value="${data}"/>
</c:forTokens>

<p style="color:crimson"> <b> c:param </b> </p>
<c:url value="/JSTL/CoreDisplay.jsp" var="completeURL">
    <c:param name="userId" value="043"/>
    <c:param name="userName" value="James"/>
</c:url>
${completeURL}

<%-- Needs to be commented out or you can't view the page
<p style="color:crimson"> <b> c:redirect </b> </p>
<c:redirect url="CoreDisplay.jsp" >
    <c:param name="userId" value="043"/>
    <c:param name="userName" value="James"/>
</c:redirect>
--%>

</body>
</html>
