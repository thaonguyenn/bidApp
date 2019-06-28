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
<style type="text/css">
.full-screen {
 min-height: 100vh;
}
</style>

</head>
<body>
<p style="color: red;">${success}</p>
<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="nav navbar-nav navbar-right">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<ul class="nav navbar-nav navbar-right"
					style="position: relative; margin-top: 20px;display: inline-block;">
					<li><a href="${pageContext.request.contextPath}/" class="fontMenuLevel">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/customer/listBiddingProduct" class="fontMenuLevel">Auctions</a></li>
					<c:if test = "${accountAd == null}">
					<li><a href="${pageContext.request.contextPath}/loginAdmin" class="fontMenuLevel">Admin</a></li>
					</c:if>
					<c:if test = "${accountAd != null}">
					<li><a href="${pageContext.request.contextPath}/admin/listCustomer" class="fontMenuLevel">Admin</a></li>
					</c:if>
					<c:if test = "${account == null}">
					<button type="image"
						src="<c:url value="/images/Register01.jpg"/>"
						class="contact" onmouseover="this.style.backgroundColor='#0d0d0d'"
						onmouseout="this.style.backgroundColor='#fdd513'"
						onclick="window.location.href = '<c:url value='/login'/>'"
						style="position: relative; width: 100px; border: 1px; color: white; font-weight: bold;">Log
						in</button>
					</c:if>
					<c:if test = "${account != null}">
					<br>
					<li style="margin-top: -20px;"><a href="${pageContext.request.contextPath}/customer/listUserOwner" class="fontMenuLevel">Own Product</a></li>
					<li style="margin-top: -20px;"><a href="${pageContext.request.contextPath}/customer/addProduct" class="fontMenuLevel">Sell</a></li>
					
					<li><button type="image"
						src="<c:url value="/images/Register01.jpg"/>"
						class="contact" onmouseover="this.style.backgroundColor='#0d0d0d'"
						onmouseout="this.style.backgroundColor='#fdd513'"
						onclick="window.location.href = '<c:url value='/logout'/>'"
						style="position: relative; width: 100px; border: 1px; color: white; font-weight: bold;">Log
						out</button></li>
					<li><a href="" class="fontMenuLevel" style="margin-top: -40px">Welcome ${account.email}</a></li>
					</c:if>
				</ul>
				<ul class="nav navbar-nav navbar-left">

					<input type="image" alt="" src="<c:url value="/images/logo.png"/>" class="logoAuction">
				</ul>
			</div>
		</div>
	</div>
	

</body>
</html>