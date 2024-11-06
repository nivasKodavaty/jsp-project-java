<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- form.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Submit Form to Servlet</title>
</head>
<body>
	<h2>Enter Your Details</h2>
	<form action="Mountbluecontroller" method="post">
		<label for="fullname">Name:</label> <input type="text" id="fullname"
			name="fullname" required><br>
		<br> <label for="email">Email:</label> <input type="email"
			id="email" name="email" required><br>
		<br> <label for="message">Message:</label> <input type="text"
			id="message" name="message" required><br>
		<br>

		<button type="submit">Submit</button>
	</form>
</body>
</html>
