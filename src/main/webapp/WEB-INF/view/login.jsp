<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div>
    <c:if test="${not empty suss}">
        <div class="p-3 mb-2 bg-primary text-white">${suss}</div>
    </c:if>
    <c:if test="${not empty err}">
        <div class="p-3 mb-2 bg-danger text-white">${err}</div>
    </c:if>
</div>
<form method="post" action="/trang-chu">
    <div class="mb-3">
        <label  class="form-label">Email address</label>
        <input type="text" name = "email" class="form-control" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label  class="form-label">Password</label>
        <input type="password" name="matKhau" class="form-control">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>