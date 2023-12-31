/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.CurrencyBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "result", urlPatterns = {"/result"})
public class result extends HttpServlet {

    @EJB
    CurrencyBeanLocal cl;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            try {
                String fromCurrency = request.getParameter("fcurrency");
                String toCurrency = request.getParameter("Tcurrency");
                String amountStr = request.getParameter("amt");

                BigDecimal amount = new BigDecimal(amountStr);

                out.println("<h3>From Currency :" + fromCurrency + "</h3>");
                out.println("<h3>To Currency :" + toCurrency + "</h3>");
                out.println("<h3>Ammount to be Converted :" + amount + "</h3>");

                BigDecimal convertedAmount = cl.convertCurrency(fromCurrency, toCurrency, amount);

                out.println("<h3>Converted Amount: " + convertedAmount + "</h3>");
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        

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
