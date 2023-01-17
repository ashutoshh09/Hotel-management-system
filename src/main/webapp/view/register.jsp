<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>Registration Page</h1>
	<table>
		<s:form action="./registeruser" method="post" modelAttribute="b">
			<%-- <tr>
				<td>ID</td>
				<td><s:input path="id" value="${id}" /></td>
			</tr> --%>
			<%-- <tr>
				<td>Check-in</td>
				<td><s:input type="date" path="check_in" /></td>
			</tr> --%>
			<tr>
				<td>NAME</td>
				<td><s:input path="name" /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><s:input path="mobile" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><s:input  path="email"  /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:input  path="password"  /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><s:input path="address"  /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="ADD" /></td>
			</tr>



		</s:form>

	</table>
</body>
</html>