<%--
  Created by IntelliJ IDEA.
  User: BUI VIET THANG
  Date: 04/01/2022
  Time: 1:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post">
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Description</th>
            <th>Color</th>
            <th>Name Categotry</th>
        </tr>
        <tr>
            <input type="hidden" name="id" value="${product.id}">
            <td><input type="text" name="name" value="${product.name}" readonly></td>
            <td><input type="text" name="price" value="${product.price}"></td>
            <td><input type="text" name="quantity" value="${product.quantity}"></td>
            <td><input type="text" name="description" value="${product.description}"></td>
            <td><input type="text" name="color" value="${product.color}"></td>
            <td>
                <select name="categories">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <button type="submit">Update Category</button>
    </table>
</form>
</body>
</html>
