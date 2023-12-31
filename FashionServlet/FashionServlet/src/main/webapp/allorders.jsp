<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String check = (String) session.getAttribute("login");
    if(check == null)
    {
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@include file="common/connection.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders - DG Fashion</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="assets/css/custom.css"/>
        <%
            request.setAttribute("page", "orders");
        %>
    <style>
        /* Add custom styles here */
        .product-container {
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
        }
        .product-image {
            max-width: 100%;
            height: auto;
            margin-bottom: 20px;
        }
        .product-name {
            font-size: 24px;
            margin-bottom: 10px;
        }
        .product-category {
            font-size: 16px;
            color: #666;
            margin-bottom: 10px;
        }
        .product-price {
            font-size: 24px;
            margin-bottom: 10px;
        }
        .product-discount {
            font-size: 18px;
            color: green;
            margin-bottom: 20px;
        }
        .product-quantity {
            width: 100px;
            text-align: center;
            font-size: 16px;
        }
        .add-to-cart-button,
        .buy-now-button {
            width: 100%;
            margin-top: 10px;
        }
        .related-products {
            margin-top: 40px;
        }
        .related-product-card {
            border: 1px solid #ddd;
            padding: 20px;
            text-align: center;
        }
        .related-product-card img {
            max-width: 100%;
            height: 150px;
            object-fit: cover;
        }
        .related-product-name {
            font-size: 18px;
            margin-top: 10px;
        }
        .related-product-price {
            font-size: 18px;
            color: #333;
            margin-top: 5px;
        }
    </style>
</head>
<body>

    <%@include file="common/navbar.jsp" %>

    <div class="container mt-5">
        <div class="col-12">
            <div id="alertsContainer"></div>
        </div>
        <h2 class="mb-4">Your Orders</h2>
        <table id="cartTable" class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Tax</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from order_master where user_id = "+ session.getAttribute("userId").toString() +" order by created_at desc");
                    while(rs.next())
                    {%>
                    <tr>
                        <td>#<%= rs.getString("id") %></td>
                        <td><%= rs.getString("order_date") %></td>
                        <td><%= rs.getString("tax") %></td>
                        <td><%= rs.getString("total") %></td>
                        <td>
                            <a href="viewOrder.jsp?id=<%= rs.getString("id") %>" class="btn btn-primary viewOrder btn-sm">View</a>
                        </td>
                    </tr>
                    <%}
                %>
            </tbody>
        </table>
    </div>
    
    <%@include file="common/footer.jsp" %>

<!-- Include Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
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
    
    $('#cartTable').DataTable();
    
    $("#cartTable").on("click", ".deleteItem", function(){
        const json = {"pid" : $(this).attr("data-id")};
        
        $.ajax({
            type : "POST",
            method : "POST",
            data : json,
            dataType : "JSON",
            url : "Config?what=removeItem",
            success : function(response){
                if(response.success)
                {
                    window.location.reload();
                }
                else
                {
                    displayAlert("danger", response.message, 2000);
                }
            },
            error : function(err){
                console.log(err);
                displayAlert("danger", err.statusText, 2000);
            }
        })
    })
</script>
</body>
</html>