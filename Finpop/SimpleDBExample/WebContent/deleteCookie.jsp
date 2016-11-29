<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<title>Logout</title>
</head>
<body>

	<%
		// deleting a cookie
		
		// get the cookie
		Cookie cookie = new Cookie("loginCookie", "");
			
		// option 1:  delete cookie immediately
		cookie.setMaxAge(0);

		
		// option 2: delete cookie when browser closes
		//cookie.setMaxAge(60*5);
		
		// option 3: delete after 5 minutes
		//cookie.setMaxAge(60*5);

		// add updated cookie back into repsonse header
		response.addCookie(cookie);
		%>
	
	<div style="text-align:center;margin-top:50px;">You have been logged out <br/><br/>
	
	You will be redirected to the login page in a few seconds.</br><img src="img/squares.gif" style="width:50px"/></div>
		<script>
				$(document).ready(function () {
				    // Handler for .ready() called.
				    window.setTimeout(function () {
				        location.href = "index.jsp";
				    }, 2000);
				});
			</script>


</body>
</html>