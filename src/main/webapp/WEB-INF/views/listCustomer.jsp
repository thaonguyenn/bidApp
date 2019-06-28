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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

<title>List Customer</title>
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


table{
    width:100%;
}
#example_filter{
    float:right;
}
#example_paginate{
    float:right;
}
label {
    display: inline-flex;
    margin-bottom: .5rem;
    margin-top: .5rem;
   
}

</style>
</head>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable(
        
         {     
      "aLengthMenu": [[5, 10, 25, -1], [5, 10, 25, "All"]],
        "iDisplayLength": 5
       } 
        );
} );

function checkAll(bx) {
  var cbs = document.getElementsByTagName('input');
  for(var i=0; i < cbs.length; i++) {
    if(cbs[i].type == 'checkbox') {
      cbs[i].checked = bx.checked;
    }
  }
}
</script>

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

	<div class="container" style="position: absolute; left: 190px;">
	<form:form method="post" modelAttribute="customer">
		<div class="row">
		</div>
			<h1 class="text-center">Manage Customer</h1>
			<br><br>
			<div class="col-md-10 col-md-offset-1" style="width: 900px;">					
				
	<div class="row">	
	<table id="example" class="table table-striped table-bordered" style="width:100%;">
							<thead>
								<tr>
									<th class="hidden-xs" style="text-align: left;">IDCus</th>
									<th>Fullname</th>
									<th>Address</th>
									<th>Telephone</th>
									
									<th style="text-align: center;"><em class="fa fa-cog"></em>
									</th>
								</tr>
							</thead>
							<tbody id = "myTable">
								
								<c:forEach items="${customers}" var="customer">
								<tr>
									<td class="hidden-xs">${customer.idCus}</td>
									<td>${customer.fullName}</td>									
									<td>${customer.address}</td>
									<td>${customer.phoneNumber}</td>
									
									<td align="center">

																
									<button type="button" class="btn btn-info btn-md" id="myBtnCus"
													onclick="functionDetailCustomer('${customer.idCus}')">
													<em class="fa fa-info"></em>
												</button></td>
												
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				
			</div>
		
		</form:form>
	</div>
<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Detail Customer</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						
							<div class="form-group">
							<label class="control-label col-sm-2" for="fullName">Fullname: </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="fullName"
									disabled>
							</div>
						</div>
							<div class="form-group">
							<label class="control-label col-sm-2" for="phoneNumber">Telephone:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="phoneNumber"
									disabled>
							</div>
						</div>
							<div class="form-group">
							<label class="control-label col-sm-2" for="address">Address:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="address"
									disabled>
							</div>
						</div>
					
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>

			</div>

		</div>

	</div>




<script type="text/javascript">
function functionDetailCustomer(idCus){
	$.ajax({
		url : "./findDetail/" + idCus,
		type : "GET",
		dataType : "xml",
		success : function(valueDetail) {
			functionShowDetail(valueDetail);
	}});
	
}
function functionShowDetail(valueDetail) {
	$('#fullName').val($(valueDetail).find('fullName').text());
	$('#phoneNumber').val($(valueDetail).find('phoneNumber').text());
	$('#address').val($(valueDetail).find('address').text());
	$('#myModal').modal();
	
}
</script>
</body>
</html>