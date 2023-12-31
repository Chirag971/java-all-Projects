<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<div>
    <!<!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalLabel">Add Category</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            <div class="card">
                <div class="card-body">
                  <form id="cat-form">
                    <div class="form-group">
                      <label for="categoryName">Category Name</label>
                      <input type="text" required class="form-control" id="categoryName" name="categoryName" placeholder="Enter category name">
                    </div>
                    <button type="submit" class="btn btn-primary">Add Category</button>
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
    
    <h2>Welcome Admin</h2>
    <button id="addCat" class="btn btn-primary">Add Category</button>
    <div class="table-responsive">
        <table id="category-tbl" class="table table-hover">
            <thead>
                <tr>
                    <th>Category</th>
                    <th>Number of Products</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT `category_master`.`id`, `category_master`.`name`, COUNT(`product_master`.`id`) AS 'counter' FROM `category_master` LEFT JOIN `product_master` ON `category_master`.`id` = `product_master`.`category_id` GROUP BY `category_master`.`id`;");
                    while(rs.next())
                    {%>
                    <tr>
                        <td><%= rs.getString("name") %></td>
                        <td><%= rs.getString("counter") %></td>
                        <td>
                            <button class="btn btn-danger deleteCat" data-id="<%= rs.getString("id") %>" <%= (rs.getInt("counter") != 0)?"disabled":"" %>>Delete</button>
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
    $("#category-tbl").DataTable();
    
    $("#addCat").click(function(){
        $("#myModal").modal("show");
    });
    
    $("#category-tbl").on("click", ".deleteCat", function(){
        const json = {"id" : $(this).attr("data-id")};
        $.ajax({
            type : "POST",
            method : "POST",
            data : json,
            dataType : "JSON",
            url : "../Config?what=deleteCategory",
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
    
    $("#cat-form").submit(function(e){
        e.preventDefault();
        const json = {"name" : $("#categoryName").val()};
        $.ajax({
            type : "POST",
            method : "POST",
            data : json,
            dataType : "JSON",
            url : "../Config?what=addCategory",
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
</script>
</body>
</html>