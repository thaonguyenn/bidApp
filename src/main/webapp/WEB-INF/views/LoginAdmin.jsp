<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<script
	src="${pageContext.request.contextPath}/styles/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/styles/js/LoginAccount.js"
	type="text/javascript"></script>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/projectCDW.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<title>Login</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	color: #fff;
		font-family: 'Roboto', sans-serif;
}

.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}

.form-control:focus {
	border-color: #5cb85c;
}

.form-control, .btn {
	border-radius: 3px;
}

.signup-form {
	width: 400px;
	margin: 0 auto;
	padding: 30px 0;
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}

.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 30%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}

.signup-form h2:before {
	left: 0;
}

.signup-form h2:after {
	right: 0;
}

.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f2f3f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form input[type="checkbox"] {
	margin-top: 3px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	min-width: 140px;
	outline: none !important;
}

.signup-form .row div:first-child {
	padding-right: 10px;
}

.signup-form .row div:last-child {
	padding-left: 10px;
}

.signup-form a {
	color: #fff;
	text-decoration: underline;
}

.signup-form a:hover {
	text-decoration: none;
}

.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}

.signup-form form a:hover {
	text-decoration: underline;
}
#errorEmail,#errorPass,#errorRepass{
color: red;
}

</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<div class="signup-form">
		<form:form method="post" modelAttribute="accountAd">
			<h2>Login for admin</h2>
			<div class="form-group">
			</div>
			<div class="form-group">
				<form:input path="email" type="email" class="form-control"
					name="email" placeholder="Email" id="email" required="required"/>
			</div>
			<center>
				<p id="errorEmail" class="errorEmail"></p>
			</center>
			<div class="form-group">
				<form:input path="password" type="password" class="form-control"
					name="password" placeholder="Password" id="pass" />
			</div>
			<center>
				<p id="errorPass"class="errorPass"></p>
			</center>
						<div class="form-group">
				<button type="submit" style="color: white; position: absolute; background-color: #fdd513; height: 40px; width: 170px; -moz-border-radius: 10px; -webkit-border-radius: 10px;margin-left: 80px; ">Login
					Now</button>
			</div>
			<br><br><br>
	<div class="text-center">
			Don't have an account? <a href="<c:url value='/register'/>">Sign
					up</a>
		</div>
		</form:form>
	
	</div>
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
</body>
</html>
