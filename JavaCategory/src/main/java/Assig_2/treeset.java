/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assig_2;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author root
 */
public class treeset {

    static TreeSet<String> colors = new TreeSet<>();

    static void createTreeSet() {
        System.out.println("<==================createTreeSet========================>");

        colors.add("Red");
        colors.add("Orange");
        colors.add("Green");
        colors.add("Yellow");
        System.out.println("Colors : " + colors);

    }

    static void iterateTreeSet() {

        System.out.println("<==================iterateTreeSet========================>");

        System.out.println("Iterating through TreeSet :");
        for (String i : colors) {
            System.out.println(i);
        }
    }

    static void addElements() {
        System.out.println("<========addElementsToAnotherTreeSet============>");

        TreeSet<String> tree_set2 = new TreeSet<String>();
        tree_set2.add("Pink");
        tree_set2.add("White");
        tree_set2.add("Black");
        System.out.println("Tree set2: " + tree_set2);

        // adding treetwo to treeone
        colors.addAll(tree_set2);
        System.out.println("Colors: " + colors);
    }

    static void reverseElements() {
        System.out.println("<==============reverseElements====================>");

        Iterator it = colors.descendingIterator();
        System.out.println("Elements in Reverse Order:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    static void firstAndLastElement() {
        System.out.println("<===============firstAndLAstElements========>");

        // Find first element of the tree set
        Object first_element = colors.first();
        System.out.println("First Element is: " + first_element);

        // Find last element of the tree set
        Object last_element = colors.last();
        System.out.println("Last Element is: " + last_element);
    }

    static void cloneTreeset() {
        System.out.println("<===========cloneElements=========>");

        System.out.println("Tree set: " + colors);
        TreeSet<String> new_colors = (TreeSet<String>) colors.clone();
        System.out.println("Cloned tree list: " + colors);
    }

    static void numberOfElements() {
        System.out.println("<=========numberOfElements============>");

        System.out.println("Tree set: " + colors);
        System.out.println("Size of the tree set: " + colors.size());
    }

    static void compareTwoTreeset() {
        System.out.println("<=========compareTwoTreeset>");

        System.out.println("First Tree set: " + colors);

        TreeSet<String> colors_2 = new TreeSet<String>();
        colors_2.add("Red");
        colors_2.add("Pink");
        colors_2.add("Black");
        colors_2.add("Orange");
        System.out.println("Second Tree set: " + colors_2);

        //comparison output in tree set
        TreeSet<String> result_set = new TreeSet<String>();
        for (String element : colors) {
            System.out.println(colors_2.contains(element) ? "Yes" : "No");
        }
    }

    static void noLessThan7() {
        System.out.println("<============noLessThan7===========>");

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
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    static void greaterOrEqualElements() {
        System.out.println("<==========greaterOrEqualThanElements>");

        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> head = new TreeSet<>();

        // Add numbers in the tree
        set.add(10);
        set.add(22);
        set.add(36);
        set.add(25);
        set.add(16);
        set.add(70);
        set.add(82);
        set.add(89);
        set.add(14);

        System.out.println("Greater than or equal to 86 : " + set.ceiling(86));
        System.out.println("Greater than or equal to 29 : " + set.ceiling(29));
    }

    static void lessOrEqualThanElements() {
        System.out.println("<==========lessOrEqualThanElements>");

        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> head = new TreeSet<>();

        // Add numbers in the tree
        set.add(10);
        set.add(22);
        set.add(36);
        set.add(25);
        set.add(16);
        set.add(70);
        set.add(82);
        set.add(89);
        set.add(14);

        System.out.println("Less than or equal to 86 : " + set.floor(86));
        System.out.println("Less than or equal to 29 : " + set.floor(29));
    }

    static void strictlyGreaterOrEqualThanElements() {
        System.out.println("<=========strictlyGreaterOrEqualThanElements>");

        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> head = new TreeSet<>();

        // Add numbers in the tree
        set.add(10);
        set.add(22);
        set.add(36);
        set.add(25);
        set.add(16);
        set.add(70);
        set.add(82);
        set.add(89);
        set.add(14);

        System.out.println("Strictly greater than 76 : " + set.higher(76));
        System.out.println("Strictly greater than 31 : " + set.higher(31));
    }

    static void lowerThanGivenElement() {
        System.out.println("<============lowerThanGivenEleemnet=============>");
        // New TreeSet 
        TreeSet<Integer> set = new TreeSet<>();

        // Adding element to TreeSet 
        set.add(40);
        set.add(50);
        set.add(30);
        set.add(10);
        set.add(20);
        set.add(100);

        System.out.println("TreeSet: " + set);
        // Print floor value of 23 
        System.out.println("Floor value of 23: "
                + set.floor(23));
    }

    static void retrieveAndRemoveFirstElement() {
        System.out.println("<=========retrieveAndRemovefirstElement==========>");

        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> head = new TreeSet<>();

        // Add numbers in the tree
        set.add(10);
        set.add(22);
        set.add(36);
        set.add(25);
        set.add(16);
        set.add(70);
        set.add(82);
        set.add(89);
        set.add(14);
        System.out.println("Original tree set: " + set);
        System.out.println("Removes the first(lowest) element: " + set.pollFirst());
        System.out.println("Tree set after removing first element: " + set);
    }

    static void retrieveAndRemoveLastElement() {
        System.out.println("<=========retrieveAndRemoveLastElement==========>");

        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> head = new TreeSet<>();

        // Add numbers in the tree
        set.add(10);
        set.add(22);
        set.add(36);
        set.add(25);
        set.add(16);
        set.add(70);
        set.add(82);
        set.add(89);
        set.add(14);
        System.out.println("Original tree set: " + set);
        System.out.println("Removes the last element: " + set.pollLast());
        System.out.println("Tree set after removing first element: " + set);
    }

    static void removeElement() {
        System.out.println("<=========removeElement==========>");
        
        TreeSet<Integer> obj = new TreeSet<>();
        obj.add(2);
        obj.add(8);
        obj.add(5);
        obj.add(1);
        obj.add(10);
        System.out.println("TreeSet: " + obj);
        System.out.println("TreeSet: " + obj.remove(5));
        System.out.println("TreeSet: " + obj);
    }

    public static void main(String args[]) {
        createTreeSet();
        iterateTreeSet();
        addElements();
        reverseElements();
        firstAndLastElement();
        cloneTreeset();
        numberOfElements();
        compareTwoTreeset();
        noLessThan7();
        greaterOrEqualElements();
        lessOrEqualThanElements();
        strictlyGreaterOrEqualThanElements();
        lowerThanGivenElement();
        retrieveAndRemoveFirstElement();
        retrieveAndRemoveLastElement();
        removeElement();
    }
}
