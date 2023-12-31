/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assig_2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author LENOVO
 */
public class priorityQueue {

    static PriorityQueue<String> queue = new PriorityQueue<>();

    static void createPriorityqueue() {
        System.out.println("<===========createPriorityqueue=================>");

        queue.add("Red");
        queue.add("Green");
        queue.add("Orange");
        queue.add("Grey");
        System.out.println("Elements of the Priority Queue:" + queue);
    }

    static void iteratePriorityQueue() {
        System.out.println("<============iteratePriorityQueue================>");

        System.out.println(queue);
        System.out.println("Iterating through PriorityQueue :");
        for (String i : queue) {
            System.out.println(i);
        }
    }

    static void addToAnotherPriorityqueue() {
        System.out.println("<============addToAnotherPriorityqueue=============>");

        System.out.println("Priority Queue1: " + queue);

        PriorityQueue<String> queue2 = new PriorityQueue<>();
        queue2.add("Pink");
        queue2.add("White");
        queue2.add("Black");
        System.out.println("Priority Queue2: " + queue2);
        // adding queue2 to queue1
        queue.addAll(queue2);
        System.out.println("New Priority Queue1: " + queue);
    }

    static void insertElement() {
        System.out.println("<=============insertElement============>");

        System.out.println("Priority Queue: " + queue);
        // Printing the elements of queue  
        for (String value : queue) {
            System.out.println("Colors : " + value);
        }
    }

    static void removeAllElement() {
        System.out.println("<==========removeAllElement=============>");

        System.out.println("Original Priority Queue: " + queue);
        // Removing all the elements from the Priority Queue
        queue.clear();
        System.out.println("The New Priority Queue: " + queue);

    }

    static void noOfElements() {
        System.out.println("<==============noOfElements================>");

        queue.add("Red");
        queue.add("Green");
        queue.add("Orange");
        queue.add("Grey");
        System.out.println("Elements of the Priority Queue:" + queue);
        System.out.println("Size of the Priority Queue: " + queue.size());
    }

    static void compareTwoPriorityQueue() {
        System.out.println("<==============compareTwoPriorityQueue================>");
        queue.add("Red");
        queue.add("Green");
        queue.add("Orange");
        queue.add("Grey");
        System.out.println("First Priority Queue: " + queue);

        PriorityQueue<String> queue2 = new PriorityQueue<>();
        queue2.add("Red");
        queue2.add("Pink");
        queue2.add("Black");
        queue2.add("Orange");
        System.out.println("Second Priority Queue: " + queue2);
        //comparison output in Priority Queue
        for (String element : queue) {
            System.out.println(queue2.contains(element) ? "Yes" : "No");
        }
    }

    static void retrieveFirstElement() {
        System.out.println("<==============retrieveFirstElement================>");
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(19);
        q.add(2);
        q.add(46);
        q.add(95);
        q.add(96);
        System.out.println("Priority Queue: " + q);
        System.out.println("The first element of the Queue: " + q.peek());
    }

    static void retrieveAndRemoveFirstElement() {
        System.out.println("<==============retrieveAndRemoveFirstElement================>");
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(19);
        q.add(2);
        q.add(46);
        q.add(95);
        q.add(96);
        q.add(56);
        System.out.println("Priority Queue: " + q);
        System.out.println("Removes the first element: " + q.poll());
        System.out.println("Priority Queue after removing first element: " + q);
    }

    static void convertPriorityqueueToArray() {
        System.out.println("<==============convertPriorityqueueToArray================>");

        System.out.println("Priority Queue: " + queue);
        List<String> array_list = new ArrayList<>(queue);
        System.out.println("Array containing all of the elements in the queue: " + array_list);
    }

    static void convertPriorityqueueToString() {
        System.out.println("<==============convertPriorityqueueToString================>");
        System.out.println("Priority Queue: " + queue);

        //Convert Priority Queue to a string representation
        String str1;
        str1 = queue.toString();
        System.out.println("String representation of the Priority Queue: " + str1);
    }

    static void changePqToMaximumPq() {
        System.out.println("<==============changePqToMaximumPq================>");
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(19);
        q.add(2);
        q.add(46);
        q.add(95);
        q.add(96);
        q.add(56);
        q.add(67);
        System.out.println("Priority Queue: " + q);

        System.out.print("\nMaximum Priority Queue: ");
        Integer val = null;
        while ((val = q.poll()) != null) {
            System.out.print(val + "  ");
        }
        System.out.print("\n");
    }

    
    public static void main(String args[]) {
        createPriorityqueue();
        iteratePriorityQueue();
        addToAnotherPriorityqueue();
        insertElement();
        removeAllElement();
        noOfElements();
        compareTwoPriorityQueue();
        retrieveFirstElement();
        retrieveAndRemoveFirstElement();
        convertPriorityqueueToArray();
        convertPriorityqueueToString();
        changePqToMaximumPq();
    }
}
