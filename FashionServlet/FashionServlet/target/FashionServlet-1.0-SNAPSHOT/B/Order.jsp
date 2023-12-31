<%@page import="java.time.LocalDate"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.sql.*"%>
<%@page import="packages.conn"%>
<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            .invoice {
                position: relative;
                background: #fff;
                border: 1px solid #f4f4f4;
                padding: 20px;
                margin: 10px 25px;
            }
            .page-header {
                margin: 10px 0 20px 0;
                font-size: 22px;
            }
        </style>
        <title>Billing</title>
    </head>
    <body>
        <%!
            Connection con = null;
            PreparedStatement pstmt = null;
            PreparedStatement pstmtOrderInsert;

            ResultSet rs;
            Integer id;
            String uname = null;
            String contact = null;
            int orderDetailId = 0;
        %>
        <%
            if (session.getAttribute("loggedInUserName") != null) {
// String name = (String) session.getAttribute("loggedInUserName");
            } else {
                response.sendRedirect("Login.jsp");
            }

            LocalDate today = LocalDate.now();
            int product_id = (int) session.getAttribute("product_id");
            String disc = (String) session.getAttribute("disc");
            System.out.println(product_id + disc);
            String name = (String) session.getAttribute("loggedInUserName");
            String pname = request.getParameter("pname");
            String price = request.getParameter("price");
            String Qty = request.getParameter("Qty");
            Integer total = Integer.parseInt(price) * Integer.parseInt(Qty);
            LocalDateTime currentDateTime = LocalDateTime.MIN.now();
            con = conn.createc();
            pstmt = con.prepareCall("select * from userr_master where email= ?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {

                id = rs.getInt("Id");
                uname = rs.getString("username");
                contact = rs.getString("contact_no");
            }


        %>
        <%            String InsertQry = "INSERT INTO order_master (datetime, session_id, payment_mode,tax, total_amt, order_status) VALUES (?,?,?,?,?,?)";
            pstmt = con.prepareStatement(InsertQry, Statement.RETURN_GENERATED_KEYS);
            pstmt.setObject(1, currentDateTime);
            pstmt.setString(2, id.toString());
            pstmt.setString(3, "Cash");
            pstmt.setString(4, "10");
            pstmt.setString(5, total.toString());
            pstmt.setString(6, "Pending");

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet genKey = pstmt.getGeneratedKeys();
                if (genKey.next()) {
                    orderDetailId = genKey.getInt(1);
                    System.out.println("Generated order_detail_id: " + orderDetailId);
                }
                System.out.println("succefully inserted");
            }

        %>
        <%            String insertOrderDetails = "insert into order_details(order_id,product_id,product_price,discount) values (?,?,?,?)";
            pstmtOrderInsert = con.prepareStatement(insertOrderDetails);
            pstmtOrderInsert.setInt(1, orderDetailId);
            pstmtOrderInsert.setInt(2, product_id);
            pstmtOrderInsert.setInt(3, Integer.parseInt(price));
            pstmtOrderInsert.setString(4, disc);
            int row = pstmtOrderInsert.executeUpdate();

            if (row > 0) {
                System.out.println("ORDER DETAILS - row inserted");
            }
        %>
        <div class="mt-4">
            <a class="back" href="home.jsp"><h2 style="color: black"> <-Back</h2></a>
        </div>
        <section class="content content_content" style="width: 70%; margin: auto;">
            <section class="invoice">
                <!-- title row -->
                <div class="row">
                    <div class="col-xs-12">
                        <h2 class="page-header">
                            <i class="fa fa-globe"></i> Fashion Store
                            <small class="pull-right"> <%= today%></small><!--  -->
                        </h2>
                    </div><!-- /.col -->
                </div>
                <!-- info row -->
                <div class="row invoice-info">
                    <div class="col-sm-4 invoice-col">
                        From
                        <address>
                            <strong>
                                Fashion Store
                            </strong>
                        </address>
                    </div><!-- /.col -->
                    <div class="col-sm-4 invoice-col">
                        To
                        <address>
                            <strong>
                                <%= uname%>        </strong>
                            <br>
                            Phone:<%= contact%>
                            <br>
                            Email:<%=name%></address>
                    </div><!-- /.col -->
                    <div class="col-sm-4 invoice-col">
                        <!--<b>Invoice #007612</b><br>-->
                        <br>
                        <b>Order ID:</b>  <%= orderDetailId%><br>
                        <b>Payment Method:</b> Cash On Delivery<br>
                        <!--<b>Account:</b> 968-34567-->
                    </div><!-- /.col -->
                </div><!-- /.row -->

                <!-- Table row -->
                <div class="row">
                    <div class="col-xs-12 table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Qty</th>
                                    <th>Price</th>
                                    <th>Sub Total</th>
                                </tr>
                            </thead>
                            <tbody>


                                <tr>
                                    <td> <%=pname%></td>
                                    <td><%=Qty%></td>
                                    <td><%=price%></td>
                                    <td><%= total%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div><!-- /.col -->
                </div><!-- /.row -->

                <div class="row">
                    <!-- accepted payments column -->
                    <div class="col-md-12">
                        <!--<p class="lead">Amount Due 2/22/2014</p>-->
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <th>Total:</th>
                                        <td> <%= total%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div><!-- /.col -->
                </div><!-- /.row -->

                <!-- this row will not appear when printing -->
                <div class="row no-print">
                    <div class="col-xs-12">
                        <a href="" class="btn btn-default"><i class="fa fa-print"></i> Print</a>
                        <button class="btn btn-success pull-right"><i class="fa fa-credit-card"></i> Submit Payment</button>
                        <button class="btn btn-primary pull-right" style="margin-right: 5px;"><i class="fa fa-download"></i> Generate PDF</button>
                    </div>
                </div>
            </section>
        </section>

    </body>
</html>
