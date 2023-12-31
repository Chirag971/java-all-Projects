<%@page import="packages.conn" %> 
<%@page import="java.sql.*" %>
<%@include file="adminHeader.jsp" %>
<%@include file="../footer.jsp" %>

<html>
    <head>
        <link rel="stylesheet" href="../css/addNewProduct-style.css">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Add New Category</title>
    </head>
    <body>

        <h3 class="alert">Product Added Successfully!</h3>

        <h3 class="alert">Some thing went wrong! Try Again!</h3>
        <%
            int id = 1;
            try {
                Connection con = conn.createc();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select max(id) from category_master");
                while (rs.next()) {
                    id = rs.getInt(1);
                    id = id + 1;
                }
            } catch (Exception e) {
            }
        %>
        <form method="POST" action="addNewCatgActive.jsp">


            <h3 style="color: yellow;">Product ID:<%out.println(id);%> </h3>
            <input type="hidden" name="id" value="<%out.println(id);%>"/>

            <div class="left-div">
                <h3> Name</h3>
                <input class="input-style" type="text" name="name" placeholder="Enter Category Name" required/>
                <hr>
            </div>

            <div class="right-div">
                <h3>Parent category</h3>
                <input class="input-style" type="text" name="Pcat" placeholder="Parent Category" required/>
                <hr>
            </div>
            
            <button class="button" type="submit">Save  <i class='far fa-arrow-alt-circle-right'></i></button>
        </form>
    </body>
    <br><br><br>
</body>
</html>