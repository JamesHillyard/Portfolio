<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 07/04/2021
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<body>
<form action="tutorial/orders/add" method="post">
    ID: <input type="number" name="id"> <br>
    Product: <input type="text" name="product"> <br>
    Quantity: <input type="number" name="quantity"> <br>
    <input type="submit" value="Add Order"/>
</form>
</body>
</html>
