package CapgeminiTraining;

import java.util.*;

public class TaskA_ArrayListAdvanced {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(Arrays.asList(12, 45, 23, 88, 56, 19, 34, 90, 11, 67));

        list.removeIf(num -> num % 2 == 0);

        int max = Collections.max(list);
        int min = Collections.min(list);

        Collections.sort(list, Collections.reverseOrder());

        System.out.println("Final List: " + list);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
