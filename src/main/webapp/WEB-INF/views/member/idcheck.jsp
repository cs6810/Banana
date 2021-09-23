<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>

<script type="text/javascript">
function idok(){
  opener.formm.email_id.value="${email_id}"; 
  opener.formm.reid.value="${email_id}";
  self.close();
}
</script>
</head>
<body>
<div id="wrap">
  <h1>E-mail (ID) 중복확인</h1>
  <form method=post name=formm id="theform" action="id_check_form" >
    E-mail (ID) <input type=text name="email_id" value="${email_id}"> 
            <input type=submit value="검색" class="submit"><br>     
    <div>   
     
     
      <c:if test="${message == 1}">
        <script type="text/javascript">
          opener.document.formm.email_id.value="";
        </script>
        ${email_id}는 이미 사용중인 이메일입니다.
      </c:if>
      
      
      <c:if test="${message==-1}">
        ${email_id}는 사용 가능한 이메일입니다.
        <input type="button" value="사용" class="cancel" onclick="idok()">
      </c:if>
      
    </div>
  </form>
</div>  
</body>
</html>