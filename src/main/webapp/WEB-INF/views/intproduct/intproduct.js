

function go_detail(user_id) {
	$("#product_main_form").attr("action", "product_detail?user_id="+user_id).submit();
}