<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	
	You have been logged out <br/><br/>
	
	Go back to the <a href="index.jsp">login page</a>.</br>


</body>
</html>