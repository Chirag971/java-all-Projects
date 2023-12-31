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

@WebServlet(name = "getCustomer", urlPatterns = {"/getCustomer"})
public class getCustomer extends HttpServlet {

    @EJB
    PublishBeanLocal pub;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet getAllCustomer</title>");
            out.println("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
             out.println("<div class='container text-center'>");
             out.println("<h3>Manage Customer</h3>");
            out.println("<form action='sCustomer' method='post'><br>"); // Use the appropriate action URL
            out.println("<label for='field2'>Search By First Name :</label>");
            out.println("<input type='text' id='firstName' name='firstName' class='form-control-sm'>");
            out.println("<input type='submit' value='Search' class='btn btn-info'>");
            out.println("</form><br>");
            out.println("<form action='sCustomer' method='post'>"); // Use the appropriate action URL
            out.println("<label for='field2'>Search By Last Name :</label>");
            out.println("<input type='text' id='lastName' name='lastName' class='form-control-sm'>");
            out.println("<input type='submit' value='Search' class='btn btn-info'>");
            out.println("</form><br>");
            out.println("<form action='sCustomer' method='post'>"); // Use the appropriate action URL
            out.println("<label for='field2'>Search By Customer ID :</label>");
            out.println("<input type='text' id='cId' name='cId' class='form-control-sm'>");
            out.println("<input type='submit' value='Search' class='btn btn-info'>");
            out.println("</form><br>");
           
            out.println("<table  class='table table-borderd table-striped w-100'>");
            out.println("<tr>");
            out.println("<th>Customer ID</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
            out.println("<th>Address</th>");
            out.println("<th>Subsriptions</th>");
            out.println("<th>Options</th>");
            out.println("</tr>");
            out.print("<a href='InsCustomer' class='btn btn-primary'>Add Customer</a><br><br>");
            Collection<Customer> customer = pub.getAllCustomer();
            for (Customer cust : customer) {
                out.println("<tr>");
                out.println("<td>" + cust.getCustomerID() + "</td>");
                out.println("<td>" + cust.getFirstName() + "</td>");
                out.println("<td>" + cust.getLastName() + "</td>");
                out.println("<td><a href='getAddress?cid=" + cust.getCustomerID() + "' class='btn btn-primary'>Address</a>");
                out.println("<td><a href='cSubs?cid=" + cust.getCustomerID() + "' class='btn btn-warning' >Subscription</a>");
                out.println("<td><a href='delCust?del_id=" + cust.getCustomerID() + "' class='btn btn-danger'>Delete</a>  "
                        + "<a href='OprationCust?edit_id=" + cust.getCustomerID() + "'class='btn btn-secondary'>Update</a>"
                        + "</td>");

                out.println("</tr>");
            }
            out.println("</table>");
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
