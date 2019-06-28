$(function() {
	$("#nameProduct").blur(validateNameProduct);
	$("#nameProduct").click(removeNameProdutcError);
	$("#description").blur(validateDescr);
	$("#description").click(removeDecriptionError);
	$("#price").blur(validatePrice);
	$("#price").click(removePriceError);
});

function removeNameProdutcError() {
	$("#errorName").html("");
}

function removeDecriptionError() {
	$("#errorDecription").html("");
}
function removePriceError() {
	$("#errorPrice").html("");
}
function validateNameProduct() {
	if ($("#nameProduct").val() == "") {
		$("#errorName").html("Bạn không thể để trống dữ liệu này");
		$("#errorName").css('color', 'red');
	}
}
function validatePrice() {
	if ($("#price").val() == "") {
		$("#errorPrice").html("Bạn không thể để trống dữ liệu này");
		$("#errorPrice").css('color', 'red');
	}
}
function validateDescr() {
	if ($("#description").val() == "") {
		$("#errorDecription").html("Bạn không thể để trống dữ liệu này");
		$("#errorDecription").css('color', 'red');
	}
}
function checkValid() {
	var checked = true;
	if ($("#nameProduct").val() == "") {
		$("#errorName").html("Bạn không thể để trống dữ liệu này");
		$("#errorName").css('color', 'red');
		checked = false;
	}
	if ($("#price").val() == "") {
		$("#errorPrice").html("Bạn không thể để trống dữ liệu này");
		$("#errorPrice").css('color', 'red');
		checked = false;
	}
	if ($("#description").val() == "") {
		$("#errorDecription").html("Bạn không thể để trống dữ liệu này");
		$("#errorDecription").css('color', 'red');
		checked = false;
	}
		if (checked == true) {
			document.getElementById("add").type = 'submit';
		} 
	

}
