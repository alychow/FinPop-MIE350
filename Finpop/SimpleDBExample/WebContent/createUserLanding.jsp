<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<title>FinPOP</title>
</head>
<body>

<div style="text-align:center;margin-top:100px;"><%=request.getAttribute("feedback")%></br>
		You Will Be Redirected To The Login Page Shortly</br>
		<img src="img/squares.gif" style="width:50px;"/></div>


</body>
<script>
				$(document).ready(function () {
				    // Handler for .ready() called.
				    window.setTimeout(function () {
				        location.href = "index.jsp";
				    }, 2000);
				});
			</script>
</html>