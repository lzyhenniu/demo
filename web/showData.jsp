<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/28
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = "zhou";
    char sex = '1';
    HashMap<String, Object> data = new HashMap<String, Object>();
    data.put("province", "广东省");
    data.put("city", "广州市");
    data.put("dinst", "从化区");
%>
<html>
<head>
    <title>数据的封装与显示</title>
    <style>
        span {
            color: red;
            font-size: 30px;
        }
    </style>
</head>
<body>
<h4>页面产生数据，用JSP脚本进行显示</h4>
姓名：<%=name%><br>
出版社：<%=data.get("province")%><%=data.get("city")%><%=data.get("dinst")%><br>
性别：<%
    if (sex == '1') {
%>      男
<%
} else {
%>      女
<%
    }
%><br>

<hr>
<h4>servlet中产生数据，用request对象进行封装和传递(<span>一次性</span>)，EL显示数据</h4>
ISBN：${book.ISBN}<br>
出版社：${book.press}<br>
快递地址：${book.addr.province}${book.addr.city}${book.addr.dinst}<br>

<hr>
<h4>servlet中产生数据，用session对象进行封装和传递(<span>跨页面</span>)，EL显示数据</h4>
ISBN：${book.ISBN}<br>
出版社：${book.press}<br>
快递地址：${book1.addr.province}${book1.addr.city}${book1.addr.dinst}<br>


<hr>
<h4>servlet中产生数据，用session对象进行封装和传递(<span>跨页面</span>)，JSTL显示数据</h4>
ISBN：<c:out value="${book.ISBN}" default="no data"/><br>
出版社：<c:out value="${book.press}" default="no data"/><br>
快递地址：<c:out value="${book1.addr.province}${book1.addr.city}${book1.addr.dinst}" default="no data"/><br>

<hr>
<h4>servlet中产生数据，用session对象进行封装和传递(<span>跨页面</span>)，JSTL批量显示数据</h4>
<c:forEach items="${orderItems}" var="oderItem"> &nbsp;&nbsp;
    <c:out value="${orderItem.id}"/> &nbsp;&nbsp;
    <c:out value="${orderItem.num}"/> &nbsp;&nbsp;
    <c:out value="${orderItem.product.imgUrl}"/> &nbsp;&nbsp;
    <c:out value="${orderItem.product.id}"/> &nbsp;&nbsp;
    <c:out value="${orderItem.product.name}"/> &nbsp;&nbsp;
    <c:out value="${orderItem.product.desc}"/> &nbsp;&nbsp;
</c:forEach>
</body>
</html>
