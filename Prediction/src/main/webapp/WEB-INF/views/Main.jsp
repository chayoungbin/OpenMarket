<%@page import="java.util.ArrayList"%>
<%@page import="play.playDTO"%>
<%@page import="game_result.game_resultDTO"%>
<jsp:useBean id="play" class="play.playDAO" />
<jsp:useBean id="game" class="game_result.game_resultDAO" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프론트오피스</title>
<style>
#main_img{
	background-color:green;
}
#main_img img{
	width:1000px;
	height:600px;
}
</style>
</head>
<body>
<jsp:include page="Navbar.jsp" />
<center>
<h1>메인페이지 입니다</h1><p>
<hr />
<div id="main_img">
<img src="resources/image/main.PNG" alt="메인사진" />
</div>
</center>
<hr />
<center>
<div>
@CopyRight
</div>
<br />
</center>
</body>
</html>