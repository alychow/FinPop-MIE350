// Attach a submit handler to the form
$("#search_form").on('keyup', function (e) {
  // Stop form from submitting normally
	 var Value = document.getElementById("search_bar");
     var s = Value.value;
     console.log(s);
     
     if(s != " "){
    	 event.preventDefault();
		
  // Get some values from elements on the page:
	var $form = $( this ),
    term = $form.find( "input[name='keyword']" ).val(),
    url = $form.attr( "action" );
 
  // Send the data using post
  var posting = $.get( url, { keyword: term } );
 
  // Put the results in a div
  posting.done(function( data ) {
	  var list = data.split("|");
	  console.log(list);
	  $( "#search_bar" ).autocomplete({
	      source: list
	  });
  });
}
});