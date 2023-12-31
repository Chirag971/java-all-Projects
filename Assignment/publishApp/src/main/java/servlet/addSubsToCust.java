/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.PublishBeanLocal;
import Entities.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
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
@WebServlet(name = "addSubsToCust", urlPatterns = {"/addSubsToCust"})
public class addSubsToCust extends HttpServlet {
    
    @EJB
    PublishBeanLocal pub;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//       processRequest(request, response);
 out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addSubsToCust</title>");
            out.println("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container text-center'>");
            out.println("<h3>Add Subscription To Customer</h3>");
            
            out.println("<form action='' method='post'><br><br>"); // Use the appropriate action URL
            out.println("<label for='dropdown'>Select Title:</label>");
            out.println("<select id='dropdown' name='subs' class='form-select-md'>");
            Collection<Subscription> subscription = pub.getAllSubscription();
            for (Subscription subs : subscription) {
                out.println("<option value='" + subs.getSubscriptionId() + "'>" + subs.getTitle() + "</option>");
                
            }
            out.println("</select><br><br>");
            out.println("<input type='submit' value='Add' class='btn btn-primary'>");
            out.println("</form><br>");
            int cId = Integer.parseInt(request.getParameter("cId"));
             out.println("<a href='cSubs?cid=" + cId + "' class='btn btn-warning'>Back</a>");
            out.println("</div>");
            
             out.println("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>");

            out.println("</body>");
            out.println("</html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//       processRequest(request, response);
        
        try {
            int cId = Integer.parseInt(request.getParameter("cId"));
            String[] subsParam = request.getParameterValues("subs");
            List<Integer> sIds = new ArrayList<>();
            
            if (subsParam != null) {
                for (String s : subsParam) {
                    sIds.add(Integer.parseInt(s));
                }
            }
            
//            System.out.println(cId);
//            System.out.println(sIds);
            pub.addSubscriptionsToCustomer(cId, sIds);
//            response.sendRedirect("cSubs?cid=" + cId + "");
            response.sendRedirect("cSubs?cid=" + cId + "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
