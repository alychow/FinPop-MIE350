<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="style/results.css">

<title>FinPOP</title>
</head>
<body>
	
		<h1><c:out value="${hedgefund.getHedgeName()}" /></h1>
					<h3><c:out value="${hedgefund.getCountry()}" /> | <c:out value="${hedgefund.getHQ()}" /></h3>

		
	<div>
			<br>
			<div><c:out value="${hedgefund.getDesc()}" /></div>
			<h4>Companies that <c:out value="${hedgefund.getHedgeName()}" /> is currently invested in as of <%=new java.util.Date()%></h4>
			<table border=0 style="width:100%;">
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
		<div id="search_results" >The following Hedgefunds match your search keyword "<b><%=request.getAttribute("keyword")%></b>":<div>
</body>

</html>