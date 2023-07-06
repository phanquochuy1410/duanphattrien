<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="col-8 offset-2">
    <h1 style="text-align: center">Size</h1>
    <br>
    <c:if test="${not empty successMessage}">
        <div >
                ${successMessage}
        </div>
    </c:if>
    <form:form method="post" action="/size/add" modelAttribute="size">
        <div class="row mt-3">
            <div class="col-6">
                Mã : <form:input path="ma" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="ma" cssStyle="color: red"/>
                <c:if test="${not empty suss}">
                    <p style="color: red">${suss}</p>
                </c:if>
            </div>
            <div class="col-6">
                Size : <form:input path="sizes" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="sizes" cssStyle="color: red"/>
            </div>
        </div>
        <br>
        <div>
            <form:button type="submit" onclick="return check()" class="btn btn-primary">Add</form:button>
        </div>
    </form:form>

    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã </th>
            <th scope="col">Size </th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSize}" var="s" varStatus="i">
            <tr>
                <th scope="row">${i.index + 1}</th>
                <td>${s.ma}</td>
                <td>${s.sizes}</td>
                <td>
                    <a href="/size/view-update/${s.id}">
                        <button type="button" class="btn btn-warning">Update</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a href="/size/hien-thi?page=0">
            <button class="btn btn-success"> |<</button>
        </a>
        <c:if test="${soTrang > 0}">
            <a href="/size/hien-thi?page=${soTrang - 1}">
                <button class="btn btn-success"> <<</button>
            </a>
        </c:if>
        <c:if test="${soTrang < cuoiTrang -1}">
            <a href="/size/hien-thi?page=${soTrang + 1}">
                <button class="btn btn-success"> >></button>
            </a>
        </c:if>
        <a href="/size/hien-thi?page=${cuoiTrang - 1}">
            <button class="btn btn-success"> >|</button>
        </a>
    </div>
</div>
<script>
    function check(){
        return confirm("Bạn có muốn thêm ${s.sizes} không ?")
    }
</script>
</body>
</html>