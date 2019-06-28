function initList() {
	setInterval(() => {
		//reduce countdown 1
		var urla = "./loadListReadySession"; 
        $.ajax({ url: urla, 
        	type: "GET",
        	dataType: "xml",
        	success:  function(text) {showListReadySession(text); } //3 items for ready
        	, cache: false }); 
	}, 1000);
	
}
function showListReadySession(text) {
	var i = 1;
	$(text).find('product').each(function(){
    	var idProduct = $(this).find('idProduct'
    			).text();
     	var timeNow = $(this).find('timeNow').text();
     	document.getElementById("timeNow"+i).innerHTML = timeNow;
     	i++;
    });
}
