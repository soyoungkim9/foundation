<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-19
  Time: 오후 5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
    response.addCookie(Cookies.createCookie("name","김소영"));
    response.addCookie(
      Cookies.createCookie("id", "madvirus", "/cookie", -1));
%>
<html>
<head>
    <title>Cookies 사용 예</title>
</head>
<body>
Cookies를 사용하여 쿠키 생성
</body>
</html>
