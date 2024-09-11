<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FunFit - Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">

<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 15px;
}

.container {
	max-width: 600px;
}

h1 {
	color: #343a40;
}

.btn {
	margin: 5px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<img src="${pageContext.request.contextPath}/images/freelogo.png"
			alt="FunFit Logo" class="img-thumbnail" width="75" height="75">
		<a class="navbar-brand mb-0 h1" href="#">FunFit</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="add-participant.jsp">Add Participant</a></li>
				<li class="nav-item"><a class="nav-link" href="add-batch.jsp">Add
						Batch</a></li>
				<li class="nav-item"><a class="nav-link"
					href="view-participants.jsp">View Participants</a></li>
				<li class="nav-item"><a class="nav-link"
					href="view-batches.jsp">View Batches</a></li>
			</ul>
		</div>
	</nav>





	<div class="container">
		<div class="row">
			

			<div class="col">

				<h1>Welcome to FunFit</h1>
				<p class="lead">Manage your fitness program easily with FunFit.
					Use the navigation bar to add new participants or batches, and view
					existing records.</p>

				<img src="${pageContext.request.contextPath}/images/dancing.png"
					alt="FunFit Logo" class="img-fluid">
				<div class="row">
					<div class="col">
						<a class="btn btn-primary btn-lg btn-block"
							href="add-participant.jsp">Add Participant</a>
					</div>
					<div class="col">
						<a class="btn btn-secondary btn-lg btn-block" href="add-batch.jsp">Add
							Batch</a>
					</div>
				</div>


			</div>
			
			<div class="col">
				<img src="${pageContext.request.contextPath}/images/dancehair.jpg"
				alt="FunFit Logo" class="img-fluid">
					<p>
					<strong>FunFit</strong> is a comprehensive fitness management web
					application designed to simplify the process of managing fitness
					programs, participants, and batches. Whether you are a fitness
					instructor or program manager, FunFit offers an intuitive platform
					for organizing and tracking participants and their assigned
					batches.
				</p>
					<h3>How to Use FunFit:</h3>
					<ul>
					<li><strong>Navigation</strong>: Use the top navigation bar to
						access different sections.</li>
					<li><strong>Adding Participants</strong>: Go to the 'Add
						Participant' page and fill out the required details.</li>
					<li><strong>Adding Batches</strong>: Visit the 'Add Batch'
						page to create new batches.</li>
					<li><strong>Viewing Records</strong>: Check 'View
						Participants' or 'View Batches' to see the records.</li>
				</ul>
			</div>
		</div>
	</div>








	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
