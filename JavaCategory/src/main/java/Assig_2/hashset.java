/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assig_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author root
 */
public class hashset {
    static HashSet <String> names = new HashSet <String>();
    
    static void iterateAllElements(){
        System.out.println("iterateAllElements");
        
        Iterator i = names.iterator();
        while (i.hasNext()) {
            System.out.println("Name : " + i.next());
        }
    }
    
     static void numberOfElements() {
        System.out.println("<==================numberOfElements========================>");

        System.out.println("Names : " + names);
        System.out.println("No. of elements : " + names.size());
    }

    static void toEmptyHashSet() {
        System.out.println("<==================toEmptyHashSet========================>");

        HashSet<String> set = new HashSet<>();
        set.add("one");
        set.add("Two");
        set.add("Three");

        System.out.println("Set : " + set);
        set.clear();
        System.out.println("Set after empty it: " + set);
    }

    static void checkEmptyOrNot() {
        System.out.println("<==================checkEmptyOrNot========================>");

        HashSet<String> set = new HashSet<>();
        System.out.println("Names : " + names);
        System.out.println("Set : " + set);

        System.out.println("Set is empty or not : " + set.isEmpty());
        System.out.println("Names is empty or not : " + names.isEmpty());
    }

    static void cloneHashSet() {
        System.out.println("<==================cloneHashSet========================>");

        HashSet<String> set = new HashSet<>();
        System.out.println("Names : " + names);
        System.out.println("Set : " + set);
        set = (HashSet<String>) names.clone();
        System.out.println("Set after cloning names to it : " + set);
    }

    static void hashSetToArray() {
        System.out.println("<==================hashSetToArray========================>");

        HashSet<String> set = new HashSet<>();
        set.add("one");
        set.add("Two");
        set.add("Three");
        System.out.println("Set : " + set);

        String[] newArray = new String[set.size()];
        set.toArray(newArray);
        System.out.println("Array :");
        for (String a : newArray) {
            System.out.println(a);
        }
    }
    static void hashSetToTreeSet() {
        System.out.println("<==================hashSetToTreeSet========================>");

        HashSet<String> set = new HashSet<>();
        set.add("one");
        set.add("Two");
        set.add("Three");
        System.out.println("Set : " + set);

        TreeSet<String> treeset = new TreeSet<>(set);
        System.out.println("Tree Set :");
        for (String a : treeset) {
            System.out.println(a);
        }
    }
    
    static void noLessThan7() {
        System.out.println("<==================noLessThan7========================>");

        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> head = new TreeSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);

        System.out.println("Set : " + set);

        head = (TreeSet<Integer>) set.headSet(7);
        Iterator i = head.iterator();
        while(i.hasNext()){
            System.out.println( i.next());
        }  
    }
 static void compareHashSet() {
        System.out.println("<==================compareHashSet========================>");

        HashSet<String> set1 = new HashSet<>();
        set1.add("one");
        set1.add("Two");
        set1.add("Three");
        set1.add("Four");
        
        HashSet<String> set2 = new HashSet<>();
        set2.add("one");
        set2.add("Two");
        set2.add("Three");
        set2.add("Five");

        System.out.println("Set 1 : " + set1);
        System.out.println("Set 2 : " + set2);

        ArrayList<String> result = new ArrayList<>();

        for(String e : set1){
            result.add(set2.contains(e) ? "Yes" : "No");
        }
        System.out.println("Compare : " + result);
    }
    
    static void retainCommonElements() {
        System.out.println("<==================retainCommonElements========================>");

        HashSet<String> set1 = new HashSet<>();
        set1.add("one");
        set1.add("Two");
        set1.add("Three");
        set1.add("Four");

        HashSet<String> set2 = new HashSet<>();
        set2.add("one");
        set2.add("Two");
        set2.add("Three");
        set2.add("Five");

        System.out.println("Set 1 : " + set1);
        System.out.println("Set 2 : " + set2);

        set1.retainAll(set2);
        System.out.println("Common Elements : " + set1);
    }
     
    static void removeAllElements() {
        System.out.println("<==================removeAllElements========================>");

        HashSet<String> set1 = new HashSet<>();
        set1.add("one");
        set1.add("Two");
        set1.add("Three");
        set1.add("Four");

        System.out.println("Set : " + set1);
        set1.removeAll(set1);
        System.out.println("Set after removing all Elements : " + set1);
    }
    

    public static void main(String[] args) {
        // TODO code application logic here
        names.add("Nick");
        names.add("Nikita");
        names.add("Arun");
        names.add("Aditya");
        names.add("Jay");

        System.out.println("Names : " + names);

        iterateAllElements();
        numberOfElements();
        toEmptyHashSet();
        checkEmptyOrNot();
        cloneHashSet();
        hashSetToArray();
        hashSetToTreeSet();
        noLessThan7();
        compareHashSet();
        retainCommonElements();
        removeAllElements();
    }
}
