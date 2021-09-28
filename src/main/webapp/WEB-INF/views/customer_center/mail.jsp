<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  

<head>
</head>
<html>
<body>
<article>
<h1>1:1문의하기</h1>  

<form name="main" id="mail_form" method="post" >
  <input type="hidden" name="emailID" id="emailID" value="${sessionScope.loginUser.email_id}">
<table id="mail">
<tr>
  <th>제목</th>
  <td width="343" colspan="5">
       <input type="text" name="title" id="title" size="47" maxlength="100">
  </td>
</tr>
<tr>
  <th>내용</th>
  <td colspan="5">
      <textarea name="contents" id="contents" rows="8" cols="70" >내용을 입력 해 주세요.</textarea>
  </td>
</table>
<input class="btn" type="button" value="보내기" onClick="go_save()">           
<input type="reset" value="취소" class="cancel" onclick="location.href='customer_center'">
</form> 
</article>
</body>
</html> 
