<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="style/theme.css">
<link rel="stylesheet" type="text/css" href="style/search.css">


<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>MIE350 Sample DB Web App</title>
</head>
<body>
<%-- 	<%@ include file="navbar.jsp"%>.
 --%>	
 <div class="search_logo">
	<img id="logo" src="img/logo.png"></img>
	
	<div class="container">
			<form method="POST" action='SearchController' name="frmAddUser">
				<input id="search_bar" type="text" name="keyword"
					value="<c:out value="${user.searchword}" />">
					<input id="submit_button" type="submit" value="Search" />
			</form>
		</div>
	</div>
</body>
</html>