<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookies Demo</title>
</head>
<body>
	<h1>Cookies Demo</h1>
	<%
		Object object = request.getAttribute("name");
		
		if(null != object) {
			String name = object.toString();
			
		%>
			User Name is : <%= name %>
		<% 
		} else {
			
		%>
			<form action="cookies" method="post">
				<input placeholder="Enter Name" name="name" />
				<input type="submit" value="Send" />
			</form>
		<% 
		}
	%>
</body>
</html>