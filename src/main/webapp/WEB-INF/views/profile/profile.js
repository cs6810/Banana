/*
 * 회원정보 수정화면 요청 함수
 */
function go_mod(pseq) {
	$("#detail_form").attr("action", "admin_product_update_form?email_id="+email_id).submit();
}


/*
 * 회원정보 변경 폼에 항목이 입력되었는지 확인
 */
function go_profile_save(email_id) {
	var $pwd = $("#pwd");
	var $name = $("#name");
	var $nk_name = $("#nk_name");
	var $ph_nm = $("#ph_nm");
	var $address = $("#address");
	var $profile_img = $("#profile_img");

	
	if ($("#pwd").val()=="") {
		alert("비밀번호를 입력해주세요!");
		$("#pwd").focus();
	} else if ($("#name").val()=="") {
		alert("성명을 입력하세요!");
		$("#name").focus();
	} else if ($nk_name.val()=="") {
		alert("닉네임을 입력하세요!");
		$nk_name.focus();
	} else if ($ph_nm.val()=="") {
		alert("전화번호를 입력하세요!");
		$ph_nm.focus();
	} else if ($("#address").val()=="") {
		alert("주소를 입력하세요!");
		$("#address").focus();
	} else{
		if (confirm("수정하시겠습니까?")){
			
		$("#update_form").attr("encoding", "multipart/form-data");
		$("#update_form").attr("action", "profile_member_update").submit();
		}
	}	
}


	function address_ok() {
		$("#theform").attr("action", "address_confirmed").submit()
		
	}

