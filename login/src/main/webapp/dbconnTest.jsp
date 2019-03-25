<%@ page import="jdbc.connection.ConnectionProvider" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-25
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>연결 테스트</title>
</head>
<body>
<%
    try (Connection conn = ConnectionProvider.getConnection()) {
        out.println("커넥션 연결 성공함");
    } catch (SQLException ex) {
        out.println("커넥션 연결 실패함 : " + ex.getMessage());
        application.log("커넥션 연결 실패", ex);
    }
%>
</body>
</html>
