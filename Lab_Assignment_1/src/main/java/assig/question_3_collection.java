/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class question_3_collection {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("Names: " + names);
        Collections.reverse(names);
        System.out.println("Reversed Names: " + names);
    }
}
