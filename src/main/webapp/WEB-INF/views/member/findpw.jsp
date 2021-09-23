<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

	  <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	  <script type="text/javascript" src="member/findpw.js"></script>
<script>
	$(function(){
		$("#findBtn").click(function(){
			$.ajax({
				url : "/member/find_pw",
				type : "POST",
				data : {
					email_id : $("#email_id").val(),
					ph_nm : $("#ph_nm").val()
				},
				success : function(result) {
					alert(result);
				},
			})
		});
	})
</script>

<title>비밀번호 찾기</title>
</head>
<body>

<form id="findpw" action="findpw" method="post" name="formm">
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 456.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>비밀번호 찾기</h3>
			</div>
			<div>
				<p>
					<label>이메일</label>
					<input class="w3-input" type="text" id="email_id" name="email_id" placeholder="회원가입한 이메일를 입력하세요" required>
				</p>
				<p>
					<label>전화번호</label>
					<input class="w3-input" type="text" id="ph_nm" name="ph_nm" placeholder="회원가입한 전화번호를 입력하세요" required>
				</p>
				<p class="w3-center">
					<button type="button" id="findBtn" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">찾기</button>
					<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">로그인으로</button>
				</p>
			</div>
		</div>
	</div>
	
	</form>
</body>
</html>