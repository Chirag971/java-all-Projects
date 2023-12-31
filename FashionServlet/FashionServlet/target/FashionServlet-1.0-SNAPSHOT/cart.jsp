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
    <title>Cart - DG Fashion</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="assets/css/custom.css"/>
        <%
            request.setAttribute("page", "cart");
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
        <h2 class="mb-4">Your Cart</h2>
        <table id="cartTable" class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Discount</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    float total = 0;
                %>
                <%
                    try
                    {
                        Statement stmt = con.createStatement();
                        Hashtable<Integer, Integer> cartTbl = (Hashtable<Integer, Integer>) session.getAttribute("cartTable");
                        
                        Enumeration<Integer> keys = cartTbl.keys();
                        
                        while(keys.hasMoreElements())
                        {
                            ResultSet rs = stmt.executeQuery("select * from product_master where id = " + keys.nextElement().toString());
                            
                            while(rs.next())
                            {%>
                            <tr>
                                <td><%= rs.getString("name") %></td>
                                <td><%= rs.getString("price") %></td>
                                <td><%= cartTbl.get(rs.getInt("id")) %></td>
                                <td><%= rs.getString("discount") %> %</td>
                                <td>
                                    <%
                                        float price = rs.getFloat("price") * Float.parseFloat(cartTbl.get(rs.getInt("id")).toString());
                                        float discount = rs.getFloat("discount");
                                        float sub = price - (price * (discount / 100));
                                        out.print(sub);
                                        total += sub;
                                    %>
                                </td>
                                <td>
                                    <svg style="cursor:pointer" data-id="<%= rs.getInt("id") %>" class="deleteItem" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
                                        <path d="M135.2 17.7L128 32H32C14.3 32 0 46.3 0 64S14.3 96 32 96H416c17.7 0 32-14.3 32-32s-14.3-32-32-32H320l-7.2-14.3C307.4 6.8 296.3 0 284.2 0H163.8c-12.1 0-23.2 6.8-28.6 17.7zM416 128H32L53.2 467c1.6 25.3 22.6 45 47.9 45H346.9c25.3 0 46.3-19.7 47.9-45L416 128z"/>
                                    </svg>
                                </td>
                            </tr>
                            <%}
                        }%>
                        <tr style="font-weight: bolder">
                            <td>Total</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><%= total %> &#8377;</td>
                            <td></td>
                        </tr>
                    <%}
                    catch(Exception err)
                    {
                        out.print(err.toString());
                    }
                %>
            </tbody>
        </table>
            <button class="btn btn-primary btn-lg" onclick="window.location.href = 'checkout.jsp'">Checkout</button>
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