<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-22
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("MEMBERID", "madvirus");
    session.setAttribute("NAME", "김소영");
%>
<html>
<head>
    <title>세션에 정보 저장 후 출력</title>
</head>
<body>
<%
    String memberid = (String)session.getAttribute("MEMBERID");
    String name = (String)session.getAttribute("NAME");
%>
회원아이디: <%= memberid %> <br>
회원명: <%= name %>
</body>
</html>
