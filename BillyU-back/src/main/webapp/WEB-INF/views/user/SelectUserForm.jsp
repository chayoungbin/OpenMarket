<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="java.util.*" %>
<%@ page import="user.userDTO" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    사용자목록  
</h1>
<p> This is my Database </p>
  <!--
	<p> ${list.usernumber}</p>
	<p> ${list.nickname}</p>
  -->
<c:forEach var="item" items="${list}">
    이름 : ${item.nickname}
    나이 : ${item.usernumber}
</c:forEach>

</body>
</html>
