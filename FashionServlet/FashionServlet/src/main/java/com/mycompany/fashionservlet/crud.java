package com.mycompany.fashionservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import org.json.JSONObject;

@WebServlet(name = "crud", urlPatterns = {"/crud"})
public class crud extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        
        JSONObject custom_response = new JSONObject();
        Connection con = null;
        try
        {
            Class.forName("com.jdbc.mysql.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/fashion_store", "root", "deep@007");
        }
        catch(Exception err)
        {
            custom_response.put("success", false);
            custom_response.put("message", err.toString());
        }
        
        if(request.getParameter("what") == "login")
        {
            String phone = request.getParameter("phoneNumber");
            String password = request.getParameter("password");
            
            custom_response.put("phone", phone);
            custom_response.put("password", password);
        }
        
        response.getWriter().write(custom_response.toString());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
