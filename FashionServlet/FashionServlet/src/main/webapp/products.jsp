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
    <title>Products - DG Fashion</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/custom.css"/>
    <%
        request.setAttribute("page", "product");
    %>
    <style>
        /* Add custom styles here */
        .product-card {
            border: 1px solid #ddd;
            padding: 20px;
            text-align: center;
        }
        .product-card img {
            max-width: 100%;
            height: 200px; /* Fixed height for all images */
            object-fit: cover; /* Maintain aspect ratio and cover the container */
        }
        .product-price {
            font-size: 18px;
            margin-top: 10px;
        }
        .product-discount {
            font-size: 16px;
            color: green;
            margin-top: 5px;
        }
        .product-link {
            text-decoration: none;
            color: #333;
        }
        .product-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <%@include file="common/navbar.jsp" %>

<div class="container mt-5">
    <h1 class="text-center">Browse Our Products</h1>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <%
            try
            {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from product_master order by created_at desc;");
                
                while(rs.next())
                {%>
                    <div class="col">
                        <div class="product-card">
                            <a href="singleProduct.jsp?id=<%= rs.getInt("id") %>" class="product-link">
                                <img src="<%= rs.getString("image") %>" alt="<%= rs.getString("name") %>">
                                <p class="product-price">&#8377; <%= rs.getString("price") %></p>
                                <p class="product-price"><%= rs.getString("name") %></p>
                                <p class="product-discount"><%= rs.getString("discount") %>% off</p>
                            </a>
                        </div>
                    </div>
                <%}
            }
            catch(Exception err)
            {
                out.print(err.toString());
            }
        %>
<!--        <div class="col">
            <div class="product-card">
                <img src="product1.jpg" alt="Product 1">
                <p class="product-price">$49.99</p>
                <p class="product-discount">20% off</p>
            </div>
        </div>-->
    </div>
</div>

    <%@include file="common/footer.jsp" %>

<!-- Include Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>