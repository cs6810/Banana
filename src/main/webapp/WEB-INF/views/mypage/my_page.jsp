<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ include file="../header.jsp" %> 
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<style> 
 #profile_img{
   width:300px;	
   height:300px;
	  		}
	  		
 .is-left{
	float: left;
		}	
  .is-right{
  	float: right;
  		} 		
</style>
</head>
<html>
<body>
<form name="mypage" id="mypage" method="post">

	<div class="header" style="height: 20%;">
	<div class = "is-left">
		<label>TESTSETSETSETSET</label>
	</div>

	
	</div>	
	<span>
	  <img src="images/${getMember.profile_img}"  alt="프로필사진" name="profile" id="profile_img"> 
	</span>
	
<br><br><br>

<div id="my_page">
      <input class="btn" type="button" name="sell_list" value="판매내역" onClick="location.href='sale_list_form'">
      <input class="btn" type="button" name="buy_list" value="구매내역" onClick="location.href='buy_list_form'">
      <input class="btn" type="button" name="favorite" value="관심상품" onClick="">
      <input class="btn" type="button" name="profile_edit" value="프로필 수정" onClick="location.href='profile_update_form'">
	
</div>
</form> 
</body>
</html>
    
