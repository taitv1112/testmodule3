<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 31/12/2021
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/product?action=create">
    <table>
        <tr>
            <td><input name="name" type="text" placeholder="name"></td>
        </tr>
        <tr>
            <td><input name="price" type="text" placeholder="price">> </td>
        </tr>
        <tr>
            <td><input name="quantity" type="text" placeholder="quantity"></td>
        </tr>

        <tr>
            <td><input name="description" type="text" placeholder="description"></td>
        </tr>
        <tr>
            <td><input name="color" type="text"  placeholder="color"></td>
        </tr>

        <tr>
            <td>
                <select name="categories">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <button type="submit">Create</button>
</form>
</body>
</html>
