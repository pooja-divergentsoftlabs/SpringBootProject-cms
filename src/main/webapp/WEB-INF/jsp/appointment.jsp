<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Appointment</title>

<script src="static/js/bootstrap.min.js"></script>
<link href="static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="app"
							method="POST">
							<fieldset>

								<!-- Form Name -->
								<legend>Appointment Add</legend>
								
								

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="name">Name</label>
									<div class="col-md-4">
										<input id="name" name="name" type="text" placeholder=""
											class="form-control input-md">

									</div>
								

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="date">Date</label>
									<div class="col-md-4">
										<input id="date" name="date" type="text" placeholder=""
											class="form-control input-md">

									</div>
								
								
								
								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info"
											value="Add Appointment">
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-md-6">
					<legend>Appointment List</legend>
						<div class="table-responsive">
							<table id="example" class="table table-striped table-bordered">							
							<thead>
								<tr>
								
									<th>Name</th>
									<th>Date</th>
									<th>Action</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allAppointments}" var="appointment">
									<tr>
										
										<td><c:out value="${appointment.name}" /></td>
										<td><c:out value="${appointment.date}" /></td>							
										<td><a href="app/remove?appointmentId=${appointment.id}"
											class="btn btn-danger" type="button">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
					</div>
					<div class="col-md-6"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>