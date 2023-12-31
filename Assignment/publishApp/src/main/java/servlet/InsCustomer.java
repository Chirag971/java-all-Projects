package servlet;

import Bean.PublishBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "InsCustomer", urlPatterns = {"/InsCustomer"})
public class InsCustomer extends HttpServlet {

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
            out.println("<title>Servlet InsCustomer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='' method='post'>"); // Use the appropriate action URL
            out.println("<label for='firstname'>First Name</label>");
            out.println("<input type='text' id='firstName' name='firstName'><br>");
            out.println("<label for='field2'>Last Name</label>");
            out.println("<input type='text' id='lastName' name='lastName'><br>");
            out.println("<input type='submit' value='Submit'>");
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
        processRequest(request, response);
        try {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            System.err.println(firstName);

               pub.addCustomer(firstName, lastName);
               System.err.println("||||||||||||||||||||||||||||||||||||||||||");
          response.sendRedirect(request.getContextPath()+"/getCustomer");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
