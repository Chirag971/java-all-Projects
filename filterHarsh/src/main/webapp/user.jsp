<%-- 
    Document   : user
    Created on : 09-Nov-2023, 1:26:13 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Supervisors !!!  <%=request.getAttribute("user")%></h1>

        <a href="SecureServlet">  Secure Servlet </a>
        <br><br><br><a href="logout.jsp">Log out </a>

    </body>
</html>
