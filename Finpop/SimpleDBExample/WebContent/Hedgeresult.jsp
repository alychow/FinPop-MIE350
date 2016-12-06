<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="style/results.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<title>FinPOP</title>
</head>
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
<body>
<div class="page">
	<div id="search_results" >The following Hedgefunds match your search keyword "<b><%=request.getAttribute("keyword")%></b>":</div>
	
	<div class="hedgefund">
			<h1><c:out value="${hedgefund.getHedgeName()}" /></h1>
			<h3><c:out value="${hedgefund.getCountry()}" /> | <c:out value="${hedgefund.getHQ()}" /></h3>
			<div><c:out value="${hedgefund.getDesc()}" /></div>
			<h4 class="table_title">Companies that <c:out value="${hedgefund.getHedgeName()}" /> is currently invested in as of <%=new java.util.Date()%></h4>
			<table class="result_table" border=0>
			<thead>
				<tr>
					<th>Company Name</th>
					<th>Ticker</th>
					<th>Number of Shares Owned</th>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${compList}" var="comp">
				<tr>
							<td align="center"><c:out value="${comp.getCompanyName()}" /></td>
							<td align="center"><c:out value="${comp.getTicker()}" /></td>
							<td align="center"><c:out value="${comp.getSharesOwned()}" /></td>
				</tr>
						
			</c:forEach>
			</tbody>
			</table>
	</div>
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