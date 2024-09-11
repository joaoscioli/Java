package chapter_20;

import java.util.ArrayDeque;

// Demonstrate ArrayDeque.
public class ArrayDequeDemo {
    public static void main(String[] args) {
        // Create an array deque.
        ArrayDeque<String> adq = new ArrayDeque<String>();

        // Use an ArrayDeque like a stack.
        adq.add("A");
        adq.add("B");
        adq.add("C");
        adq.add("D");
        adq.add("E");
        adq.add("F");

        System.out.println("Popping the stack: ");

        while (adq.peek() != null)
            System.out.print(adq.pop() + " ");

        System.out.println();
    }
}
