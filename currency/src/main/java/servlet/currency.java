/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.CurrencyBeanLocal;
import Entites.Currencyconversionrate;
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
@WebServlet(name = "currency", urlPatterns = {"/currency"})
public class currency extends HttpServlet {

    @EJB
    CurrencyBeanLocal cl;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet currency</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='result'>");
            out.println("<h1>Currency Converter</h1>");
            Collection<Currencyconversionrate> fc = cl.getFromCurrency();
            out.println("<label for='fruitSelect'>Select a From Currency:</label>");
            out.println("<select id='fcurrency' name='fcurrency'>");
            for (Currencyconversionrate cl : fc) {
                out.println("<option value=" + cl.getFromCurrency() + ">" + cl.getFromCurrency() + "</option>");
            }
            out.println("</select>");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='fruitSelect'>Select a To Currency:</label>");
            out.println("<select id='tcurrency' name='Tcurrency'>");
            for (Currencyconversionrate cl : fc) {
                out.println("<option value=" + cl.getToCurrency() + ">" + cl.getToCurrency() + "</option>");
            }
            out.println("</select>");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for='textInput'>Enter Ammount To Convert:</label>");
            out.println("<input type='text' id='amt' name='amt' placeholder='Your Amuont...'>");
            out.println("<input type='submit' value='Submit'>"); // This is the submit button

            out.println("</form>");
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

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
