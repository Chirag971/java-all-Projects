<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/connection.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Placed Successfully</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="card">
        <div class="card-body text-center">
            <h2 class="card-title">Order Placed Successfully</h2>
            <p class="card-text">Your order has been placed successfully. Thank you for shopping with us!</p>
            
            <div class="mt-4">
                <div class="card">
                    <div class="card-body">
                        <%
                            String date = null;
                            String total = null;
                            String id = null;
                            
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("select * from order_master where id = " + session.getAttribute("orderId"));
                            while(rs.next())
                            {
                                date = rs.getString("order_date");
                                total = rs.getString("total");
                                id = rs.getString("id");
                            }
                        %>
                        <h4 class="card-title">Order Details</h4>
                        <p class="card-text">Order ID: <strong>#<%= id%></strong></p>
                        <p class="card-text">Order Date: <strong><%= date%></strong></p>
                        <p class="card-text">Total Billing: <strong>&#8377; <%= total%></strong></p>
                        <!-- Add more order details if necessary -->
                    </div>
                </div>
            </div>
            
            <div class="mt-4">
                <a href="index.jsp" class="btn btn-primary">Back to Home</a>
            </div>
        </div>
    </div>

    <!-- Add Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>