/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.PublishBeanLocal;
import Entities.Address;
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
@WebServlet(name = "searchAddress", urlPatterns = {"/sAddress"})
public class searchAddress extends HttpServlet {

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
            out.println("<title>Servlet searchAddress</title>");
            out.println("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container text-center'>");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            out.println("<h1>Result</h1>");
            out.println("<div style=\"text-align:center;\">");

            out.println("<table  class='table table-borderd table-striped w-100'>");
            out.println("<tr>");
            out.println("<th>Street</th>");
            out.println("<th>City</th>");
            out.println("<th>State</th>");
            out.println("<th>Zip</th>");

            out.println("</tr>");
            if (street != null) {
                Collection<Address> address = pub.getAddressesByStreet(street);
                for (Address ad : address) {
                    out.println("<tr>");
                    out.println("<td>" + ad.getStreet() + "</td>");
                    out.println("<td>" + ad.getCity() + "</td>");
                    out.println("<td>" + ad.getState() + "</td>");
                    out.println("<td>" + ad.getZip() + "</td>");
                    out.println("</tr>");
                }
            }
            if (city != null) {
                Collection<Address> address = pub.getAddressesByCity(city);
                for (Address ad : address) {
                    out.println("<tr>");
                    out.println("<td>" + ad.getStreet() + "</td>");
                    out.println("<td>" + ad.getCity() + "</td>");
                    out.println("<td>" + ad.getState() + "</td>");
                    out.println("<td>" + ad.getZip() + "</td>");
                    out.println("</tr>");
                }
            }
            if (state != null) {
                Collection<Address> address = pub.getAddressesByState(state);
                for (Address ad : address) {
                    out.println("<tr>");
                    out.println("<td>" + ad.getStreet() + "</td>");
                    out.println("<td>" + ad.getCity() + "</td>");
                    out.println("<td>" + ad.getState() + "</td>");
                    out.println("<td>" + ad.getZip() + "</td>");
                    out.println("</tr>");
                }
            }
            if (zip != null) {
                Collection<Address> address = pub.getAddressesByZip(zip);
                for (Address ad : address) {
                    out.println("<tr>");
                    out.println("<td>" + ad.getStreet() + "</td>");
                    out.println("<td>" + ad.getCity() + "</td>");
                    out.println("<td>" + ad.getState() + "</td>");
                    out.println("<td>" + ad.getZip() + "</td>");
                    out.println("</tr>");
                }
            }
            out.println("</table>");
            out.println("</div>");
           out.println("</div>");
            out.println("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>");

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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
