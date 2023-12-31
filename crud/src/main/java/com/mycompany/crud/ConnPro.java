 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sujeet
 */
public class ConnPro {

    static Connection con;

    public static Connection createC() {
        try {
//          Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
//            crete connection
            String user = "root";
            String password = "sujeetm8866";
            String url = "jdbc:mysql://localhost:3306/javaproject";
            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }
}
