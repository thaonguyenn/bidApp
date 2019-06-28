<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  isELIgnored="false"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<script src="${pageContext.request.contextPath}/styles/js/home.js" type="text/javascript"></script> 
<style type="text/css">
.full-screen {
 min-height: 100vh;
}
</style>

</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<section class="section novi-bg novi-bg-img section-xl section-banner-classic bg-primary text-center text-lg-left" style="height: 520px;background-image: url(<c:url value="/images/homeBid.jpg"/>">
        <div class="container">
          </div>
      </section>
	<div class="bg" style="margin-top: -480px;">
		<div class="fontHeader1">The best place</div>

		<div class="fontHeader2">to buy and sell</div>
		<br>
		<div>
		<c:if test="${account != null}">
			<input type="image" alt="" onclick="window.location.href = '<c:url value='/register'/>'"
				src="<c:url value="/images/Register01.jpg"/>" class="contact" data-toggle="modal" data-target="#myModal" 
				style="position: relative; left: 215px; top: 100px;" disabled="disabled">
		</c:if>
		<c:if test="${account == null}">
			<input type="image" alt="" onclick="window.location.href = '<c:url value='/register'/>'"
				src="<c:url value="/images/Register01.jpg"/>" class="contact" data-toggle="modal" data-target="#myModal" 
				style="position: relative; left: 215px; top: 100px;">
		</c:if>
		</div>
		<div>
			<input type="image" alt=""
				src="<c:url value="/images/uon.png"/>" class="curve" />
		</div>
		<div class="register">Register</div>
	</div>
	<br>

	<div class="container">
		<h2 class="text-left">
			Finished <span class="h2-style">Auctions</span>
		</h2>
		<br>
	</div>
	<div class="container">
	<c:forEach items="${productDone}" var="product">
		<div class="col-sm-3" style="margin-left: -10px;">
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

	<br>
	<br>
	<br>
	<div class="container">
		<h2 class="text-left">
			Current <span class="h2-style">Auctions</span>
		</h2>
		<br> <br> <br> <br>
	</div>
	<div class="container">
	<c:set var="counter" value="1" />
	<c:forEach items="${sessions}" var="session">
		<div class="col-sm-3">
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
	<div class="viewMore">
		<a href="#" style="font-size: 14px;">View all auctions<span
			class="icon novi-icon fa fa-chevron-right"></span></a>
	</div>
	<br>
	<br>

	<section
		class="section novi-bg novi-bg-img section-lg bg-gray-100 section-top-shadow">
		<div class="container">
			<h2 class="text-sm-left">
				How <span class="h2-style">it Works</span>
			</h2>

			<div class="row row-50 mt-50 column-arrow"
				style="margin-top: 50px; margin-left: 45px;">
				<div class="col-lg-3 col-sm-6">
					<!-- Box Icon Classic-->
					<div class="box-icon-classic">
						<div
							class="box-icon-classic-icon icon novi-icon linearicons-mouse-left">
							<div style="margin-left: 57px; margin-top: 55px;">
								<img alt="" src="<c:url value="/images/login.png"/>"
									class="icon1">
							</div>
						</div>

					</div>
					<h4 class="box-icon-classic-title">Register</h4>
					<p class="description">To start using our auction, you all need
						to register. It as completely free and requires just a few clicks!</p>
				</div>
				<div class="col-lg-3 col-sm-6">
					<!-- Box Icon Classic-->
					<div class="box-icon-classic">
						<div
							class="box-icon-classic-icon icon novi-icon linearicons-cart-exchange">
							<div style="margin-left: 57px; margin-top: 55px;">
								<img alt=""
									src="<c:url value="/images/shopping-cart.png"/>"
									class="icon1">
							</div>
						</div>
						<h4 class="box-icon-classic-title">Buy or Bid</h4>
						<p class="description">You can instantly buy or place a bid on
							any desired product right after registration on our website.</p>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6">
					<!-- Box Icon Classic-->
					<div class="box-icon-classic">
						<div
							class="box-icon-classic-icon icon novi-icon linearicons-hammer2">
							<div style="margin-left: 57px; margin-top: 55px;">
								<img alt="" src="<c:url value="/images/auction.png"/>"
									class="icon1">
							</div>
						</div>
						<h4 class="box-icon-classic-title">Submit a Bid</h4>
						<p class="description">Submitting a bid to our auction is
							quick and easy. The process takes approximately 5 minutes.</p>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6">
					<!-- Box Icon Classic-->
					<div class="box-icon-classic">
						<div
							class="box-icon-classic-icon icon novi-icon linearicons-trophy2">
							<div style="margin-left: 57px; margin-top: 55px;">
								<img alt="" src="<c:url value="/images/win.png"/>"
									class="icon1">
							</div>
						</div>
						<h4 class="box-icon-classic-title">Win</h4>
						<p class="description">Easily win at our auction and enjoy
							owning the product you dream of after the bidding is closed.</p>

					</div>
				</div>
			</div>
		</div>
	</section>

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

	 <script type="text/javascript">initList();</script>
</body>
</html>