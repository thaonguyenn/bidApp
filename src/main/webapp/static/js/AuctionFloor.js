
function initList() {
	document.getElementById("yourPosition").innerHTML = 0;
	setInterval(() => {
		//reduce countdown 1
		var urla = "../loadListReadySession"; 
        $.ajax({ url: urla, 
        	type: "GET",
        	dataType: "xml",
        	success:  function(text) {showListReadySession(text); } //3 items for ready
        	, cache: false }); 
//        var urlb = "../loadListOpeningSession"; 
//        $.ajax({ url: urlb, 
//        	type: "GET",
//        	dataType: "xml",
//        	success:  function(text) {showListOpeningSession(text); }//2 items for open 
//        	, cache: false });
        //${id} time for detail product
        var idSession = document.getElementById("idSession").value;
        var idProduct = document.getElementById("idProduct").value;
        var urlc = "../loadBidingTime?idSession="+idSession+"&idProduct="+idProduct;
        $.ajax({ url: urlc, 
        	type: "GET",
        	dataType: "xml",
        	success:  function(text) {showBidingTime(text); }
        	, cache: false });
        //get all item session
        var urld = "../loadItemSession?idSession="+idSession;
        $.ajax({ url: urld, 
        	type: "GET",
        	dataType: "xml",
        	success:  function(text) {addItemSession(text); }
        	, cache: false });
	}, 1000);
	
}

function addItemSession(text) {
	var divPrice = document.getElementById("priceOfItem");
	for (loop = divPrice.childNodes.length -1; loop >= 0 ; loop--) {
		divPrice.removeChild(divPrice.childNodes[loop]);
      }
	var nodePrice = document.createElement("P");
	var textnodePrice = document.createTextNode("Money");
	$(nodePrice).css("font-size", "10px");
	nodePrice.appendChild(textnodePrice);
	divPrice.appendChild(nodePrice);
	
	var count = 0;
	var bestPrice = ""; 
	var bestUser = ""; 
	var bestAccUser = ""; 
	$(text).find('item').each(function(){
		bestPrice = $(this).find('price').text();
		bestUser = $(this).find('email').text();
		bestAccUser = $(this).find('customer').text();
		return false;
	});
	
	$(text).find('item').each(function(){
		count++;	
	});
	var idCustomer = document.getElementById("idAccount").value;//get id customer by session login
	var position = 1;
	//var tmp = 0;
	$(text).find('item').each(function(){
		//tmp++;
		if (idCustomer == $(this).find('customer').text()){
			//position = tmp;
			return false;
		}
		position++;
	});
	if (count == 0) {
	document.getElementById("yourPosition").innerHTML = "0/"+count;
	}
	else {
	document.getElementById("yourPosition").innerHTML = position+"/"+count;
	}
	document.getElementById("bestPrice").innerHTML = "$"+bestPrice;
	document.getElementById("bestUser").innerHTML = bestUser;
	document.getElementById("bestAccUser").innerHTML = bestAccUser;
	$(text).find('item').each(function(){
    	var price = $(this).find('price').text();
    	var node = document.createElement("P");
    	var textnode = document.createTextNode(price);
    	$(node).css("font-size", "10px");
		$(node).css("margin-top", "-15px");
    	node.appendChild(textnode);
    	divPrice.appendChild(node);
    });
	
	var divCustomer = document.getElementById("customerOfItem");
	for (loop = divCustomer.childNodes.length -1; loop >= 0 ; loop--) {
		divCustomer.removeChild(divCustomer.childNodes[loop]);
      }
	var nodeCustomer = document.createElement("P");
	var textnodeCustomer = document.createTextNode("Customer");
	$(nodeCustomer).css("font-size", "10px");
	nodeCustomer.appendChild(textnodeCustomer);
	divCustomer.appendChild(nodeCustomer);
	$(text).find('item').each(function(){
		var customer = $(this).find('email').text();
		var node = document.createElement("P");
		var textnode = document.createTextNode(customer);
		$(node).css("font-size", "10px");
		$(node).css("margin-top", "-15px");
		node.appendChild(textnode);
    	divCustomer.appendChild(node);
	});
	
	var divTime = document.getElementById("timeOfItem");
	for (loop = divTime.childNodes.length -1; loop >= 0 ; loop--) {
		divTime.removeChild(divTime.childNodes[loop]);
      }
	var nodeTime = document.createElement("P");
	var textnodeTime = document.createTextNode("Time");
	$(nodeTime).css("font-size", "10px");
	nodeTime.appendChild(textnodeTime);
	divTime.appendChild(nodeTime);
	$(text).find('item').each(function(){
		var time = $(this).find('time').text();
		var node = document.createElement("P");
		var textnode = document.createTextNode(time);
		$(node).css("font-size", "10px");
		$(node).css("margin-top", "-15px");
		node.appendChild(textnode);
    	divTime.appendChild(node);
	});
  
}

