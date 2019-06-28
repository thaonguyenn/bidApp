<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script class="jsbin"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Titillium+Web"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/RegisterCoach9.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/projectCDW.css">
<script
	src="${pageContext.request.contextPath}/styles/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/styles/js/addProductJS.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/styles/js/bootstrap.min.js"
	type="text/javascript"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Titillium+Web"
	rel="stylesheet">

<!------ Include the above in your HEAD tag ---------->
<head>
<meta charset="UTF-8">
<title>Save Product</title>
<style type="text/css">
body {
	font-family: sans-serif;
	background-color: #eeeeee;
}

.file-upload {
	background-color: #ffffff;
	width: 400px;
	margin: 0 auto;
	padding: 1px;
	top: -550px;
}

.file-upload-btn {
	width: 100%;
	margin: 0;
	color: #fff;
	background: #fdd513;
	border: none;
	padding: 3px;
	border-radius: 4px;
	border-bottom: 4px solid #fdd513;
	transition: all .2s ease;
	outline: none;
	text-transform: uppercase;
	font-weight: 700;
}

.file-Add-btn {
	width: 10%;
	margin: 0;
	color: #fff;
	background: #fdd513;
	border: none;
	padding: 3px;
	border-radius: 4px;
	border-bottom: 4px solid #fdd513;
	transition: all .2s ease;
	outline: none;
	text-transform: uppercase;
	font-weight: 700;
}

.file-upload-btn:hover {
	background: #fdd513;
	color: #ffffff;
	transition: all .2s ease;
	cursor: pointer;
}

.file-upload-btn:active {
	border: 0;
	transition: all .2s ease;
}

.file-upload-content {
	display: none;
	text-align: center;
}

.file-upload-input {
	position: absolute;
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	outline: none;
	opacity: 0;
	cursor: pointer;
}

.image-upload-wrap {
	margin-top: 10px;
	border: 4px dashed #fdd513;
	position: relative;
	height: 185px;
}

.image-dropping, .image-upload-wrap:hover {
	background-color: #fdd513;
	border: 4px dashed #fdd513;
}

.image-title-wrap {
	padding: 0 15px 15px 15px;
	color: #222;
}

.drag-text {
	text-align: center;
}

.drag-text h5 {
	font-weight: 100;
	text-transform: uppercase;
	color: #15824B;
	padding: 60px 0;
}

.file-upload-image {
	max-height: 200px;
	max-width: 200px;
	margin: auto;
	padding: 20px;
}

.remove-image {
	width: 200px;
	margin: 0;
	color: #fff;
	background: #cd4535;
	border: none;
	padding: 10px;
	border-radius: 4px;
	border-bottom: 4px solid #b02818;
	transition: all .2s ease;
	outline: none;
	text-transform: uppercase;
	font-weight: 700;
}

.remove-image:hover {
	background: #c13b2a;
	color: #ffffff;
	transition: all .2s ease;
	cursor: pointer;
}

.remove-image:active {
	border: 0;
	transition: all .2s ease;
}

.panel-table .panel-body {
	padding: 0;
}

.panel-table .panel-body .table-bordered {
	border-style: none;
	margin: 0;
}

.panel-table .panel-body .table-bordered>thead>tr>th:first-of-type {
	text-align: center;
	width: 100px;
}

.panel-table .panel-body .table-bordered>thead>tr>th:last-of-type,
	.panel-table .panel-body .table-bordered>tbody>tr>td:last-of-type {
	border-right: 0px;
}

.panel-table .panel-body .table-bordered>thead>tr>th:first-of-type,
	.panel-table .panel-body .table-bordered>tbody>tr>td:first-of-type {
	border-left: 0px;
}

.panel-table .panel-body .table-bordered>tbody>tr:first-of-type>td {
	border-bottom: 0px;
}

.panel-table .panel-body .table-bordered>thead>tr:first-of-type>th {
	border-top: 0px;
}

.panel-table .panel-footer .pagination {
	margin: 0;
}

.panel-table .panel-footer .col {
	line-height: 34px;
	height: 34px;
}

.panel-table .panel-heading .col h3 {
	line-height: 30px;
	height: 30px;
}

