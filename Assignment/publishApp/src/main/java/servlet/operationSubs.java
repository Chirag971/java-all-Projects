/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.PublishBeanLocal;
import Entities.Subscription;
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
@WebServlet(name = "operationSubs", urlPatterns = {"/operationSubs"})
public class operationSubs extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet operationSubs</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div style=\"text-align:center;\">");
        out.println("<h3>Update Subsription</h3><br>");
        out.println("<form action='' method='post'>");// Use the appropriate action URL
        String edit_id = request.getParameter("edit_id");
        if (edit_id != null) {
            int eid = Integer.parseInt(edit_id);
            Subscription s = (Subscription) pub.findSubsById(eid);
            out.println("<label for='title'>Title</label>");
            out.println("<input type='text' id='title' name='title' value='" + s.getTitle() + "'><br><br>");
            out.println("<label for='type'>Type</label>");
            out.println("<input type='text' id='type' name='type' value='" + s.getType() + "'><br><br>");
            out.println("<input type='submit' value='Submit'>");

        }
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
//        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        try {
            String title = request.getParameter("title");
            String type = request.getParameter("type");
            int sId = Integer.parseInt(request.getParameter("edit_id"));

            pub.updateSubscription(sId, title, type);
            response.sendRedirect("getAllSubs");
        } catch (Exception e) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
