<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Please login:</h2>
		<form action="">
			Email: <input type="text" size="20"><br /> <br /> Password: <input
				type="password" size="15" /> <br />
			<br /> <input type="submit" value="Login" />
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>