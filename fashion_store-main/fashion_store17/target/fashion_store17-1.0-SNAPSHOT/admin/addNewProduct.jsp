<%@page import="packages.conn" %> 
<%@page import="java.sql.*" %>
<%@include file="adminHeader.jsp" %>
<%@include file="../footer.jsp" %>

<html>
    <head>
        <link rel="stylesheet" href="../css/addNewProduct-style.css">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Add New Product</title>
    </head>
    <body>

        <h3 class="alert">Product Added Successfully!</h3>

        <h3 class="alert">Some thing went wrong! Try Again!</h3>
        <%
            int id = 1;
            try {
                Connection con = conn.createc();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select max(id) from product_master");
                while (rs.next()) {
                    id = rs.getInt(1);
                    id = id + 1;
                }
            } catch (Exception e) {
            }
        %>
        <form method="POST" action="addNewProActive.jsp">


            <h3 style="color: yellow;">Product ID:<%out.println(id);%> </h3>
            <input type="hidden" name="id" value="<%out.println(id);%>"/>

            <div class="left-div">
                <h3>Enter Name</h3>
                <input class="input-style" type="text" name="prod_name" placeholder="Enter Product Name" required/>
                <hr>
            </div>

            <div class="right-div">
                <h3>Enter Category</h3>
              <select class="input-style" name="category">
                    <option disabled selected>Select Category</option>
                    <option value="available">Asddd</option>
                    <option value="notavailable">asdcx</option>
                </select>
                <hr>
            </div>

            <div class="left-div">
                <h3>Enter Price</h3>
                <input class="input-style" type="text" name="price" placeholder="Enter Price " required/>
                <hr>
            </div>

            <div class="right-div">
                <h3>Discount</h3>
                <input class="input-style" type="text" name="disc" placeholder="Total discount" required/>
                <hr>
            </div>
            <div class="left-div">
                <h3>Enter unit</h3>
                <input class="input-style" type="text" name="unit" placeholder="Enter unit Name" required/>
                <hr>
            </div>

            <div class="right-div">
                <h3>Stock</h3>
                <select class="input-style" type="text"  name="stock">
                    <option disabled selected>Check Stock</option>
                    <option value="available">Available</option>
                    <option value="notavailable">Not Available</option>
                </select>
                <hr>
            </div>
            <button class="button" type="submit">Save  <i class='far fa-arrow-alt-circle-right'></i></button>
        </form>
    </body>
    <br><br><br>
</body>
</html>