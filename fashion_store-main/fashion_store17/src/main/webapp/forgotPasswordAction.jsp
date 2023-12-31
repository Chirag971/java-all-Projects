<%@page import="packages.conn" %> 
<%@page import="java.sql.*" %>
<%
    String email = request.getParameter("email");
    String contact = request.getParameter("contact");
    String securityQues = request.getParameter("pwd_ques");
    String pwd_ans = request.getParameter("pwd_ans");
    String newpwd = request.getParameter("newpwd");

    System.out.println(email + contact + pwd_ans + securityQues);
    int check = 0;
    try {
        Connection con = conn.createc();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from userr_master where email ='" + email + "' and contact_no ='" + contact + "'  and password_ques ='" + securityQues + "'  and password_ans ='" + pwd_ans + "'");
//        System.out.println("render data");
        while(rs.next()) {
            check = 1;
            st.executeUpdate("update userr_master set password='" + newpwd + "' where email ='" + email + "' ");
//            System.out.println("updated  data" + newpwd + email);
            response.sendRedirect("forgotPassword.jsp?msg=done");
        }
        if (check == 0) {
            response.sendRedirect("forgotPassword.jsp?msg=invalid");
        }
    } catch (Exception e) {
        System.out.println(e);
    }


%>