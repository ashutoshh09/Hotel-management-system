<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>User Page</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/userbar.jsp"%>

<div class="container admin">
	<%@include file="components/message.jsp"%>

	

	<div class="row mt-3">
		<div class="col-md-4">
			<div class="card">
				<div class="card-body text-center">
					<div class="container">
						<a href="userdetail"> <img style="max-width: 125px"
							class="img-fluid rounded-circle"
							src="https://cdn-icons-png.flaticon.com/512/1077/1077012.png"
							alt="user_icon"></a>
					</div>
					<h1>User</h1>

				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-body text-center">
					<div class="container">
						<a href="booking"> <img style="max-width: 125px"
							class="img-fluid rounded-circle"
							src="https://cdn-icons-png.flaticon.com/512/2664/2664669.png"
							alt="user_icon"></a>
					</div>
					<h1>Booking</h1>

				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-body text-center">
					<div class="container">
						<a href="servicesinfo"> <img style="max-width: 125px"
							class="img-fluid rounded-circle"
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
							src="https://cdn-icons-png.flaticon.com/512/5511/5511414.png"
							alt="user_icon">
					</div>
					<h1>Book A Stay</h1>

				</div>
			</div>


		</div>

		<div class="col-md-6">

			<div class="card" data-toggle="modal" data-target="#feedback-modal">

				<div class="card-body text-center">
					<div class="container">
						<img style="max-width: 125px" class="img-fluid rounded-circle"
							src="https://cdn-icons-png.flaticon.com/512/2546/2546749.png"
							alt="user_icon">
					</div>
					<h1>FeedBack</h1>

				</div>
			</div>



		</div>

	</div>
	</div>


	<!--  Password-->


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

					<form action="userchangepassword" method="post" modelAttribute="b">
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


	<!--book stay  -->


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

					<form action="bookastay" method="post" modelAttribute="b">
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




	<!-- end stay -->


	<!-- feedback -->

	<div class="modal fade" id="feedback-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">Guest Feedback Form</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<!-- <form action="addService" method="post" modelAttribute="b">
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

					</form> -->

					<form class="form-inline" method="post">
						<select class="custom-select my-1 mr-sm-2"
							id="inlineFormCustomSelectPref">
							<option selected>Check-in experience</option>
							<option value="1">Excellent</option>
							<option value="2">Good</option>
							<option value="3">Fair</option>
							<option value="4">Poor</option>
						</select>
						
						<select class="custom-select my-1 mr-sm-2"
							id="inlineFormCustomSelectPref">
							<option selected>Cleanliness</option>
							<option value="1">Excellent</option>
							<option value="2">Good</option>
							<option value="3">Fair</option>
							<option value="4">Poor</option>
						</select>
						
						<select class="custom-select my-1 mr-sm-2"
							id="inlineFormCustomSelectPref">
							<option selected>Housekeeping</option>
							<option value="1">Excellent</option>
							<option value="2">Good</option>
							<option value="3">Fair</option>
							<option value="4">Poor</option>
						</select>
						
						
						<select class="custom-select my-1 mr-sm-2"
							id="inlineFormCustomSelectPref">
							<option selected>Staff Service</option>
							<option value="1">Excellent</option>
							<option value="2">Good</option>
							<option value="3">Fair</option>
							<option value="4">Poor</option>
						</select>
						
						<select class="custom-select my-1 mr-sm-2"
							id="inlineFormCustomSelectPref">
							<option selected>Restaurant Food</option>
							<option value="1">Excellent</option>
							<option value="2">Good</option>
							<option value="3">Fair</option>
							<option value="4">Poor</option>
						</select>
						
						<select class="custom-select my-1 mr-sm-2"
							id="inlineFormCustomSelectPref">
							<option selected>Amenities</option>
							<option value="1">Excellent</option>
							<option value="2">Good</option>
							<option value="3">Fair</option>
							<option value="4">Poor</option>
						</select>
						
						<select class="custom-select my-1 mr-sm-2"
							id="inlineFormCustomSelectPref">
							<option selected>Overall Hotel Rating</option>
							<option value="1">Excellent</option>
							<option value="2">Good</option>
							<option value="3">Fair</option>
							<option value="4">Poor</option>
						</select>

						<div class="custom-control custom-checkbox my-1 mr-sm-2">
							<input type="checkbox" class="custom-control-input"
								id="customControlInline"> <label
								class="custom-control-label" for="customControlInline">Remember
								my preference</label>
						</div>

						<button type="submit" class="btn btn-primary my-1">Submit</button>
					</form>



				</div>

			</div>
		</div>
	</div>

	<!-- end feedback -->
</body>
</html>