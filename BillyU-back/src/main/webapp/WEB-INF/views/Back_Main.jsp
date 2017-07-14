<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
		<h1>사용자관리</h1>
		<table>
		 <tr>
		  <td>UserNumber</td>
		  <td>Nickname</td>
		  <td>삭제</td>
		  <td>수정</td>
		 </tr>
		</table>
		<a href="user/InsertUserForm">유저등록</a><p>
		<a href="user/SelectUserForm">유저목록</a><p>
		<a href="user/DeleteUserForm">유저삭제</a><p>
		<a href="user/UpdateUserForm">유저수정</a><p>
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