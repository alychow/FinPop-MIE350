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

	<div id="search_results" >The following Companies match your search keyword "<b><%=request.getAttribute("keyword")%></b>":</div>			
		
	<div class="company">
			<img id="company_logo" src="<c:out value="${company.getLogoURL()}" />"/>
			<h1 id="company_name"><c:out value="${company.getCompName()}" /></h1>
			<h3>$<c:out value="${company.getStockPrice()}" /> | <c:out value="${company.getTicker()}" /> | <c:out value="${company.getNation()}" /></h3>
			<div><c:out value="${company.getDesc()}" /></div>
			<h4 class="table_title">Hedgefunds that are currently invested in <c:out value="${company.getCompName()}"/> as of <%=new java.util.Date()%></h4>
			<c:forEach items="${hedgeList}" var="hedgeFund">
						<div id="hedgeInvests"><c:out value="${hedgeFund.getHedgeName()}" /></div>
			</c:forEach>
			<form id="add_to_portfolio" method="POST" action='PortfolioController&<c:out value="${company.getCompName()}" />&<c:out value="${company.getTicker()}" />&<%out.print(storedLogin);%>' name="add_to_portfolio">
					<input id="number_of_shares" type="text" name="number"
						 placeholder="Number of Shares of <c:out value="${company.getCompName()}" />">
						<input id="add_button" type="submit" value="Add to Portfolio" />
			</form>	
	</div>
	</div>
</body>
      <script src="js/search.js"></script>
            <script src="js/addtoPortfolio.js"></script>
      

<%
		} else {
			%><a id="login_button" href="index.jsp">Login</a><%
			out.print("You are NOT allowed to view private data for " + login + ".");
		}
	%>

</html>