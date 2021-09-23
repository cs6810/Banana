<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="member/findIdAndPassword.js"></script>

<script type="text/javascript">
function idok(){
  self.close();
}
</script>
</head>
<body>
<div id="wrap">
  <h1>비밀번호 찾기 결과</h1>
  <form method=post name=formm id="pwd_form" style="margin-right:0" >
    E-mail <input type=text name="email_id" value="${email_id}">   
    <div >   
     
      <c:if test="${message == 1}">
      	<label>Password</label> 
        <input type="password"  name="pwd" id="pwd"><br> 
        <label>Retype Password</label> 
        <input type="password"  name="pwdCheck" id="pwdcheck"><br> 
        <input type="button" value="확인" class="cancel" onclick="changePassword()">
      </c:if>
      <c:if test="${message==-1}">
             잘못된 사용자 정보입니다.
         <input type="button" value="확인" class="cancel" onclick="idok()">
      </c:if>
    </div>
    
  </form>
</div>  
</body>
</html>