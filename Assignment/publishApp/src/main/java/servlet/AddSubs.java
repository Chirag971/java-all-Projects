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
@WebServlet(name = "AddSubs", urlPatterns = {"/AddSubs"})
public class AddSubs extends HttpServlet {

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
            out.println("<title>Servlet AddSubs</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"text-align:center;\">");
            out.println("<h3>Add Subsription</h3><br>");
            out.println("<form action='' method='post'>"); // Use the appropriate action URL
            out.println("<label for='title'>Title</label>");
            out.println("<input type='text' id='title' name='title'><br><br>");
            out.println("<label for='type'>Type</label>");
            out.println("<input type='text' id='type' name='type'><br><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
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
        
            String title = request.getParameter("title");
        String type = request.getParameter("type");
           
        pub.addSubscription(title, type);
        response.sendRedirect("getAllSubs");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
