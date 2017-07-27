<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상대전적 비교</title>
<style>
	td{
		width:150px;
		height:100px;
		text-align:center;
	}
</style>
</head>
<body>
<jsp:include page="Navbar.jsp" />
<%
String home = request.getParameter("home");
String away = request.getParameter("away");

String home_img = "resources/image/"+home+".PNG";
String away_img = "resources/image/"+away+".PNG";
%>
<center>
<h1><%=home %> 대 <%=away %>상대전적</h1>
<hr />
<table border="1px solid gray">
	<tr>
		<td style="background-color:gray"> </td>
		<td><img src="<%=home_img%>" alt="" /></td>
		<td> VS </td>
		<td><img src="<%=away_img%>" alt="" /></td>
	</tr>
	<tr>
		<td>리그성적</td>
		<td>${home_rank}위(${home_win}승 ${home_draw}무 ${home_lose}패)</td>
		<td></td>
		<td>${away_rank}위(${away_win}승 ${away_draw}무 ${away_lose}패)</td>
	</tr>
	<tr>
		<td>상대전적</td>
		<td>${win}승 ${draw}무 ${lose}패</td>
		<td>${better}</td>
		<td>${lose}승 ${draw}무 ${win}패</td>
	</tr>
	<tr>
		<td>득점</td>
		<td>${home_score_success}</td>
		<td></td>
		<td>${away_score_success}</td>
	</tr>
	<tr>
		<td>실점</td>
		<td>${home_score_fail}</td>
		<td></td>
		<td>${away_score_fail}</td>
	</tr>
	<tr>
		<td>연속</td>
		<td>${home_streak}</td>
		<td></td>
		<td>${away_streak}</td>
	</tr>
	<tr>
		<td>최근경기</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
</center>
<br /><br />
<hr />
<a href="Main">홈으로가기</a>
</body>
</html>