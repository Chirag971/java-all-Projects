/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kewal dungarwal
 */
public class conn {
   static Connection con;

    public static Connection createc() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/fashion_store";
            con = DriverManager.getConnection(url, "root", "");
              System.out.println("connection");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex); }
        return con;
    }  
}
