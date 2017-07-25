<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="play.playDTO"%>
<%@page import="game_result.game_resultDTO"%>
<jsp:useBean id="play" class="play.playDAO" />
<jsp:useBean id="game" class="game_result.game_resultDAO" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Main">승부예측</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Main">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">예상하기<span class="caret"></span></a>
        <ul class="dropdown-menu">
        	<%
			ArrayList<playDTO> matchlist = new ArrayList<playDTO>();
			matchlist = play.matchday_list();
			for(int i=0;i<matchlist.size();i++){
				playDTO dto = matchlist.get(i);
				String matchday = dto.getMatchday();
				%>
				<li><a href="ShowResult?matchday=<%=matchday%>"><%=matchday %></a></li>
				<%
			}
			%>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">결과보기<span class="caret"></span></a>
        <ul class="dropdown-menu">
        	<%
			ArrayList<game_resultDTO> game_matchlist = new ArrayList<game_resultDTO>();
			game_matchlist = game.game_matchday_list();
			for(int i=0;i<game_matchlist.size();i++){
				game_resultDTO dto = game_matchlist.get(i);
				String matchday = dto.getMatchday();
				%>
				<li><a href="ShowForecate?matchday=<%=matchday%>"><%=matchday %></a></li>
				<%
			}
			%>
        </ul>
      </li>
    </ul>
        <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </ul>
  </div>
</nav>
</body>
</html>