<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>

	<%@ include file="data.jsp"  %>

	<h2>Login Page</h2>
	
	<p><a href="listUsers.jsp">ListUsers</a></p>


	<h3>Cookie Login</h3>
	<form action="loginCookie.jsp" method="post">
		Login: <input type="text" name="loginParameter" />
		<br/>
		Pswd: <input type="text" name="pswdParameter" />
		<br />
		<input type="submit" />
		
	</form>


	<h3>Session Login</h3>

	<form action="loginSession.jsp" method="post">
		Login: <input type="text" name="loginParameter" />
		<br/>
		Pswd: <input type="text" name="pswdParameter" />
		<br />
		<input type="submit" />
		
	</form>
	

</body>
</html>