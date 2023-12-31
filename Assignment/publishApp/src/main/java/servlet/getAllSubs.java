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
@WebServlet(name = "getAllSubs", urlPatterns = {"/getAllSubs"})
public class getAllSubs extends HttpServlet {

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
            out.println("<title>Servlet getAllSubs</title>");
            out.println("</head>");
            out.println("<body>");
             out.println("<div style=\"text-align:center;\">");
            out.println("<h1>Subscription</h1>");
            out.println("<form action='sSubs' method='post'><br><br>"); // Use the appropriate action URL
            out.println("<label for='field2'>Search By Type :</label>");
            out.println("<input type='text' id='type' name='type'>");
            out.println("<input type='submit' value='Search'>");
            out.println("</form><br><br>");
            out.print("<a href='AddSubs'>Add Subscription</a><br><br>");
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Title</th>");
            out.println("<th>Type</th>");
            out.println("<th>Options</th>");
            out.println("</tr>");
            Collection<Subscription> subscription = pub.getAllSubscription();
            for (Subscription subs : subscription) {
                out.println("<td>" + subs.getTitle() + "</td>");
                out.println("<td>" + subs.getType() + "</td>");               
                out.println("<td><a href='delSubs?del_id=" + subs.getSubscriptionId() + "'>Delete</a>"
                        + "<a href='operationSubs?edit_id=" + subs.getSubscriptionId() + "'>Update</a>"
                        + "</td>");

                out.println("</tr>");
            }
            out.println("</table>");
             out.println("</div>");
            out.println("</body>");
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
