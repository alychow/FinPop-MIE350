<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show User</title>
</head>
<body>


	<h2>Show User</h2>
	
	<%@ include file="data.jsp"  %>
	
	<% String login = request.getParameter("login"); 
	   String[] user = (String[])users.get(login);
	%>
	
	
	<table border=1 cellpadding=1>
		<tr><th>Login</th><td><% out.print(user[0]); %></td></tr>
		<tr><th>Name</th><td><% out.print(user[2]); %></td></tr>
		<tr><th>Position</th><td><% out.print(user[3]); %></td></tr>
	</table>


</body>
</html>