<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="style/editUser.css">
<link rel="stylesheet" type="text/css" href="style/results.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>FinPOP</title>
</head>
<body>

<% String login = request.getParameter("login"); 
	
		Cookie[] cookies = request.getCookies();

		// Check if the user logged in is the same as the one being viewed
		String storedLogin = null;
		for(Cookie cookie : cookies){
		    if("loginCookie".equals(cookie.getName())){
		        storedLogin = cookie.getValue();
		    }
		}
		if (storedLogin!=(null)){

			%>
			<div id="container">
				<a href="search.jsp"><img id="logo" src="img/logo.png"></img></a>
				<form id="search_form" method="POST" action='SearchController' name="DynamicSearch">
					<input id="search_bar" type="text" name="keyword"
						value="" placeholder="Search Company or Hedgefund">
						<input id="submit_button" type="submit" value="Search" />
				</form>	
					<div id="menu">
					<a href="editUser.jsp">My Account</a>
					<a href="PortfolioController?action=listPortfolio&userId=<%out.print(storedLogin);%>"><%out.print(storedLogin);%>'s Portfolio</a>
					<a href="deleteCookie.jsp">Logout</a></div>
			</div>
<div id="edit-user">
<img id="user-profile-photo" alt="user-profile" src="img/user.png"/>
<h3>Change <%out.print(storedLogin);%>'s Password</h3>
<form action="UserController" method="POST"> 	

			<label><input id="username" name="username" value="<%out.print(storedLogin);%>"></input></label>
			<label>Password:</label></br><input type="password" name="password"></br></br>

<input id="update-user" type="submit" value="Update"> 
</form>
</div>
</body>
      <script src="js/search.js"></script>

<%
		} else {
			%><a id="login_button" href="index.jsp">Login</a><%
			out.print("You are NOT allowed to view private data for " + login + ".");
		}
	%>
</html>