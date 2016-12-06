<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="style/results.css">
<link rel="stylesheet" type="text/css" href="style/aboutUs.css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resources</title>
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
					<a href="resources.jsp">Resource</a>	
					<a href="aboutUs.jsp">About Us</a>				
					<a href="editUser.jsp">My Account</a>
					<a href="PortfolioController?action=listPortfolio&userId=<%out.print(storedLogin);%>"><%out.print(storedLogin);%>'s Portfolio</a>
					<a href="deleteCookie.jsp">Logout</a>
					</div>
			</div>
			<div id="resources" class="page">
			
<p><strong>Helpful and Useful Resources</strong></p>
<p><span style="font-weight: 400;">The following are a collection of links that could help you base your investment decisions for further information.</span></p>
<p>&nbsp;</p>
<p><strong>Bloomberg Markets</strong></p>
<p><a href="http://www.bloomberg.com/markets"><span style="font-weight: 400;">http://www.bloomberg.com/markets</span></a></p>
<p>&nbsp;</p>
<p><strong>Wall Street Journal Markets</strong></p>
<p><a href="http://www.wsj.com/news/markets"><span style="font-weight: 400;">http://www.wsj.com/news/markets</span></a></p>
<p>&nbsp;</p>
<p><strong>Google Finance</strong></p>
<p><a href="https://www.google.ca/finance?hl=en&amp;gl=ca"><span style="font-weight: 400;">https://www.google.ca/finance?hl=en&amp;gl=ca</span></a></p>
<p>&nbsp;</p>
<p><strong>Yahoo Finance</strong></p>
<p><a href="https://ca.finance.yahoo.com/"><span style="font-weight: 400;">https://ca.finance.yahoo.com/</span></a></p>
<p>&nbsp;</p>
<p><strong>SEC Company Search</strong></p>
<p><a href="https://www.sec.gov/edgar/searchedgar/companysearch.html"><span style="font-weight: 400;">https://www.sec.gov/edgar/searchedgar/companysearch.html</span></a></p>
<p>&nbsp;</p>
<p><strong>Investopedia - Beginner Investor Knowledge</strong></p>
<p><a href="http://www.investopedia.com/"><span style="font-weight: 400;">http://www.investopedia.com/</span></a></p>
<p><br /><br /></p>
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