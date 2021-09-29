<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
 <head>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %> 



<style>
  .card{
    margin-top: 20px;
    margin-left: 10%;
    display: inline-block;
  }
  .button{
  	float:bottom;
  }
  
  #img1{
  	width:200px;
  	height:200px;
  	margin:10%;
  }
  
  .is-left{
  	float: left;
  }
  .is-right{
  	float: right;
  }
</style>
</head>

<body>
	<div>
		<input id="inputval"></input>
		<button type="button" class="btn btn-success" id="search">검색</button>
	</div>

  <div class="clear"></div>   

<form name="product_main_form" id="product_main_form" method="post">
	<div>
		<c:forEach items="${saleList}" var="productVO">
		 <div class="card" style="width: 18rem;">
		  <img id="img1" src="images/product/${productVO.image1}" class="card-img-top" alt="물건사진">
		  <div class="card-body">
		    <h5 class="card-title">${productVO.product_name}</h5>
		    <h5 class="card-price">${productVO.price}원</h5>
		    <p class="card-text">${productVO.content}</p>
		    <input type="button" class="btn btn-primary" onclick="go_detail('${productVO.pd_id}')" value="제품 상세보기">
		  </div>
		</div>
		</c:forEach>
 	</div>
 	<!-- <div id= "button" style="display:none">
 		<input type="button" value="상품추가" class="submit"   onclick="insert_pd">
 	</div> -->
 </form>
 </body>
 
 <footer class="py-4 bg-dark flex-shrink-0">
    <div class="container text-center">
      <a href="https://bootstrapious.com/snippets" class="text-muted">Bootstrap snippet by Bootstrapious</a>
    </div>
 </footer>
 
 