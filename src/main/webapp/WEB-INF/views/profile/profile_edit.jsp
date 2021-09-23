<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="../header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profile_edit</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>



</head>
<body>

 


<form name="frm" id="update_form" method="post" enctype="multipart/form-data">
	  
	  <span>
	  <img src="images/${myprofile.profile_img}"  alt="프로필사진" name="profile" id="profile_img"> 
	  <input type="hidden" name="no_update_img" value="${myprofile.profile_img}"/>
	  <br><input type="file" name="profile_upload">
	  </span>
	  <br><br><br>
	  
	  <div class="mb-3">
	    <label for="exampleFormControlInput1" class="form-label">E-Mail(ID)</label>
	  	<input type="email" class="form-control" name="email_id" id="email_id" size="20" value="${myprofile.email_id}" readonly>
	  </div>
	
	  <div class="mb-3">
	    <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
	    <input type="text" class="form-control" name="pwd" id="pwd" size="20" value="${myprofile.pwd}">
	  </div>
	
	  <div class="mb-3">
	    <label for="exampleFormControlInput1" class="form-label">성명</label>
	    <input type="text" class="form-control" name="name" id="name" size="20" value="${myprofile.name}">
	  </div>
	
	  <div class="mb-3">
	    <label for="exampleFormControlInput1" class="form-label">닉네임</label>
	    <input type="text" class="form-control" name="nk_name" id="nk_name" size="20" value="${myprofile.nk_name}">
	  </div>
	
	  <div class="mb-3">
	    <label for="exampleFormControlInput1" class="form-label">전화번호</label>
	    <input type="text" class="form-control" name="ph_nm" id="ph_nm"  size="20" value="${myprofile.ph_nm}">
	  </div>
	
	  <div class="mb-3">
	    <label for="exampleFormControlInput1" class="form-label">주소</label>
	    <input type="text" class="form-control" name="address" id="address" size="20" value="${myprofile.address}">
	  	
	  <input type="button"    value="주소수정"  onclick="address_edit()">
	  </div>
	
	<br>
	<input type="button" value="수정완료" onClick="go_profile_save('${myprofile.email_id}')"> 
</form>
</body>
</html>