<%--
  Created by IntelliJ IDEA.
  User: khkh0
  Date: 2022-04-30
  Time: 오후 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="/login">
    아이디: <input type="text" name="id" /><br />
    비밀번호: <input type="password" name="pwd" /><br />
    <input type="submit" value="로그인" />
</form>
</body>
</html>
