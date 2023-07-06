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
    <h1 style="text-align: center">Khách hàng</h1>
    <form:form method="post" action="/khach-hang/add" modelAttribute="khachHang">
        <div class="row mt-3">
            <div class="col-6">
                Mã : <form:input path="ma" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="ma" cssStyle="color: red"/>
                <c:if test="${not empty suss}">
                    <div style="color: red">${suss}</div>
                </c:if>
            </div>
            <div class="col-6">
                Họ và tên : <form:input path="hoVaTen" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="hoVaTen" cssStyle="color: red"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Gioi tính : <form:radiobutton path="gioiTinh" value="true" checked="true"/>Nam
                <form:radiobutton path="gioiTinh" value="false"/>Nữ
            </div>
            <div class="col-6">
                Số điện thoại : <form:input path="sdt" class="form-control"
                                        aria-describedby="basic-addon1"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Địa chỉ : <form:input path="diaChi" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="diaChi" cssStyle="color: red"/>
            </div>
            <div class="col-6">
                Trạng thái : <form:radiobutton path="trangThai" value="1" checked="true"/>Hoạt động
                <form:radiobutton path="trangThai" value="0"/>Ngừng hoạt động
            </div>
        </div>

            <form:button type="submit" onclick="return check()" class="btn btn-primary">Add</form:button>

    </form:form>

    <c:if test="${not empty successMessage}">
        <div>
                ${successMessage}
        </div>
    </c:if>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã</th>
            <th scope="col">Họ và tên</th>
            <th scope="col">Gioi tính</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKhachHang}" var="kh" varStatus="i">
            <tr>
                <th scope="row">${i.index + 1}</th>
                <td>${kh.ma}</td>
                <td>${kh.hoVaTen}</td>
                <td>${kh.gioiTinh == true ? "Nam":"Nữ"}</td>
                <td>${kh.sdt}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/khach-hang/view-update/${kh.id}">
                        <button type="button" class="btn btn-warning">Update</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="text-align: center">
        <a href="/khach-hang/hien-thi?page=0">
            <button class="btn btn-success"> |<</button>
        </a>
        <c:if test="${soTrang > 0}">
            <a href="/khach-hang/hien-thi?page=${soTrang - 1}">
                <button class="btn btn-success"> <<</button>
            </a>
        </c:if>
        <c:if test="${soTrang < cuoiTrang -1}">
            <a href="/khach-hang/hien-thi?page=${soTrang + 1}">
                <button class="btn btn-success"> >></button>
            </a>
        </c:if>
        <a href="/khach-hang/hien-thi?page=${cuoiTrang - 1}">
            <button class="btn btn-success"> >|</button>
        </a>
    </div>
</div>
<script>
    function check() {
        return confirm("Bạn có muốn thêm ${kh.hoVaTen} không ?")
    }
</script>
</body>
</html>