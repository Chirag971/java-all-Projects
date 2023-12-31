/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sujeet
 */
public class Crud {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Crud Operation");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("PRESS 1 TO DISPLAY TABLE");
            System.out.println("PRESS 2 TO INSERT ");
            System.out.println("PRESS 3 TO DELETE");
            System.out.println("PRESS 4 TO UPDATE");
            System.out.println("PRESS 5 TO EXIT");

            System.out.print("Enter Your Choice :");
            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                //display student

                CrudMethod.Display();

            } else if (c == 2) {
//                insert 
                System.out.println("ENTER NAME :");
                String fname = br.readLine();
                System.out.println("ENTER MARK:");
                int mark = Integer.parseInt(br.readLine());

//                crete student object
                Crudoperation cr = new Crudoperation(fname, mark);
                boolean answer = CrudMethod.insertCrud(cr);
                if (answer) {
                    System.out.println("Inserted Succefully");
                } else {
                    System.out.println("Something Went Wrong");
                }
                System.out.println(cr);

            } else if (c == 3) {
//               delete
                System.out.print("Enter Id for Delete :-");
                int id = Integer.parseInt(br.readLine());
                boolean answer = CrudMethod.deleteCrud(id);
                if (answer) {
                    System.out.println("Deleted Succefully");
                } else {
                    System.out.println("Something Went Wrong");
                }
            } else if (c == 4) {
                System.out.print("Enter Id for Update :-");
                int id = Integer.parseInt(br.readLine());
                System.out.print("Enter Name for Change :-");
                String fname = br.readLine();
                System.out.print("Enter Mark fo change -");
                int mark = Integer.parseInt(br.readLine());
                Crudoperation cr = new Crudoperation(id,fname,mark);
                CrudMethod.Update(cr);
            } else if (c == 5) {
                break;
            } else {

            }
        }
        System.out.println("THANK YOU !!");
    }
}
