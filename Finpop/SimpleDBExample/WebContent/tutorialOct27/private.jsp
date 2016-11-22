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
	
	<%@ include file="data.jsp"  %>
	
	<% String login = request.getParameter("login"); 
	

		// Check if the user logged in is the same as the one being viewed
		String loggedIn = (String)session.getAttribute("loginValue");
	
		if (login.equals(loggedIn)){
			out.print("You are allowed to view private data for " + login + ".");

			String[] user = (String[])users.get(login);

			%>
			<table border=1 cellpadding=1>
				<tr><th>Login</th><td><% out.print(user[0]); %></td></tr>
				<tr><th>Password</th><td><% out.print(user[1]); %></td></tr>
				<tr><th>Name</th><td><% out.print(user[2]); %></td></tr>
				<tr><th>Position</th><td><% out.print(user[3]); %></td></tr>
				<tr><th>Company</th><td><% out.print(user[4]); %></td></tr>
				<tr><th>City</th><td><% out.print(user[5]); %></td></tr>
				<tr><th>Country</th><td><% out.print(user[6]); %></td></tr>
			</table>
	<%
		} else {
			out.print("You are NOT allowed to view private data for " + login + ".");
		}
	%>
	
	


</body>
</html>