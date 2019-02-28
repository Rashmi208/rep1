<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%
String message=(String)session.getAttribute("invalidUser");
if(message != null)
		out.println("<b>" + message + "</b>");
session.removeAttribute("invalidUser");
%>

	<form method="post" action="login.form">
		User Name: <input type="text" name="username"><br>
		<br> Password: <input type="password" name="password"><br>
		<br> 

		<button type="submit">Login</button>
	</form>

</body>
</html>