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
    <form:form method="post" action="/chi-tiet-ao/add" modelAttribute="chiTietAo">
        <div class="row mt-3">
            <div class="col-6">
                Áo :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idAo" >
                    <form:option value="">Mời chọn</form:option>
                    <c:forEach items="${ao}" var="ao">
                        <form:option value="${ao.id}">${ao.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-6">
                Màu sắc :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle"  path="idMauSac" >
                    <form:option value="">Mời chọn</form:option>
                    <c:forEach items="${mauSac}" var="ms">
                        <form:option value="${ms.id}">${ms.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Size :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idSize" >
                    <form:option value="">Mời chọn</form:option>
                    <c:forEach items="${sizes}" var="s">
                        <form:option value="${s.id}">${s.sizes}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-6">
                Loại áo :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idLoaiAo" >
                    <form:option value="">Mời chọn</form:option>
                    <c:forEach items="${loaiAo}" var="la">
                        <form:option value="${la.id}">${la.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                Chất liệu :
                <form:select data-toggle="dropdown" class="btn btn-secondary dropdown-toggle" path="idChatLieu" >
                    <form:option value="">Mời chọn</form:option>
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
        </div>
        <br>
        <form:button  class="btn btn-primary" type="submit">Add</form:button>
    </form:form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Áo</th>
                <th scope="col">Màu sắc</th>
                <th scope="col">Size</th>
                <th scope="col">Loại áo</th>
                <th scope="col">Chất kiêu</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Gía</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Ảnh</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listChiTietAo}" var="ct" varStatus="i">
            <tr>
                <th scope="row">${i.index + 1}</th>
                <td>${ct.idAo.ten}</td>
                <td>${ct.idMauSac.ten}</td>
                <td>${ct.idSize.sizes}</td>
                <td>${ct.idLoaiAo.ten}</td>
                <td>${ct.idChatLieu.ten}</td>
                <td>${ct.soLuong}</td>
                <td>${ct.gia}</td>
                <td>${ct.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                <td><img src="${ct.anh}" width="100px" height="100px"></td>
                <td>
                    <a href="/chi-tiet-ao/view-update/${ct.id}"><button class="btn btn-warning">Update</button></a>
                    <a href="/trang-chu/detail/${ct.id}"><button class="btn btn-danger">Xem sản phẩm</button></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a href="/chi-tiet-ao/hien-thi?page=0">
            <button class="btn btn-success"> |<</button>
        </a>
        <c:if test="${soTrang > 0}">
            <a href="/chi-tiet-ao/hien-thi?page=${soTrang - 1}">
                <button class="btn btn-success"> <<</button>
            </a>
        </c:if>
        <c:if test="${soTrang < cuoiTrang -1}">
            <a href="/chi-tiet-ao/hien-thi?page=${soTrang + 1}">
                <button class="btn btn-success"> >></button>
            </a>
        </c:if>
        <a href="/chi-tiet-ao/hien-thi?page=${cuoiTrang - 1}">
            <button class="btn btn-success"> >|</button>
        </a>
    </div>
</div>
</body>
</html>