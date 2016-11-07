<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link rel="stylesheet" type="text/css" href="style/theme.css">
<link rel="stylesheet" type="text/css" href="style/search.css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<title>MIE350 Sample DB Web App</title>
</head>
<body>
		<a id="login_button" href="">Login</a>

<%-- 	<%@ include file="navbar.jsp"%>.
 --%>	
 <div class="search_logo">
	<img id="logo" src="img/logo.png"></img>
	
	<div class="container">
			<form id="search_form" method="POST" action='SearchController' name="frmAddUser">
				<label for="tags"><input id="search_bar" type="text" name="keyword"
					value="" placeholder="Search Company or Ticker"></label>
					<input id="submit_button" type="submit" value="Search" />
			</form>
		</div>
	</div>
	
</body>
      <script src="js/search.js"></script>


</html>