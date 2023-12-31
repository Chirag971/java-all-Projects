/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.PublishBeanLocal;
import Entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "searchCustomer", urlPatterns = {"/sCustomer"})
public class searchCustomer extends HttpServlet {

    @EJB
    PublishBeanLocal pub;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchCustomer</title>");
            out.println("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container text-center'>");
           

            String fName = request.getParameter("firstName");
            String lName = request.getParameter("lastName");
            String cusId = request.getParameter("cId");
            out.println("<h1>Result</h1>");
            out.println("<table  class='table table-borderd table-striped w-100'>");
            out.println("<tr>");
            out.println("<th>Customer ID</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
            out.println("</tr>");
            if (fName != null) {
                Collection<Customer> fcustomer = pub.getCustomerByfirstName(fName);
                for (Customer cust : fcustomer) {
                    out.println("<tr>");
                    out.println("<td>" + cust.getCustomerID() + "</td>");
                    out.println("<td>" + cust.getFirstName() + "</td>");
                    out.println("<td>" + cust.getLastName() + "</td>");
                    out.println("</tr>");
                }
            }

            if (lName != null) {
                Collection<Customer> lcustomer = pub.getCustomerBylastName(lName);
                for (Customer cust : lcustomer) {
                    out.println("<tr>");
                    out.println("<td>" + cust.getCustomerID() + "</td>");
                    out.println("<td>" + cust.getFirstName() + "</td>");
                    out.println("<td>" + cust.getLastName() + "</td>");
                    out.println("</tr>");
                }
            }

            if (cusId != null) {
                int cId = Integer.parseInt(cusId);

                Customer icustomer = pub.findCustomerById(cId);

                out.println("<tr>");
                out.println("<td>" + icustomer.getCustomerID() + "</td>");
                out.println("<td>" + icustomer.getFirstName() + "</td>");
                out.println("<td>" + icustomer.getLastName() + "</td>");
                out.println("</tr>");

            }
            out.println("</table>");
            out.print("<a href='getCustomer' class='btn btn-info'>Back</a>");
            out.println("</div>");
            out.println("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>");

            out.println("</body>");
            out.println("</html>");
        }
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
