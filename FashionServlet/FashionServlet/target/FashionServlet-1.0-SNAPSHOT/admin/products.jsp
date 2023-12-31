<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<div>
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalLabel">Update Stock</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            <div class="card">
                <div class="card-body">
                  <form id="cat-form">
                    <div class="form-group">
                      <label for="categoryName">New Stock</label>
                      <input type="number" required class="form-control" id="newStock" name="newStock" placeholder="Enter new stock" min="1">
                    </div>
                    <button type="submit" id="updStk" class="btn btn-primary">Update Stock</button>
                  </form>
                </div>
              </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
    <!-- Modal -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalLabel">Add Product</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            <form id="addProductForm" enctype="multipart/form-data">
            <div class="form-group">
              <label for="productName">Product Name</label>
              <input type="text" class="form-control" id="productName" name="productName" required>
            </div>
            <div class="form-group">
              <label for="category">Category</label>
              <select class="form-control" id="category" name="category" required>
                <%
                    Statement st = con.createStatement();
                    ResultSet rs2 = st.executeQuery("select * from category_master");
                    while(rs2.next())
                    {%>
                    <option value="<%= rs2.getString("id") %>"><%= rs2.getString("name") %></option>
                    <%}
                %>
              </select>
            </div>
            <div class="form-group">
              <label for="unit">Unit</label>
              <input type="text" class="form-control" id="unit" name="unit" required>
            </div>
            <div class="form-group">
              <label for="stock">Stock</label>
              <input type="number" class="form-control" id="stock" name="stock" required>
            </div>
            <div class="form-group">
              <label for="price">Price</label>
              <input type="number" class="form-control" id="price" name="price" required>
            </div>
            <div class="form-group">
              <label for="discount">Discount</label>
              <input type="number" class="form-control" id="discount" name="discount" required value="0">
            </div>
            <div class="form-group">
              <label for="image">Image</label>
              <input type="file" class="form-control-file" id="image" name="image" accept="image/jpeg, image/png, image/gif" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Product</button>
          </form>
        </div>
      </div>
    </div>
  </div>
    <h2>Welcome Admin</h2>
    <button id="addPro" class="btn btn-primary">Add Product</button>
    <div class="table-responsive">
        <table id="products-tbl" class="table table-hover">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Unit</th>
                    <th>Discount</th>
                    <th>Stock</th>
                    <th>Category</th>
                    <th>Image</th>
                    <th>Update Stock</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select product_master.*, category_master.name as 'cname' from product_master join category_master on category_master.id = product_master.category_id");
                    while(rs.next())
                    {%>
                    <tr>
                        <td><%= rs.getString("name") %></td>
                        <td><%= rs.getString("price") %></td>
                        <td><%= rs.getString("unit") %></td>
                        <td><%= rs.getString("discount") %> %</td>
                        <td><%= rs.getString("stock") %></td>
                        <td><%= rs.getString("cname") %></td>
                        <td>
                            <image src="<%= rs.getString("image") %>" width="100px" />
                        </td>
                        <td>
                            <button class="btn btn-primary btn-sm updateStock" data-id="<%= rs.getString("id") %>">Update Stock</button>
                        </td>
                    </tr>  
                    <%}
                %>
            </tbody>
        </table>
    </div>
</div>
<%@include file="common/foot.jsp" %>
<script>
    $("#products-tbl").DataTable();
    
    $("#addPro").click(function(){
        $("#myModal").modal('show');
    });
    
    $("#products-tbl").on("click", ".updateStock", function()
    {
        $("#updStk").attr("data-id", $(this).attr("data-id"));
        $("#myModal2").modal('show');
    });
    
    $("#cat-form").submit(function(e){
        e.preventDefault();
        const json = {"id" : $("#updStk").attr("data-id"), "qty" : $("#newStock").val()};
        
        $.ajax({
            type : "POST",
            method : "POST",
            data : json,
            dataType : "JSON",
            url : "../Config?what=updateStock",
            success : function(response)
            {
                if(response.success)
                {
                    window.location.reload();
                }
                else
                {
                    alert("Some error occured");
                }
            }
        })
    })
    
    $("#addProductForm").submit(function(e){
        e.preventDefault();
        var formData = new FormData($("#addProductForm")[0]);
        
        $.ajax({
            url: '../Config?what=addProduct',
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            dataType : "JSON",
            success: function(response) {
              if(response.success)
              {
                  window.location.reload();
              }
              else
              {
                  console.log(response);
                  alert("Some error occurred.");
              }
            },
            error : function(err)
            {
                console.log(err);
            }
        });
    })
</script>
</body>
</html>