.panel-table .panel-body .table-bordered>tbody>tr>td {
	line-height: 34px;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default panel-table">
					<form:form method="POST" modelAttribute="product"
						action="../customer/addProduct">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									<h3 class="panel-title">Form information</h3>
								</div>
								<div class="col col-xs-6 text-right"></div>
							</div>
						</div>

						<div class="panel-body" style="height: 320px;">
							<br>

							<div class="col-sm-6">
							<input hidden="true" name="idProduct"value="${product.idProduct}">

								<p style="position: absolute; left: 30px;">Name Product:</p>
								<form:input path="nameProduct" id="nameProduct"
									name="nameProduct" class="form-control"
									style="position: absolute; left: 130px; width: 330px;" />
								<br> <br>
								<center>
									<p id="errorName" class="errorName"
										style="position: absolute; left: 130px; width: 330px;"></p>
								</center>
								<br> <br>
								<p style="position: absolute; left: 30px;">Category</p>
								<select id="idcategory" name="idcategory"
									style="position: absolute; left: 130px; width: 330px;">
									<option value="05142019Ca00001">Phone</option>
									<option value="05142019Ca00002">LapTop</option>
									<option value="05142019Ca00003">MacBook</option>
									<option value="05142019Ca00004">Cosmetics</option>
									<option value="05142019Ca00005">Clothes</option>
									<option value="05142019Ca00006">Fashion</option>
								</select>
								<br> <br>
								<p style="position: absolute; left: 30px;">Description</p>
								<form:textarea path="description" id="description"
									class="form-control"
									style="position: absolute; left: 130px; width: 330px;" />

								<br> <br> <br>
								<center>
									<p id="errorDecription" class="errorDecription"
										style="position: absolute; left: 130px; width: 330px;"></p>
								</center>
								<br> <br>
								<p style="position: absolute; left: 30px;">Price</p>
								<form:input path="price" type="number" pattern="[-+]?[0-9]"
									id="price" name="price" class="price"
									style="position: absolute; left: 130px; width: 330px;" />

								<center>
									<p id="errorPrice" class="errorPrice"
										style="position: absolute; left: 130px; width: 330px;"></p>
								</center>
							</div>
							<div class="col-sm-6">
								<div class="file-upload">
									<button class="file-upload-btn" type="button"
										onclick="$('.file-upload-input').trigger( 'click' )">Add
										Image</button>

									<div class="image-upload-wrap">
										<input class="file-upload-input" type='file'
											onchange="readURL(this);" accept="image/*" />
										<div class="drag-text">
											<h5>Drag and drop a file or select add Image</h5>
										</div>
									</div>
									<div class="file-upload-content">
										<img class="file-upload-image" src="#" alt="your image" />
										<div class="image-title-wrap">
											<button type="button" onclick="removeUpload()"
												class="remove-image">
												Remove <span class="image-title">Uploaded Image</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							
							<center>
								<button type="button" id="add" class="file-Add-btn"
									style="margin-top:50px;  background-color: #fdd513" onclick="checkValid()">Add new</button>
							</center>
						</div>
						<input type="text" id="uploadedImage" name="uploadedImage" hidden="true">
					</form:form>
					<br>

				</div>

			</div>
		</div>
	</div>

<br><br><br>
	<footer class="section footer-classic context-dark bg-image"
		style="background: #2d3246; height: 280px; width: 100%;">
		<div class="container">
			<div class="row row-30">
				<div class="col-md-4 col-xl-3">
					<h4 class="fontHeader3">Information</h4>
					<ul class="nav-list">
						<li><a href="#">About</a></li>
						<li><a href="#">Projects</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Contacts</a></li>
						<li><a href="#">Pricing</a></li>
					</ul>
				</div>
				<div class="col-md-4 col-xl-3">
					<h4 class="fontHeader3">Help Center</h4>
					<ul class="nav-list">
						<li><a href="#">Assistance</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Testimonials</a></li>
						<li><a href="#">Account Refill</a></li>
						<li><a href="#">Payments</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<h4 class="fontHeader3">Contact</h4>
					<dl class="contact-list">
						<dt>Address:</dt>
						<dd style="font-size: 15px;">Quarter 6, Linh Trung Ward, Thu
							Duc District, Ho Chi Minh City</dd>
					</dl>
					<dl class="contact-list">
						<dt>email:</dt>
						<dd>
							<a href="mailto:#">nhomCDW@gmail.com</a>
						</dd>
					</dl>
					<dl class="contact-list">
						<dt>phones:</dt>
						<dd>
							<a href="tel:#">0929890162</a> <span>or</span> <a href="tel:#">0909168168</a>
						</dd>
					</dl>
				</div>
			</div>
		</div>

	</footer>
	<script type="text/javascript">
		function readURL(input) {
			if (input.files && input.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {
					$('.image-upload-wrap').hide();

					$('.file-upload-image').attr('src', e.target.result);
					document.getElementById("uploadedImage").value = e.target.result;
					
					$('.file-upload-content').show();

					$('.image-title').html(input.files[0].name);
				};

				reader.readAsDataURL(input.files[0]);

			} else {
				removeUpload();
			}
		}

		function removeUpload() {
			$('.file-upload-input')
					.replaceWith($('.file-upload-input').clone());
			$('.file-upload-content').hide();
			$('.image-upload-wrap').show();
		}
		$('.image-upload-wrap').bind('dragover', function() {
			$('.image-upload-wrap').addClass('image-dropping');
		});
		$('.image-upload-wrap').bind('dragleave', function() {
			$('.image-upload-wrap').removeClass('image-dropping');
		});
	</script>
</body>