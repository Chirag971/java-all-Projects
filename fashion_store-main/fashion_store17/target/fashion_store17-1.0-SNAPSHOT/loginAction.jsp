<%@page import="packages.conn" %> 
<%@page import="java.sql.*" %>

<%
    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");
    System.out.println(email);
    System.out.println(pwd);
    if ("admin@gmail.com".equals(email) && "admin".equals(pwd)) {
//session is bacically we use value in multiple places email is use in multiple thing
        session.setAttribute("email", email);
        response.sendRedirect("admin/adminHome.jsp");
    } else {

        int z = 0;
        try {
            Connection con = conn.createc();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userr_master where email ='" + email + "' and password = '" + pwd + "' ");
            System.out.println();
            while (rs.next()) {
                z = 1;//it means user is exist.
                session.setAttribute("email", "email");
                response.sendRedirect("home.jsp");
            }
            if (z == 0) {
                response.sendRedirect("login.jsp?msg=notexists");
            }
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("signup.jsp?msg=invalid");
        }
    }
%>