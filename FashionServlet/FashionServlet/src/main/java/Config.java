/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

//For Files
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/Config"})
@MultipartConfig
public class Config extends HttpServlet {
    
    public static String hashPassword(String plainPassword) {
        String salt = BCrypt.gensalt(); // Generate a random salt
        return BCrypt.hashpw(plainPassword, salt);
    }

    // Verify a hashed password
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        
        JSONObject custom_response = new JSONObject();
        Connection con = null;
        HttpSession session = request.getSession();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/fashion_store", "root", "deep@007");
        }
        catch(Exception err)
        {
            custom_response.put("success", false);
            custom_response.put("message", err.toString());
        }
        
        if(request.getParameter("what").equalsIgnoreCase("login"))
        {
            String phone = request.getParameter("phoneNumber");
            String password = request.getParameter("password");
            
            try
            {
                Statement stmt = con.createStatement();
                String query = "select count(*) as 'counter',id, password, username from user_master where phone = " + phone;
                ResultSet rs = stmt.executeQuery(query);
                
                while(rs.next())
                {
                    if(rs.getInt("counter") != 0)
                    {
                        if(verifyPassword(password, rs.getString("password")))
                        {
                            Hashtable<Integer, Integer> cartTbl = new Hashtable<>();
                            session.setAttribute("login", "yes");
                            session.setAttribute("username", rs.getString("username"));
                            session.setAttribute("userId", rs.getInt("id"));
                            session.setAttribute("cart", 0);
                            session.setAttribute("cartTable", cartTbl);
                            session.setAttribute("admin", "yes");
                            
                            custom_response.put("success", true);
                            custom_response.put("message", "Login Successful.");
                            if(phone.equalsIgnoreCase("1000000000"))
                            {
                                custom_response.put("admin", true);
                            }
                        }
                        else
                        {
                            custom_response.put("success", false);
                            custom_response.put("message", "Credentials does not match.");
                        }
                    }
                    else
                    {
                        custom_response.put("success", false);
                        custom_response.put("message", "User Data not found");
                    }
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("register"))
        {
            String username = request.getParameter("username");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String question = request.getParameter("securityQuestion");
            String answer = request.getParameter("securityAnswer");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String pincode = request.getParameter("pincode");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            
            try
            {
                Statement stmt = con.createStatement();
                String query = "select count(*) as 'counter' from user_master where phone = " + phone + " and email = '"+ email +"'";
                ResultSet rs = stmt.executeQuery(query);
                boolean flag = true;
                while(rs.next())
                {
                    if(rs.getInt("counter") != 0)
                    {
                        flag = false;
                        custom_response.put("success", false);
                        custom_response.put("message", "You are already registered, please login.");
                    }
                }
                
                if(flag)
                {
                    query = "insert into user_master(username, password, security_question, security_answer, email, phone, address, pincode, state, city) values('"+ username.trim() +"', '"+ hashPassword(password.trim()) +"', '"+ question.trim() +"', '"+ answer.trim() +"', '"+ email +"', "+ phone.trim() +", '"+ address.trim() +"', "+ pincode.trim() +", '"+ state.trim() +"', '"+ city.trim() +"')";
                    if(stmt.executeUpdate(query) > 0)
                    {
                        custom_response.put("success", true);
                        custom_response.put("message", "User Registration Success.");
                    }
                    else
                    {
                        custom_response.put("success", false);
                        custom_response.put("message", "Some error occurred.");
                    }
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("getSecQuestion"))
        {
            String phone = request.getParameter("phone");
            boolean flag = true;
            String question = null;
            String answer = null;
            try
            {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select count(*) as 'counter', security_question, security_answer from user_master where phone = "+ phone.trim() +"");
                
                while(rs.next())
                {
                    if(rs.getInt("counter") == 0)
                    {
                        flag = false;
                    }
                    else
                    {
                        question = rs.getString("security_question");
                        answer = rs.getString("security_answer");
                    }
                }
                
                if(flag)
                {
                    custom_response.put("success", true);
                    custom_response.put("question", question);
                    custom_response.put("answer", answer);
                }
                else
                {
                    custom_response.put("success", false);
                    custom_response.put("message", "User not found.");
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("changePassword"))
        {
            try
            {
                Statement stmt = con.createStatement();
                String query = "update user_master set password = '"+ hashPassword(request.getParameter("password")) +"' where phone = " + request.getParameter("phone");
                
                if(stmt.executeUpdate(query) > 0)
                {
                    custom_response.put("success", true);
                    custom_response.put("message", "Password updated successfully.");
                }
                else
                {
                    custom_response.put("success", false);
                    custom_response.put("message", "Some error occurred.");
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("addToCart"))
        {
            Hashtable<Integer, Integer> cartTbl = (Hashtable<Integer, Integer>) session.getAttribute("cartTable");
            
            if(cartTbl.containsKey(Integer.parseInt(request.getParameter("pid"))))
            {
                int oldQty = cartTbl.get(Integer.parseInt(request.getParameter("pid")));
                
                int newQty = oldQty + Integer.parseInt(request.getParameter("qty"));
                
                cartTbl.put(Integer.parseInt(request.getParameter("pid")), newQty);
            }
            else
            {
                cartTbl.put(Integer.parseInt(request.getParameter("pid")), Integer.parseInt(request.getParameter("qty").toString()));
                session.setAttribute("cart", (Integer.parseInt(session.getAttribute("cart").toString()) + 1));
            }
            session.setAttribute("cartTable", cartTbl);
            custom_response.put("success", true);
            custom_response.put("message", "Item added to cart.");
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("removeItem"))
        {
            Hashtable<Integer, Integer> cartTbl = (Hashtable<Integer, Integer>) session.getAttribute("cartTable");
            
            cartTbl.remove(Integer.parseInt(request.getParameter("pid")));
            session.setAttribute("cartTable", cartTbl);
            custom_response.put("success", true);
            custom_response.put("message", "Item removed from cart.");
            
            session.setAttribute("cart", (Integer.parseInt(session.getAttribute("cart").toString()) - 1));
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("checkout"))
        {
            try
            {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = dateFormat.format(calendar.getTime());
                Statement stmt = con.createStatement();
                float total = Float.parseFloat(request.getParameter("total"));
                float tax = ((total * 5) / 105);
                if(stmt.executeUpdate("insert into order_master(order_date, user_id, payment_mode, tax, total, status) values('"+ currentDate +"', "+ session.getAttribute("userId").toString() +", 'Cash On Delivery', "+ tax +", "+ total +", 'Ordered')") > 0)
                {
                    ResultSet ids = stmt.getGeneratedKeys();
                    int id = 0;
                    while(ids.next())
                    {
                        id = ids.getInt(1);
                    }
                    Statement ins = con.createStatement();
                    Hashtable<Integer, Integer> cartTbl = (Hashtable<Integer, Integer>) session.getAttribute("cartTable");

                    Enumeration<Integer> keys = cartTbl.keys();

                    while(keys.hasMoreElements())
                    {
                        ResultSet rs = stmt.executeQuery("select * from product_master where id = " + keys.nextElement().toString());

                        while(rs.next())
                        {
                            float price = rs.getFloat("price") * Float.parseFloat(cartTbl.get(rs.getInt("id")).toString());
                            float discount = rs.getFloat("discount");
                            float fdis = (price * (discount / 100));
                            ins.executeUpdate("insert into order_details(order_id, product_id, price, qty, discount) values("+ id +", "+ rs.getInt("id") +", "+ price +", "+ cartTbl.get(rs.getInt("id")).toString() +", "+ fdis +")");
                            ins.executeUpdate("update product_master set stock = stock - "+ cartTbl.get(rs.getInt("id")).toString() +" where id = "+ rs.getInt("id") +"");
                        }
                    }
                    cartTbl.clear();
                    session.setAttribute("cartTable", cartTbl);
                    session.setAttribute("cart", 0);
                    
                    custom_response.put("success", true);
                    custom_response.put("message", "Order placed successfully.");
                    session.setAttribute("orderId", id);
                }
                else
                {
                    custom_response.put("success", false);
                    custom_response.put("message", "Some error occurred.");
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("getOrder"))
        {
            try
            {
                Statement stmt = con.createStatement();
                String exp = "";
                ResultSet rs = stmt.executeQuery("select od.price, od.qty, pd.name, ((od.price - od.discount) / od.qty) as 'sprice' from order_details as od join product_master as pd on pd.id = od.product_id where order_id = " + request.getParameter("id"));
                while(rs.next())
                {
                    exp += "<tr><td>"+ rs.getString("name") +"</td><td>"+ rs.getString("sprice") +"</td><td>"+ rs.getString("qty") +"</td><td>"+ rs.getString("price") +"</td></tr>";
                }
                
                custom_response.put("success", true);
                custom_response.put("message", exp);
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
            
        }
        else if(request.getParameter("what").equalsIgnoreCase("addCategory"))
        {
            try
            {
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate("insert into category_master(name) values('"+ request.getParameter("name") +"')") > 0)
                {
                    custom_response.put("success", true);
                    custom_response.put("message", "Catgeory inserted.");
                }
                else
                {
                    custom_response.put("success", false);
                    custom_response.put("message", "Some error occured.");
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("deleteCategory"))
        {
            try
            {
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate("delete from category_master where id = "+ request.getParameter("id") +"") > 0)
                {
                    custom_response.put("success", true);
                    custom_response.put("message", "Catgeory deleted.");
                }
                else
                {
                    custom_response.put("success", false);
                    custom_response.put("message", "Some error occured.");
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("addProduct"))
        {
            try
            {
                Part filePart = request.getPart("image");
                String fileName = getFileName(filePart);

                InputStream fileContent = filePart.getInputStream();
                Path targetPath = Paths.get("/home/deep/JavaEE/FashionServlet/src/main/webapp/product-images/", fileName);

                Files.copy(fileContent, targetPath, StandardCopyOption.REPLACE_EXISTING);
                
                Statement stmt = con.createStatement();
                if(stmt.executeUpdate("insert into product_master(name, price, unit, discount, image, category_id, stock) values('"+ request.getParameter("productName") +"', "+ request.getParameter("price") +", '"+ request.getParameter("unit") +"', "+ request.getParameter("discount") +", '../product-images/"+  fileName +"', "+ request.getParameter("category") +", "+ request.getParameter("stock") +")") > 0)
                {
                    custom_response.put("success", true);
                    custom_response.put("message", "Product inserted successfully.");
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
        else if(request.getParameter("what").equalsIgnoreCase("updateStock"))
        {
            try
            {
                Statement stmt = con.createStatement();
                
                if(stmt.executeUpdate("update product_master set stock = "+ request.getParameter("qty") +" where id = "+ request.getParameter("id") +"") > 0)
                {
                    custom_response.put("success", true);
                    custom_response.put("message", "Stock Updated.");
                }
                else
                {
                    custom_response.put("success", false);
                    custom_response.put("message", "Some error occured.");
                }
            }
            catch(Exception err)
            {
                custom_response.put("success", false);
                custom_response.put("message", err.toString());
            }
            response.getWriter().write(custom_response.toString());
        }
    }
    
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
