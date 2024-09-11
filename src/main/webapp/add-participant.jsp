
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Participant - FunFit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 50px;
        }
        .container {
            max-width: 600px;
        }
        h2 {
            color: #343a40;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .alert {
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <img src="${pageContext.request.contextPath}/images/freelogo.png"
					alt="FunFit Logo" class="img-thumbnail" width="75" height="75">
        <a class="navbar-brand" href="#">FunFit</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="add-participant.jsp">Add Participant</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="add-batch.jsp">Add Batch</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="view-participants.jsp">View Participants</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="view-batches.jsp">View Batches</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
    	
        <h2>Add Participant</h2>
        
        <%-- Display success or error messages --%>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">
                <c:out value="${successMessage}"/>
            </div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">
                <c:out value="${errorMessage}"/>
            </div>
        </c:if>
        
        <form action="AddParticipantServlet" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" class="form-control" id="phone" name="phone">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="bid">Batch ID:</label>
                <input type="number" class="form-control" id="bid" name="bid" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Participant</button>
        </form>
		<c:if test="${not empty successMessage}">
        	<p style="color: green;">${successMessage}</p>
    	</c:if>
    
    	<c:if test="${not empty errorMessage}">
        	<p style="color: red;">${errorMessage}</p>
    	</c:if>
    	
        <br>
        <a class="btn btn-secondary" href="index.jsp">Back to Home</a>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
