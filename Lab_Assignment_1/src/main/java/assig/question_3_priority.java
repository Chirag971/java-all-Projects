package assig;

import java.util.PriorityQueue;
import java.util.Queue;

public class question_3_priority {
    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(10);
        priorityQueue.offer(5);
        priorityQueue.offer(15);
        priorityQueue.offer(3);
        System.out.println("PriorityQueue: " + priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
