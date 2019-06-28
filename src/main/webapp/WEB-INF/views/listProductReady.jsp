<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  isELIgnored="false"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="${pageContext.request.contextPath}/styles/js/listBidding.js" type="text/javascript"></script> 

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
	<c:set var="counter" value="1" />
	<c:forEach items="${sessions}" var="session">
		<div class="col-sm-3" style="margin-top: 70px">
		<c:forEach items="${session.product.listImages}" var="img">
			<div class="show">
				<img alt="" src="${img.nameImage}"
					class="picture1">
			</div>
			</c:forEach>
			<div class="icon">
				<img alt="" src="<c:url value="/images/Time.jpg"/>"
					class="time">
				<p id="timeNow${counter}" style="margin-top: -255px; margin-left: 55px"></p>
			</div>
			<div class="post-modern-caption">
				<div class="post-modern-price">Price:</div>
				<div class="post-modern-price-value">$${session.product.price}</div>
				<h5 class="post-modern-link">
					<a href="#">${session.product.nameProduct}</a>
				</h5>
				<div class="show">
					<c:if test = "${account != null}">
					<button type="image"
						class="contact" onmouseover="this.style.backgroundColor='#0d0d0d'"
						onmouseout="this.style.backgroundColor='#fdd513'"
						style="position: relative; top: 10px; border: 1px;"
						onclick="window.location.href = '<c:url value='/customer/detailProduct?idSession=${session.sessionID}&idProduct=${session.product.idProduct}'/>'"></button>
					<div class="bid">Submit a bid</div>
				</c:if>
				<c:if test = "${account == null}">
					<button type="image"
						class="contact" onmouseover="this.style.backgroundColor='#0d0d0d'"
						onmouseout="this.style.backgroundColor='#fdd513'"
						style="position: relative; top: 10px; border: 1px;"
						onclick="window.location.href = '<c:url value='/login'/>'"></button>
					<div class="bid">Submit a bid</div>
				</c:if>

				</div>

			</div>

		</div>
		<c:set var="counter" value="${counter+1}" />
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
<script type="text/javascript">initList();</script>
	</footer>	
</body>
</html>