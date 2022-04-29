<%--
  Created by IntelliJ IDEA.
  User: khkh0
  Date: 2022-04-30
  Time: 오후 3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>join</title>
</head>
<body>
<a href="index.jsp">메인으로 돌아가기</a><br>
<form method="post" action="/join">
    <p>
        아이디:<br/><input type="text" name="id" value="${param.id}">
    </p>
    <p>
        이름:<br/><input type="text" name="name" value="${param.name}">
    </p>
    <p>
        암호:<br/><input type="password" name="password">
    </p>
    <p>
        사진:<br/><input type="file" name="profile">

    </p>
    <input type="submit" value="가입">
</form>
</body>
</html>
