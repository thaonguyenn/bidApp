<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>index</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/projectCDW.css">
<script
	src="${pageContext.request.contextPath}/styles/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/styles/js/bootstrap.min.js"
	type="text/javascript"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Titillium+Web"
	rel="stylesheet">
<style type="text/css">
.full-screen {
 min-height: 100vh;

}
</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
		<h2 class="text-center">
			Finished <span class="h2-style">Auctions</span>
		</h2>
		<br>
	</div>
	<br>
	<div class="container">
		<c:forEach items="${productDone}" var="product">
		<div class="col-sm-3" style="margin-left: -10px; margin-top: 10px">
		<c:forEach items="${product.listImages}" var="img">
			<div class="show">
			<input type="image" alt=""
					src="${img.nameImage}" class="picture">
			</div>
			</c:forEach>
			<div class="setPrice">Final price</div>
			<div class="setPrice1" id="finalPriceProduct">$671</div>
			<div class="setText">
				<a class="heading-5" id="nameProduct">${product.nameProduct}</a>
			</div>
		</div>
		</c:forEach>
	</div>
	<br><br>
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