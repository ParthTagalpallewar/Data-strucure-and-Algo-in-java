package PriorityQueue;

import java.util.PriorityQueue;

public class Basic {
    public static void main(String[] args) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // add() - Inserts the specified element to the queue. If the queue is full, it throws an exception.
        // offer() - Inserts the specified element to the queue. If the queue is full, it returns false.
        // peek() - return head of queue
        // remove() - removes the specified element from the queue
        // poll() - returns and removes the head of the queue

        queue.add(3);
        queue.add(1);

        queue.offer(9);


        System.out.println(queue);


    }   
}
