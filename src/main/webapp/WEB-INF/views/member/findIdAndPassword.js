/**
 *  아이디, 비밀번호 찾기 관련 스크립트 함수
 */
function find_id_form() {
	var url = "find_id_form";
	
	window.open(url, "_blank_1", 
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, heigth=500, "+
	"top=300, left=300");
}
/*
 *  아이디를 찾기 위해 find_id url 요청 전송
 *  
 * 
 */

function findMemberId() {
	
	if($("#name").val() == "") {
		alert("이름을 입력해 주세요")
		$("#name").focus();
	} else if($("#ph_nm").val() == "") {
		alert("전화번호를 입력해 주세요!");
		$("#ph_nm").focus();
	} else {
		$("#findId").attr("action", "find_id").submit();
	}
	
}
/*
 *  비밀번호 찾기 요청 
 */
function findPassword() {
	
	if($("#email_id2").val() == "") {
		alert("이메일 입력해 주세요!");
		$("#email_id2").focus();
	} else if ($("#ph_nm2").val() == "") {
		alert("전화번호 입력해 주세요")
		$("#ph_nm2").focus();
	} else {
		$("#findPW").attr("action", "find_password").submit();
	}
	
}
function changePassword() {
	
	if ($("#pwd").val() == "") {
		alert("암호를 입력해 주세요!");
		$("#pwd").focus();
	} else if ($("#pwd").val() != $("#pwdcheck").val()) {
		alert("암호가 일치하지 않습니다!");
		$("#pwd").focus();
	} else {
		$("#pwd_form").attr("action", "change_password").submit();
	}
	
	
	
	
	/* NEW
	
function findPw(){
		$("#findBtn").click(function(){
			$.ajax({
				url : "/member/findpw",
				type : "POST",
				data : {
					email_id : $("#email_id").val(),
					ph_nm : $("#ph_nm").val()
				},
				success : function(result) {
					alert(result);
				},
			})
		});
	}

	*/
	
}