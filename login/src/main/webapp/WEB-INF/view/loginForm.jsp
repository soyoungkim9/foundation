<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-27
  Time: 오후 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="login.do" method="post">
    <p>
        아이디:<br/><input type="text" name="id" value="${param.id}">
        <c:if test="${errors.id}">ID를 입력하세요</c:if>
    </p>
    <p>
        암호:<br/><input type="password" name="password" value="${param.password}">
        <c:if test="${errors.password}">암호를 입력하세요</c:if>
    </p>
    <c:if test="${errors.idOrPwNotMatch}">아이디 혹은 암호가 일치하지 않습니다.<br/></c:if>
    <input type="submit" value="로그인">
</form>
</body>
</html>
