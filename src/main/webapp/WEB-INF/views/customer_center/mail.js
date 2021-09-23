function go_mail() {
	$("#center_form").attr("action", "mail_form").submit();
}



/*
 * 1:1문의 폼에 항목이 입력되었는지 확인
 */
function go_save() {
	var $title = $("#title");
	var $contents = $("#contents");
	
	if ($title.val()=="") {
		alert("제목을 입력하세요!");
		$title.focus();
	} else if ($contents.val()=="") {
		alert("내용을 입력하세요!");
		$contents.focus();
	} else {
		$("#mail_form").attr("action", "send_email").submit();
	}
}