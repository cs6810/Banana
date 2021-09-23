
function go_new_product() {
	$("#main_form").attr("action", "product_form").submit();
}

function go_back() {
	$("#product_form").attr("action", "main_form").submit();
}

function go_save_product() {	
	if ($("#product_name").val()=="") {
		alert("상품명을 입력하세요!");
		$("#product_name").focus();
	} else if ($("#category").val()=="") {
		alert("카테고리를 선택하세요!");
		$("#category").focus();
	} else if ($("#price").val()=="") {
		alert("가격을 입력하세요!");
		$("#price").focus();
	} else if ($("#state").val()=="") {
		alert("판매 상태를 선택하세요!");
		$("#state").focus();
	} else if ($("#useyn").val()=="") {
		alert("새상품 여부를 선택하세요!");
		$("#useyn").focus();
	} else if ($("#content").val()=="") {
		alert("상품 설명을 입력하세요!");
		$("#content").focus();
	} else if ($("#image1").val()=="") {
		alert("이미지를 하나이상 선택하세요!");
		$("#image1").focus();
	} else {
		$("#product_form").attr("encoding", "multipart/form-data");
		$("#product_form").attr("action", "insert_product").submit();
	}
}

function go_mod(pd_id) {
	$("#product_detail").attr("action", "update_form?pd_id="+pd_id).submit();
}

function go_mod_save(pd_id){
	if ($("#product_name").val()=="") {
		alert("상품명을 입력하세요!");
		$("#product_name").focus();
	} else if ($("#category").val()=="") {
		alert("카테고리를 선택하세요!");
		$("#category").focus();
	} else if ($("#price").val()=="") {
		alert("가격을 입력하세요!");
		$("#price").focus();
	} else if ($("#state").val()=="") {
		alert("판매 상태를 선택하세요!");
		$("#state").focus();
	} else if ($("#useyn").val()=="") {
		alert("새상품 여부를 선택하세요!");
		$("#useyn").focus();
	} else if ($("#content").val()=="") {
		alert("상품 설명을 입력하세요!");
		$("#content").focus();
	} else if ($("#image1").val()=="") {
		alert("수정할 이미지를 선택하세요!");
		$("#image1").focus();
	} else {
		if (confirm("수정하시겠습니까?")) {
			$("#update_form").attr("encoding", "multipart/form-data");
			$("#update_form").attr("action", "update_product").submit();		
		}
	}
}

function go_detail(pd_id) {
	$("#product_main_form").attr("action", "product_detail?pd_id="+pd_id).submit();
}