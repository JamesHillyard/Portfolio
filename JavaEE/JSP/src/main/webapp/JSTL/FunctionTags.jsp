<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 16/03/2021
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Functions</title>
    <h2>
        All function tags begin with fn:
    </h2>
</head>
<body>
<p style="color:deepskyblue"> <b> fn:contains </b> </p>
<c:set var="oldPassword" value="HelloPass"/>
<c:set var="newPassword" value="HelloPassNew" />
<c:if test="${fn:contains(newPassword, oldPassword)}">
    <c:out value="New Password should not contain old password as substring"/>
</c:if>

<p style="color:deepskyblue"> <b> fn:containsIgnoreCase </b> </p>
<c:set var="string1" value="James Hillyard"/>
<c:set var="string2" value="Hill" />
<c:if test="${fn:containsIgnoreCase(string1, string2)}">
    <c:out value="Case Insensitive Check: String1 contains string2"/>
</c:if>

<p style="color:deepskyblue"> <b> fn:indexOf </b> </p>
${fn:indexOf("James Hillyard", "James")}
${fn:indexOf("James Hillyard", "Hill")}
${fn:indexOf("James Hillyard", "Yes")}

<p style="color:deepskyblue"> <b> fn:escapeXml </b> </p>
    <small>Stops the use of HTML markup tags and outputs them as a string instead.</small> <br>
${fn:escapeXml("<b>Message in bold</b>")}

<p style="color:deepskyblue"> <b> fn:join </b> </p>
<%
    String arr[]={"James", "Seb", "Tom"};
    session.setAttribute("names", arr);
%>
${fn:join(names, " & ")}

<p style="color:deepskyblue"> <b> fn:split </b> </p>
<c:set var="msg" value="This is an example of JSTL function"/>
<c:set var="arrayofmsg" value="${fn:split(msg,' ')}"/>
<c:forEach var="i" begin="0" end="6">
    arrayofmsg[${i}]: ${arrayofmsg[i]}<br>
</c:forEach>

<p style="color:deepskyblue"> <b> fn:length </b> </p>
<c:set var="string1" value="This is a String"/>
Length of String is: ${fn:length(string1)}

<p style="color:deepskyblue"> <b> fn:startsWith </b> </p>
<c:set var="mymsg" value="JSTL function"/>
The string starts with "function": ${fn:startsWith(mymsg, 'function')}
<br>The string starts with "JSTL": ${fn:startsWith(mymsg, 'JSTL')}

<p style="color:deepskyblue"> <b> fn:endsWith </b> </p>
String ends with ".fish": ${fn:endsWith("payara.fish", "fish")}
<br>String ends with "yara.fish": ${fn:endsWith("payara.fish", "yara.fish")}
<br>String ends with "yaRA.fish": ${fn:endsWith("payara.fish", "yaRA.fish")}
<br>String ends with "yara.fi": ${fn:endsWith("payara.fish", "yara.fi")}

<p style="color:deepskyblue"> <b> fn:substring </b> </p>
<c:set var="msg" value="This is an example of JSTL function"/>
${fn:substring(msg, 10, 26)}

<p style="color:deepskyblue"> <b> fn:substringAfter </b> </p>
<c:set var="url" value="payara.fish"/>
${fn:substringAfter(url, ".")}

<p style="color:deepskyblue"> <b> fn:substringBefore </b> </p>
<c:set var="url" value="payara.fish"/>
${fn:substringBefore(url, ".")}

<p style="color:deepskyblue"> <b> fn:trim </b> </p>
<c:set var="mymsg" value=" This is the test String       "/>
${fn:trim(mymsg)}

<p style="color:deepskyblue"> <b> fn:toUpperCase </b> </p>
<c:set var="name" value="James"/>
Name: ${fn:toUpperCase(name)}

<p style="color:deepskyblue"> <b> fn:toLowerCase </b> </p>
${fn:toLowerCase("HELLO")}

<p style="color:deepskyblue"> <b> fn:replace </b> </p>
<c:set var="randomstring" value="abc def abc ghi ABC"/>
${fn:replace(randomstring, "abc", "James")}
</body>
</html>
