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
<div class="col-8 offset-2">
    <c:if test="${message != null}">
        <script>
            alert("${message}");
        </script>
    </c:if>

    <a href="/hoa-don">
        <svg style="margin-top: 10px" xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
             class="bi bi-file-text-fill" viewBox="0 0 16 16">
            <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM5 4h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1 0-1zm-.5 2.5A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5zM5 8h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1 0-1zm0 2h3a.5.5 0 0 1 0 1H5a.5.5 0 0 1 0-1z"/>
        </svg>
    </a>
    <br>
    <div>
        <div style=" position: absolute">
            <img src="${ct.anh}" height="350px" width="300px">
        </div>
        <div style="margin-left: 350px">
            <h2>${ct.idAo.ten}</h2>
            <h2 style="color: red">${ct.gia} VND</h2>
            <h2> Size : ${ct.idSize.sizes}</h2>
            Màu quần áo mà tôi lựa chọn đó là màu trắng và đen. Đây là tông màu cổ điển và rất dễ phối hợp.
            Với bộ quần áo đó, tôi có thể kết hợp với một đôi giày thể thao. Trông tôi rất nâng động trong bộ đồ đó.
            Vào mùa đông tôi thích mặc áo hoodie và một chiếc chân váy dài.
            những ngày nhiệt độ quá thấp tôi sẽ khoác trên mình chiếc áo khoác màu trắng. Nhìn tổng thể rất đẹp.

        </div>
        <div style="margin-left: 350px ; margin-top: 30px">
            <a href="/trang-chu">
                <button class="btn btn-warning">Quay lại</button>
            </a>
            <div class="container">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    Thêm vào giỏ hàng
                </button>
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">

                            <div class="modal-header">
                                <h4 class="modal-title">Thêm sản phẩm vào giỏ hàng</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <div class="modal-body">
                                <form method="post" action="/add-san-pham">
                                    Áo :<input name="idChiTietAo" value="${ct.id}" readonly>
                                    <br>
                                    Hóa đơn : <select name="idHoaDon">
                                    <c:forEach items="${hoaDon}" var="hd">
                                        <option value="${hd.id}">${hd.ma}</option>
                                    </c:forEach>
                                </select>
                                    <br>
                                    Số lượng : <input type="number" name="soLuong">
                                    <br>
                                    Gía : <input name="gia" value="${ct.gia}" readonly>
                                    <br>
                                    <a>
                                        <button class="btn btn-danger" onclick="return hienThi()">Thêm</button>
                                    </a>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        function hienThi() {
            return confirm("Bạn có muốn thêm ${ct.idAo.ten} vào giỏ hàng không ?")
        }

        function thongBao() {
            return alert("Sản phẩm đã tồn tại trong giỏ hàng !");
        }
    </script>
</div>
</body>
</html>