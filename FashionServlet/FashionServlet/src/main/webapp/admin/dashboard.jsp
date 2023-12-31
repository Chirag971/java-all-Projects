<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<div>
    <h2>Welcome Admin</h2>
    
    <%
        String orders = null;
        String revenue = null;
        String tax = null;
        String users = null;
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) as 'orders', sum(total) as 'total', sum(tax) as 'tax' from order_master");
        while(rs.next())
        {
            orders = rs.getString("orders");
            revenue = rs.getString("total");
            tax = rs.getString("tax");
        }
        
        rs = stmt.executeQuery("select count(*) as 'counter' from user_master where phone != '1000000000'");
        while(rs.next())
        {
            users = rs.getString("counter");
        }
    %>
    
    <div class="row">
      <div class="col-sm-12 col-md-6 col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Total Orders</h5>
            <p class="card-text"><%= orders %></p>
          </div>
        </div>
      </div>
      <div class="col-sm-12 col-md-6 col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Total Revenue</h5>
            <p class="card-text">&#8377; <%= revenue %></p>
          </div>
        </div>
      </div>
      <div class="col-sm-12 col-md-6 col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Total Tax</h5>
            <p class="card-text">&#8377; <%= tax %></p>
          </div>
        </div>
      </div>
      <div class="col-sm-12 col-md-6 col-lg-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Total Users</h5>
            <p class="card-text"><%= users %></p>
          </div>
        </div>
      </div>
    </div>
</div>
<%@include file="common/foot.jsp" %>
</body>
</html>