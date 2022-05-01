<%--
  Created by IntelliJ IDEA.
  User: khkh0
  Date: 2022-04-30
  Time: 오후 10:31
  To change this template use File | Settings | File Templates.
--%>
<%--<%@page import="com.nhnacademy.common.servlet.BoardListServlet" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>No</th>
    <th>Title</th>
    <th>Writer</th>
    <th>Time</th>
    <th>Count</th>
    </thead>
    <tbody>
    <c:forEach var="item" items = "${boardList.getPosts()}">
        <td>${item.id()}</td>
        <td>${item.Title()}</td>
        <td>${item.WriterUserId()}</td>
        <td>${item.WriterTime()}</td>
        <td>${item.ViewCount()}</td>

    </c:forEach>
    </tbody>
</table>
<form method="post" action="/list/edit">
    <input type="submit" value="글쓰기"/>
</form>
</body>
</html>
