<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/connection.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Order Details - DG Fashion</title>
  <link rel="stylesheet" href="path-to-your-custom-style.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/custom.css"/>
    <%
        request.setAttribute("page", "orders");
    %>
</head>
<body>
    <%@include file="common/navbar.jsp" %>
  <div class="container mt-5">
    <div class="card">
      <div class="card-header">
        Order Details
      </div>
      <div class="card-body">
          <%
              String oid = null;
              String odate = null;
              String total = null;
              String tax = null;
              
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery("select * from order_master where id = "+ request.getParameter("id") +"");
              while(rs.next())
              {
                oid = rs.getString("id");
                odate = rs.getString("order_date");
                total = rs.getString("total");
                tax = rs.getString("tax");
              }
          %>
        <h5 class="card-title">Order ID: #<%= oid%></h5>
        <p class="card-text">Customer: <%= session.getAttribute("username").toString() %></p>
        <p class="card-text">Order Date: <%= odate %></p>
        <p class="card-text">Sub Total: &#8377; <%= (Float.parseFloat(total) - Float.parseFloat(tax)) %></p>
        <p class="card-text">Total Tax (5%): &#8377; <%= tax%></p>
        <p class="card-text">Total Amount: &#8377; <%= total%></p>

        <h6 class="mt-4">Items:</h6>
        <ul class="list-group">
          <%
                stmt = con.createStatement();
              
                rs = stmt.executeQuery("select order_details.price, order_details.discount, product_master.name from order_details join product_master on product_master.id = order_details.product_id where order_id = "+ request.getParameter("id").toString() +"");
                while(rs.next())
                {%>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <%= rs.getString("name") %>
                        <span class="badge badge-primary badge-pill">&#8377; <%= (rs.getFloat("price") - rs.getFloat("discount")) %></span>
                    </li>
                <%}
          %>
        </ul>
      </div>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>