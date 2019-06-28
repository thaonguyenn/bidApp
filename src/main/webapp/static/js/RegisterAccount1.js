$(function() {
	$("#email").blur(validateEmail);
	$("#email").click(removeEmailError);
	$("#pass").blur(validatePass);
	$("#pass").click(removePassError);
	$("#repass").blur(validateRepass);
	$("#repass").click(removeRepassError);
});

function removeEmailError() {
	$("#errorEmail").html("");
}
function removePassError() {
	$("#errorPass").html("");
}
function removeRepassError() {
	$("#errorRepass").html("");
}
function validateEmail() {
	var email = $("#email").val();
	if (email == "")
		$("#errorEmail").html("Bạn không thể để trống dữ liệu này");
	else if (email.indexOf('@') == -1 || email.indexOf('.') == -1)
		$("#errorEmail").html("Email không hợp lệ, thử lại");
	else {
		var urlEmail = "./checkEmailExist?email=" + email; 
        $.ajax({ url: urlEmail, 
        	type: "GET",
        	dataType: "xml",
        	success:  function(text) 
        	{checkExistEmail(text); } ,
        	 cache: false }); 
	}
	
}
function checkExistEmail(text) {
	if ($(text).find('valid').text() == "false") {
		$("#errorEmail").html("Email này đã có người đăng ký, thử lại");
	}
}
function validatePass() {
	var pass = $("#pass").val();
	if (pass == "")
		$("#errorPass").html("Bạn không thể để trống dữ liệu này");
	else if (pass.length < 8)
		$("#errorPass").html("Mật khẩu có ít nhất 8 ký tự. Thử lại.");
	
}


function validateRepass() {
	var repass = $("#repass").val();
	var pass = $("#pass").val();
	if (repass == "")
		$("#errorRepass").html("Bạn không thể để trống dữ liệu này");
	else if (repass != pass)
		$("#errorRepass").html("Mật khẩu không tương ứng. Thử lại.");
	
}
