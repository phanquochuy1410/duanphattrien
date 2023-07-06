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
    <h1 style="text-align: center">Update khách hàng</h1>
    <form:form method="post" action="/khach-hang/update" modelAttribute="khachHang">
        <div class="col-6">
            Mã : <form:input path="id" class="form-control" aria-describedby="basic-addon1" readonly="true"/>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Mã : <form:input path="ma" class="form-control" aria-describedby="basic-addon1" readonly="true"/>
                <form:errors path="ma" cssStyle="color: red"/>
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
                Số điện thoại : <form:input path="sdt"  class="form-control"
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

        <form:button type="submit" onclick="return check()" class="btn btn-primary">Update</form:button>

    </form:form>
</div>
<script>
    function check() {
        return confirm("Bạn có muốn thêm ${kh.hoVaTen} không ?")
    }
</script>
</body>
</html>