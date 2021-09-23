 <%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
 <%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">

  <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="member/member.js"></script>
</head>


<body>
     
     
     
 
    <h1>Login</h1>
    <form method="post" action="login">
        <fieldset>
        <legend></legend>
          <label>User ID</label>
          <input name="email_id" type="text" value="${email_id}"><br> 
          <label>Password</label> 
          <input name="pwd" type="password"><br> 
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="submit" value="로그인" class="submit">
            <input type="button" value="회원가입" class="cancel"
                 onclick="location='join'">
            <input type="button" value="아이디 비밀번호 찾기" class="submit"
                 onclick="find_id_form()">     
        </div>
    </form>  
 
  </body>

