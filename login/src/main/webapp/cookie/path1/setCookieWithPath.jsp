<%--
  Created by IntelliJ IDEA.
  User: soyoungkim
  Date: 2019-03-19
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.net.URLEncoder" %>
<%
  Cookie cookie1 = new Cookie("path1",
          URLEncoder.encode("경로:cookie/path1", "utf-8"));
  cookie1.setPath("/path1");
  response.addCookie(cookie1);

  Cookie cookie2 = new Cookie("path2",
          URLEncoder.encode("경로:", "utf-8"));
  response.addCookie(cookie2);

  Cookie cookie3 = new Cookie("path3",
          URLEncoder.encode("경로:/", "utf-8"));
  cookie3.setPath("/");
  response.addCookie(cookie3);

  Cookie cookie4 = new Cookie("path4",
          URLEncoder.encode("경로:cookie/path2", "utf-8"));
  cookie4.setPath("/path2");
  response.addCookie(cookie4);
%>

<html>
<head>
    <title>쿠키 경로 지정</title>
</head>
<body>

다음과 같이 쿠키를 생성했습니다.<br>
<%= cookie1.getName() %> = <%= cookie1.getValue()%>
[<%= cookie1.getPath() %>]
<br>
<%= cookie2.getName() %> = <%= cookie2.getValue()%>
[<%= cookie2.getPath() %>]
<br>
<%= cookie3.getName() %> = <%= cookie3.getValue()%>
[<%= cookie3.getPath() %>]
<br>
<%= cookie4.getName() %> = <%= cookie4.getValue()%>
[<%= cookie4.getPath() %>]


</body>
</html>
