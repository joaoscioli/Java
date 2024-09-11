package chapter_20;

import java.util.TreeSet;

public class CompDemo {
    public static void main(String[] args) {
        // Create a tree set.
        TreeSet<String> ts = new TreeSet<String>(new MyComp());

        // Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        // Display the elements.
        for (String element : ts)
            System.out.print(element + " ");

        System.out.println();
    }
}
