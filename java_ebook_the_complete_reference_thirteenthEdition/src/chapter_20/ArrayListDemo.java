package chapter_20;

import java.util.ArrayList;
import java.util.List;

// Demonstrate ArrayList.
public class ArrayListDemo {
    public static void main(String[] args) {
        // Create an array list.
        List<String> al = new ArrayList<>();

        System.out.println("Initial size of al: " + al.size());

        // Add elements to the array list.
        al.add("B");
        al.add("X");
        al.add(1, "C");
        al.addFirst("A");
        al.add("D");
        al.add("Y");
        al.add("Z");
        System.out.println("Size of al after additions: " + al.size());

        // Display the array list.
        System.out.println("Contents of al: " + al.size());

        // Remove elements from the array list.
        al.remove("y");
        al.remove(3);
        al.removeLast();

        System.out.println("Size of al after deletions: " + al.size());
        System.out.println("Contents of al, in reverse order: " + al.reversed());
    }
}
