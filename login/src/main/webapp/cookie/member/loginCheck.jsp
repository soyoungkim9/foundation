<%--
  Created by IntelliJ IDEA.
  User: CI
  Date: 2019-03-22
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
    Cookies cookies = new Cookies(request);
%>
<html>
<head>
    <title>로그인여부 검사</title>
</head>
<body>
<%
    if(cookies.exists("AUTH")) {
%>
아이디 "<%= cookies.getValue("AUTH") %>로 로그인 한 상태
<%
    } else {
%>
로그인하지 않은 상태
<%
    }
%>
</body>
</html>
