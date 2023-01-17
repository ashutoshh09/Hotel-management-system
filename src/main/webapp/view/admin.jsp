
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<style>
body {
	background-color: powderblue;
}

h1 {
	color: blue;
}

p {
	color: red;
}

.custom-bg {
	background: #673ab7 !important;
}

.admin .card {
	border: 1px solid red;
}

.admin .card:hover {
	background: #e2e2e2;
	cursor: pointer;
}
</style>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<link rel="stylesheet" href="css/style.css">

<%@include file="components/common_css_js.jsp"%>

</head>
<body>
	<%@include file="components/userbar.jsp"%>

	<div class="container admin">
		<div class="container-fluid">
			<%
			String msg = (String) session.getAttribute("message");

			if (msg != null) {

				//	out.println(message);
			%>

			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong><%=msg%></strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>


			<%
			session.removeAttribute("message");

			}
			%>
		</div>
		<div class="row mt-3">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<a href="alluser"> <img style="max-width: 125px"
								class="img-fluid rounded-circle"
								src="https://cdn-icons-png.flaticon.com/512/1165/1165674.png"
								alt="user_icon"></a>
						</div>
						<h1>Users</h1>

					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<a href="showGuests"> <img style="max-width: 125px"
								class="img-fluid rounded-circle"
								src="https://cdn-icons-png.flaticon.com/512/3284/3284589.png"
								alt="user_icon"></a>
						</div>
						<h1>Guests</h1>

					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
						<a href="services">	<img style="max-width: 125px" class="img-fluid rounded-circle"
								src="https://cdn-icons-png.flaticon.com/512/950/950237.png"
								alt="user_icon"></a>
						</div>
						<h1>Services</h1>

					</div>
				</div>

			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-6">

				<div class="card" data-toggle="modal" data-target="#add-guest-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 125px" class="img-fluid rounded-circle"
								src="https://cdn-icons-png.flaticon.com/512/5775/5775810.png"
								alt="user_icon">
						</div>
						<h1>Add Guest</h1>

					</div>
				</div>


			</div>

			<div class="col-md-6">

				<div class="card" data-toggle="modal"
					data-target="#add-service-modal">

					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 125px" class="img-fluid rounded-circle"
								src="https://cdn-icons-png.flaticon.com/512/8479/8479645.png"
								alt="user_icon">
						</div>
						<h1>Add Services</h1>

					</div>
				</div>



			</div>

		</div>

	</div>

	<!--add guest  -->

	<!-- Button trigger modal -->




	<!-- Modal -->
	<div class="modal fade" id="add-guest-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">Fill guest
						details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<form action="addGuest" method="post" modelAttribute="b">
						<div class="form-group">
							<input type="text" class="form-control" name="name"
								placeholder="Enter name" required />
						</div>
						<div class="form-group">
							<input type="date" class="form-control" name="check_in"
								placeholder="Enter Check in" required />
						</div>
						<div class="form-group">
							<input type="date" class="form-control" name="check_out"
								placeholder="Enter Check out" required />
						</div>
						<div class="form-group">
							<input type="number" min="1" max="5" class="form-control"
								name="room" placeholder="Enter Rooms" required />
						</div>
						<div class="form-group">
							<input type="number" min="1" max="10" class="form-control"
								name="nosguest" placeholder="Enter no. of guest" required />
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">Add Guest</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>

						</div>

					</form>

				</div>

			</div>
		</div>
	</div>

	<!-- add service -->

	<div class="modal fade" id="add-service-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">Fill Service
						details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<form action="addService" method="post" modelAttribute="b">
						<div class="form-group">
							<input type="text" class="form-control" name="servicename"
								placeholder="Enter service" required />
						</div>
						<div class="form-group">
							<textarea style="height: 200px" class="form-control"
								name="servicedesc" placeholder="Enter service description"
								required /></textarea>
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="contact"
								placeholder="Enter contact number" required />
						</div>


						<div class="container text-center">
							<button class="btn btn-outline-success">Add Service</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>

						</div>

					</form>

				</div>

			</div>
		</div>
	</div>
	<!-- end service -->

	<!--end add guest  -->

	<!--change password  -->

	<div class="modal fade" id="change-password-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">Update Password</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<form action="changepassword" method="post" modelAttribute="b">
						<div class="form-group">
							<input type="password" class="form-control" name="pr_password"
								placeholder="Enter old password" required />
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="new_password"
								placeholder="Enter new password" required />
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">Change Password</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>

						</div>

					</form>

				</div>

			</div>
		</div>
	</div>

	<!--end password  -->

	<!-- show user  -->





	<!--end user  -->


</body>
</html>