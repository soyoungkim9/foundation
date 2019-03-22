<%--
  Created by IntelliJ IDEA.
  User: CI
  Date: 2019-03-22
  Time: 오전 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
    response.addCookie(
            Cookies.createCookie("AUTH", "", "/", 0)
    );
%>
<html>
<head>
    <title>로그아웃</title>
</head>
<body>

로그아웃하였습니다.

</body>
</html>
