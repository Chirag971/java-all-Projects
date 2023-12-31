/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.PublishBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "addAddress", urlPatterns = {"/addAddress"})
public class addAddress extends HttpServlet {

    @EJB
    PublishBeanLocal pub;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addAddress</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"text-align:center;\">");
//            out.println("<h1>Servlet addAddress at " + request.getParameter("cId") + "</h1>");
            out.println("<form action='' method='post'>"); // Use the appropriate action URL
            out.println("<label for='firstname'>Street</label>");
            out.println("<input type='text' id='street' name='street'><br><br>");
            out.println("<label for='field2'>City</label>");
            out.println("<input type='text' id='city' name='city'><br><br>");
            out.println("<label for='firstname'>State</label>");
            out.println("<input type='text' id='state' name='state'><br><br>");
            out.println("<label for='field2'>Zip</label>");
            out.println("<input type='text' id='zip' name='zip'><br><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
            int cId = Integer.parseInt(request.getParameter("cId"));
             out.println("<a href='getAddress?cid=" + cId + "'>Back</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        try {
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            int cId = Integer.parseInt(request.getParameter("cId"));
            pub.addAddressToCustomer(street, city, state, zip, cId);

            response.sendRedirect("getAddress?cid=" + cId + "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
