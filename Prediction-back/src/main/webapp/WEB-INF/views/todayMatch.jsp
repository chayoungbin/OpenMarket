<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>오늘 경기 입력</h1><p>
<form action="today" method="post">
날짜 : <input type="text" name="matchday"/><p>
홈팀 : 
<select name="home">
		<option value="kia">기아</option>
		<option value="nc">NC</option>
		<option value="sk">SK</option>
		<option value="nexen">넥센</option>
		<option value="lg">LG</option>
		<option value="doosan">두산</option>
		<option value="lotte">롯데</option>
		<option value="hanhwa">한화</option>
		<option value="samsung">삼성</option>
		<option value="kt">KT</option>
</select><p>
원정팀 : 
<select name="away">
		<option value="kia">기아</option>
		<option value="nc">NC</option>
		<option value="sk">SK</option>
		<option value="nexen">넥센</option>
		<option value="lg">LG</option>
		<option value="doosan">두산</option>
		<option value="lotte">롯데</option>
		<option value="hanhwa">한화</option>
		<option value="samsung">삼성</option>
		<option value="kt">KT</option>
</select><p>
예측 : 
<input type="radio" name="prediction" value="home">승
<input type="radio" name="prediction" value="draw">무
<input type="radio" name="prediction" value="away">패
<p>
<input type="submit" value="제출" /><p>
</form>
<hr />
<a href="Main">홈으로 돌아가기</a>
</body>
</html>