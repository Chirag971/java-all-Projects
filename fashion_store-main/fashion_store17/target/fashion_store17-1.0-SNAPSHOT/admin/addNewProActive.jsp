<%@page import="packages.conn" %>
<%@page import="java.sql.*" %>

<%
String name = request.getParameter("prod_name");
String category = request.getParameter("category");
String price = request.getParameter("price");
String disc = request.getParameter("disc");
String unit = request.getParameter("unit");
String stock = request.getParameter("stock");
String image ="";

    try {
        Connection con = conn.createc();
        System.out.println(name + category + price + disc + unit + stock);
        PreparedStatement ps = con.prepareStatement("insert into product_master(product_name, price,unit,discount,image,category_id,stock)\n"
                    + " values(?,?,?,?,?,?,?)");
                System.out.println("Insert successfully");
        ps.setString(1, name);
        ps.setString(2, price);
        ps.setString(3, unit);
        ps.setString(4, disc);
        ps.setString(5, image);
        ps.setString(6, category);
        ps.setString(7, stock);
        ps.executeUpdate();
//        System.out.println(row);

        response.sendRedirect("addNewProduct.jsp");

    } catch (Exception e) {
        System.out.println(e);
        response.sendRedirect("addNewProduct.jsp");
    }

%>