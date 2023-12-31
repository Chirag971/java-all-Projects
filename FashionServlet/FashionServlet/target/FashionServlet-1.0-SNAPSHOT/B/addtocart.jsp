
<%@include file="header.jsp" %>
<%@include file="footer.jsp" %><%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   
    String productName = request.getParameter("productName");

    List<String> cart = (List<String>) session.getAttribute("cart");
    if (cart == null) {
        cart = new ArrayList<>();
        session.setAttribute("cart", cart);
    }

    // Add the product to the cart
    cart.add(productName);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add To Cart</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <div class="card mt-5" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Product Added to Cart</h5>
    <p class="card-text"><strong>"<%= productName%>"</strong> has been added to your cart.</p>
    <a href="cart.jsp" class="btn btn-primary">View Cart</a>
  </div>
</div>
    </center>
<!--        <div >
        <h1>Product Added to Cart</h1>
        <p><%= productName%> has been added to your cart.</p>
        <p><a href="cart.jsp">View Cart</a></p>
        </div>-->
        </body>
</html>
