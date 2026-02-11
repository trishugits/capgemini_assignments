package CapgeminiTraining.day2;

import java.util.ArrayList;
import java.util.Collections;

public class TaskA_ArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(78);
        marks.add(85);
        marks.add(66);
        marks.add(90);
        marks.add(72);

        marks.add(2, 80);

        int minMark = Collections.min(marks);
        marks.remove(Integer.valueOf(minMark));

        System.out.println("Final Marks List: " + marks);
    }
}
