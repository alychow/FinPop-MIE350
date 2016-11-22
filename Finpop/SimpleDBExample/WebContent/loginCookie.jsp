<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import='com.mie.dao.*' %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Session</title>
</head>
<body>


<h2>Logging in with Session</h2>

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
			out.print("Login Successful. Welcome back " + username);
			out.print("<br/><a href='listUsers.jsp'>List Users</a><br/>");
		} else {
			// login failed
			out.print("Login Unsuccessful. Please go back and try again");
		}
	} else {	
		// a value was laready stored in the session
		// a user is already logged in 
		out.print("Someone is already logged in as " + storedLogin);
		out.print("<br/>Sorry, need to logoff first. <br/>");
		out.print("<a href='deleteCookie.jsp'>Log off</a><br/>");
	}
%>




</body>
</html>