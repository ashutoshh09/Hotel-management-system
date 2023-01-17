<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${name}bill</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>


	<%@include file="components/generalbar.jsp"%>
	
	<!-- <a href="home"><button class="btn btn-primary ">Home</button></a>
	<a href="view"><button class="btn btn-success">Refresh</button></a>
	<a href="add"><button class="btn btn-warning">Add</button></a>
	<a href="alluser"><button class="btn btn-info">All User</button></a> -->
	<hr />

	<!-- <div style="width: 800px"> -->
		<div class="container">
		<h4>Below ${name} Bill Available!!!</h4>
			<table class="table table-hover">
				<tr>
					<th>Guest ID</th>
					<th>Guest Name</th>
					<th>Check-in</th>
					<th>Check-out</th>
					<th>Room</th>
					<th>Guest</th>


				</tr>

				<tr>
					<td>${id}</td>
					<td>${name}</td>
					<td>${check_in}</td>
					<td>${check_out}</td>
					<td>${room}</td>
					<td>${nosguest}</td>
				</tr>





			</table>
			<h3>Amount: &#x20b9;${result}</h3>
		</div>
	


</body>
</html>