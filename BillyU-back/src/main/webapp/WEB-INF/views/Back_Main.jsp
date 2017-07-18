<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>백오피스</title>
<style>
#userlist{
	width:45%;
	height:250px;
	border:1px solid red;
	background color:cyan;
}
#userlist a{
	text-decoration:none;
	color:blue;
}
#productlist{
	width:45%;
	height:250px;
	border:1px solid red;
	background color:cyan;
}
</style>
</head>
<body>
<center>
  <div id="userlist">
	<center>
		<h1><a href="Back_Main">사용자관리</a></h1>
		<a href="InsertUserForm">유저등록</a><p>
		<a href="SelectUserForm">유저목록</a><p>
		<a href="DeleteUserForm">유저삭제</a><p>
		<a href="UpdateUserForm">유저수정</a><p>
	</center>
  </div>

  <div id="productlist">
		<center>
		<h1>상품관리</h1>
		</center>
  </div>
</center>
</body>
</html>