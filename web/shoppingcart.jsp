<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/9
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/static/js/jquery-1.10.2.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/static/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <jsp:include page="common/header.jsp"/>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="row clearfix">
                    <c:forEach items="${products}" var="p">
                        <div class="col-md-3 column text-center" style="margin-bottom: 20px">
                            <img style="width: 200px ;height: 200px" alt="200x200" src="static/images/${p.value.imgUrl}"
                                 class="img-rounded"/>
                            <blockquote>
                                <p>
                                        ${p.value.name}

                                </p>
                                <span>price>${p.value.price}</span>元
                                <small>库存量：${p.value.num}</small>
                            </blockquote>
                            <button type="button" class="btn btn-default btn-danger" value="${p.value.id}">加入购物车
                            </button>
                        </div>
                    </c:forEach>

                </div>
            </div>

            <jsp:include page="common/footer.jsp"/>
        </div>
    </div>
</div>
</body>
</html>

<script>

    $(function () {
        $("button").each(function () {
            $(this).click(function () {
                var id = $(this).val();

                $.ajax({
                    type: "post",
                    url: "/addCart",
                    data: {
                        "id": id
                    },
                    dataType: "json",
                    contentType: "application/json;charset=utf-8",
                    success: function () {

                    },
                    error: function () {

                    }

                });
            });
        });
    });


</script>