<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<%
    Connection con = null;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost/fashion_store", "root", "deep@007");
    }
    catch(Exception err)
    {
        out.print(err.toString());
    }
%>