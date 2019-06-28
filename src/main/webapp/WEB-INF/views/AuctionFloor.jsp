
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auction Floor</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/css/auctionFloor.css">
<script src="${pageContext.request.contextPath}/styles/js/jquery-3.1.1.min.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/styles/js/AuctionFloor.js" type="text/javascript"></script> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
	/* Khung chứa thumbnail */
.thumbnail {
    width: 100px;
    height: 100px; 
    overflow: hidden; 
    border: 1px solid #e5e5e5; 
}
.hovergallery img{
-webkit-transform:scale(0.8); /*Webkit: Scale down image to 0.8x original size*/
-moz-transform:scale(0.8); /*Mozilla scale version*/
-o-transform:scale(0.8); /*Opera scale version*/
-webkit-transition-duration: 0.5s; /*Webkit: Animation duration*/
-moz-transition-duration: 0.5s; /*Mozilla duration version*/
-o-transition-duration: 0.5s; /*Opera duration version*/
margin: 0 10px 5px 0; /*margin between images*/
}
.hovergallery img:hover{
-webkit-transform:scale(1.1); /*Webkit: Scale up image to 1.2x original size*/
-moz-transform:scale(1.1); /*Mozilla scale version*/
-o-transform:scale(1.1); /*Opera scale version*/
box-shadow:0px 0px 30px gray; /*CSS3 shadow: 30px blurred shadow all around image*/
-webkit-box-shadow:0px 0px 30px gray; /*Safari shadow version*/
-moz-box-shadow:0px 0px 30px gray; /*Mozilla shadow version*/
}
 
/* Thumbnail */
.thumbnail img {
    width: 100%; 
    height: 100%;  
    opacity: 0.7;
    transition-duration: 0.5s;
        /* Safari & Google Chrome */
        -webkit-transition-duration: 0.5s; 
        /* Mozilla Firefox */
        -moz-transition-duration: 0.5s; 
        /* Opera */
        -o-transition-duration: 0.5s;
        /* IE 9 */
        -ms-transition-duration: 0.5s;
}
         
