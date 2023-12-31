<%-- 
    Document   : logout
    Created on : 09-Nov-2023, 1:26:50 PM
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
    <body>
        <%

            request.logout();
            session.invalidate();
//        
            // request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            response.sendRedirect("index.jsp");
        %>
    </body>
</body>
</html>
