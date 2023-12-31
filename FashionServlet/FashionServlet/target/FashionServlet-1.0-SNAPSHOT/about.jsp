<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="java.sql.*" %>
<%@include file="common/connection.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - DG Fashion</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/custom.css"/> >
    <%
        request.setAttribute("page", "about");
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
        .section-content {
            font-size: 18px;
        }
    </style>
</head>
<body>

    <%@include file="common/navbar.jsp" %>

    <div class="jumbotron jumbotron-fluid text-center">
        <div class="container">
            <h1 class="display-4">Welcome to DG Fashion</h1>
            <p class="lead">Explore our collection of stylish menswear and accessories.</p>
        </div>
    </div>

    <div class="container section">
        <h2 class="section-heading">Our Story</h2>
        <p class="section-content">
            At DG Fashion, our journey began with a vision to redefine men's fashion. Inspired by the desire to offer high-quality clothing and accessories that reflect style, comfort, and individuality, we embarked on a mission to create a brand that resonates with modern men.
        </p>
        <p class="section-content">
            From our humble beginnings, we've worked tirelessly to curate a diverse range of products that cater to every occasion and personal taste. Our commitment to quality craftsmanship, attention to detail, and understanding of the latest trends drive us to provide you with the best fashion options.
        </p>
    </div>

    <div class="container section bg-light">
        <h2 class="section-heading">Why Choose Us</h2>
        <p class="section-content">
            At DG Fashion, we stand out because we don't just sell clothing; we offer an experience. We understand that your clothing reflects your personality and aspirations, and that's why we're dedicated to delivering exceptional products that make you feel confident and stylish.
        </p>
        <p class="section-content">
            With a focus on customer satisfaction, we provide a seamless shopping journey, from browsing our collection to receiving your order. Our curated selection, attention to fit and comfort, and commitment to innovation are what set us apart in the fashion industry.
        </p>
    </div>

    <div class="container section">
        <h2 class="section-heading">Our Mission</h2>
        <p class="section-content">
            Our mission at DG Fashion is to empower every man to express his unique style through our thoughtfully designed and carefully curated fashion offerings. We aim to inspire confidence and authenticity in the modern man by providing him with versatile clothing and accessories that elevate his look.
        </p>
        <p class="section-content">
            We strive to be a brand that understands and anticipates the needs of our customers. Our dedication to quality, trend-consciousness, and ethical business practices drives us to continually evolve and deliver fashion that makes a statement.
        </p>
    </div>
    <%@include file="common/footer.jsp" %>
<!-- Include Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>
