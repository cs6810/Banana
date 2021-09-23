<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  

<head>
</head>
<html>
<body>
<article>
<h1>상품등록하기</h1>  

<form name="product" id="product_form" method="post"  enctype="multipart/form-data">
<table id="insertProduct">

<tr>
<input type="hidden" name="emailID" id="emailID" value="${sessionScope.loginUser.email_id}">
<input type="hidden" name="phNm" id="phNm" value="${sessionScope.loginUser.ph_nm}">
  <th>상품명</th>
  <td width="343" colspan="5">
       <input type="text" name="product_name" id="product_name" size="47" maxlength="100">
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
       <input type="text" name="price" id="price" size="47" maxlength="100">
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
      <textarea name="content" id="content" rows="8" cols="70" >상품설명을 입력 해 주세요.</textarea>
  </td>
</tr>
<tr>
	<th>상품이미지</th>
    <td width="343" colspan="5">
      이미지<input type="file" name="productImage" id="productImage"><br>
      <!-- 
      이미지 2<input multiple="multiple" type="file" name="image2" id="image2"><br>
      이미지 3<input multiple="multiple" type="file" name="image3" id="image3"><br>
      이미지 4<input multiple="multiple" type="file" name="image4" id="image4"><br>
      이미지 5<input multiple="multiple" type="file" name="image5" id="image5"><br>
      이미지 6<input multiple="multiple" type="file" name="image6" id="image6"><br>
      이미지 7<input multiple="multiple" type="file" name="image7" id="image7"><br>
      이미지 8<input multiple="multiple" type="file" name="image8" id="image8"><br>
      이미지 9<input multiple="multiple" type="file" name="image9" id="image9"><br>
      이미지 10<input multiple="multiple" type="file" name="image10" id="image10"><br>
       -->
    </td>
</tr>  
</table>
<input class="btn" type="button" value="등록하기" onClick="go_save_product()">
<input class="btn" type="button" value="취소" onClick="go_back()"> 
</form> 
</article>
</body>
</html>