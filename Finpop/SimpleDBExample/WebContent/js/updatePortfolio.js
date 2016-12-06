$(".update_button").on('click',function (e) {
	
	// Stop form from submitting normally
 		event.preventDefault();
 	// Get some values from elements on the page:
     	var $form = $( this  ),
     //get href from the form	
     	href = $form.attr( "name" );
     	console.log(href);
     //split action to get url, company, and userID
	    hSplit = href.split("&");
	    url = hSplit[0];
	    console.log(url); 

	    action = hSplit[1];
	    userid = hSplit[2];
	    compName = hSplit[3];
		    console.log(action); 
		    console.log(compName);
		    console.log(userid); 
 	//get number of shares from document
 		var id = "#update_value_"+compName;
		 var value = $(id).val();
	     console.log(value);
     
     //check if the number of shares entered is a valid number
     	if(!isNaN(value)&&parseInt(value)>0){
		
		    
	 // Send the data using post
		var posting = $.get( url,{action:action,userid:userid,compName:compName,number:value});
	    location.reload();

     	}else{
     		//print alert is not a valid number
     		window.alert("The entered number of shares: "+value+" is not a valid number");
		}
});