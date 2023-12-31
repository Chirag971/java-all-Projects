package com.mycompany.lab_assignment_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab_Assignment_2 {

    static ArrayList<String> colors = new ArrayList<>();

    public static void createArrayList() {
        System.out.println("----------------------------------------- CREATE ------------------------------------------------");
        colors.add("Red");
        colors.add("Yellow");
        colors.add("Orange");
        colors.add("Blue");
        colors.add("Green");

        System.out.print("Printing Collection :-");
        System.out.println(colors);

    }

    static void iterateList() {
        System.out.println("----------------------------------------- Iterate ------------------------------------------------");

        System.out.println("Iterating through ArrayList :");
        for (String i : colors) {
            System.out.println(i);
        }

    }

    static void inFirst() {
        System.out.println("----------------------------------------- Insert At First ------------------------------------------------");

        colors.add(0, "grey");
        System.out.print("Printing After Inserting at first position :");
        System.out.println(colors);

    }

    static void updateEle() {
        System.out.println("----------------------------------------- Update Element ------------------------------------------------");

        colors.set(2, "babyPink");
        System.out.println("Updating Element at index 2 position :");
        System.out.println(colors);

    }

    static void removeThird() {
        System.out.println("----------------------------------------- Remove Third Element ------------------------------------------------");
        colors.remove(2);
        System.out.print("ArrayList after removing third Element :");
        System.out.println(colors);

    }

    static void search() {
        System.out.println("----------------------------------------- Search ------------------------------------------------");

        System.out.print("Searching for brown in ArrayList :" + colors.contains("Brown"));
        System.out.print("Searching for Red in ArrayList :" + colors.contains("Red"));

    }

    static void sortList() {
        System.out.println("----------------------------------------- Short List ------------------------------------------------");
        Collections.sort(colors);
        System.out.println("Sorted ArrayList :" + colors);

    }

    static void shuffleArrayList() {

        System.out.println("----------------------------------------- Shuffle Array ------------------------------------------------");

        Collections.shuffle(colors);
        System.out.println("Shuffled ArrayList :" + colors);

    }

    static void reverseArrayList() {

        System.out.println("----------------------------------------- Reverse Array List ------------------------------------------------");

        Collections.reverse(colors);
        System.out.println("Reversed ArrayList :" + colors);

    }

    static void extractPortion() {

        System.out.println("----------------------------------------- Extract Portion ------------------------------------------------");

        // Element "toIndex" will not be included
        List<String> portion = colors.subList(1, 3);
        System.out.println("Portion of real ArrayList :" + portion);

    }

    static void compareArrayList() {

        System.out.println("----------------------------------------- Compare Array List ------------------------------------------------");

        ArrayList<String> secondColors = (ArrayList<String>) colors.clone();

        System.out.println("First ArrayList :" + colors);
        System.out.println("Second ArrayList :" + secondColors);

        System.out.println("Comparing both ArrayList: " + colors.equals(secondColors));

        //Adding one extra element to second ArrayList
        secondColors.add("Pink");
        System.out.println("First ArrayList :" + colors);
        System.out.println("Second ArrayList After adding extra element: " + secondColors);
        System.out.println("Comparing both ArrayList after adding elements : " + colors.equals(secondColors));

    }

    static void swapElement() {

        System.out.println("----------------------------------------- Swap Element ------------------------------------------------");

        System.out.println("ArrayList before swapping:" + colors);
        //swap element at index 1 and 3
        Collections.swap(colors, 1, 3);
        System.out.println("ArrayList after swapping 1 and 3:" + colors);

    }

    static void joinArrayList() {

        System.out.println("<==================joinArrayList========================>");

        ArrayList<String> otherArrayList = new ArrayList<>();
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        System.out.println("First ArrayList :" + colors);
        System.out.println("Second ArrayList :" + otherArrayList);

        colors.addAll(otherArrayList);
        System.out.println("ArrayList after joining :" + colors);

    }

    static void cloneArrayList() {

        System.out.println("----------------------------------------- CREATE ------------------------------------------------");

        ArrayList<String> otherArrayList = (ArrayList<String>) colors.clone();

        System.out.println("Original ArrayList :" + colors);
        System.out.println("Cloned ArrayList :" + otherArrayList);

    }

    static void emptyArrayList() {

        System.out.println("----------------------------------------- CREATE ------------------------------------------------");

        ArrayList<String> otherArrayList = new ArrayList<>();
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        System.out.println("ArrayList:" + otherArrayList);
        otherArrayList.clear();
        System.out.println("ArrayList After emptying it:" + otherArrayList);

    }

    static void testEmptyArrayList() {

        System.out.println("----------------------------------------- CREATE ------------------------------------------------");

        ArrayList<String> otherArrayList = new ArrayList<>();
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        System.out.println("ArrayList:" + otherArrayList);
        otherArrayList.clear();
        System.out.println("ArrayList After emptying it:" + otherArrayList);
        System.out.println("ArrayList is empty or not:" + otherArrayList.isEmpty());

    }

    static void trimArrayList() {

        System.out.println("----------------------------------------- CREATE ------------------------------------------------");

        //Initializing array with capacity 5
        ArrayList<String> otherArrayList = new ArrayList<>(5);
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        otherArrayList.trimToSize();
        System.out.println("ArrayList After trimming it capacity:" + otherArrayList.size());

    }

    static void increaseSize() {

        System.out.println("----------------------------------------- CREATE ------------------------------------------------");

        ArrayList<String> otherArrayList = new ArrayList<>();
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        // this will increase the capacity of the ArrayList to 5 elements
        otherArrayList.ensureCapacity(5);
        System.out.println("Printing ArrayList:" + otherArrayList);

    }

    static void replaceSecondElement() {

        System.out.println("----------------------------------------- CREATE ------------------------------------------------");

        System.out.println("ArrayList before replace :" + colors);
        colors.set(1, "Blue");
        System.out.println("Replacing second Element :" + colors);

    }

    static void printUsingPosition() {

        System.out.println("----------------------------------------- CREATE ------------------------------------------------");

        System.out.println("Print using Element's Position :");
        for (Integer i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }

    }

    public static void main(String[] args) {
        createArrayList();
        iterateList();
        inFirst();
        updateEle();
        removeThird();
        search();
        sortList();
        shuffleArrayList();
        reverseArrayList();
        extractPortion();
        compareArrayList();
        swapElement();
        joinArrayList();
        cloneArrayList();
        emptyArrayList();
        testEmptyArrayList();
        trimArrayList();
        increaseSize();
        replaceSecondElement();
        printUsingPosition();

    }
}
