<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 23/12/2022
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Product</h1>
<form method="post" action="/products">
    <input name="id" placeholder="nhập id"><br>
    <input name="name" placeholder="nhập name"><br>
    <input name="img" placeholder="nhập img"><br>
    <input name="price" placeholder="nhập price"><br>
    <button type="submit">Create</button>
</form>
</body>
</html>
