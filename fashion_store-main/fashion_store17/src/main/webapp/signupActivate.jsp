<%@page import="packages.conn" %> 
<%@page import="java.sql.*" %>
<%
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String securityQues = request.getParameter("pwd_ques");
    String pwd_ans = request.getParameter("pwd_ans");
    String pwd = request.getParameter("pwd");
    String contact = request.getParameter("contact");
    String address = "";
    String city = "";
    String state = "";
    String country = "";
    String pin = "";

    try {
        Connection con = conn.createc();
        System.out.println(username + email + pwd + securityQues + pwd_ans + contact + address + city + state + country + pin);
        PreparedStatement ps = con.prepareStatement("insert into userr_master(username,password,password_ques,password_ans,email,contact_no,address,city,state,country,pin)\n"
                    + " values(?,?,?,?,?,?,?,?,?,?,?)");
                System.out.println("Insert successfully");
        ps.setString(1, username);
        ps.setString(2, pwd);
        ps.setString(3, securityQues);
        ps.setString(4, pwd_ans);
        ps.setString(5, email);
        ps.setString(6, contact);
        ps.setString(7, address);
        ps.setString(8, city);
        ps.setString(9, state);
        ps.setString(10, country);
        ps.setString(11, pin);
        ps.executeUpdate();
//        System.out.println(row);

        response.sendRedirect("signup.jsp?msg=valid");

    } catch (Exception e) {
        System.out.println(e);
        response.sendRedirect("signup.jsp?msg=invalid");
    }
%>