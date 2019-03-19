<%--
  Created by IntelliJ IDEA.
  User: CI
  Date: 2019-03-19
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie cookie = new Cookie("oneh", "Item");
    cookie.setMaxAge(60 * 60); //60초 * 60 = 1시간
    response.addCookie(cookie);
%>
<html>
<head>
    <title>쿠키유효시간설정</title>
</head>
<body>

유효시간이 1시간인 oneh 쿠키 생성.


</body>
</html>
