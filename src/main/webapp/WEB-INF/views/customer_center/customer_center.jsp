<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="../header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer_center</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<style>
	
	.col{
		float:right;
    	display: inline-block;
	}
	
	.header{
		width:30%
    	height:50%
	}
	
	.ullsit{
		list-style: none;
	}
	
	.ullsit1{
		margin-left:10%;
		
	}
	
	.ullsit2{
		margin-left:30%;
		width:5%
    	height:5%
	}
	
	.is-right{
  	float: right;
  	width: 30%;
  	}
	
	
	#in_ullsit{
	margin-top:1%;
	}
	
	.container {
		clear: both;
	}
</style>
</head>

<body>
<form name="center" id="center_form" method="post">
<input type="hidden" name="nowUser" id="nowUser" value="${sessionScope.loginUser.email_id}">
	<div class="header" style="height: 20%;">
		<div class = "is-left">	
		</div>
	</div>
	
			
	<div class="container">
	
	  <div style="position: absolute; left: 100px;" >
	  
	  <h2>자주묻는질문</h2>
	  <hr width="400px">
	  <ul>
	  <li>Q.바나나마켓 운영정책</li>
	  <br>A. 바나나 마켓은 통신판매중개자이며<br>통신판매의 당사자가 아님을 공지합니다.<br><br>
	  <li>Q.판매금지 물품</li>
	  <br>A. 주류, 담배 등 19세 미만의<br>성인인증이 필요한 품목의 판매를 금지합니다.<br><br>
	  <li>Q.바나나마켓 뜻이 뭔가요?</li>
	  <br>A. 바로, 나의 물건을 나누는..!<br><br>
	  </ul>
	  </div>
	  <div style="position: relative; left: 400px;">
	  <h2>공지사항</h2>
	  <hr width="400px">
	  <ul>
	  <li>[공지]추석 연휴 택배 서비스 일정 2021/09/15</li>
	  <br>--연휴 이후 일괄 배송되며 <br>택배사의 정책에 따라 다를 수 있습니다.<br><br>
	  <li>[공지]CJ대한통운 택배사 파업관련 2021/09/10</li>
	  <br>--자세한 내용은 CJ대한통운 <br>택배사 홈페이지를 참고 해 주세요.<br><br>
	  <li>[공지]바나나 마켓 개인정보처리방침 개정 안내 2021/09/01</li>
	  <br>--개인정보처리방침 개정안은 <br>회원 e-mail에서 확인하실 수 있습니다.<br><br>
	  <li>[공지]위조상품 판매에 대한 제재 정책 강화 안내 2021/08/14</li>
	  <br>--위조상품, 불건전상품 판매에 <br>대해서는 경고 없이 삭제처리 중에 있습니다.<br><br>
	  </ul>
	  </div>
	<div style="position: relative; left: 1000px; bottom: 100px;">
	      	<input type="button" class="submit" name="mail_form" value="1:1문의 " onClick="go_mail()">	
	    </div>
    </div>
	</div>
</form>
</body>
</html>
