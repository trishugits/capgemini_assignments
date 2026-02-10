package CapgeminiTraining;

import java.util.LinkedList;
import java.util.Queue;

public class TaskB_LinkedListQueue {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.add("Customer 1");
        queue.add("Customer 2");
        queue.add("Customer 3");
        queue.add("Customer 4");
        queue.add("Customer 5");

        queue.poll();
        queue.poll();

        System.out.println("Remaining Queue: " + queue);
    }
}
