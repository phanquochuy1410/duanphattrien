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

    <h1 style="text-align: center">Nhân viên</h1>

    <form method="get" action="/nhan-vien/search">
        Tên : <input name="tenSearch" class="form-control" aria-describedby="basic-addon1"><br>
        <button type="submit" class="btn btn-success">Search</button>
    </form>

    <form:form method="post" action="/nhan-vien/add" modelAttribute="nhanVien">
        <div class="row mt-3">
            <div class="col-6">
                Mã : <form:input path="ma" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="ma" cssStyle="color: red"/>
                <c:if test="${not empty suss}">
                    <p style="color: red">${suss}</p>
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
                Ngày sinh : <form:input path="ngaySinh" type="date" class="form-control"
                                        aria-describedby="basic-addon1"/>
                <c:if test="${not empty suse}">
                    <p style="color: red">${suse}</p>
                </c:if>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Email : <form:input path="email" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="email" cssStyle="color: red"/>
                <c:if test="${not empty sus}">
                    <p style="color: red">${sus}</p>
                </c:if>
            </div>
            <div class="col-6">
                Số điện thoại : <form:input path="sdt" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="sdt" cssStyle="color: red"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Địa chỉ : <form:input path="diaChi" class="form-control" aria-describedby="basic-addon1"/>
                <form:errors path="diaChi" cssStyle="color: red"/>
            </div>
            <div class="col-6">
                Mật khẩu : <form:input path="matKhau" type="passWold" class="form-control"
                                       aria-describedby="basic-addon1"/>
                <form:errors path="matKhau" cssStyle="color: red"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Chức vụ : <form:radiobutton path="chucVu" value="1" checked="true"/>Quản lý
                <form:radiobutton path="chucVu" value="0"/>Nhân viên
            </div>
            <div class="col-6">
                Trạng thái : <form:radiobutton path="trangThai" value="1" checked="true"/>Hoạt động
                <form:radiobutton path="trangThai" value="0"/>Ngừng hoạt động
            </div>
        </div>
        <div>
            <form:button type="submit" onclick="return check()" class="btn btn-primary">Add</form:button>
        </div>
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
            <th scope="col">Ngày sinh</th>
            <th scope="col">Email</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Chức vụ</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listNhanVien}" var="nv" varStatus="i">
            <tr>
                <th scope="row">${i.index + 1}</th>
                <td>${nv.ma}</td>
                <td>${nv.hoVaTen}</td>
                <td>${nv.gioiTinh == true ? "Nam":"Nữ"}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.email}</td>
                <td>${nv.sdt}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.chucVu == 1 ? "Quản lý" : "Nhân viên"}</td>
                <td>${nv.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/nhan-vien/view-update/${nv.id}">
                        <button type="button" class="btn btn-warning">Update</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="text-align: center">
        <a href="/nhan-vien/hien-thi?page=0">
            <button class="btn btn-success"> |<</button>
        </a>
        <c:if test="${soTrang > 0}">
            <a href="/nhan-vien/hien-thi?page=${soTrang - 1}">
                <button class="btn btn-success"> <<</button>
            </a>
        </c:if>
        <c:if test="${soTrang < cuoiTrang -1}">
            <a href="/nhan-vien/hien-thi?page=${soTrang + 1}">
                <button class="btn btn-success"> >></button>
            </a>
        </c:if>
        <a href="/nhan-vien/hien-thi?page=${cuoiTrang - 1}">
            <button class="btn btn-success"> >|</button>
        </a>
    </div>
</div>
<script>
    function check() {
        return confirm("Bạn có muốn thêm ${nv.hoVaTen} không ?")
    }
</script>
</body>
</html>