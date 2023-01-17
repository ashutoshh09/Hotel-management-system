<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<%@include file="components/generalbar.jsp" %>
	<h3>Below is your Booking!!!</h3>
	<!-- <a href="home"><button class="btn btn-primary ">Home</button></a>
	<a href="view"><button class="btn btn-success">Refresh</button></a>
	<a href="add"><button class="btn btn-warning">Add</button></a>
	<a href="alluser"><button class="btn btn-info">All User</button></a>
	<hr /> -->
	<%-- <h3>${msg}</h3> --%>
	
	<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong>${msg}</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
<!-- 	<div style="width: 800px"> -->
	<div class="container">
		<table class="table table-striped table-bordered" style="width: 100%">
			<tr>
				<th>Guest ID</th>
				<th>Guest Name</th>
				<th>Check-in</th>
				<th>Check-out</th>
				<th>Room</th>
				<th>Guest</th>
				<th>Update</th>
				<th>Delete</th>
				<th>Bill</th>
			</tr>
			<c:forEach items="${b}" var="guest">
				<tr>
					<td>${guest.getId()}</td>
					<td>${guest.getName()}</td>
					<td>${guest.getCheck_in()}</td>
					<td>${guest.getCheck_out()}</td>
					<td>${guest.getRoom()}</td>
					<td>${guest.getNosguest()}</td>
					<td><a
						href="update?id=${guest.getId()}&name=${guest.getName()}&check_in=${guest.getCheck_in()}&check_out=${guest.getCheck_out()}&room=${guest.getRoom()}&nosguest=${guest.getNosguest()}">Update</a></td>
					<td><a href="delete?id=${guest.getId()}">Delete</a></td>
					<td><a href="bill?id=${guest.getId()}&name=${guest.getName()}&check_in=${guest.getCheck_in()}&check_out=${guest.getCheck_out()}&room=${guest.getRoom()}&nosguest=${guest.getNosguest()}">Generate Bill</a></td>
				</tr>


			</c:forEach>



		</table>
	</div>
	



</body>
</html>