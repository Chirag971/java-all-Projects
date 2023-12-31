/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.NewSessionBeanLocal;
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
@WebServlet(name = "pageVisit", urlPatterns = {"/pageVisit"})
public class pageVisit extends HttpServlet {

    @EJB
    NewSessionBeanLocal ns;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pageVisit</title>");
            out.println("</head>");
            out.println("<body>");

            String clientIp = request.getRemoteAddr();
            String pageUrl = request.getRequestURI();

            int visitCount = ns.recordVisit(clientIp, pageUrl);
            out.println("<h3>Page Visited: " + pageUrl + "</h3>");
//            out.println("<br/>");
            response.getWriter().println("<h3>Client IP: " + clientIp + "</h3>");
//            out.println("<br/>");
            response.getWriter().println("<h3>Visit Count: " + visitCount + "</h3>");
//             out.println("<br/>");
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
    }// </editor-fold>

}
