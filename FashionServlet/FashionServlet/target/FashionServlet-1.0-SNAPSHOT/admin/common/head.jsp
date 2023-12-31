<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String admin = (String) session.getAttribute("admin");
    if(admin == null)
    {
        session.invalidate();
        response.sendRedirect("../index.jsp");
    }
%>
<%@include file="../../common/connection.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DG Fashion - Dashboard</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- DataTables CSS -->
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
  <!-- Custom CSS -->
  <style>
    body {
      background-color: #f4f4f4;
    }
    #sidebar {
      background-color: #333;
      color: #fff;
      /*height: 100vh;*/
    }
    #content {
      padding: 20px;
    }
    .active{
        text-decoration : underline;
    }
    
    @media(min-width : 499px)
    {
        #sidebar{
            height:100vh;
        }
    }
  </style>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
      <nav id="sidebar" class="col-md-3 col-lg-2 d-md-block bg-dark sidebar">
        <div class="position-sticky">
          <ul class="nav flex-column">
            <li class="nav-item">
              <a class="nav-link" href="dashboard.jsp">
                Dashboard
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="products.jsp">
                Products
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="categories.jsp">
                Categories
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="users.jsp">
                Users
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="orders.jsp">
                Orders
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../logout.jsp">
                Logout
              </a>
            </li>
          </ul>
        </div>
      </nav>

      <main id="content" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">