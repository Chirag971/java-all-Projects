<%@include file="header.jsp" %>
<%@include file="footer.jsp" %>
<%@page import="java.sql.*"%>
<%@page import="packages.conn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%
    List<String> cart = (List<String>) session.getAttribute("cart");

    if (cart == null || cart.isEmpty()) {
        out.println("Your cart is empty.");
    } else {
%>
<%!
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt;
    ResultSet rs;
%>
<html>
    <head>
        <title>Cart</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--<div style="display: flex; justify-content: center;" >-->
        <h1  style="text-align:  center">Your Cart</h1>
        <div class="container mt-4 align-items-center">
            <table class="table table-borderless table-striped border-success align-items-center justify-content-center" align="center">
                <thead>
                    <tr>
                        <th scope="col">Product Name</th>
                        <th scope="col">Image</th>
                        <th scope="col">Options</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        con = conn.createc();
                        for (String item : cart) {

                            pstmt = con.prepareStatement("Select * from product_master where product_name = ?");
                            pstmt.setString(1, item);
                            rs = pstmt.executeQuery();
                            while (rs.next()) {

                    %>
                    <tr>
                        <td><%=  item%></td>
                        <td><img src="<%= rs.getString("image")%>" width="50px" height="50px" alt="image"/>   </td>
                        <td> <a class=" btn btn-outline-warning" href="placeOreder.jsp?product_id=<%= rs.getInt("Id")%>">Order Now</a></td>
                         <td> <a class=" btn btn-outline-danger" href="placeOreder.jsp?product_id=<%= rs.getInt("Id")%>">Delete</a></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
                <div class="m-5" style="display: flex; justify-content: center">
            <a class=" btn btn-outline-secondary" href="product.jsp">Add More Products</a>
           
        </div>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>
<% }%>
