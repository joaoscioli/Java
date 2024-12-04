package calculatingIntersectionTwoSets_in_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/// # IntersectionOfSets
/// A program to compute the intersection of two sets of integers.
///
/// ## Features
/// - Accepts two sets of integers as input from the user.
/// - Compute the intersection of the two sets.
/// - Display the common elements between the two sets.
public class IntersectionOfSets {
    /// Main entry point of the program.
    ///
    /// - Prompts the user to input the sizes and element of two sets.
    /// - Calls the `findIntersection` method to compute the intersection of the two sets.
    /// - Displays the result of the intersection.
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

        ArrayList<Integer> intersection = findIntersection(set1, set2);
        System.out.println("The intersection of the two sets is: " + intersection);
    }
    /// Compute the intersection of two sets of integers.
    ///
    /// - Iterates through the elements of the first set.
    /// - Checks if each element is present in the second set.
    /// - Adds common elements to the resulting list.
    ///
    /// ## Algorithm
    /// 1. Initialize an empty `ArrayList` to store the intersection.
    /// 2. Iterate through the elements of `set1`:
    ///     - If an element exists in `set2`, add it to the intersection list.
    /// 3. Return the list of intersecting elements.
    ///
    /// ## Performance
    /// - **Time Complexity**: O(n + m), where `n` in the size of `set1` and `m` in the size of `set2`.
    /// - **Space Complexity**: O(k), where `k` is the size of the intersection.
    ///
    /// @param set1 The first set of integers.
    /// @param set2 The second set of integers.
    /// @return     A list of integers that are present in both sets.
    public static ArrayList<Integer> findIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                intersection.add(num);
            }
        }
        return intersection;
    }
}
