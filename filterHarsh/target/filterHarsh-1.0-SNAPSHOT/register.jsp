<%-- 
    Document   : register
    Created on : 09-Nov-2023, 12:22:58 PM
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
        <!--<h1>Hello World!</h1>-->
        <form method="post" action="register">
            <label>username</label>
            <input type="text" name="username" id="username"  />
            <label>password</label>
            <input type="text" name="password" id="password"  />
            <label for="group">User Group:</label><br>
            <!--<input type="radio" id="gname" name="gname" value="Admin">Admin<br>-->
            <!--<input type="radio" id="gname" name="gname" value="Manager">As Restaurant Manager<br>-->
            <input type="radio" id="gname" name="gname" value="User">As User<br><br>
            <button type="submit">Register</button>
        </form>
    </body>
</html>
