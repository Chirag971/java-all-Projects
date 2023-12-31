<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="java.sql.*" %>
<%@include file="common/connection.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DG Fashion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-pzjw9X9+oaed5IHCRPVWGF0cLuAIAKJzJgojMeCFSvBBO/5j5Wr5BjWSw02rnPu/" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/custom.css"/>
        <%
            request.setAttribute("page", "home");
            int i = 0;
        %>
    </head>
    <body>
        <div class="container-fluid">
        <%@include file="common/navbar.jsp" %>
        
            <div id="carouselExampleCaptions" class="carousel slide">
                <div class="carousel-inner">
                <%
                    try
                    {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from product_master order by created_at desc limit 3;");

                        while(rs.next())
                        {%>
                            <div class="carousel-item <% 
                                if(i == 0)
                                {
                                    out.print("active");
                                }
                            %>">
                                <img src="<%= rs.getString("image") %>" class="d-block cimage" alt="...">
                                <div class="carousel-caption d-none d-md-block">
                                    <h5><%= rs.getString("name") %></h5>
                                </div>
                            </div>
                            <%
                                i++;
                            %>
                        <%}
                    }
                    catch(Exception err)
                    {
                        out.print(err.toString());
                    }
                %>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Next</span>
                </button>
            </div>
            <hr/>
            
            <h3 class="text-center">We offer the following categories :</h3>
            <div>
                <%
                    try
                    {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from category_master");
                        while(rs.next())
                        {%>
                            <span class="badge rounded-pill fs-5 text-bg-primary">
                                <%= rs.getString("name") %>
                            </span>
                        <%}
                    }
                    catch(Exception err)
                    {
                        out.print(err.toString());
                    }
                %>
            </div>
            <hr/>
            <div class="row">
                <%
                    try
                    {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from product_master where discount > 0 order by created_at desc limit 6");
                        while(rs.next())
                        {%>
                            <div class="col-lg-4">
                                <div class="card">
                                    <img src="<%= rs.getString("image") %>" class="card-img-top" alt="Product Image">
                                    <div class="card-body">
                                        <h5 class="card-title"><%= rs.getString("name") %></h5>
                                    </div>
                                    <div class="card-footer">
                                        <div class="d-flex justify-content-between align-items-center">
                                            <span class="price">&#8377; <%= rs.getString("price") %></span>
                                            <span class="badge bg-success"><%= rs.getString("discount") %>% off</span>
                                        </div>
                                        <div class="d-flex justify-content-between mt-2">
                                            <button onclick="window.location.href = 'singleProduct.jsp?id=<%= rs.getString("id") %>'" class="btn btn-primary">Buy Now</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <%}
                    }
                    catch(Exception err)
                    {
                        out.print(err.toString());
                    }
                %>
            </div>
        </div>
                <%@include file="common/footer.jsp" %>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</html>