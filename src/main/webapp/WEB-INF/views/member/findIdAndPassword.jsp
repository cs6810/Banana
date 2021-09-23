<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	
	  <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	  <script type="text/javascript" src="member/findIdAndPassword.js"></script>
	 <script>
	$(function(){
		$("#findBtn").click(function(){
			$.ajax({
				url : "/member/findIdAndPassword",
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
  </head>
  <body>
  <div id="wrap">
  	<h1>이메일, 비밀번호 찾기</h1>
  	<br>
	<form name="findId" id="findId" action="find_id" method="get">
	<table>
	<tr>
		<td align="right"><label> 이름</label></td>
		<td><input type="text" name="name" id="name" value=""></td>
	</tr>	

		
	<tr>
		<td align="right"><label> 전화번호</label></td>
		<td><input type="text" name="ph_nm" id="ph_nm" value=""></td>
	</tr>	
	
	
	
	<tr>
		<td align="center" colspan="2"><input type="button" value="이메일(ID) 찾기" onclick="findMemberId()"></td>
	</tr>
	</table>
	</form>
	<p><p><p><p><p><p><p><p><p><p><p><p>
	
	
	<form name="findPW" id="findPW">
	<table>
	<tr>
		<td align="right"><label> 이메일</label></td>
		<td><input type="text" name="email_id" id="email_id2" value=""></td>
	</tr>	
	<tr>
		<tr>
		<td align="right"><label> 전화번호</label></td>
		<td><input type="text" name="ph_nm" id="ph_nm2" value=""></td><br>
	</tr>	
	 <td align="center" colspan="2"><input type="button" value="비밀번호 찾기" onclick="findPassword()"></td> 	 
	<!--NEW	<button type="button" id="findBtn" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">비밀번호 찾기</button> -->
	</tr>
	</table>
	</form>
	</div>
</body>
</html>