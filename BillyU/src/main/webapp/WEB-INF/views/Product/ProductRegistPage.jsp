<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$(".K_trade").hide();

		$(".input").click(function() {
			$(".product").toggle();
			$(".K_trade").toggle(500);
			$(this).html($(this).html() == '다음' ? '이전' : '다음');
		});

		//대여 버튼 누르면 tratype의 value값이 rent로
		$('.re').click(function() {
			$('.tratype').val("대여");
		});
		//판매 버튼 누르면 tratype의 value값이 sale로 ,,
		$('.sa').click(function() {
			$('.tratype').val("판매");
		});
	});
</script>
<style type="text/css">
/*nav바와 상품등록 간격 줄이기*/
#page-content-wrapper{
		padding-top: 20px !important;
	}
	#require{
	color:red;
	}

</style>
</head>
<body>
<% if(session.getAttribute("id") == null){
	response.sendRedirect("UserLoginForm");
} %>
	<jsp:include page="../Navigation/NavigationBar.jsp"></jsp:include>
	<br />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="K_productRegist">
					<center><h1>상품 정보 입력</h1></center><hr /><br />
					<p><span id="require">*</span> 는 반드시 작성해 주세요.</p><br />
					<form action="regist.do" method="post">
						<div class="product">
							<div class="form-group">
								<label for="title"><span id="require">*</span> 제목 : </label> <input type="text"
									class="form-control" id="title" name="title"
									placeholder="50글자 이내로 작성해주세요!">
							</div><br />
							<div class="form-group">
								<label for="category"><span id="require">*</span> 대분류:</label> <select class="form-control"
									id="category">
									 <%-- <jsp:useBean id="sel"
										class="com.openmarket.Capstone_productDAO"></jsp:useBean>  --%>
										 <jsp:useBean id="select"
										class="regist.registDAO"></jsp:useBean> 
										<option>대분류를 선택해 주세요</option>
									<%
										ArrayList<String> al = select.selectCategory();
										for (int i = 0; i < al.size(); i++) {
									%>
									
									<option><%=al.get(i)%></option>
									<%
										}
									%>
								</select>
								<br />
								<label for="category"><span id="require">*</span> 소분류:</label>
								 <select class="form-control" id="category2" name="category">
									<option value="">대분류를 선택해주세요</option>
								</select>
								<script>
								$('#category').change(function(){
									$.ajax({
										type : "POST",
										url : "./ProductSmallAccoddingtoBig",
										data : {cate : $('#category').val()},
										success : WhenSuccess,
										error : WhenError
									});
								});
								function WhenSuccess(resdata){
									$('#category2').html(resdata);
								}

								function WhenError(){
									alert('error');
								}
								
								</script>
							</div><br />
							<div class="form-group container" >
								<label for="productstate"><span id="require">*</span> 상품상태 :</label> <label
									class="radio-inline"> <input type="radio"
									name="productstate" value="s급">S급
								</label> <label class="radio-inline"> <input type="radio"
									name="productstate" value="a급">A급
								</label> <label class="radio-inline"> <input type="radio"
									name="productstate" value="b급" checked >B급
								</label>
								<a href="#" data-toggle="tooltip" data-placement="right" 
							title="S급 :!!!! A급 :@@@@ B급 : ####">상품상태기준</a>
							</div><hr /><br />
							<div class="form-group">
								<label for="kakaotalkid">카카오톡ID : </label> <input type="text"
									class="form-control" id="kakaotalkid" name="kakaotalkid"
									placeholder="카카오톡ID를 입력해 주세요!">
							</div>
							<div class="container">
							<a href="#" data-toggle="tooltip" data-placement="right" 
							title="어딜 이러쿵 저러쿵 들어가서 슝슝">
							카카오톡 아이디 확인방법</a>
							</div>
							<br />
							<div class="form-group">
								<label for="phone">연락처 : </label> <input type="text"
									class="form-control" id="phone" name="phone"
									placeholder="전화번호를 '-' 없이 입력해주세요">
							</div><br />
							<div class="form-group">
								<!--  이건 text가 아니라 다른 형식으로받는건 어떨까? -->
								<label for="productinformation">특이사항</label>
								<textarea class="form-control" rows="5" id="productinformation"
									placeholder="100자 이내로 작성해 주세요" name="productinformation"></textarea>
							</div><hr />

						</div>
						<!-- 여기부턴 대여 정보 입력 -->
						<div class="K_trade">
								<div class="form-group">
									<input class="tratype" type="hidden" name="tratype" value="대여" />
								</div>
								<div id="rent" class="re tab-pane fade in active">
									<div class="form-group">
										<label for="rentprice"><span id="require">*</span> 대여금액 : </label> <input type="text"
											class="form-control" id="rentprice" name="rentprice"
											placeholder="1일 기준입니다">
									</div><br />
									<div class="form-group">
										<label for="rentdeposite"><span id="require">*</span> 보증금 :</label> <input type="text"
											class="form-control" id="rentdeposit" name="rentdeposite"
											placeholder="보증금은 정해진 기준이 없습니다">
									</div><br />
									<div class="form-group">
										<label for="rentmaxdate"><span id="require">*</span> 대여가능일수 :</label> <input type="text"
											class="form-control" id="rentmaxdate" name="rentmaxdate"
											placeholder="최대 대여일수 '일'은 제외하고 숫자만 입력하세요 ex)100 ">
									</div><hr /><br />
									<button type="submit" class="submit btn btn-default btn-block">다음</button>
									<br />
								</div>
						</div>
							<!-- 거래 형식을 '판매'를 선택했을 때 -->		
						
					</form>
					
				</div>
					<button type="button" class="input btn btn-primary btn-block">다음</button>
			</div>
		</div>
			<div class="col-lg-3"></div>
	</div>

	<br />
	<br />
	<br />
<script>
$(document).ready(function(){
$('[data-toggle="popover"]').popover();   
});

$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
</body>
</html>