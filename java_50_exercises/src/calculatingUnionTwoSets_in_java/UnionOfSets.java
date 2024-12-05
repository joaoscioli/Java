package calculatingUnionTwoSets_in_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/// # UnionOfSets
/// A program to compute the union of two sets of integers.
///
/// ## Features
/// - Accepts two sets of integers as input from the user.
/// - Computes the union of the two sets.
/// - Display all unique elements from both sets.
public class UnionOfSets {
    /// Main entry point of the program.
    ///
    /// - Prompts the user to input the sizes and elements of two sets.
    /// - Calls the `findUnion` method to compute the union of the two sets.
    /// - Displays the resulting union.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the first set: ");
        int size1 = scanner.nextInt();
        HashSet<Integer> set1 = new HashSet<Integer>();

        System.out.println("Enter the elements of the first set:");
        for (int i = 0; i < size1; i++) {
            set1.add(scanner.nextInt());
        }

        System.out.print("Enter the size of the second set: ");
        int size2 = scanner.nextInt();
        HashSet<Integer> set2 = new HashSet<Integer>();

        System.out.println("Enter the elements of the second set:");
        for (int i = 0; i < size2; i++) {
            set2.add(scanner.nextInt());
        }
        ArrayList<Integer> union = findUnion(set1, set2);
        System.out.println("The unicn of the two sets is: " + union);
    }
    /// Computes the union of two sets of integers.
    ///
    /// - Combines all unique elements from both input sets into a single collection.
    ///
    /// ## Algorithm
    /// 1. Create an `ArrayList` to store the union of the two sets.
    /// 2. Add all elements from `set1` to the list.
    /// 3. Add all elements from `set2` to the list.
    /// 4. Return the resulting list, which contains all unique elements.
    ///
    /// ## Performance
    /// - **Time Complexity**: O(n + m), where `n` is the size of `size1` and `m` in the size of `set2`.
    /// - **Space Complexity**: O(n + m), for storing the union in the resulting list.
    ///
    /// @param set1 The first set of integers.
    /// @param set2 The second set of integers.
    /// @return A list containing all unique elements from both sets.
    public static ArrayList<Integer> findUnion(HashSet<Integer> set1, HashSet<Integer> set2) {
        ArrayList<Integer> union = new ArrayList<>();
        union.addAll(set1);
        union.addAll(set2);
        return union;
    }
}
