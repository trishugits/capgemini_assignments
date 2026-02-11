package CapgeminiTraining.day2;

import java.util.LinkedList;

public class HospitalQueue {

    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Patient A");
        queue.add("Patient B");
        queue.add("Patient C");
        queue.add("Patient D");
        queue.add("Patient E");

        queue.addFirst("Emergency Patient");

        queue.poll();
        queue.poll();

        System.out.println("Current Queue: " + queue);
    }
}
