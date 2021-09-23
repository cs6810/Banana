<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Market</title>
 
  <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="member/member.js"></script>
  <script type="text/javascript" src="member/findIdAndPassword.js"></script>
  <script type="text/javascript" src="profile/profile.js"></script>
  <script type="text/javascript" src="product/product.js"></script>
  <script type="text/javascript" src="customer_center/mail.js"></script>
 
 
   
</head>

<body>
<div id="wrap">
<!--헤더파일 들어가는 곳 시작 -->
  <header>
    <!--로고 들어가는 곳 시작--->  
    <div id="logo">
      <a href="index">
        <img src="images/logo.jpg">
      </a>  
    </div>
    <!--로고 들어가는 곳 끝-->     
    <nav id="catagory_menu">
     <ul>
       <c:choose>
       <c:when test="${empty sessionScope.loginUser}">
       <li>         
         <a href="login" style="width:110px;">로그인</a>   
	   </li>		       

       <li><a href="join">회원가입</a></li>
       </c:when>
       <c:otherwise>
       <li>
         ${sessionScope.loginUser.nk_name}(${sessionScope.loginUser.email_id})
       </li>
       <li><a href="logout">로그아웃</a></li>
       </c:otherwise>       
       </c:choose>
<!-- 
       <li>
         <a href="">채팅</a>
       </li>
 -->
       
       <li>
         <a href="profile_update_form">MY프로필</a>
       </li>
       <li>
         <a href="customer_center">고객센터</a>
       </li>
     </ul>
    </nav>

    <div class="clear"></div>
    <hr>
  </header>
  <!--헤더파일 들어가는 곳 끝 -->