<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script
	src="${pageContext.request.contextPath}/styles/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/listCustomer.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/css/bootstrap.css">
<script
	src="${pageContext.request.contextPath}/styles/js/bootstrap.min.js"
	type="text/javascript"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<title>Insert title here</title>
<style type="text/css">
#menu ul {
	background: none;
	width: 237px;
	padding: 0;
	list-style-type: none;
	text-align: left;
}

#menu li {
	width: auto;
	height: 40px;
	line-height: 40px;
	border-bottom: 1px solid #e8e8e8;
	padding: 0 2em;
}

#menu li a {
	text-decoration: none;
	color: #262729;
	font-weight: bold;
	display: block;
}

#menu li:hover {
	background: #CDE2CD;
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
a {
    font-size: 100%;
}

</style>
</head>
<body style="font-family: 'Raleway', sans-serif;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li style="font-size: 15px; top: -25px; left: -30px;"><a
						href="./index.html"><img alt="" src="<c:url value="/images/alogoBid.png"/>"
							style="width: 200px;"></a></li>
					<br>

				</ul>
				<img alt="" src="<c:url value="/images/column.gif"/>"
					style="position: absolute; top: 82px; left: -13px;">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><img alt="" src="<c:url value="/images/admin.ico"/>"
							style="border-radius: 50px; width: 50px; height: 50px; position: absolute; left: -50px;"></a></li>
					<li
						style="font-size: 15px; position: absolute; top: 20px; left: 900px;"><a
						href="">Welcome ${accountAd.email}</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="col-sm-3"
		style="position: absolute; top: 82px; left: -20px;">
		<div id="menu">
			<ul>
				<li><a href="${pageContext.request.contextPath}/admin/listCustomer">Management Customer</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/productApproved" class="fontSmallMenu">Approved Product</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/approveProduct" class="fontSmallMenu">Non-Approve Product</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/bidSuccessProduct" class="fontSmallMenu">BidProduct success</a></li>
						
				<!-- <li class="dropdown"><a href=""
					class="dropdown-toggle fontMenu" data-toggle="dropdown"
					role="button" aria-haspopup="true" aria-expanded="false">Management Product <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/admin/productApproved" class="fontSmallMenu">Approved Product</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/approveProduct" class="fontSmallMenu">Non-Approve Product</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/bidSuccessProduct" class="fontSmallMenu">BidProduct success</a></li>
						</ul>
				</li> -->
			</ul>

		</div>
	</div>

	<div class="col-sm-9"
		style="position: absolute; top: 85px; left: 225px; width: 85%;">
		<nav aria-label="breadcrumb" role="navigation">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">Customer</li>
			</ol>
		</nav>
	</div>

</body>
</html>