
$(function() {
	$("#id_location").blur(validateLocation);
	$("#id_location").click(removeLocationError);
	$("#fullName").blur(validateName);
	$("#fullName").click(removeUserNameError);	
	$("#id_number").blur(validatePhone);
	$("#id_number").click(removePhoneError);
	$("#id_ship").blur(validateShip);
	$("#id_ship").click(removeShipError);
	$("#id_total").blur(validateTotal);
	$("#id_total").click(removeTotalError);
});

function removeUserNameError() {
	$("#nameError").html("");
}
function removeLocationError() {
	$("#locationError").html("");
}
function removePhoneError() {
	$("#telephoneError").html("");
}
function removeShipError() {
	$("#shipError").html("");
}
function removeTotalError() {
	$("#totalError").html("");
}
function validateName() {
	if ($("#fullName").val() == "") {
		$("#nameError").html("This is required field ");
		$("#nameError").css('color', 'red');
	}
}
function validateLocation() {
	if ($("#id_location").val() == "") {
		$("#locationError").html("This is required field");
		$("#locationError").css('color', 'red');
	}
}
function validateShip() {
	if ($("#id_ship").val() == "") {
		$("#shipError").html("This is required field");
		$("#shipError").css('color', 'red');
	}
}
function validateTotal() {
	if ($("#id_total").val() == "") {
		$("#totalError").html("This is required field");
		$("#totalError").css('color', 'red');
	}
}
function validatePhone() {
	var telephone = $("#id_number").val();
	var formatPhone = /^[0-9-+]+$/;
	if (telephone == "")
		$("#telephoneError").html("This is required field");
	else if (!telephone.match(formatPhone))
		$("#telephoneError").html("Invalid format.Please try again");
	$("#telephoneError").css('color', 'red');
}
function checkValid() {
	var checked = true;
		if ($("#fullName").val() == "") {
			$("#nameError").html("This is required field");
			$("#nameError").css('color', 'red');
			checked = false;
		}
		if ($("#id_location").val() == "") {
			$("#locationError").html("This is required field");
			$("#locationError").css('color', 'red');
			checked = false;
		}
		if ($("#id_number").val() == "") {
			$("#telephoneError").html("This is required field");
			$("#telephoneError").css('color', 'red');
		}	
		if ($("#id_ship").val() == "") {
			$("#shipError").html("This is required field");
			$("#shipError").css('color', 'red');
			checked = false;
		}
		if ($("#id_total").val() == "") {
			$("#totalError").html("This is required field");
			$("#totalError").css('color', 'red');
			checked = false;
		}
		if (checked == true) {
			document.getElementById("add").type = 'submit';
		} 
	

}
function calculateFeeShip() {
	var id_location = document.getElementById("id_location").value;
	var urlad = "../calculateFee?id_location="+id_location; 
	 $.ajax({ url: urlad, 
     	type: "GET",
     	dataType: "xml",
     	success:  function(text) {showFee(text); } //3 items for ready
     	, cache: false }); 	
}
function showFee(text) {
	var fee = document.getElementById("id_ship").value = $(text).find('fee').text();
	var highestPrice = document.getElementById("highestPrice").innerHTML;
	document.getElementById("id_total").value = parseFloat(fee) + parseFloat(highestPrice);
}