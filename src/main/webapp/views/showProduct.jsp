<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 31/12/2021
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<button><a href="/product?action=create">Create</a></button>
<form action="/product?action=search" method="post">
    <input name="search">
    <button type="submit">Search</button>
</form>
<table border="1">
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Id_Category</th>
        <th>Category</th>

    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td>${p.description}</td>
            <td>${p.color}</td>
            <td>${p.name_category}</td>
            <td><a href="/product?action=delete&id=${p.id}">Delete</a></td>
            <td><a href="/product?action=edit&id=${p.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
