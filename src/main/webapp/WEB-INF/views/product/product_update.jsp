<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  

<head>
</head>
<html>
<body>
<article>
<h1>상품수정</h1>  

<form name="frm" id="update_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="pd_id" value="${productVO.pd_id}">
<input type="hidden" name="emailID" id="emailID" value="${sessionScope.loginUser.email_id}">
<input type="hidden" name="phNm" id="phNm" value="${sessionScope.loginUser.ph_nm}">
<table id="update">
<tr>
  <th>상품명</th>
  <td width="343" colspan="5">
  	<input type="text" name="product_name" id="product_name" size="47" maxlength="100" value="${productVO.product_name}">
  </td>
<tr>  
  <th>카테고리</th>
  <td width="343" colspan="5">
		<input type="radio" name="category" value="3"/>가전
       <input type="radio" name="category" value="2"/>식품
       <input type="radio" name="category" value="1"/>기타
  </td> 
</tr>
<tr>  
  <th>가격</th>
  <td width="343" colspan="5">
  	<input type="text" name="price" id="price" size="47" maxlength="100" value="${productVO.price}">
  </td>
</tr>
<tr>
  <th>판매상태</th>
  <td width="343" colspan="5">
  		<input type="radio" name="state" value="sale"/>판매중
       <input type="radio" name="state" value="stop"/>판매중지
       <input type="radio" name="state" value="done"/>판매종료
  </td>
</tr>
<tr>
  <th>중고여부</th>
  <td width="343" colspan="5">
  		<input type="radio" name="useyn" value="n"/>새상품
       <input type="radio" name="useyn" value="y"/>중고상품
  </td>
</tr>
<tr>
  <th>설명</th>
  <td colspan="5">
  	<textarea name="content" id="content" rows="8" cols="70" >${productVO.content}</textarea>
  </td>
</tr>
<tr>
	<th>상품이미지</th>
    <td width="343" colspan="5">
    	<img src="images/product/${productVO.image1}" width="200pt">
    	<input type="file" name="productImage" id="productImage">
    </td>
</tr>   

</table>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" onClick="go_mod_save('${productVO.pd_id}')">
<input class="btn" type="button" value="취소" onClick="go_back()">

</form> 
</article>
</body>
</html>
