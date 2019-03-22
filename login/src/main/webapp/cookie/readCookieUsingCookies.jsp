<%--
  Created by IntelliJ IDEA.
  User: CI
  Date: 2019-03-22
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
    Cookies cookies = new Cookies(request);
%>
<html>
<head>
    <title>Cookie 사용</title>
</head>
<body>

name 쿠키 = <%= cookies.getValue("name") %> <br>
<% if (cookies.exists("id")) {%>
id 쿠키 = <%= cookies.getValue("id") %> <br>
<% } %>
</body>
</html>
