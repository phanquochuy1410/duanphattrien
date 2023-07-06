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

<div style="margin-top: 20px">
    <a href="/chi-tiet-ao/hien-thi">
        <button class="btn btn-primary">Thêm sản phẩm mới</button>
    </a>
</div>
<br>
<section>
    <div class="text-center">
        <div class="row">

            <c:forEach items="${listChiTietAo}" var="ct">
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">
                        <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                             data-mdb-ripple-color="light">
                            <img src="${ct.anh}"
                                 class="w-100"/>
                            <a href="#!">
                                <div class="hover-overlay">
                                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                </div>
                            </a>
                        </div>
                        <div class="card-body">
                            <a href="/trang-chu/detail/${ct.id}" class="text-reset">
                                <h5 class="card-title mb-2">Xem sản phẩm</h5>
                            </a>
                            <h5>${ct.idAo.ten}</h5>
                            <h4 class="mb-3 price">${ct.gia}VND</h4>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<div style="text-align: center">
    <a href="/trang-chu?page=0">
        <button class="btn btn-success"> |<</button>
    </a>
    <c:if test="${soTrang > 0}">
        <a href="/trang-chu?page=${soTrang - 1}">
            <button class="btn btn-success"> <<</button>
        </a>
    </c:if>
    <c:if test="${soTrang < cuoiTrang -1}">
        <a href="/trang-chu?page=${soTrang + 1}">
            <button class="btn btn-success"> >></button>
        </a>
    </c:if>
    <a href="/trang-chu?page=${cuoiTrang - 1}">
        <button class="btn btn-success"> >|</button>
    </a>
</div>
<br>
</body>
</html>