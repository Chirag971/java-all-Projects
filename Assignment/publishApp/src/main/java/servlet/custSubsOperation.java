/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.PublishBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "custSubsOperation", urlPatterns = {"/custSubsOperation"})
public class custSubsOperation extends HttpServlet {

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
            out.println("<title>Servlet custSubsOperation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet custSubsOperation at " + request.getParameter("del_id")+ "</h1>");
            out.println("<h1>Servlet custSubsOperation at " + request.getParameter("cId")+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        int cId = Integer.parseInt(request.getParameter("cId"));
        String[] sParam = request.getParameterValues("del_id");
        List<Integer> sIds = new ArrayList<>();
        
        if (sParam != null) {
            for (String s : sParam) {
                sIds.add(Integer.parseInt(s));
            }
        }
        pub.removeSubscriptionsToCustomer(cId, sIds);
        response.sendRedirect("cSubs?cid=" + cId + "");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
