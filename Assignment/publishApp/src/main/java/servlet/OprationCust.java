package servlet;

import Bean.PublishBeanLocal;
import Entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OprationCust", urlPatterns = {"/OprationCust"})
public class OprationCust extends HttpServlet {

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
//         processRequest(request, response);
        PrintWriter out = response.getWriter();
        String edit_id = request.getParameter("edit_id");
        int eid = Integer.parseInt(edit_id);
        Customer customer = (Customer) pub.findCustomerById(eid);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet OprationCust</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div style=\"text-align: center;\">");
        out.println("<h1>Update Customer</h1>");
        out.println("<form action='' method='post'>"); // Use the appropriate action URL
        out.println("<label for='cId'>Customer ID</label>");
        out.println("<input type='text' id='cId' name='cId' value='" + customer.getCustomerID() + "' readonly><br/><br>");
        out.println("<label for='firstName'>First Name</label>");
        out.println("<input type='text' id='firstName' name='firstName' value='" + customer.getFirstName() + "'><br/><br>");
        out.println("<label for='lastName'>Last Name</label>");
        out.println("<input type='text' id='lastName' name='lastName' value='" + customer.getLastName() + "'><br/><br>");
        out.println("<input type='submit' name='edit' value='Update Customer'>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
//        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         processRequest(request, response);
        try {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            int cId = Integer.parseInt(request.getParameter("cId"));
            pub.updateCustomer(firstName, lastName, cId);
            response.sendRedirect("getCustomer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
