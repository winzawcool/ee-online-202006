<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL Expression</title>
</head>
<body>

	<h1>EL Expression Demo</h1>
	
	<table>
		<tr>
			<td>Request</td>
			<td>
				${ empty requestScope.counter ? 0 : requestScope.counter.count }
			</td>
		</tr>
		<tr>
			<td>Session</td>
			<td>
				${ empty sessionScope.counter ? 0 : sessionScope.counter.count }
			</td>
		</tr>
		<tr>
			<td>Application</td>
			<td>
				${ empty applicationScope.counter ? 0 : applicationScope.counter.count }
			</td>
		</tr>
		<tr>
			<td>Default</td>
			<td>
				${ empty counter ? 0 : counter.count }
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<a href="countUp">Count Up</a>
			</td>
		</tr>
	</table>

</body>
</html>