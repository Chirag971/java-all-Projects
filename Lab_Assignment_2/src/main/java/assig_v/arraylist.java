/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assig_v;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author root
 */
public class arraylist {
     static ArrayList<String> colors = new ArrayList<>();

    public static void createArrayList(){ 
        System.out.println("<==================createArrayList========================>");
        
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");

        System.out.println("Printing Collection :");
        System.out.println(colors);
    }
    
    static void iterateArrayList(){
        System.out.println("<==================iterateArrayList========================>");

        System.out.println("Iterating through ArrayList :");
        for(String i : colors){
            System.out.println(i);
        }
    }
    
    static void insertAtFirst(){ 
        System.out.println("<==================insertAtFirst========================>");

        colors.add(0,"Black");
        System.out.println("Printing After Inserting at first position :");
        System.out.println(colors);
    }
    
    static void retrieveElement() {
        System.out.println("<==================retrieveElement========================>");
        
        System.out.println("Retrieving Element at index 2 position :");
        System.out.println(colors.get(2));
    }
    
    static void updateElement() {
        System.out.println("<==================updateElement========================>");
        
        colors.set(2, "White");
        System.out.println("Updating Element at index 2 position :");
        System.out.println(colors);
    }
    
    static void removeThirdElement() {
        System.out.println("<==================removeThirdElement========================>");

        colors.remove(2);
        System.out.println("ArrayList after removing third Element :");
        System.out.println(colors);
    }
    
    static void searchElement() {
        System.out.println("<==================searchElement========================>");

        System.out.println("Searching for brown in ArrayList :" +  colors.contains("Brown"));
        System.out.println("Searching for Red in ArrayList :" + colors.contains("Red"));
    }
    
    static void sortArrayList() {
        System.out.println("<==================sortArrayList========================>");
        
        Collections.sort(colors);
        System.out.println("Sorted ArrayList :" + colors );
    }
    
    static void copyArrayList() {
        System.out.println("<==================copyArrayList========================>");

        ArrayList<String> copiedColors = colors;
        System.out.println("Copied ArrayList :" + copiedColors);
    }
    
    static void shuffleArrayList() {
        System.out.println("<==================shuffleArrayList========================>");

        Collections.shuffle(colors);
        System.out.println("Shuffled ArrayList :" + colors);
    }
    
    static void reverseArrayList() {
        System.out.println("<==================reverseArrayList========================>");

        Collections.reverse(colors);
        System.out.println("Reversed ArrayList :" + colors);
    }
    
    static void extractPortion() {
        System.out.println("<==================extractPortion========================>");

        // Element "toIndex" will not be included
        List<String> portion = colors.subList(1, 3);
        System.out.println("Portion of real ArrayList :" + portion);
    }
    
    static void compareArrayList() {
        System.out.println("<==================compareArrayList========================>");

        ArrayList<String> secondColors = (ArrayList<String>) colors.clone();
    
        System.out.println("First ArrayList :" + colors);
        System.out.println("Second ArrayList :" + secondColors);

        System.out.println("Comparing both ArrayList: "+colors.equals(secondColors));

        //Adding one extra element to second ArrayList
        secondColors.add("Pink");
        System.out.println("First ArrayList :" + colors);
        System.out.println("Second ArrayList After adding extra element: " + secondColors);
        System.out.println("Comparing both ArrayList after adding elements : " + colors.equals(secondColors));
    }
    
    static void swapElement() {
        System.out.println("<==================swapElement========================>");

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
        System.out.println("<==================cloneArrayList========================>");

        ArrayList<String> otherArrayList = (ArrayList<String>) colors.clone();

        System.out.println("Original ArrayList :" + colors);
        System.out.println("Cloned ArrayList :" + otherArrayList);      
    }
    
    static void emptyArrayList() {
        System.out.println("<==================emptyArrayList========================>");

        ArrayList<String> otherArrayList = new ArrayList<>();
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        System.out.println("ArrayList:" + otherArrayList);
        otherArrayList.clear();
        System.out.println("ArrayList After emptying it:" + otherArrayList);
    }
    
    static void testEmptyArrayList() {
        System.out.println("<==================testEmptyArrayList========================>");

        ArrayList<String> otherArrayList = new ArrayList<>();
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        System.out.println("ArrayList:" + otherArrayList);
        otherArrayList.clear();
        System.out.println("ArrayList After emptying it:" + otherArrayList);
        System.out.println("ArrayList is empty or not:" + otherArrayList.isEmpty());
    }
    
    
    static void trimArrayList() {
        System.out.println("<==================trimArrayList========================>");

        
        ArrayList<String> otherArrayList = new ArrayList<>(5);
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        otherArrayList.trimToSize();
        System.out.println("ArrayList After trimming it capacity:" + otherArrayList.size());
    }
    
    static void increaseSize() {
        System.out.println("<==================increaseSize========================>");

        ArrayList<String> otherArrayList = new ArrayList<>();
        otherArrayList.add("Grey");
        otherArrayList.add("Pink");

        // this will increase the capacity of the ArrayList to 5 elements
        otherArrayList.ensureCapacity(5);
        System.out.println("Printing ArrayList:" + otherArrayList);
    }
    
    static void replaceSecondElement() {
        System.out.println("<==================replaceSecondElement========================>");

        System.out.println("ArrayList before replace :" + colors);
        colors.set(1, "Blue");
        System.out.println("Replacing second Element :" + colors);
    }

    static void printUsingPosition() {
        System.out.println("<==================printUsingPosition========================>");

        System.out.println("Print using Element's Position :");
        for(Integer i =0; i<colors.size(); i++){
            System.out.println( colors.get(i));
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
          createArrayList();
          iterateArrayList();
          insertAtFirst();  
          retrieveElement();
          updateElement();
          removeThirdElement();
          searchElement();
          sortArrayList();
          copyArrayList();
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
