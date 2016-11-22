<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Users</title>
</head>
<body>

	<%@ include file="data.jsp"  %>

	
	<h2>List Users</h2>

	<p><a href="login.jsp">Login</a> | <a href="deleteSession.jsp">Logoff Session</a> | <a href="deleteCookie.jsp">Logoff Cookie</a></p>
	
	<table border=1 cellpadding=2>
		<tr>
			<th>User Id</th>
			<th>Name</th>
			<th>Position</th>
			<th colspan=2></th>
		</tr>
		<%
		for (String key: keys){
    			String[] user = (String[])users.get(key);
	    		out.print("<tr>");
    				out.print("<td align='center'>"+ user[0]+"</td>");
    				out.print("<td align='center'>"+ user[2]+"</td>");
    				out.print("<td align='center'>"+ user[3]+"</td>");
				out.print("<td align='center'><a href='public.jsp?login="+ user[0] +"'>Public</a></td>");
				out.print("<td align='center'><a href='private.jsp?login="+ user[0] +"'>Private</a></td>");
	   		out.print("</tr>");
		} %>
	</table>

</body>
</html>