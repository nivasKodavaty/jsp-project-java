<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Submit Form to Servlet</title>
</head>
<body>
	<h2>Enter Your Details</h2>
	<form action="Adminlogin" method="get">
		<label for="adminname">Username:</label> <input type="text"
			id="adminname" name="adminname" required><br>
		<br> <label for="password">Password:</label> <input type="text"
			id="password" name="password" required><br>
		<br>
		
		<button type="submit">Submit</button>
	</form>
</body>
</html>