<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<c:if test="${checkMa != null}">
    <script>
        alert("${checkMa}");
    </script>
</c:if>

<a href="/trang-chu">
    <svg style="margin-top: 10px" xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
         class="bi bi-house-add-fill"
         viewBox="0 0 16 16">
        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 1 1-1 0v-1h-1a.5.5 0 1 1 0-1h1v-1a.5.5 0 0 1 1 0Z"/>
        <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
        <path d="m8 3.293 4.712 4.712A4.5 4.5 0 0 0 8.758 15H3.5A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
    </svg>
</a>
<a href="/hoa-don">
    <svg style="margin-top: 10px" xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
         class="bi bi-file-text-fill" viewBox="0 0 16 16">
        <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM5 4h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1 0-1zm-.5 2.5A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5zM5 8h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1 0-1zm0 2h3a.5.5 0 0 1 0 1H5a.5.5 0 0 1 0-1z"/>
    </svg>
</a>
<div class="col-6 offset-1" style="position: absolute">
    <form method="get" action="/gio-hang/hien-thi">
        <select class="form-select" name="idHoaDon" id="idHoaDon">
            <c:forEach items="${hoaDon}" var="hd">
                <option value="${hd.id}">${hd.ma}</option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-primary">Tính tổng</button>
    </form>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Size</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Gía</th>
            <th scope="col">Tổng tiền</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listHDCT}" var="hdct" varStatus="i">
            <tr>
                <th scope="row">${i.index + 1}</th>
                <td>${hdct.idChiTietAo.idAo.ten}</td>
                <td>${hdct.idChiTietAo.idSize.sizes}</td>
                <td>${hdct.soLuong}</td>
                <td>${hdct.gia}</td>
                <td>${hdct.tongTien()}</td>
                <td>
                    <a href="/delete/${hdct.id}">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                             class="bi bi-backspace-fill" viewBox="0 0 16 16">
                            <path d="M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z"/>
                        </svg>
                    </a>
                    <div class="container">
                        <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                            Sửa
                        </button>
                        <div class="modal fade" id="myModal">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Sửa sản phẩm</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <form method="post" action="/update-san-pham">
                                            Id :<input name="id" value="${hdct.id}" readonly><br>
                                            Áo :<input name="idChiTietAo" value="${hdct.idChiTietAo.id}" readonly>
                                            <br>
                                            Hóa đơn : <select name="idHoaDon">
                                            <c:forEach items="${hoaDon}" var="hd">
                                                <option value="${hd.id}">${hd.ma}</option>
                                            </c:forEach>
                                        </select><br>
                                            Số lượng : <input type="number" name="soLuong" value="${hdct.soLuong}">
                                            <br>
                                            Gía : <input name="gia" value="${hdct.gia}" readonly>
                                            <a>
                                                <button class="btn btn-danger" onclick="return hienThi()">Sửa</button>
                                            </a>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h3 style="color: red">Tổng tiền : ${tongTien}</h3>
</div>
<div class="col-5 offset-2"
     style="margin-left: 1000px ; width: 450px ; background-color: beige ; position: absolute">
    <table>
        <tbody>
        <c:forEach items="${listHDCT}" var="hd" varStatus="i">
            <tr>
                <td>${hd.idChiTietAo.idAo.ten}</td>
                <td>${hd.gia}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form method="post" action="/thanh-toan">
        <div>
            Hóa đơn :
            <select name="id" id="myCheck" onchange="getMaHoaDon()">
                <c:forEach items="${hoaDon}" var="hd">
                    <option value="${hd.id}" data-ten="${hd.ma}">${hd.ma}</option>
                </c:forEach>
            </select>
            <c:forEach items="${hoaDon}" var="hd">
                Mã : <input value="${hd.ma}" name="ma">
            </c:forEach>
            <br>
            Khách hàng :
            <select name="idKhachHang" id="myShows" onchange="getKhachHang()">
                <option></option>
                <c:forEach items="${listKhachHang}" var="kh">
                    <option value="${kh.id}" data-ten="${kh.hoVaTen}">${kh.ma}</option>
                </c:forEach>
            </select>
            <label id="hienTenKhachHang">Khách lẻ</label>
            <br>
            Nhân viên :<select name="idNhanVien" id="myShow" onchange="getNhanVien()">
            <c:forEach items="${listNhanVien}" var="nv">
                <option value="${nv.id}" data-ten="${nv.hoVaTen}">${nv.hoVaTen}</option>
            </c:forEach>
        </select>
        </div>
        <br>
        <button class="btn btn-danger" onclick="return thongBao()">Thanh Toán</button>
    </form>
    <br>
</div>
<script>
    function getKhachHang() {
        var myShows = document.getElementById("myShows");
        var index = myShows.selectedIndex;
        var option = myShows.options[index];
        document.getElementById("hienTenKhachHang").innerHTML = option.dataset.ten;
    }

    function getNhanVien() {
        var myShow = document.getElementById("myShow");
        var index = myShow.selectedIndex;
        var option = myShow.options[index];
        document.getElementById("hienTenNhanVien").innerHTML = option.dataset.ten;
    }

    function getMaHoaDon() {
        var myCheck = document.getElementById("myCheck");
        var index = myCheck.selectedIndex;
        var option = myCheck.options[index];
        document.getElementById("tenMaHoaDon").innerHTML = option.dataset.ten;
    }

    function thongBao() {
        return alert("Thanh toán thành công !");
    }
</script>
</body>
</html>