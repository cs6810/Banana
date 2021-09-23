  <%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ include file="header.jsp" %> 
  
 <head>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




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
  	width:20%;
  	height:20%;
  	margin:25px;
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

<form name="searchForm" method="get" action="search">
	<div>
		<input id="inputval" name="key"></input>
		<button type="submit" class="btn btn-success" id="search">검색</button>
	</div>
</form>
<form name="product" id="main_form" method="post">
<div class="header" style="height: 20%;">
	
	<div class = "is-right">
				<div>
			<div class="dropdown">
		  	<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
		    	카테고리
		  	</button>
			  	<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
			    <li><a class="dropdown-item" href="products_by_category?category=1">디지털기기</a></li>
			    <li><a class="dropdown-item" href="products_by_category?category=2">패션</a></li>
			    <li><a class="dropdown-item" href="products_by_category?category=3">스포츠</a></li>
				<li ><a class="dropdown-item"  href='products_by_category?category=4'>기타</a></li>
			  	</ul>
			</div>
		</div>
		<div>
			<div class="dropdown">
		  	<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
		    	정렬기준
		  	</button>
			  	<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
			    <li><a class="dropdown-item" href="index">기본정렬</a></li>
			    <li><a class="dropdown-item" href="high_price_form">가격 높은순</a></li>
			    <li><a class="dropdown-item" href="row_price_form">가격 낮은순</a></li>
			  	</ul>
			</div>
		</div>
	</div>
	
</div>
</form> 	


  <div class="clear"></div>   

<form name="product_main_form" id="product_main_form" method="post">

<div id= "new_product">
 		<input type="button" value="상품추가" class="submit" name="insertProduct" onClick="go_new_product()">
 	</div>
<div>

	<c:forEach items="${getMainlist}" var="productVO">
	
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
</form>
 	

 </body>
 
 <footer class="py-4 bg-dark flex-shrink-0">
    <div class="container text-center">
      <a href="https://bootstrapious.com/snippets" class="text-muted">Bootstrap snippet by Bootstrapious</a>
    </div>
 </footer>
 
 