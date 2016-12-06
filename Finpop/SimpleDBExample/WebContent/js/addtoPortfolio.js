$("#add_button").on('click', function (e) {
	
	// Stop form from submitting normally
 		event.preventDefault();
 	//get number of shares from document

		 var value = $("#number_of_shares").val().toString();
	     console.log(value);
     
     //check if the number of shares entered is a valid number
     	if(!isNaN(value)&&parseInt(value)>0){
		
     // Get some values from elements on the page:
     	var $form = $( "#add_to_portfolio" ),

     //get action from the form	
     	action = $form.attr( "action" );
     	console.log(action);
     //split action to get url,company, and userID
	    actionSplit = action.split("&");
	    url = actionSplit[0];
	 //company includes number of shares 
	    company = actionSplit[1]+"-"+actionSplit[2]+"-"+ value;
	    userid = actionSplit[3];
	    console.log(url); 
	    console.log(company); 
	    console.log(userid); 
	 // Send the data using post
		var posting = $.post( url,{addinfo:company,userid:userid});
	//print out the result of the query on to the screen
		posting.done(function( result ) {
			  console.log(result);
			  window.alert(result);
		  });
     	}else{
     		//print alert is not a valid number
     		window.alert("The entered number of shares: "+value+" is not a valid number");
		}
  });