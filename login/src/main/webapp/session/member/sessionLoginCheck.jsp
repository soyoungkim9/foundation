<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-22
  Time: 오후 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String memberId = (String)session.getAttribute("MEMBERID");
    boolean login = memberId == null ? false : true;
%>
<html>
<head>
    <title>로그인여부 검사</title>
</head>
<body>

<%
    if(login) {
%>
아이디 "<%= memberId %>"로 로그인 한 상태
<%
    } else {
%>
로그인하지 않은 상태
<%
    }
%>
</body>
</html>
