<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Invalid Login</title>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f5f5f5;
	font-family: Arial, sans-serif;
}

.container {
	text-align: center;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.message {
	font-size: 24px;
	color: red;
	margin-bottom: 20px;
}

.back-button {
	padding: 10px 20px;
	font-size: 16px;
	color: #fff;
	background-color: #007bff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.back-button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<p class="message">Successfully registered</p>
		<!-- Button to redirect back to another page -->
		<button class="back-button"
			onclick="window.location.href='index.html'">Back</button>
	</div>
</body>
</html>