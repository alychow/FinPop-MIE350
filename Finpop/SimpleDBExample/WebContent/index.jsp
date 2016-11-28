<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/login.css">

<title>Login</title>
</head>
<body>

<div id="login">
	<img id="login-logo" src="img/logo.png"></img>	
	<form id="login-form" action="loginCookie.jsp" method="post">
		<label>Username:</label> <br/><input type="text" name="loginParameter" />
		<br/>		<br/>
		
		<label>Password:</label> <br/><input type="text" name="pswdParameter" />
		<br/>
				<br/>
		
		<input id="login-button" type="submit" value="Login" />
		
	</form>
	<a href="createUser.jsp">Sign Up</a>
	</div>

</body>
</html>