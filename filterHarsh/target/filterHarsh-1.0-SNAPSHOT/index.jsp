<%-- 
    Document   : index
    Created on : 09-Nov-2023, 1:27:56 PM
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
        <form method="POST" >
            <table border ="1">
                <tr>
                    <td colspan="2">Login:</td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="username"/></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="submit"/></td>
                    <td><input type="reset"/></td>
                </tr>
            </table>
        </form>

        <br>
        <% if (request.getAttribute("error") != null) {%>
        <div style="color:red"> ** <%=request.getAttribute("error")%></div>
        <% }%>
    </body>
</html>
