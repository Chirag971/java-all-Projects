/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assig_2;

import java.util.*;

/**
 *
 * @author root
 */
public class linkedlist {
     static LinkedList<String> colors = new LinkedList<>();

    static void appendAtEnd(){
        System.out.println("<==================appendAtEnd========================>");

        colors.add("Red");
        System.out.println("Colors : " + colors);  
    }
    
    static void iterateThroughAll(){
        System.out.println("<==================iterateThroughAll========================>");
        Integer count = 1;
        for(String color : colors){
            System.out.println("Color "+ count +": " + color);
            count++;
        } 
    }
    
    static void iterateAllFromSpecifiedPosition(){
        System.out.println("<==================iterateAllFromSpecifiedPosition========================>");
        ListIterator list = colors.listIterator(2);
        System.out.println("All Colors : " + colors);
        
        System.out.println("Colors From index 2 : ");

        while(list.hasNext()){
            System.out.println(list.next());
        }   
    }

    static void iterateInReverseOrder() {
        System.out.println("<==================iterateInReverseOrder========================>");
        Iterator list = colors.descendingIterator();
        System.out.println("All Colors : " + colors);

        System.out.println("Colors In Reverse Order : ");

        while (list.hasNext()) {
            System.out.println(list.next());
        }
    }
    
    static void insertAtSpecifiedPosition() {
        System.out.println("<==================insertAtSpecifiedPosition========================>");

        System.out.println("Colors : " + colors);

        colors.add(2,"Yellow");
        System.out.println("Inserting at index 2 : " + colors);
    }

    static void insertAtFirstAndLast() {
        System.out.println("<==================insertAtFirstAndLast========================>");

        System.out.println("Colors : " + colors);

        colors.addFirst("Black");
        System.out.println("Inserting at First : " + colors);
        colors.addLast("White");
        System.out.println("Appending at Last : " + colors);
    }
    
    static void insertAtFront() {
        System.out.println("<==================insertAtFront========================>");

        System.out.println("Colors : " + colors);

        colors.offerFirst("Orange");
        System.out.println("Inserting at Front : " + colors); 
    }
    
    static void insertAtEnd() {
        System.out.println("<==================insertAtEnd========================>");

        System.out.println("Colors : " + colors);

        colors.offerLast("Grey");
        System.out.println("Inserting at End : " + colors);
    }
    
    static void insertAllAtSpecifiedPosition() {
        System.out.println("<==================insertAllAtSpecifiedPosition========================>");

        System.out.println("Colors : " + colors);

        Collection<String> list = new ArrayList<>();
        list.add("67");
        list.add("23");
        list.add("45");

        System.out.println("List 2 : " + list);

        colors.addAll(4, list);
        System.out.println("After Inserting List to Colors At 4 index : " + colors);
    }
    
    static void getFirstLastElement() {
        System.out.println("<==================getFirstLastElement========================>");

        System.out.println("Colors : " + colors);
        System.out.println("First Element : " + colors.getFirst());
        System.out.println("Last Element : " + colors.getLast());
    }
    
    static void displayWithPosition() {
        System.out.println("<==================displayWithPosition========================>");

        System.out.println("Colors : " + colors);

        for(Integer i = 0; i < colors.size(); i++){
            System.out.println("Color "+ i +": " + colors.get(i));
        }   
    }
    
    static void removeSpecifiedElement() {
        System.out.println("<==================removeSpecifiedElement========================>");

        System.out.println("Colors : " + colors);
        colors.remove(4);
        System.out.println("Colors After removing Element at 4 index : " + colors);
    }
    
    static void removeFirstAndLast() {
        System.out.println("<==================removeFirstAndLast========================>");

        System.out.println("Colors : " + colors);
        colors.removeFirst();
        colors.removeLast();
        System.out.println("Colors After removing First and Last Element : " + colors);
    }

    static void removeAllElements() {
        System.out.println("<==================removeFirstAndLast========================>");

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("List : " + list);
        list.clear();
        System.out.println("List After removing all Elements : " + list);
    }
    
    
    static void swapTwoElements() {
        System.out.println("<==================swapTwoElements========================>");

        System.out.println("Colors : " + colors);
        Collections.swap(colors, 0, 4);
        
        System.out.println("Colors After swapping Element at index 0 and 4 : " + colors);
    }
    
