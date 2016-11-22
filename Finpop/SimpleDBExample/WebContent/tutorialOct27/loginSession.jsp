<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Session</title>
</head>
<body>

	<%@ include file="data.jsp"  %>

<h2>Logging in with Session</h2>

<% 
	
	// get value stored in session, if it exists
	String storedLogin = (String)session.getAttribute("loginValue");
	
	if (storedLogin == null){
		// no value was stored in the session
		// assuming new user is logging in
		// check their credentials
		String loginParameter = request.getParameter("loginParameter");
		String pswdParameter = request.getParameter("pswdParameter");
		String[] user = (String[])users.get(loginParameter);

		if (user != null && user[1].equals(pswdParameter)){
			// login success!
			// save their session
			session.setAttribute("loginValue", loginParameter);
			out.print("Login Successful. Welcome back " + user[2]);
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
		out.print("<a href='deleteSession.jsp'>Log off</a><br/>");
	}
%>




</body>
</html>