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

 ${nick} <p>
 ${usernum}
<a href="Back_Main">홈으로</a>
</body>
</html>
