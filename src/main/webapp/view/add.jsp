<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>Add Guest Details</h1>
	<table>
		<s:form action="addGuest" method="post" modelAttribute="b">
		<%-- 	<tr>
				<td>ID</td>
				<td><s:input path="id" /></td>
			</tr> --%>
			<tr>
				<td>NAME</td>
				<td><s:input path="name" /></td>
			</tr>
			<tr>
				<td>Check-in</td>
				<td><s:input type="date" path="check_in" /></td>
			</tr>
			<tr>
				<td>Check-out</td>
				<td><s:input type="date" path="check_out" /></td>
			</tr>
			<tr>
				<td>Room</td>
				<td><s:input type="number" min="1" max="5" path="room" /></td>
			</tr>
			<tr>
				<td>No. of Guest</td>
				<td><s:input type="number" min="1" max="10" path="nosguest" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="ADD" /></td>
			</tr>



		</s:form>

	</table>

</body>
</html>