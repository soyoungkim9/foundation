<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-19
  Time: 오전 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="util.Cookies" %>
<%
    Cookie cookie = new Cookie("name", URLEncoder.encode("김소영", "utf-8"));
    response.addCookie(cookie);
%>
<head>
    <title>쿠키생성</title>
</head>
<body>
    <%= cookie.getName() %> 쿠키의 값 = "<%= cookie.getValue()%>"

</body>
</html>
