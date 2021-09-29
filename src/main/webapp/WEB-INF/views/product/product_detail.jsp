<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  

<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
</head>
<html>
<body>
<article>
<h1>상품조회</h1>  

<form name="product" id="product_detail" method="POST" >

<input type="hidden" name="nowID" id="nowID" value="${sessionScope.loginUser.email_id}">
<input type="hidden" name="emailID" id="emailID" value="${productVO.email_id}">

<table id="insertProduct">
<tr>	
  <th>상품명</th>
  <td width="343" colspan="5">${productVO.product_name}
  </td>
<tr>  
  <th>카테고리</th>
  <c:choose>
  	<c:when test="${productVO.category eq '3'}">
  		<td width="343" colspan="5">가전</td>
  	</c:when>
  	<c:when test="${productVO.category eq '2'}">
  		<td width="343" colspan="5">식품</td>
  	</c:when>
  	<c:otherwise>
  		<td width="343" colspan="5">기타</td>
  	</c:otherwise>
  </c:choose>
</tr>
<tr>  
  <th>가격</th>
  <td width="343" colspan="5">${productVO.price}
  </td>
</tr>
<tr>
  <th>판매상태</th>
  <c:choose>
  	<c:when test="${productVO.state eq 'sale'}">
  		<td width="343" colspan="5">판매중</td>
  	</c:when>
  	<c:when test="${productVO.state eq 'stop'}">
  		<td width="343" colspan="5">판매중지</td>
  	</c:when>
  	<c:otherwise>
  		<td width="343" colspan="5">판매종료</td>
  	</c:otherwise>
  </c:choose>
</tr>
<tr>
  <th>중고여부</th>
  	<c:choose>
  		<c:when test="${productVO.useyn eq 'n'}">
			<td width="343" colspan="5">새상품</td>  			
  		</c:when>
  		<c:otherwise>
  			<td width="343" colspan="5">중고상품</td>
  		</c:otherwise>
  	</c:choose>
  
  
</tr>
<tr>
  <th>설명</th>
  <td colspan="5">${productVO.content}
  </td>
</tr>
<tr>
	<th>상품이미지</th>
    <td width="343" colspan="5">
    <img src="images/product/${productVO.image1}" width="200pt">
    </td>
</tr>
<tr> 
	<th>판매자 ID </th>
	<td width="343" colspan="5">${productVO.email_id}</td>
</tr>
<tr> 
	<th>판매자 연락처 </th>
	<td width="343" colspan="5">${productVO.ph_nm}</td>
</tr>

</table>
	<input type="button" class="btn btn-primary" onclick="go_mod('${productVO.pd_id}')" value="수정">
	<input type="button" class="btn btn-primary" onclick="go_mod('${productVO.pd_id}')" value="관심상품등록">
	<input class="btn"  type="hidden" value="채팅으로 거래하기" onClick="go_deal()">
</form> 
</article>
</body>
</html>
