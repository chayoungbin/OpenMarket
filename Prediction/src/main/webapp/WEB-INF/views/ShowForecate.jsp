<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="game_result.game_resultDTO"%>
<jsp:useBean id="game" class="game_result.game_resultDAO" />    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#td td{
	width:120px;
	height:120px;
	text-align:center;
}
#th td{
	text-align:center;
}
a{
	text-decoration:none;
}
</style>
</head>
<body>
<jsp:include page="Navbar.jsp" />
<% String mat = request.getParameter("matchday"); %>
<center>
<h1><%=mat %> 경기</h1>
<hr />
<table>
	<tr id="th">
		<td style="color:blue"> 홈팀 </td>
		<td> </td>
		<td style="color:red"> 원정팀 </td>
		<td> 스코어 </td>
		<td> 결과 </td>
		<td> 예상 </td>
	</tr>
	<%
	
	
	ArrayList<game_resultDTO> game_list = new ArrayList<game_resultDTO>();
	game_list = game.game_result_list(mat);
	for(int i=0;i<game_list.size();i++){
		game_resultDTO dto = game_list.get(i);
		String matchday = dto.getMatchday();
		String home = dto.getHome();
		String away = dto.getAway();
		int home_score = dto.getHome_score();
		int away_score = dto.getAway_score();
		String forecate = dto.getForecate();
		
		String home_img = "";
		String away_img = "";
		if(home.equals("kia")){home_img = "resources/image/Kia.PNG";}
		if(home.equals("sk")){home_img = "resources/image/SK.PNG";}
		if(home.equals("nc")){home_img = "resources/image/NC.PNG";}
		if(home.equals("lotte")){home_img = "resources/image/Lotte.PNG";}
		if(home.equals("kt")){home_img = "resources/image/KT.PNG";}
		if(home.equals("doosan")){home_img = "resources/image/Doosan.PNG";}
		if(home.equals("samsung")){home_img = "resources/image/Samsung.PNG";}
		if(home.equals("hanhwa")){home_img = "resources/image/Hanhwa.PNG";}
		if(home.equals("lg")){home_img = "resources/image/LG.PNG";}
		if(home.equals("nexen")){home_img = "resources/image/Nexen.PNG";}
		
		if(away.equals("kia")){away_img = "resources/image/Kia.PNG";}
		if(away.equals("sk")){away_img = "resources/image/SK.PNG";}
		if(away.equals("nc")){away_img = "resources/image/NC.PNG";}
		if(away.equals("lotte")){away_img = "resources/image/Lotte.PNG";}
		if(away.equals("kt")){away_img = "resources/image/KT.PNG";}
		if(away.equals("doosan")){away_img = "resources/image/Doosan.PNG";}
		if(away.equals("samsung")){away_img = "resources/image/Samsung.PNG";}
		if(away.equals("hanhwa")){away_img = "resources/image/Hanhwa.PNG";}
		if(away.equals("lg")){away_img = "resources/image/LG.PNG";}
		if(away.equals("nexen")){away_img = "resources/image/Nexen.PNG";}
		
		%>
		<tr id="td">
			<td><a href="detail_team?club_name=<%=home%>"><img src="<%=home_img %>" alt="home" /></a></td>
			<td> VS </td>
			<td><a href="detail_team?club_name=<%=away%>"><img src="<%=away_img %>" alt="away" /></a></td>
			<td>
				<%
					if(home_score>away_score){
						out.println("<span style='color:blue'>"+home_score+"</span> : "+away_score);
						out.println("<td style='color:blue'>"+"홈승"+"</td>");
					}else if(home_score<away_score){
						out.println(home_score+" : <span style='color:red'>"+away_score+"</span>");
						out.println("<td style='color:red'>"+"원정승"+"</td>");
					}else{
						out.println(home_score+" : "+away_score);
						out.println("<td>"+"무승부"+"</td>");
					}
				%>
			</td>
			<td>
			<%
				if(forecate.equals("Success")){
					out.println("<span style='color:blue'>"+forecate+"</span>");
				}else{
					out.println("<span style='color:red'>"+forecate+"</span>");
				}
			%>
			</td>
		</tr>
		<%
	}
	%>

</table>
</center>
<hr />
<a href="Main">메인화면 가기</a>
</body>
</html>