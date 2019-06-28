<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/styles/css/bootstrap.css"
	rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/projectCDW.css">
<script
	src="${pageContext.request.contextPath}/styles/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" media="screen"
	href="${pageContext.request.contextPath}/styles/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/styles/js/jquery-3.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/styles/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/styles/chart.js/Chart.min.js"></script>
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Titillium+Web"
	rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
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
	<form action="../customer/listUserOwne" method="POST">
		<div class="col-sm-6">
			<div class="row">
			<h3 class="text-center">List Product Owner</h3> 
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-12">
									<h3 class="panel-title">List of products you have posted for auction</h3>
								</div>
								<div class="col col-xs-6 text-right"></div>
							</div>
						</div>
						<div class="panel-body">
							<table class="table table-striped table-bordered table-list">
								<thead>
									<tr>
										<th class="hidden-xs" style="text-align: left;">Name
											Product</th>
										<th>Price</th>
										<th>Create day</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listProducts}" var="listProduct">
										<tr>
											<td>${listProduct.nameProduct}</td>
											<td>${listProduct.price}</td>
											<td>${listProduct.createDay}</td>
										<c:if test = "${listProduct.presentStatus == 1}">	
										<td align="center">notApprove</td>
										</c:if>
										<c:if test = "${listProduct.presentStatus == 2}">	
										<td align="center">Approved</td>
										</c:if>
									</c:forEach>
								</tbody>
							</table>

						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col col-xs-4">Page 1 of 5</div>
								<div class="col col-xs-8">
									<ul class="pagination hidden-xs pull-right">
										<li><a href="./Users.html">1</a></li>
										<li><a href="./Users.html">2</a></li>
										<li><a href="./Users.html">3</a></li>
										<li><a href="./Users.html">4</a></li>
										<li><a href="./Users.html">5</a></li>
									</ul>
									<ul class="pagination visible-xs pull-right">
										<li><a href="#">«</a></li>
										<li><a href="#">»</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-sm-6">
			<div class="row">
			<h3 class="text-center">List Product Buyer</h3> 
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-12">
									<h3 class="panel-title">Product list you have successfully auctioned</h3>
								</div>
								<div class="col col-xs-6 text-right"></div>
							</div>
						</div>
						<div class="panel-body">
							<table class="table table-striped table-bordered table-list">
								<thead>
									<tr>
										<th class="hidden-xs" style="text-align: left;">Name
											Product</th>

										<th>Price</th>
										<th>Create day</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lists}" var="listProduct">
										<tr>
											<td>${listProduct.nameProduct}</td>
											<td>${listProduct.price}</td>
											<td>${listProduct.createDay}</td>
									</c:forEach>
								</tbody>
							</table>

						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col col-xs-4">Page 1 of 5</div>
								<div class="col col-xs-8">
									<ul class="pagination hidden-xs pull-right">
										<li><a href="./Users.html">1</a></li>
										<li><a href="./Users.html">2</a></li>
										<li><a href="./Users.html">3</a></li>
										<li><a href="./Users.html">4</a></li>
										<li><a href="./Users.html">5</a></li>
									</ul>
									<ul class="pagination visible-xs pull-right">
										<li><a href="#">«</a></li>
										<li><a href="#">»</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>
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