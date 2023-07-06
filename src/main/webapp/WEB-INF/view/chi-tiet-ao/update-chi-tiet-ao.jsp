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
    <h1 style="text-align: center">Chi tiết áo</h1>
    <form:form method="post" action="/chi-tiet-ao/update" modelAttribute="chiTietAo">
        <div class="row mt-3">
            <div class="col-6">
                Áo :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idAo">
                    <c:forEach items="${ao}" var="ao">
                        <form:option value="${ao.id}">${ao.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-6">
                Màu sắc :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idMauSac">
                    <c:forEach items="${mauSac}" var="ms">
                        <form:option value="${ms.id}">${ms.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Size :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idSize">
                    <c:forEach items="${sizes}" var="s">
                        <form:option value="${s.id}">${s.sizes}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-6">
                Loại áo :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idLoaiAo">
                    <c:forEach items="${loaiAo}" var="la">
                        <form:option value="${la.id}">${la.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Chất liệu :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idChatLieu">
                    <c:forEach items="${chatLieu}" var="cl">
                        <form:option value="${cl.id}">${cl.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-6">
                Số lượng : <form:input path="soLuong" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="soLuong" cssStyle="color: red"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Gía : <form:input path="gia" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="gia" cssStyle="color: red"/>
            </div>
            <div class="col-6">
                Link ảnh : <form:input path="anh" class="form-control" aria-describedby="basic-addon1"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Trạng thái : <form:radiobutton path="trangThai" value="1" checked="true"/> Hoạt động
                <form:radiobutton path="trangThai" value="0"/> Ngừng hoạt động
            </div>
            <div class="col-6">
                Id: <form:input path="id" class="form-control" aria-describedby="basic-addon1" readonly="true"/>
            </div>
        </div>
        <br>
        <form:button class="btn btn-primary" type="submit">Update</form:button>
    </form:form>
</div>
</body>
</html>