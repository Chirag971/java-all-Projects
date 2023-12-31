/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assig_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author LENOVO
 */
public class hashMapp {

    static HashMap<String, Integer> hp = new HashMap<>();

    static void associateHashmap() {
        System.out.println("<==================associateHashmap============>");
        hp.put("vishal", 1);
        hp.put("vaibhav", 2);
        hp.put("sachin", 3);
        hp.put("karan", 4);
        hp.put("priya", 5);

        System.out.println("Hash map :" + hp);
        for (Map.Entry x : hp.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }

    static void noOfHashmap() {
        System.out.println("<==================noOfHashmap============>");
        System.out.println("Size of the hash map: " + hp.size());
    }

    static void copyMapToAnotherMap() {
        System.out.println("<==================copyMapToAnotherMap============>");
        System.out.println("\nValues in first map: " + hp);

        HashMap<String, Integer> hp2 = new HashMap<>();
        hp2.put("neha", 6);
        hp2.put("kartik", 7);
        hp2.put("punit", 8);
        System.out.println("\nValues in second map: " + hp2);

        // put all values in secondmap
        hp2.putAll(hp);
        System.out.println("\nNow values in second map: " + hp2);
    }

    static void removeMapping() {
        System.out.println("<==================removeMapping============>");
        System.out.println("-------before removing------");
        System.out.println(hp);

        // clear() method 
        hp.clear();
        System.out.println("--------After removing-------");
        System.out.println(hp);
    }

    static void checkKeyvalueMapping() {
        System.out.println("<==================checkKeyvalueMapping============>");

        hp.put("vishal", 1);
        hp.put("vaibhav", 2);
        hp.put("sachin", 3);
        System.out.println("Hash map :" + hp);

        boolean res = hp.isEmpty();

        System.out.println("Is Hashmap Empty : " + res);
        hp.clear();
        res = hp.isEmpty();// check if map is empty
        System.out.println("Is Hashmap Empty : " + res);
    }

    static void shallowCopyOfHashmap() {
        System.out.println("<==================shallowCopyOfHashmap============>");
        hp.put("vishal", 1);
        hp.put("vaibhav", 2);
        hp.put("sachin", 3);
        hp.put("karan", 4);
        hp.put("priya", 5);
        System.out.println("The Original map: " + hp);

        HashMap<String, Integer> new_hp = (HashMap<String, Integer>) hp.clone();
        System.out.println("Cloned map: " + new_hp);
    }

    static void mappingOfSpecifiedKey() {
        System.out.println("<===============mappingOfSpecifiedKey============>");

        System.out.println("The Original map: " + hp);
        System.out.println("1. Is key 'sachin' exists?");
        if (hp.containsKey("sachin")) {
            System.out.println("yes! - " + hp.get("sachin"));
        } else {
            System.out.println("no!");
        }

        System.out.println("\n2. Is key 'priya' exists?");
        if (hp.containsKey("priya")) {
            System.out.println("yes! - " + hp.get("priya"));
        } else {
            System.out.println("no!");
        }
    }

    static void mappingOfSpecifiedValue() {
        System.out.println("<===============mappingOfSpecifiedValue============>");

        System.out.println("HashMap : " + hp);
        System.out.println("1. Is value \'vishal\' Exists ?");
        if (hp.containsValue("vishal")) {
            System.out.println("Yes! ");
        } else {
            System.out.println("no!");
        }

        System.out.println("\n2. Is value \'karan\' Exists ?");
        if (hp.containsValue("karan")) {
            System.out.println("yes! - ");
        } else {
            System.out.println("No!");
        }

    }

    static void createSetview() {
        System.out.println("<===============mappingOfSpecifiedValue============>");
        System.out.println("HashMap : " + hp);

        Set set = hp.entrySet();
        // check set values
        System.out.println("Set values: " + set);
    }

    static void getValueOfSpecifiedkey() {
        System.out.println("<===============getValueOfSpecifiedkey============>");
        System.out.println("HashMap : " + hp);

        // Getting the value of "You"
        System.out.println("The Value is: " + hp.get("karan"));
        System.out.println("The Value is: " + hp.get("priya"));
    }

    static void setViewOfKeys() {
        System.out.println("<===============setViewOfKeys============>");
        HashMap<Integer, String> hp = new HashMap<>();

        hp.put(1, "Black");
        hp.put(2, "green");
        hp.put(3, "white");
        System.out.println("HashMap : " + hp);
        Set<Integer> hp1 = hp.keySet();
        System.out.println("Set View of Keys in HashMap : " + hp1);
    }

    static void collectionView() {
        System.out.println("<===============collectionView============>");
        System.out.println("HashMap : " + hp);
        System.out.println("Collection view is: " + hp.values());
    }

    public static void main(String[] args) {
        associateHashmap();
        noOfHashmap();
        copyMapToAnotherMap();
        removeMapping();
        checkKeyvalueMapping();
        shallowCopyOfHashmap();
        mappingOfSpecifiedKey();
        mappingOfSpecifiedValue();
        createSetview();
        getValueOfSpecifiedkey();
        setViewOfKeys();
        collectionView();
    }
}
