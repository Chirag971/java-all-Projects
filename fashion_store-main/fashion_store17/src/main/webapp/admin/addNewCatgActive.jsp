<%@page import="packages.conn" %>
<%@page import="java.sql.*" %>

<%
String name = request.getParameter("name");
String parentCat = request.getParameter("Pcat");


    try {
        Connection con = conn.createc();
        System.out.println(name + parentCat);
        PreparedStatement ps = con.prepareStatement("insert into category_master(name, parent_category_id)\n"
                    + " values(?,?)");
                System.out.println("Insert successfully");
        ps.setString(1, name);
        ps.setString(2, parentCat);
        
        ps.executeUpdate();
//        System.out.println(row);

        response.sendRedirect("addNewCategory.jsp");

    } catch (Exception e) {
        System.out.println(e);
//        response.sendRedirect("signup.jsp?msg=invalid");
    }

%>