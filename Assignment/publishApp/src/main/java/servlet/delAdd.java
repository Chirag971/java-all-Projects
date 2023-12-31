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
@WebServlet(name = "delAdd", urlPatterns = {"/delAdd"})
public class delAdd extends HttpServlet {

     @EJB
    PublishBeanLocal pub;
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String del_id = request.getParameter("del_id");
        String cId = request.getParameter("cId");
        if (del_id != null && cId != null) {
            int aid = Integer.parseInt(del_id);
            int cid = Integer.parseInt(cId);

            pub.removeAddressToCustomer(aid, cid);
         response.sendRedirect("getAddress?cid="+cId+"");}
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
