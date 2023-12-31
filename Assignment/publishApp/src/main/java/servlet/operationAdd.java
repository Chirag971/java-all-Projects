/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.PublishBeanLocal;
import Entities.Address;
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
@WebServlet(name = "operationAdd", urlPatterns = {"/operationAdd"})
public class operationAdd extends HttpServlet {

    @EJB
    PublishBeanLocal pub;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        PrintWriter out = response.getWriter();
        String edit_id = request.getParameter("edit_id");
        String cId = request.getParameter("cId");
        if (edit_id != null && cId != null) {
            int aid = Integer.parseInt(edit_id);
            int cid = Integer.parseInt(cId);
            Address a = (Address) pub.findAddressById(aid);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet operationAdd</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"text-align:center;\">");
            out.println("<form action='' method='post'>"); // Use the appropriate action URL
            out.println("<label for='firstname'>Street</label>");
            out.println("<input type='text' id='street' name='street' value='" + a.getStreet() + "'><br>");
            out.println("<label for='field2'>City</label>");
            out.println("<input type='text' id='city' name='city' value='" + a.getCity() + "'><br>");
            out.println("<label for='firstname'>State</label>");
            out.println("<input type='text' id='state' name='state' value='" + a.getState() + "'><br>");
            out.println("<label for='field2'>Zip</label>");
            out.println("<input type='text' id='zip' name='zip' value='" + a.getZip() + "'><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }

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
            int aId = Integer.parseInt(request.getParameter("edit_id"));

            pub.updateAddressToCustomer(aId, street, city, state, zip, cId);
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
