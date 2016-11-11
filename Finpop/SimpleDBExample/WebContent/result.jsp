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
	
		<h1><c:out value="${company.getCompName()}" /></h1>
					<h3>$<c:out value="${company.getStockPrice()}" /> | <c:out value="${company.getTicker()}" /> | <c:out value="${company.getNation()}" /></h3>

		
	<div>
		
			<div><c:out value="${company.getDesc()}" /></div>
			
	</div>
		<div id="search_results" >The following Companies match your search keyword "<b><%=request.getAttribute("keyword")%></b>":<div>
</body>

</html>