/* Hover chuột vào thumbnail */
.thumbnail img:hover {
    transform: scale(1.5);
    opacity: 1;
        /* Safari & Google Chrome */
        -webkit-transform: scale(1.5);
        /* Mozilla Firefox */
        -moz-transform: scale(1.5); 
        /* Opera */
        -o-transform: scale(1.5);
        /* IE 9 */
        -ms-transform: scale(1.5);
    cursor: pointer; 
}
</style>
</head>

 
<body style="background-color: #EEEEEE;font-family: 'Montserrat', sans-serif;">

	<jsp:include page="menu.jsp"></jsp:include>
    <!-- <h1>${greeting}</h1>
    <p class="title">abc</p>

    <form action="payment" method="post">
    	<input type="text" name="age">age
    	<button type="submit">search</button>
    </form> -->
    <input hidden="true" id="idSession" name="idSession" type="text" value="${idSession}">
    <input hidden="true" id="idProduct" name="idProduct" type="text" value="${idProduct}">
    <input hidden="true" id="idAccount" name="idAccount" type="text" value="${acc.idCus}">
    
    <div class="container">
    <div class="row" style="background-color: white; margin-top: 20px; border-radius: 5px">
    <div class="col-sm-4" style="margin-left: 20px; width: 700px">
    	<p style="color: gray; font-size: 20px; margin-top: 9px"><b>${product.nameProduct}</b></p>
    	<c:forEach items="${product.listImages}" var="img">
    	<div class="hovergallery">
    	<img alt="" src="${img.nameImage}" style="width: 300px; height: 300px">
    	</div>
    	</c:forEach>
    	<br>
    	<div class="row" style="margin-top: 11px;">
    		<c:forEach items="${product.listImages}" var="img">
	    	<div class="col-sm-3">
	    		<img alt="" src="${img.nameImage}" style="width: 65px; height: 65px;  border: 0.5px solid #BBBBBB; border-radius: 5px; margin-left: 1px">
	    	</div>
	    	</c:forEach>
	    	<c:forEach items="${product.listImages}" var="img">
	    	<div class="col-sm-3">
	    		<img alt="" src="${img.nameImage}" style="width: 65px; height: 65px;  border: 0.5px solid #BBBBBB; border-radius: 5px; margin-left: -15px">
	    	</div>
	    	</c:forEach>
	    	<c:forEach items="${product.listImages}" var="img">
	    	<div class="col-sm-3">
	    		<img alt="" src="${img.nameImage}" style="width: 65px; height: 65px;  border: 0.5px solid #BBBBBB; border-radius: 5px; margin-left: -35px">
	    	</div>
	    	</c:forEach>
	    	<c:forEach items="${product.listImages}" var="img">
	    	<div class="col-sm-3">
	    		<img alt="" src="${img.nameImage}" style="width: 65px; height: 65px;  border: 0.5px solid #BBBBBB; border-radius: 5px; margin-left: -55px">
	    	</div>
	    	</c:forEach>
    	</div>
    	<div style="background-color: #CCCCCC;width:300px; margin-top: 13px; font-size: 13px;  background: -moz-linear-gradient(bottom, #cc0000 30%, #330000 70%);
        background: -o-linear-gradient(bottom, #FFFFFF 30%, #330000 70%);
        background: -ms-linear-gradient(bottom, #FFFFFF 30%, #330000 70%);
        background: -webkit-gradient(linear,left bottom,left top,color-stop(0.3, #FFFFFF),color-stop(0.7, #CCCCCC));">
	    		<center>
	    		<p>Your position now</p>
	    		<p style="font-size: 25px; color: #FF4040; margin-top: -10px" id="yourPosition">10/100</p>
	    		</center>
    		</div>
    </div>
    <div class="col-sm-6" style="width:700px; border-radius: 5px;margin-right:15px; color:white; height: 500px; background-color: #333333; margin-top: 40px; margin-left: -50px;  background: -moz-linear-gradient(bottom, #cc0000 30%, #330000 70%);
        background: -o-linear-gradient(bottom, #FFFFFF 30%, #111111 70%);
        background: -ms-linear-gradient(bottom, #FFFFFF 30%, #111111 70%);
        background: -webkit-gradient(linear,left bottom,left top,color-stop(0.3,#111111),color-stop(0.7, #333333));">
    	<div class="row">
    		<div class="col-sm-8" style="margin-top: 20px">
    			<p style="font-size: 10px">Final sales price :</p>
    		</div>
    		<div class="col-sm-4">
    			<p style="font-size: 30px;" id="bestPrice"><b></b></p>
    		</div>
    	</div>
    	<div class="row" style="border: 0.5px solid black; margin-bottom: 10px">
    		<div class="col-sm-8" style="margin-top: 10px">
    			<p style="font-size: 10px">Highest bidder</p>
    			<img alt="" src="${pageContext.request.contextPath}/img/avatar2.png" style="width: 30px; height: 30px; border-radius: 20px">
    		</div>
    		<div class="col-sm-4" style="margin-top: 10px">
    			<p style="font-size: 10px; color: #FFFF00">Account</p>
    			<p style="font-size: 10px; margin-top: -10px" id="bestUser"></p>
    			<p hidden="true" id="bestAccUser"></p>
    		</div>
    	</div>
    	<center><p style="font-size: 10px">Great deals, good luck</p></center>
    	<div class="row" style="margin-top: 10px">
    		<div class="col-sm-3" id="priceOfItem">
    		<!--
    		<p style="font-size: 10px">Money</p>
    		<c:forEach items="${items}" var="item">	
    			<p style="font-size: 10px; margin-top: -15px">${item.price}</p>
    		</c:forEach>  --> 				
    		</div>
    		
    		<div class="col-sm-5" style="color: #FFFF00" id="customerOfItem">
    			<!--
    			<p style="font-size: 10px">Email</p>
    			<c:forEach items="${items}" var="item">	
    			<p style="font-size: 10px; margin-top: -15px">${item.customerID}</p>
    		</c:forEach>  -->    			
    		</div>
    		
    		<div class="col-sm-4" id="timeOfItem">
    			<!--
    			<p style="font-size: 10px">Time</p>
    			<c:forEach items="${items}" var="item">	
    			<p style="font-size: 10px; margin-top: -15px">${item.itemTime}</p>
    		</c:forEach>  -->
    		</div>
    	</div>
    	<div class="row">
    		<div class="col-sm-12">
    		<center>
    		<p style="font-size: 35px; color: #FF4040" id="biddingTime"><b>${biddingTime}</b></p>
    		</center>
    		</div>
    	</div>
    	<div class="row" style="position: absolute;left: 10px;top: 410px;">
    		<div class="col-sm-1">
    			<img alt="" src="${pageContext.request.contextPath}/img/avatar3.png" style="width: 35px; height: 36px; border-radius: 20px">
    		</div>
    		<div class="col-sm-8">
    			<input class="form-control" type="number" style="width: 390px; height: 38px" id="biddingMoney" disabled="disabled" onkeyup="checkValidPrice();">
    			<p style="color: red" id = "messInvalidPrice"></p>
    		</div>
    		<div class="col-sm-3">
    			<button class="btn" style="background-color: #FFFF00; margin-left: 20px" onclick="bid()" disabled="disabled" id="biddingButton"><b>Bid now</b></button>
    		</div>
    	</div>
    </div>
    <div id = "listReady" class="col-sm-2" style="background-color: #EEEEEE; margin-left: 15px; margin-top: 0px; font-size: 10px">
    	<div id="product1" style="border: 0.1px solid; margin-top: 10px">
			 <center>
			 <p id="nameProduct1">name product</p>
			 <div class="thumbnail">
			 <img alt="" src="" id="im1"
			 style="width: 100px; height: 100px">
			 </div>
			 <div style="background-color: #CCCCCC; margin-top: 13px; font-size: 13px;
			 background: -moz-linear-gradient(bottom, #cc0000 30%, #330000 70%);
			 background: -o-linear-gradient(bottom, #FFFFFF 30%, #330000 70%);
			 background: -ms-linear-gradient(bottom, #FFFFFF 30%, #330000 70%)
			 background: -webkit-gradient(linear,left bottom,left top,color-stop(0.3,
			 #FFFFFF),color-stop(0.7, #CCCCCC));">
			 <p style="margin-top: 10px; margin-bottom: 0px; font-size: 15px; color:
			 #00CC00"><b>$40</b></p>
			 <p id = "timeBinding1"><b></b></p>
			 <p id = "timeNow1"><b></b></p>
			 </div>
			 </center>
 		</div>
 		<div id="product2" style="border: 0.1px solid; margin-top: 10px">
			 <center>
			 <p id="nameProduct2">name product</p>
			 <div class="thumbnail">
			 <img alt="" id="im2"
			 style="width: 100px; height: 100px">
			 </div>
			 <div style="background-color: #CCCCCC; margin-top: 13px; font-size: 13px;
			 background: -moz-linear-gradient(bottom, #cc0000 30%, #330000 70%);
			 background: -o-linear-gradient(bottom, #FFFFFF 30%, #330000 70%);
			 background: -ms-linear-gradient(bottom, #FFFFFF 30%, #330000 70%)
			 background: -webkit-gradient(linear,left bottom,left top,color-stop(0.3,
			 #FFFFFF),color-stop(0.7, #CCCCCC));">
			 <p style="margin-top: 10px; margin-bottom: 0px; font-size: 15px; color:
			 #00CC00"><b>$40</b></p>
			 <p id = "timeBinding2"><b></b></p>
			 <p id = "timeNow2"><b></b></p>
			 </div>
			 </center>
 		</div>
 		<div id="product3" style="border: 0.1px solid; margin-top: 10px">
			 <center>
			 <p id="nameProduct3">name product</p>
			 <div class="thumbnail">
			 <img alt="" id="im3"
			 style="width: 100px; height: 100px">
			 </div>
			 <div style="background-color: #CCCCCC; margin-top: 13px; font-size: 13px;
			 background: -moz-linear-gradient(bottom, #cc0000 30%, #330000 70%);
			 background: -o-linear-gradient(bottom, #FFFFFF 30%, #330000 70%);
			 background: -ms-linear-gradient(bottom, #FFFFFF 30%, #330000 70%)
			 background: -webkit-gradient(linear,left bottom,left top,color-stop(0.3,
			 #FFFFFF),color-stop(0.7, #CCCCCC));">
			 <p style="margin-top: 10px; margin-bottom: 0px; font-size: 15px; color:
			 #00CC00"><b>$40</b></p>
			 <p id = "timeBinding3"><b></b></p>
			 <p id = "timeNow3"><b></b></p>
			 </div>
			 </center>
 		</div>
 		<div id="product4" style="border: 0.1px solid; margin-top: 10px">
			 <center>
			 <p id="nameProduct4">name product</p>
			 <div class="thumbnail">
			 <img alt="" id="im4"
			 style="width: 100px; height: 100px">
			 </div>
			 <div style="background-color: #CCCCCC; margin-top: 13px; font-size: 13px;
			 background: -moz-linear-gradient(bottom, #cc0000 30%, #330000 70%);
			 background: -o-linear-gradient(bottom, #FFFFFF 30%, #330000 70%);
			 background: -ms-linear-gradient(bottom, #FFFFFF 30%, #330000 70%)
			 background: -webkit-gradient(linear,left bottom,left top,color-stop(0.3,
			 #FFFFFF),color-stop(0.7, #CCCCCC));">
			 <p style="margin-top: 10px; margin-bottom: 0px; font-size: 15px; color:
			 #00CC00"><b>$40</b></p>
			 <p id = "timeBinding4"><b></b></p>
			 <p id = "timeNow4"><b></b></p>
			 </div>
			 </center>
 		</div>
 		<!-- <div id="product5" style="border: 0.1px solid; margin-top: 10px">
			 <center>
			 <p id="nameProduct5">name product</p>
			 <div class="thumbnail">
			 <img alt="" src="${pageContext.request.contextPath}/img/cook.jpg"
			 style="width: 100px; height: 100px">
			 </div>
			 <div style="background-color: #CCCCCC; margin-top: 13px; font-size: 13px;
			 background: -moz-linear-gradient(bottom, #cc0000 30%, #330000 70%);
			 background: -o-linear-gradient(bottom, #FFFFFF 30%, #330000 70%);
			 background: -ms-linear-gradient(bottom, #FFFFFF 30%, #330000 70%)
			 background: -webkit-gradient(linear,left bottom,left top,color-stop(0.3,
			 #FFFFFF),color-stop(0.7, #CCCCCC));">
			 <p style="margin-top: 10px; margin-bottom: 0px; font-size: 15px; color:
			 #00CC00"><b>$40</b></p>
			 <p id = "timeBinding5"><b></b></p>
			 <p id = "timeNow5"><b></b></p>
			 </div>
			 </center>
 		</div> -->
    </div>
 
    </div>
    
    <div class="col-sm-11" style="background-color: white; margin-left: -15px; width: 950px; position: absolute; top: 950px;">
    	<p style="color: gray; font-size: 18px; margin-left: 25px; margin-top: -270px">Name product: abc</p>
    	<p style="font-size: 10px; margin-left: 25px">Place a colander in a bowl (which has enough volume to hold the amount of liquid in the crockpot) and slowly pour the contents from the crockpot into the colander. Carefully lift the colander and let it drain, then place it in a large, empty bowl or on some paper towels (as a little more liquid will continue to drain off), to let your chicken cool until you can easily handle it.

The meat will fall completely off the bone, the skins are easy to remove, and you’ll have loads of cooked chicken for several recipes, as well as several cups of homemade broth. You can refrigerate the broth before using it, and easily skim the fat off the top to make it even healthier.

Many crock pot dishes from soups to beans can provide multiple meals: just freeze the leftovers to reheat on the stove top or microwave for weeks to come!

Another great thing about crock pot cooking is it can easily fit into a busy family’s schedule, where different family members sometimes need to eat at different times. Using this simple cooking method, they can each eat a hot meal without requiring you to put in the effort of cooking multiple times.</p>
        <center>
        <c:forEach items="${product.listImages}" var="img">
         <img alt="" src="${img.nameImage}" style="width: 500px; height: 500px;">
	    	</c:forEach>
       <c:forEach items="${product.listImages}" var="img">
         <img alt="" src="${img.nameImage}" style="width: 500px; height: 500px">
	    	</c:forEach>
    	</center>
    
    </div>
    </div>
    <script type="text/javascript">initList();</script>
    
    <div class="container">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Result</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeResult()">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
</body>
 
 
</html>