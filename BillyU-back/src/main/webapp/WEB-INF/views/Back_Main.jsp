<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����ǽ�</title>
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
		<h1>����ڰ���</h1>
		<table>
		 <tr>
		  <td>UserNumber</td>
		  <td>Nickname</td>
		  <td>����</td>
		  <td>����</td>
		 </tr>
		</table>
		<a href="user/InsertUserForm">�������</a><p>
		<a href="user/SelectUserForm">�������</a><p>
		<a href="user/DeleteUserForm">��������</a><p>
		<a href="user/UpdateUserForm">��������</a><p>
	</center>
  </div>
  <div id="productlist">
		<center>
		<h1>��ǰ����</h1>
		</center>
  </div>
</center>
</body>
</html>