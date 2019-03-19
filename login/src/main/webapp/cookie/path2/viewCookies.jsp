<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-18
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.net.URLDecoder" %>
<html>
  <head>
    <title>쿠키생성</title>
  </head>
  <body>
  <%
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length > 0) {
      for(int i = 0; i < cookies.length; i++) {
  %>
  <%= cookies[i].getName() %> = <%= URLDecoder.decode(cookies[i].getValue(), "utf-8") %><br>
  <%
    }
  } else {
  %>
  쿠키가 존재하지 않습니다.
  <%
    }
  %>
  </body>
</html>
