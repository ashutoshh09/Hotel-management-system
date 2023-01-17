<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="r"%>
<!DOCTYPE html>
<html>
<head>
<%-- <%@ page isELIgnored="false"%> --%>
<meta charset=ISO-8859-1">
<title>Hotel Management System</title>

<!-- refrence our style sheet  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>


	<a href="home">Home</a>
	<hr />
	<table>
		<r:form action="login" method="post" modelAttribute="b">
			<tr>
				<td>Email</td>
				<td><r:input  path="email"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><r:input  path="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="login" /></td>
			</tr>
		</r:form>
	</table>


</body>
</html>



