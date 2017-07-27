<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<h1>오늘 경기 입력</h1><p>
<form action="today" method="post">
날짜 : <input type="text" name="matchday"/><p>
홈팀 : 
<select name="home" id="home">
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
<select name="away" id="away">
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
배당률 : <input type="text" id="home_bat" size=5 /> : <input type="text" id="away_bat" size=5 /><p>
<input id="ajax_button" type="button" value="예측정보 가져오기" /><span id="ajax_result">연결중...</span>
<p>
예측 : 
<input type="radio" name="prediction" value="home">홈승
<input type="radio" name="prediction" value="draw">무승부
<input type="radio" name="prediction" value="away">원정승
<p>
<input type="submit" value="제출" /><p>
</form>
<hr />
<a href="Main">홈으로 돌아가기</a>
<script type="text/javascript">
$('#ajax_button').click(function(){	
$.ajax({
	type : "POST",
	url : "./Information",
	data : {home : $('#home').val() , away : $('#away').val() , home_bat : $('#home_bat').val() , away_bat : $('#away_bat').val() },
	success : WhenSuccess,
	error : WhenError	
});
})

function WhenSuccess(resdata){
	$('#ajax_result').html(resdata);
}

function WhenError(){
	alert('error');
}
</script>
</body>
</html>