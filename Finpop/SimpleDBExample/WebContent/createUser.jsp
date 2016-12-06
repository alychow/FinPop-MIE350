<html>
<link rel="stylesheet" type="text/css" href="style/createUser.css">
<title>MIE350 Sample DB Web App: Add/Update A User</title>
</head>
<a href="index.jsp"><img id="back-button" src="img/left-arrow.png"/></a>
<body>
<div id="new-user">
<img id="user-profile-photo" alt="user-profile" src="img/user.png"/>
<h3>Create New User</h3>
<form action="UserController" method="get"> 	

			<label>Username:</label></br><input type="text" name="username"></br>
			<label>Password:</label></br><input type="password" name="password"></br>
			<label>First Name:</label></br><input type="text" name="firstname"></br>
			<label>Last Name:</label></br><input type="text" name="lastname"></br></br>

<input id="create-user" type="submit" value="Submit"> 
</form>
</div>
</body>
</html>
