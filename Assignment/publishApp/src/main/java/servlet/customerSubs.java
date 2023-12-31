/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.PublishBeanLocal;
import Entities.Subscription;
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
@WebServlet(name = "customerSubs", urlPatterns = {"/cSubs"})
public class customerSubs extends HttpServlet {

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
            out.println("<title>Servlet customerSubs</title>");
           out.println("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container text-center'>");
             out.println("<h3>Manage Subscription</h3>");
            String custId = request.getParameter("cid");
           
      
            out.print("<a href='addSubsToCust?cId=" + custId + "'' class='btn btn-primary'>Add Subscription</a><br><br>");
           out.println("<table  class='table table-borderd table-striped w-100'>");
            out.println("<tr>");
            out.println("<th>Title</th>");
            out.println("<th>Type</th>");
            out.println("<th>Options</th>");
            out.println("</tr>");

            if (custId != null) {
                int cId = Integer.parseInt(custId);
                Collection<Subscription> subscription = pub.getAllSubscriptionsOfCustomer(cId);
                for (Subscription subs : subscription) {
                    out.println("<td>" + subs.getTitle() + "</td>");
                    out.println("<td>" + subs.getType() + "</td>");
                    out.println("<td><a href='custSubsOperation?del_id=" + subs.getSubscriptionId() + "&cId=" + custId + "' class='btn btn-danger'>Remove</a></td>");
                    out.println("</tr>");
                }
            }
            out.println("</table>");
            out.println("<a href='getCustomer' class='btn btn-warning'>Back</a>");
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
