<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-22
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인폼</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/session/member/sessionLogin.jsp" method="post">
    아이디 <input type="text" name="id" size="10">
    암호 <input type="password" name="password" size="10">
<input type="submit" value="로그인">
</form>
</body>
</html>
