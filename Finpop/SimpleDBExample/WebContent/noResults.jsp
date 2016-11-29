<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
					<div id="menu"><a href="PortfolioController?action=listPortfolio&userId=<%out.print(storedLogin);%>"><%out.print(storedLogin);%>'s Portfolio</a>
					<a href="deleteCookie.jsp">Logout</a></div>
			</div>
			<div class="page">
			
				<div id="search_results" >No Companies or Hedgefunds match your search keyword "<b><%=request.getAttribute("keyword")%></b>"</div>			
			</div>
							<img style="border-radius:500px;width:500px;position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);" src="img/team.png"/>
			
</body>
<%
		} else {
			%><a id="login_button" href="index.jsp">Login</a><%
			out.print("You are NOT allowed to view private data for " + login + ".");
		}
	%>

</html>