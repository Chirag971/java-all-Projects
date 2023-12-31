<%-- 
    Document   : register
    Created on : 06-Nov-2023, 9:44:32 PM
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
        <form method="POST" action="hash">
            <label>username</label>
            <input type="text" name="username" id="username"/><br/>
            <label>Password</label>
            <input type="password" name="password" id="password"/><br/>
            <input type="submit" value="register"/> 
            <label for="group">User Group:</label><br>
            <!--<input type="radio" id="gname" name="gname" value="Admin">Admin<br>-->
             <input type="radio" id="gname" name="gname" value="User">As User<br><br>
        </form>
    </body>
</html>
