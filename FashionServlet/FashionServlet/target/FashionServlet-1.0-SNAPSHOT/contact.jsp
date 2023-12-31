<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - DG Fashion</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/custom.css"/>
    <%
        request.setAttribute("page", "contact");
    %>
    <style>
        /* Add custom styles here */
        .jumbotron {
            background-size: cover;
            color: white;
        }
        .section {
            padding: 50px 0;
        }
        .section-heading {
            font-size: 30px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<%@include file="common/navbar.jsp" %>
<div class="jumbotron jumbotron-fluid text-center">
    <div class="container">
        <h1 class="display-4">Contact Us</h1>
        <p class="lead">We'd love to hear from you! Reach out to us with your queries.</p>
    </div>
</div>

<div class="col-12"
    <div id="alertsContainer"></div>         
</div>

<div class="container section">
    <h2 class="section-heading">Get in Touch</h2>
    <div class="row">
        <div class="col-md-6">
            <form action="#" id="contactus" method="post">
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="query" class="form-label">Your Query</label>
                    <textarea class="form-control" id="query" name="query" rows="5" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col-md-6">
            <h4>Our Details</h4>
            <p><strong>Address:</strong> Athwagate, Surat</p>
            <p><strong>Email:</strong> ganatradeep9@gmail.com</p>
            <p><strong>Phone:</strong> +91 94292 67032</p>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>

<!-- Include Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
    $("#contactus").submit(function(e){
        e.preventDefault();
        displayAlert("success", "Your data has been received by us. We will contact you soon.", 3000);
        $(this)[0].reset();
    });
    
    function displayAlert(type, message, duration) {
        var alertHtml = `
            <div class="alert alert-`+ type +` alert-dismissible fade show" role="alert">
                `+ message +`
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `;

        $('#alertsContainer').html(alertHtml);
        
        setTimeout(function() {
            $('#alertsContainer .alert').alert('close');
        }, duration);
    }
</script>
</body>
</html>