    static void shuffleElements() {
        System.out.println("<==================shuffleElements========================>");

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        System.out.println("List : " + list1);
        Collections.shuffle(list1);

        System.out.println("List After Shuffling Elements : " + list1);
    }

    static void joinTwoList() {
        System.out.println("<==================joinTwoList========================>");

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("x");
        list2.add("y");
        list2.add("z");
        
        LinkedList<String> combinedList = new LinkedList<>();
        combinedList.addAll(list1);
        combinedList.addAll(list2);
        
        System.out.println("List 1 : " + list1);
        System.out.println("List 2 : " + list2);
        System.out.println("Combined List : " + combinedList);
    }
    
    static void copyList() {
        System.out.println("<==================copyList========================>");

        LinkedList<String> list = new LinkedList<>();
        
        System.out.println("List: " + list);
        list = (LinkedList<String>) colors.clone();
        System.out.println("List After Copy: " + list);
    }
    
    static void removeAndReturnFirst() {
        System.out.println("<==================removeAndReturnFirst========================>");

        System.out.println("Colors : " + colors);
        System.out.println("Removing And return : " + colors.pollFirst());
        System.out.println("Colors After removing : " + colors);
    }
    
    static void retrieveButNotRemoveFirst() {
        System.out.println("<==================retrieveButNotRemoveFirst========================>");

        System.out.println("Colors : " + colors);
        System.out.println("Retrieve First : " + colors.peekFirst());
        System.out.println("Colors After retrieving : " + colors);
    }
    
    static void retrieveButNotRemoveLast() {
        System.out.println("<==================retrieveButNotRemoveLast========================>");

        System.out.println("Colors : " + colors);
        System.out.println("Retrieve Last : " + colors.peekLast());
        System.out.println("Colors After retrieving : " + colors);
    }
    
    static void checkElementExists() {
        System.out.println("<==================checkElementExists========================>");

        System.out.println("Colors : " + colors);
        System.out.println("Checking Orange color : " + colors.contains("Orange"));
        System.out.println("Checking Blue color : " + colors.contains("Blue"));
    }
    
    static void convertToArrayList() {
        System.out.println("<==================convertToArrayList========================>");

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        
        System.out.println("Linked List : " + list1);
        
        List<String> newList = new ArrayList<>(list1);
        
        System.out.println("List Into ArrayList : " + newList);
    }
    
    static void compareTwoLinkedList() {
        System.out.println("<==================compareTwoLinkedList========================>");

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
  
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("a");
        list2.add("b");
        list2.add("e");
        list2.add("i");

        LinkedList<String> list3 = new LinkedList<>();

        for(String s : list1){
            list3.add(list2.contains(s) ? "YES" : "NO");
        }
        System.out.println("Linked List 1 : " + list1);
        System.out.println("Linked List 2 : " + list2);
        System.out.println("Compare : " + list3);
    }
    
    static void checkListIsEmpty() {
        System.out.println("<==================checkListIsEmpty========================>");

        LinkedList<String> list = new LinkedList<>();

        System.out.println("Colors : " + colors);
        
        System.out.println("List : " + list);
        System.out.println("Checking colors is empty or not : " + colors.isEmpty());
        System.out.println("Checking List is empty or not : " + list.isEmpty());
    }
    
    static void replaceElement() {
        System.out.println("<==================replaceElement========================>");

        System.out.println("Colors : " + colors);
        colors.set(0, "Orange");
        System.out.println("Colors after replacing index 0 : " + colors);
    }


    public static void main(String[] args) {
        // TODO code application logic here
        colors.add(0,"Green");
        colors.add(1,"Blue");
        colors.add(2, "Violet");
        colors.add(3, "Pink");

        appendAtEnd();
        iterateThroughAll();
        iterateAllFromSpecifiedPosition();
        iterateInReverseOrder();
        insertAtSpecifiedPosition();
        insertAtFirstAndLast();
        insertAtFront();
        insertAtEnd();
        insertAllAtSpecifiedPosition();
        getFirstLastElement();
        displayWithPosition();
        removeSpecifiedElement();
        removeFirstAndLast();
        removeAllElements();
        swapTwoElements();
        shuffleElements();
        joinTwoList();
        copyList();
        removeAndReturnFirst();
        retrieveButNotRemoveFirst();
        retrieveButNotRemoveLast();
        checkElementExists();
        convertToArrayList();
        compareTwoLinkedList();
        checkListIsEmpty();
        replaceElement();
        
        
        
        
    }
    
}
