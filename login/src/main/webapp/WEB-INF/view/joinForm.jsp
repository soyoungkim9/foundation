<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-27
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form action="join.do" method="post">
    <p>
        아이디:<br/><input type="text" name="id" value="${param.id}">
        <c:if test="${errors.id}">ID를 입력하세요.</c:if>
        <c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
    </p>
    <p>
        이름:<br/><input type="text" name="name" value="${param.name}">
        <c:if test="${errors.id}">이름를 입력하세요.</c:if>
    </p>
    <p>
        암호:<br/><input type="password" name="pwd" value="${param.pwd}">
        <c:if test="${errors.id}">암호를 입력하세요.</c:if>
    </p>
    <p>
        확인:<br/><input type="password" name="confirmPwd" value="${param.confirmPwd}">
        <c:if test="${errors.confirmPwd}">확인을 입력하세요.</c:if>
        <c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
    </p>
    <input type="submit" value="가입">
</form>
</body>
</html>
