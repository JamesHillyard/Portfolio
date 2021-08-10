<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 16/03/2021
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formatting</title>
    <h2>
        All formatting tags begin with fmt:
    </h2>
</head>
<body>
<p style="color:deepskyblue"> <b> fmt:formatNumber </b> </p>
<c:set var = "balance" value = "1200.2309" />
Currency: <fmt:formatNumber value = "${balance}" type = "number"/>
<p></p>
Currency USD: <fmt:setLocale value = "en_US"/> <fmt:formatNumber value = "${balance}" type = "currency" maxFractionDigits="2"/>

<p style="color:deepskyblue"> <b> fmt:parseNumber </b> </p>
<c:set var = "balance" value = "1250003.350" />
<fmt:parseNumber var = "i" type = "number" value = "${balance}" />
<c:out value = "${i}" /></p>

<p style="color:deepskyblue"> <b> fmt:formatDate </b> </p>
<c:set var = "now" value = "<%= new java.util.Date()%>" />
<fmt:formatDate type = "date" value = "${now}" />
<p></p>
<fmt:formatDate type = "both" dateStyle = "long" timeStyle = "long" value = "${now}" />

<%-- More formatting tags can be found here: --%>
<p style="color:cornflowerblue"> <b> https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm  </b> </p>
</body>
</html>
