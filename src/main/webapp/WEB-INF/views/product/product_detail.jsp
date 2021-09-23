<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  

<head>
</head>
<html>
<body>
<article>
<h1>상품조회</h1>  

<form name="product" id="product_detail" method="POST" >
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
	<th>판매자 연락처 </th>
	<td width="343" colspan="5">${productVO.ph_nm}</td>
</tr>

</table>
	<input class="btn"  type="button" value="수정" onClick="go_mod('${productVO.pd_id}')">
	<input class="btn"  type="hidden" value="채팅으로 거래하기" onClick="go_deal()">
</form> 
</article>
</body>
</html>