<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import='com.mie.dao.*' %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="style/cookie.css">

<title>Login</title>
</head>
<body>


<h2 style="text-align:center">Logging in</h2>

<% 
	
	// get all cookies first
	Cookie[] cookies = request.getCookies();

	// get value stored in cookie, if it exists
	String storedLogin = null;
	// option 1: iterate the Cookies array for specific cookie
	/*
	for(Cookie cookie : cookies){
	    if("loginCookie".equals(cookie.getName())){
	        storedLogin = cookie.getValue();
	    }
	}
	*/		

 	// option 2: store cookies in a HashMap and get specific cookie
 	java.util.Map cookieMap = new java.util.HashMap();
	for(Cookie cookie : cookies){
	    cookieMap.put(cookie.getName(), cookie.getValue());
	}
	storedLogin = (String)cookieMap.get("loginCookie");
	
	if (storedLogin == null){
		Query query = new Query();
		// no value was stored in the session
		// assuming new user is logging in
		// check their credentials
		String username = request.getParameter("loginParameter");
		String password = request.getParameter("pswdParameter");
		boolean isALogin = query.isALogin(username, password);
				
		if (isALogin){
			// login success!
			// set the session variable
			Cookie cookie = new Cookie("loginCookie", username);
			// add cookie back into repsonse header
			response.addCookie(cookie);
			out.print("<div style = 'text-align:center;'id='success'>Login Successful. </br>Welcome back " + username+"</br> You will be redirected in 2 seconds</br></br><img style='width:100px' src='img/squares.gif'/></div>");
			%>
			<script>
				$(document).ready(function () {
				    // Handler for .ready() called.
				    window.setTimeout(function () {
				        location.href = "search.jsp";
				    }, 2000);
				});
			</script>
			<%
			
/* 			out.print("<br/><a href='listUsers.jsp'>List Users</a><br/>");
 */		} else {
			// login failed
			out.print("<div style='text-align:center'>Login Unsuccessful. Please go back and try again</div>");
			%>
			<script>
				$(document).ready(function () {
				    // Handler for .ready() called.
				    window.setTimeout(function () {
				        location.href = "index.jsp";
				    }, 2000);
				});
			</script>
			<%
		}
	} else {	
		// a value was laready stored in the session
		// a user is already logged in 
		out.print("<div style='text-align:center'> Someone is already logged in as " + storedLogin+"<br/></div>");
		out.print("<div style='text-align:center;margin:15px;'><a href='search.jsp'>Continue as current user</a><br/></div>");
		out.print("<div style='text-align:center'><br/>Sorry, need to logoff first. <br/></div>");
		out.print("<div style='text-align:center;margin:15px;'><a href='deleteCookie.jsp'>Log off</a><br/></div>");
	}
%>

</body>

</html>