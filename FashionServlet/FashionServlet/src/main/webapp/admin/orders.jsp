<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<div>
    <h2>Welcome Admin</h2>
    <!-- Modal -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalLabel">Order Details</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <table class="table">
            <thead>
              <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
              </tr>
            </thead>
            <tbody id="ord-details">
            </tbody>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
    <div class="table-responsive">
        <table id="order-tbl" class="table table-hover">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Username</th>
                    <th>Payment Mode</th>
                    <th>Order Date</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select od.id, od.order_date, od.payment_mode, od.total, us.username from order_master as od join user_master as us on us.id = od.user_id");
                    while(rs.next())
                    {%>
                    <tr>
                        <td># <%= rs.getString("id") %></td>
                        <td><%= rs.getString("username") %></td>
                        <td><%= rs.getString("payment_mode") %></td>
                        <td><%= rs.getString("order_date") %></td>
                        <td><%= rs.getString("total") %></td>
                        <td><button class="btn btn-primary btn-sm viewOrder" data-id="<%= rs.getString("id") %>">View</button></td>
                    </tr>  
                    <%}
                %>
            </tbody>
        </table>
    </div>
</div>
<%@include file="common/foot.jsp" %>
<script>
    $("#order-tbl").DataTable();
    $("#order-tbl").on("click", ".viewOrder", function(){
        const json = {"id" : $(this).attr("data-id")}
        
        $.ajax({
            type : "POST",
            method : "POST",
            data : json,
            dataType : "JSON",
            url : "../Config?what=getOrder",
            success : function(response)
            {
                if(response.success)
                {
                    $("#ord-details").html(response.message);
                    $("#myModal").modal("show");
                }
            },
            error : function(err)
            {
                alert(err.toString());
            }
        })
    })
</script>
</body>
</html>