<%@page import="com.jdc.students.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />

<script src="/resources/js/jquery.min.css"></script>
<script src="/resources/js/popper.min.css"></script>
<script src="/resources/js/bootstrap.min.css"></script>
</head>
<body>
	<div class="container">
		<h1>Student List</h1>

		<!-- Search  -->
		<form class="form-inline mt-4">

			<div class="form-group mr-4">
				<label class="mr-2">Name</label>
				<input name="name" type="text" class="form-control" placeholder="Search Name"/>
			</div>
			
			<div class="form-group mr-4">
				<label class="mr-2">Phone</label>
				<input name="phone" type="text" class="form-control" placeholder="Search Phone"/>
			</div>
			
			<div class="form-group">
				<button class="btn btn-primary mr-2">Search</button>
				
				<a class="btn btn-danger" href="student-add">Add New Student</a>
			</div>
		</form>

		<!-- Result Table -->
		<table class="table table-bordered mt-4">
		
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
				</tr>
			</thead>
			
			<tbody>
			
				<%
					@SuppressWarnings("unchecked")
					List<Student> list = (List<Student>)request.getAttribute("list"); %>
				<% for(int i=0; i < list.size(); i++) { %>
					<tr>
						<td><%= list.get(i).getId() %></td>
						<td><%= list.get(i).getName() %></td>
						<td><%= list.get(i).getPhone() %></td>
						<td><%= list.get(i).getEmail() %></td>
						<td><%= list.get(i).getAddress() %></td>
					</tr>
				<% } %>
				
			</tbody>
		</table>
	</div>

</body>
</html>