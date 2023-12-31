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
    <title>Single Product - DG Fashion</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/custom.css"/>
        <%
            request.setAttribute("page", "product");
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
<%!
    String img = null;
    String pname = null;
    String price = null;
    String unit = null;
    String discount = null;
    String stock = null;
    String cname = null;
    int cid = 0;
%>

<%
  try
    {
        if(request.getParameter("id").isEmpty())
        {
            response.sendRedirect("products.jsp");
        }
        else
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) as 'counter' from product_master where id = "+ request.getParameter("id").trim() +"");
            boolean flag = true;
            while(rs.next())
            {
                if(rs.getInt("counter") == 0)
                {
                    flag = false;
                    response.sendRedirect("products.jsp");
                }
            }
            
            if(flag)
            {
                rs = stmt.executeQuery("SELECT `product_master`.`name`, `product_master`.`price`, `product_master`.`stock`, `product_master`.`unit`, `product_master`.`discount`, `product_master`.`image`, `product_master`.`category_id` AS 'cid', `category_master`.`name` AS 'cname' FROM `product_master` JOIN `category_master` ON `category_master`.`id` = `product_master`.`category_id` WHERE `product_master`.`id` = "+ request.getParameter("id").trim() +";");
                
                while(rs.next())
                {
                    img = rs.getString("image");
                    pname = rs.getString("name");
                    price = rs.getString("price");
                    unit = rs.getString("unit");
                    discount = rs.getString("discount");
                    stock = rs.getString("stock");
                    cname = rs.getString("cname");
                    cid = rs.getInt("cid");
                }
            }
        }
    }
    catch(Exception err)
    {
        out.print(err.toString());
    }  
%>
<div class="container mt-5">
    <div class="col-12">
        <div id="alertsContainer"></div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <div class="product-container">
                <img src="<%= img %>" alt="<%= pname %>" class="product-image">
                <h2 class="product-name"><%= pname %></h2>
                <p class="product-category">Category: <%= cname %></p>
                <p class="product-price">&#8377; <%= price %></p>
                <p class="product-discount"><%= discount %>% off</p>
                <p><strong>Available Stock:</strong> <%= stock %> <%= unit %></p>
                <div class="d-flex align-items-center">
                    <label for="quantity" class="me-2">Quantity:</label>
                    <input type="number" id="quantity" class="form-control product-quantity" min="1" max="<%= stock %>" value="1">
                </div>
                <button id="addToCart" class="btn btn-primary add-to-cart-button">Add to Cart</button>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="product-container">
                <h3>Related Products</h3>
                <div class="row related-products">
                    <%
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from product_master where category_id = "+ cid +" and id != "+ request.getParameter("id").trim() +"");
                        
                        while(rs.next())
                        {%>
                            <div class="col-md-6">
                                <div class="related-product-card">
                                    <a href="singleProduct.jsp?id=<%= rs.getString("id") %>">
                                        <img src="<%= rs.getString("image") %>" alt="Related Product 1">
                                        <p class="related-product-name"><%= rs.getString("name") %></p>
                                        <p class="related-product-price">&#8377; <%= rs.getString("price") %></p>
                                    </a>
                                </div>
                            </div>
                        <%}
                    %>
                </div>
            </div>
        </div>
    </div>
</div>

    <%@include file="common/footer.jsp" %>

<!-- Include Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
    var flag = "<%
        String flag = (String) session.getAttribute("login");
        
        if(flag != null)
        {
            out.print("yes");
        }
        else
        {
            out.print("no");
        }
    %>";
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
    
    $("#addToCart").click(function(){
        var max = $("#quantity").attr("max");
        var selected = $("#quantity").val();
        
        if(parseInt(selected) > parseInt(max))
        {
            displayAlert("danger", "Selected quantity cannot be greater than available quantity.", 2000);
        }
        else if(selected <= 0)
        {
            displayAlert("danger", "Selected quantity cannot be less than equal to 0.", 2000);
        }
        else
        {
            var url = new URLSearchParams(window.location.search);
            const json = {"pid" : url.get("id"), "qty" : selected};
            
            if(flag == "no")
            {
                window.location.href = "login.jsp";
            }
            else
            {
                $.ajax({
                    type : "POST",
                    method : "POST",
                    dataType : "JSON",
                    data : json,
                    url : "Config?what=addToCart",
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
            }
        }
    })
</script>
</body>
</html>