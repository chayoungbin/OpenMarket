<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="jang" class="jang.jangDAO" />
<%
String productnumber  = request.getParameter("productnumber");
jang.delete_jang(productnumber);
response.sendRedirect("CartLeftbarJang");
%>
</body>
</html>