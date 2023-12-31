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
@WebServlet(name = "getAllAddress", urlPatterns = {"/getAddress"})
public class getAllAddress extends HttpServlet {

    @EJB
    PublishBeanLocal pub;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int cid = Integer.parseInt(request.getParameter("cid"));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet getAllAddress</title>");
            out.println("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container text-center'>");
            out.println("<h3>Manage Address</h3>");
            out.println("<form action='sAddress' method='post'><br>"); // Use the appropriate action URL
            out.println("<label for='field2'>Search By Street :</label>");
            out.println("<input type='text' id='street' name='street' class='form-control-sm'>");
            out.println("<input type='submit' value='Search' class='btn btn-info'>");
            out.println("</form><br>");
            out.println("<form action='sAddress' method='post'>"); // Use the appropriate action URL
            out.println("<label for='field2'>Search By City :</label>");
            out.println("<input type='text' id='city' name='city' class='form-control-sm'>");
            out.println("<input type='submit' value='Search' class='btn btn-info'>");
            out.println("</form><br>");
            out.println("<form action='sAddress' method='post'>"); // Use the appropriate action URL
            out.println("<label for='field2'>Search By State :</label>");
            out.println("<input type='text' id='state' name='state' class='form-control-sm'>");
            out.println("<input type='submit' value='Search' class='btn btn-info'>");
            out.println("</form><br>");
            out.println("<form action='sAddress' method='post'>"); // Use the appropriate action URL
            out.println("<label for='field2'>Search By Zip :</label>");
            out.println("<input type='text' id='zip' name='zip' class='form-control-sm'>");
            out.println("<input type='submit' value='Search' class='btn btn-info'>");
            out.println("</form><br>");
            Collection<Address> address = pub.getAddressesofCustomer(cid);
            if (address == null) {
                out.println("<div style=\"text-align:center;\">");
                out.println("<h3> No Address Added  </h3>");
                out.print("<a href='addAddress?cId=" + cid + "' class='btn btn-primary'>Insert</a>");
                out.println("</div>");
            } else {

                out.print("<a href='addAddress?cId=" + cid + "' class='btn btn-primary'>Add Address</a><br><br>");
                out.println("<table  class='table table-borderd table-striped w-100'>");
                out.println("<tr>");
                out.println("<th>Street</th>");
                out.println("<th>City</th>");
                out.println("<th>State</th>");
                out.println("<th>Zip</th>");
                out.println("<th>Options</th>");
                out.println("</tr>");
                for (Address ad : address) {
                    out.println("<tr>");
                    out.println("<td>" + ad.getStreet() + "</td>");
                    out.println("<td>" + ad.getCity() + "</td>");
                    out.println("<td>" + ad.getState() + "</td>");
                    out.println("<td>" + ad.getZip() + "</td>");
                    out.println("<td><a href='delAdd?del_id=" + ad.getAddressId() + "&cId=" + cid + "' class='btn btn-danger'>Delete</a>  "
                            + "<a href='operationAdd?edit_id=" + ad.getAddressId() + "&cId=" + cid + "'' class='btn btn-secondary'>Update</a>"
                            + "</td>");

                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<a href='getCustomer' class='btn btn-warning'>Back</a>");

            }
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