function closeResult() {
	document.getElementById("myModal").style.display = 'none';
}
function showBidingTime(text) {
	var idCustomer = document.getElementById("idAccount").value;
	var btime = $(text).find('bidingTime').text();
	document.getElementById("biddingTime").innerHTML = btime;
	if (btime == '0:0:10' && idCustomer!=null){
		document.getElementById("biddingButton").disabled = false;
		document.getElementById("biddingMoney").disabled = false;
	}
	if (btime == 'Finished'){
		if (document.getElementById("bestAccUser").innerHTML == idCustomer){
			var idSession = document.getElementById("idSession").value;
			var idProduct = document.getElementById("idProduct").value;
			window.location.href = "./checkout?idProduct=" + idProduct + "&idCustomer=" + idCustomer +"&idSession=" + idSession;
		} else {
			document.getElementById("myModal").style.display = "block";
		}
	}
}
function showListOpeningSession(text) {
	//size list product
	var size = 0;
	$(text).find('product').each(function(){
		size++;
	});
	//tmp (because not div)
    var j;
    //for (j = 5; j > size; j--) {
    for (j = 3; j > 0; j--) {
    	document.getElementById("product"+j).style.display = 'none';
	}
    
	var i = 1;
	$(text).find('product').each(function(){
    	var idProduct = $(this).find('idProduct').text();
     	var nameProduct = $(this).find('nameProduct').text();
     	var description = $(this).find('description').text();
     	var countdown = $(this).find('countdown').text();
     	
     	document.getElementById("nameProduct"+i).innerHTML = nameProduct;
     	//document.getElementById("timeBinding"+i).innerHTML = timeBinding;
     	document.getElementById("timeNow"+i).innerHTML = countdown;
     	i++;
    });
}
function showListReadySession(text) {
//	var div = document.getElementById("listReady");
//	for (loop = div.childNodes.length -1; loop >= 0 ; loop--) {
//		div.removeChild(div.childNodes[loop]);
//      }
	
	//size list product
	var size = 0;
	$(text).find('product').each(function(){
		size++;
	});
	//tmp (because not div)
    var j;
    for (j = 4; j > size; j--) {
    	document.getElementById("product"+j).style.display = 'none';
	}
    
	var i = 1;
	
	$(text).find('product').each(function(){
//		if (${idProduct} == $(this).find('idProduct').text()) {
//			continue;
//		} 
    	var idProduct = $(this).find('idProduct'
    			).text();
     	var nameProduct = $(this).find('nameProduct').text();
     	var description = $(this).find('description').text();
     	var timeBinding = $(this).find('timeBinding').text();
     	var img = $(this).find('img').text();
     	var timeNow = $(this).find('timeNow').text();
     	document.getElementById("nameProduct"+i).innerHTML = nameProduct;
     	document.getElementById("timeBinding"+i).innerHTML = timeBinding;
     	document.getElementById("timeNow"+i).innerHTML = timeNow;
     	document.getElementById("im"+i).src = img;
     	i++;
    });
}

function bid() {
	var money = document.getElementById("biddingMoney").value;
	var idSession = document.getElementById("idSession").value;
	var idCustomer = document.getElementById("idAccount").value;//get id customer by session login
	var urlbid = "../bid?idSession="+idSession+"&idCustomer="+idCustomer+"&money="+money;
     $.ajax({ url: urlbid, 
     	type: "GET",
     	dataType: "xml"
     	, cache: false });
}
function checkValidPrice() {
	var money = document.getElementById("biddingMoney").value;
	var idSession = document.getElementById("idSession").value;
	var urlv = "../checkValidPrice?idSession="+idSession+"&priceB="+money;
    $.ajax({ url: urlv, 
    	type: "GET",
    	dataType: "xml",
    	success:  function(text) {checkPrice(text); }
    	, cache: false });
}
function checkPrice(text) {
	if ($(text).find('valid').text() == "false") {
		document.getElementById("messInvalidPrice").innerHTML = "price should be higher !";
		document.getElementById("biddingButton").disabled = true;
    } else {
    	document.getElementById("messInvalidPrice").innerHTML = "";
		document.getElementById("biddingButton").disabled = false;
    }
}