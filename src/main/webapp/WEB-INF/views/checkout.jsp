<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>checkout</title>
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
<script src="${pageContext.request.contextPath}/styles/js/payment.js"
	type="text/javascript"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Titillium+Web"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.post-modern {
	font-family: montserrat, -apple-system, BlinkMacSystemFont, segoe ui,
		Roboto, helvetica neue, Arial, sans-serif;
	font-size: 47px;
	margin-left: 10px;
	display: block;
	line-height: 1;
	color: #000;
	font-family: montserrat, -apple-system, BlinkMacSystemFont, segoe ui,
		Roboto, helvetica neue, Arial, sans-serif;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<div class="col">
				<div id="signupbox" style="margin-top: 50px;"
					class="mainbox col-md-6 col-md-offset-0 col-sm-8 col-sm-offset-0"
					style="margin-left: -350px;">
					<div class="panel panel-default panel-table">

						<div class="panel-body">
							<form method="post">

								<div id="div_id_email" class="form-group required">
									<label for="id_email"
										class="control-label col-md-4  requiredField"> E-mail<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md emailinput form-control" id="id_email"
											name="email" style="margin-bottom: 10px" type="email"
											value="${emailCus}" disabled="disabled" />
									</div>
								</div>
								<div id="div_id" class="form-group required" hidden="true">
									<label for="id" class="control-label col-md-4  requiredField">
										Id<span class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 " hidden="true">
										<input name=idCus value="${idCustomer}" class="input-md textinput form-control"
											id="id_username" maxlength="30"
											placeholder="Enter your fullname" style="margin-bottom: 10px"
											type="text" />
									</div>
								</div>
								<div id="div_id_username" class="form-group required">
									<label for="id_username"
										class="control-label col-md-4  requiredField">
										Fullname<span class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input name="fullName" class="input-md textinput form-control"
											id="fullName" maxlength="30"
											placeholder="Enter your fullname" style="margin-bottom: 10px"
											type="text" />
										<p id="nameError"></p>
									</div>
								</div>

								<div id="div_id_location" class="form-group required">
									<label for="id_location"
										class="control-label col-md-4  requiredField"> Your
										address<span class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input name="address" onblur="calculateFeeShip()"
											class="input-md textinput textInput form-control"
											id="id_location" placeholder="Enter your address"
											style="margin-bottom: 10px" type="text" />
										<p id="locationError"></p>
									</div>
								</div>

								<div id="div_id_number" class="form-group required">
									<label for="id_number"
										class="control-label col-md-4  requiredField">Phone
										number<span class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input name="phoneNumber"
											class="input-md textinput textInput form-control"
											id="id_number" placeholder="provide your number"
											style="margin-bottom: 10px" type="text" />
										<p id="telephoneError"></p>
									</div>
								</div>
								<div id="div_id_number" class="form-group required"
									hidden="true">
									<label for="id_number"
										class="control-label col-md-4  requiredField">Phone
										number<span class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input name="idOrders" hidden="true"
											class="input-md textinput textInput form-control"
											id="id_number" placeholder="provide your number"
											style="margin-bottom: 10px" type="text" />
										<p id="telephoneError"></p>
									</div>
								</div>

								<div id="div_id_payment" class="form-group required">
									<label for="id_select"
										class="control-label col-md-4  requiredField"> Payment<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 " style="margin-bottom: 10px">
										<select name="payment" class="selectpicker form-control">
											<option>Card</option>
											<option>Transfer</option>

										</select>
									</div>
								</div>
								<p style="margin-top: 30px;">*</p>


								<hr style="margin-top: -20px;">


								<div id="div_id_shipq" class="form-group required">
									<label for="id_number"
										class="control-label col-md-4  requiredField">Fee ship<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md textinput textInput form-control"
											id="id_ship" name="feeShip" style="margin-bottom: 10px"
											type="text"/>
										<p id="shipError"></p>
									</div>
								</div>
								<div id="div_id_number" class="form-group required">
									<label for="id_number"
										class="control-label col-md-4  requiredField">Total<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md textinput textInput form-control"
											id="id_total" name="total" style="margin-bottom: 10px"
											type="text"/>
										<p id="totalError"></p>
									</div>
								</div>
								<input type="button" value="Payment" class="add" id="add"
									onclick="checkValid()" 
									style="left: 650px; color: white; position: absolute; background-color: #fdd513; height: 40px; width: 140px; -moz-border-radius: 10px; -webkit-border-radius: 10px; margin-top: 25px;">

							</form>

						</div>
					</div>
				</div>
			</div>
			<div class="col">


				<div class="panel panel-default panel-table">
					<div class="panel-heading">
						<div class="panel-title">Information</div>
						<div style="font-size: 85%; position: relative; top: -10px"></div>
					</div>
					<div class="panel-body">

						<div class="showhim">
							<div id="signupbox" style="margin-top: 50px;"
								class="mainbox col-md-3 col-md-offset-0">
								<c:forEach items="${product.listImages}" var="img">
								<img alt="" src="${img.nameImage}"
									class="">
								</c:forEach>
							</div>
							<div class="post-modern-caption">
								<br> <br> <br>
								<div class="post-modern" style="margin-top: 20px;">Price: $
									<p id="highestPrice">${sessionItem.price}</p></div>
								<br>
								<h5 class="post">
									<a href="#">Name : ${product.nameProduct} </a>
								</h5>


							</div>

							<br> <br>

						</div>
					</div>
				</div>

			</div>

		</div>

	</div>
	<br>
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