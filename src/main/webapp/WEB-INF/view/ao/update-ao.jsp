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
    <h1 style="text-align: center">Update Áo</h1>
    <br>
    <form:form method="post" action="/ao/update" modelAttribute="ao">
        <div class="col-6">
            Id : <form:input path="id" class="form-control" aria-describedby="basic-addon1" readonly="true"/>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Mã : <form:input path="ma" class="form-control" aria-describedby="basic-addon1" readonly="true"/>
                <form:errors path="ma" cssStyle="color: red"/>
            </div>
            <div class="col-6">
                Tên : <form:input path="ten" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="ten" cssStyle="color: red"/>
            </div>
        </div>
        <form:button type="submit" onclick="return check()" class="btn btn-primary">Update</form:button>
    </form:form>
</div>
<script>
    function check(){
        return confirm("Bạn có muốn sửa ${ao.ten} không ?")
    }
</script>
</body>
</html>