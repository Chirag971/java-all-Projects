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
<%!
    String name = null;
    String email = null;
    String address = null;
    String pincode = null;
    String city = null;
    String state = null;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - DG Fashion</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
</head>
<body>
    <%
        int id = Integer.parseInt(session.getAttribute("userId").toString());
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user_master where id = " + id);
        while(rs.next())
        {
            name = rs.getString("username");
            email = rs.getString("email");
            address = rs.getString("address");
            pincode = rs.getString("pincode");
            state = rs.getString("state");
            city = rs.getString("city");
        }
    %>
    <div class="container mt-5">
        <div class="col-12">
            <div id="alertsContainer"></div>
        </div>
        <h2 class="mb-4">Checkout</h2>
        <form id="checkoutForm">
            <!-- Billing Information -->
            <div class="mb-4">
                <h4>Billing Information</h4>
                <div class="form-group">
                    <label for="billingName">Name</label>
                    <input type="text" class="form-control" id="billingName" readonly value="<%= name %>" required>
                </div>
                <div class="form-group">
                    <label for="billingEmail">Email</label>
                    <input type="email" class="form-control" id="billingEmail" readonly value="<%= email %>" required>
                </div>
                <!-- Add more form fields for billing information -->
            </div>
            
            <!-- Shipping Information -->
            <div class="mb-4">
                <h4>Shipping Information</h4>
                <div class="form-group">
                    <label for="shippingAddress">Address</label>
                    <textarea type="text" class="form-control" id="shippingAddress" readonly required><%= address %></textarea>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="pincode">Pincode</label>
                        <input type="text" class="form-control" id="pincode" readonly value="<%= pincode %>" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="state">State</label>
                        <input type="text" class="form-control" id="state" readonly value="<%= state %>" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="city">City</label>
                        <input type="text" class="form-control" id="city" readonly value="<%= city %>" required>
                    </div>
                </div>
                <!-- Add more form fields for shipping information -->
            </div>
            
            <!-- Payment Information -->
            <div class="mb-4">
                <h4>Payment Information</h4>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="paymentMethod" id="onlinePayment" value="online" disabled>
                    <label class="form-check-label" for="onlinePayment">
                        Online Payment
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="paymentMethod" id="cashOnDelivery" value="cod" checked>
                    <label class="form-check-label" for="cashOnDelivery">
                        Cash on Delivery
                    </label>
                </div>
            </div>
            
            <!-- Cart Details -->
            <div class="mb-4">
                <h4>Cart Details</h4>
                <table id="cartTable" class="table table-bordered table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Discount</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            float total = 0;
                        %>
                        <%
                            try
                            {
                                Hashtable<Integer, Integer> cartTbl = (Hashtable<Integer, Integer>) session.getAttribute("cartTable");

                                Enumeration<Integer> keys = cartTbl.keys();

                                while(keys.hasMoreElements())
                                {
                                    rs = stmt.executeQuery("select * from product_master where id = " + keys.nextElement().toString());

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
                                    </tr>
                                    <%}
                                }%>
                                <tr style="font-weight: bolder">
                                    <td>Total</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><%= total %> &#8377;</td>
                                </tr>
                            <%}
                            catch(Exception err)
                            {
                                out.print(err.toString());
                            }
                        %>
                    </tbody>
                </table>
            </div>
            
                        <button id="checkout" type="button" <%
                        if(total == 0)
                        {
                            out.print("disabled");
                        }
                        %> class="btn btn-primary">Place Order</button>
        </form>
    </div>

    <!-- Add jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Add Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script>
        $('#cartTable').DataTable();
        
        $("#checkout").click(function(){
            const json = {"total" : "<%= total %>"};
            $.ajax({
                type : "POST",
                method : "POST",
                dataType : "JSON",
                data : json,
                url : "Config?what=checkout",
                success : function(response){
                    if(response.success)
                    {
                        window.location.replace("ordered.jsp");
                    }
                    else
                    {
                        displayAlert("danger", response.message, 2000);
                    }
                },
                error : function(err)
                {
                    displayAlert("danger", err.toString(), 2000);
                }
            })
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
