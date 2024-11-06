<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mountblue.model.Usermodel"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User List and Archived User List</title>
<style>
table {
	width: 70%;
	border-collapse: collapse;
	margin: 50px auto;
}

th, td {
	padding: 10px;
	border: 1px solid #ddd;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

.back-button, .archive-button, .activate-button {
	margin: 5px;
	padding: 10px 20px;
	font-size: 16px;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	text-align: center;
	transition: background-color 0.3s;
}

.back-button {
	background-color: #4CAF50;
	display: block;
	margin: 20px auto;
}

.back-button:hover {
	background-color: #45a049;
}

.archive-button {
	background-color: #f44336;
}

.archive-button:hover {
	background-color: #e53935;
}

.activate-button {
	background-color: #2196F3;
}

.activate-button:hover {
	background-color: #1e88e5;
}
</style>
</head>
<body>
	<h2 style="text-align: center">User List</h2>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			@SuppressWarnings("unchecked")
			List<Usermodel> userList = (List<Usermodel>) request.getAttribute("userList");
			if (userList != null) {
				for (Usermodel user : userList) {
			%>
			<tr>
				<td><%=user.getFullname()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getMessage()%></td>
				<td>
					<form action="Adminlogin" method="post">
                <input type="hidden" name="action" value="archive">
                <input type="hidden" name="requestId" value="<%= user.getId() %>">
                <button type="submit" class="archive-btn">Archive</button>
            </form>
				</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="4">No users found.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<h2 style="text-align: center">Archived User List</h2>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			@SuppressWarnings("unchecked")
			List<Usermodel> archivedUserList = (List<Usermodel>) request.getAttribute("archievedUserList");
			if (archivedUserList != null) {
				for (Usermodel user : archivedUserList) {
			%>
			<tr>
				<td><%=user.getFullname()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getMessage()%></td>
				<td>
					<form action="Adminlogin" method="post">
                <input type="hidden" name="action" value="active">
                <input type="hidden" name="requestId" value="<%=user.getId() %>">
                <button type="submit" class="archive-btn">Active</button>
            </form>
				</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="4">No archived users found.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<button class="back-button" onclick="window.location.href='index.html'">Back</button>
</body>
</html>
