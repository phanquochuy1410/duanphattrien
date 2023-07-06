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
    <h1 style="text-align: center">Chất liệu</h1>
    <br>
    <c:if test="${not empty successMessage}">
        <div >
                ${successMessage}
        </div>
    </c:if>
    <form:form method="post" action="/chat-lieu/add" modelAttribute="chatLieu">
        <div class="row mt-3">
            <div class="col-6">
                Mã : <form:input path="ma" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="ma" cssStyle="color: red"/>
                <c:if test="${not empty suss}">
                    <div style="color: red">${suss}</div>
                </c:if>
            </div>
            <div class="col-6">
                Tên : <form:input path="ten" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="ten" cssStyle="color: red"/>
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
            <th scope="col">Tên </th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listChatLieu}" var="cl" varStatus="i">
            <tr>
                <th scope="row">${i.index + 1}</th>
                <td>${cl.ma}</td>
                <td>${cl.ten}</td>
                <td>
                    <a href="/chat-lieu/view-update/${cl.id}">
                        <button type="button" class="btn btn-warning">Update</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a href="/chat-lieu/hien-thi?page=0">
            <button class="btn btn-success"> |<</button>
        </a>
        <c:if test="${soTrang > 0}">
            <a href="/chat-lieu/hien-thi?page=${soTrang - 1}">
                <button class="btn btn-success"> <<</button>
            </a>
        </c:if>
        <c:if test="${soTrang < cuoiTrang -1}">
            <a href="/chat-lieu/hien-thi?page=${soTrang + 1}">
                <button class="btn btn-success"> >></button>
            </a>
        </c:if>
        <a href="/chat-lieu/hien-thi?page=${cuoiTrang - 1}">
            <button class="btn btn-success"> >|</button>
        </a>
    </div>
</div>
<script>
    function check(){
        return confirm("Bạn có muốn thêm ${ao.ten} không ?")
    }
</script>
</body>
</html>