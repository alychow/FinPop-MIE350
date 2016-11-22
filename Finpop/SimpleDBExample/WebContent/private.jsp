<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Private User</title>
</head>
<body>


	<h2>Private User</h2>
		
	<% String login = request.getParameter("login"); 
	
		Cookie[] cookies = request.getCookies();

		// Check if the user logged in is the same as the one being viewed
		String storedLogin = null;
		for(Cookie cookie : cookies){
		    if("loginCookie".equals(cookie.getName())){
		        storedLogin = cookie.getValue();
		    }
		}
		if (storedLogin.equals(null)){
			out.print("You are allowed to view private data for " + storedLogin + ".");

			%>
			<div>HIHIHI</div>
	<%
		} else {
			out.print("You are NOT allowed to view private data for " + login + ".");
		}
	%>
	
	


</body>
</html>