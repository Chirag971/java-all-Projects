/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sujeet
 */
public class CrudMethod {

    public static boolean insertCrud(Crudoperation cr) {
        boolean f = false;
        try {
//        jcbc
            Connection con = ConnPro.createC();
            String q = "insert into crud(fname,mark) values(?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
//            set the values of parameters
            pstmt.setString(1, cr.getFname());
            pstmt.setInt(2, cr.getMark());
//execute
            pstmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

    public static boolean deleteCrud(int id) {
        boolean f = false;
        try {
//        jcbc
            Connection con = ConnPro.createC();
            String q = "delete from crud where id=?";
            PreparedStatement pstmt = con.prepareStatement(q);
//            set the values of parameters
            pstmt.setInt(1, id);
//execute
            pstmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void Display() {
       
        try {
//        jcbc
            Connection con = ConnPro.createC();
            String q = "select * from crud";
            Statement stmt = con.createStatement();
            ResultSet set =  stmt.executeQuery(q);
            while(set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                int mark = set.getInt(3);
                System.out.println("-----------------------------------------------------------------");        
                System.out.println("ID :-"+ id);
                System.out.println("Name :-" + name);
                System.out.println("Mark :-" + mark);
                System.out.println("-----------------------------------------------------------------");        
            }
//execute

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

     public static boolean Update(Crudoperation cr) {
     boolean f = false;
        try {
//        jcbc
            Connection con = ConnPro.createC();
            String q = "UPDATE crud SET fname=?, mark=? where id=?";
            PreparedStatement pstmt = con.prepareStatement(q);
//            set the values of parameters
            pstmt.setString(1, cr.getFname());
            pstmt.setInt(2, cr.getMark());
            pstmt.setInt(3, cr.getId());
//execute
            pstmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
