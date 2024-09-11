

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Participants - FunFit</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 150px;
}

.container {
	max-width: 1200px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<img src="${pageContext.request.contextPath}/images/freelogo.png"
			alt="FunFit Logo" class="img-thumbnail" width="75" height="75">
		<a class="navbar-brand" href="#">FunFit</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
				</li>
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
		<h2>Participant Records</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Batch ID</th>
				</tr>
			</thead>

			<tbody id="participantTableBody">
				<!-- Participant rows will be injected here by JS -->
			</tbody>
		</table>
		<a class="btn btn-secondary" href="index.jsp">Back to Home</a>
	</div>
	<script>
document.addEventListener('DOMContentLoaded', function() {
    function loadParticipants() {
        fetch('${pageContext.request.contextPath}/view-participants')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(participants => {
                const participantTableBody = document.getElementById('participantTableBody');
                participantTableBody.innerHTML = ''; // Clear existing rows

                participants.forEach(participant => {
                    // Create table row
                    const row = document.createElement('tr');

                    // Create table cells
                    const idCell = document.createElement('td');
                    idCell.textContent = participant.pid;
                    row.appendChild(idCell);

                    const nameCell = document.createElement('td');
                    nameCell.textContent = participant.name;
                    row.appendChild(nameCell);

                    const phoneCell = document.createElement('td');
                    phoneCell.textContent = participant.phone;
                    row.appendChild(phoneCell);

                    const emailCell = document.createElement('td');
                    emailCell.textContent = participant.email;
                    row.appendChild(emailCell);

                    const batchIdCell = document.createElement('td');
                    batchIdCell.textContent = participant.bid;
                    row.appendChild(batchIdCell);

                    // Append row to table body
                    participantTableBody.appendChild(row);
                });
            })
            .catch(error => console.error('Failed to fetch participants:', error));
    }

    loadParticipants();
});

</script>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
