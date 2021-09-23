/**
 * 
 */

// id중복화면 화면 출력
function idcheck() {
	if ($('#email_id').val() == "") {
		alert("아이디를 입력해 주세요");
		$('#email_id').focus();
		return;
	}
	
	// 아이디 중복체크를 위한 윈도우 오픈 요청
	var url="id_check_form?id=" + $('#email_id').val();
	
	window.open(url, "_blank_1", 
			"toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=350, heigth=200");
}
//사용가능한 아이디를 사용
function idok() {
	$("#theform").attr("action", "id_check_confirmed").submit()
}


/*
 *  회원가입 시 , 필수 입력 사항 체크
 *  action url: join
 *  
 */
function go_save() {
	if ($("#email_id").val() == "") {
		alert("이메일을 입력해 주세요!");
		$("#email_id").focus();
	} else if($("#email_id").val() !=$("#reid").val()) {
		alert("이메일 중복체크를 해주세요!");
		$("#email_id").focus();
	} else if($("#pwd").val() =="" ){
		alert("비밀번호를 입력해 주세요!");
		$("#pwd").focus();
	}	else if($("#pwd").val() !=$("#pwdCheck").val()){
		alert("비밀번호가 일치하지 않습니다!");
		$("#pwd").focus();
	} else if($("#name").val() == ""){
		alert("성명을 입력해 주세요");
		$("#name").focus();
	} else if($("#nk_name").val() == ""){
		alert("닉네임을 입력해 주세요");
		$("#nk_name").focus();
	} else if($("#ph_nm").val() == ""){
		alert("전화번호를 입력해주세요");
		$("#ph_nm").focus();
	} else if($("#address").val() == ""){
		alert("주소를 입력해 주세요");
		$("#address").focus();
	}else {
		alert("회원가입 완료하였습니다.");
		$("#join").attr("action", "join").submit();
	}
}

/*
 *  주소 찾기 창 오픈
 */
function address() {
	var url = "find_address";
	
	window.open(url, "_blank_1", 
	"toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=500, heigth=350");
}


/*
*	우편번호 찾기 창 오픈
*/
function post_zip() {
	var url = "find_zip_num";
	
	window.open(url, "_blank_1", 
	"toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=350, heigth=350");
}

function address_edit() {
	var url = "address_edit";
	
	window.open(url, "_blank_1", 
	"toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=300, heigth=150");		
}
function address_ok() {
	$("#theform").attr("action", "address_confirmed").submit()
	
}

