package checkingUniquenessElementsArray_in_java.readme;

import java.util.HashSet;
import java.util.Scanner;
/// # UniqueElementsChecker
///
/// A program that checker if all element in an array are unique or if there are duplicates.
///
/// ## Features
/// - Accepts an array of integers as input from the user.
/// - Verifies if the array contains duplicate elements.
/// - Displays whether all elements are unique or if duplicates are present.
public class UniqueElementsChecker {
    /// The main entry point of the program;
    ///
    /// - Prompts the user to input the size of the array and its element.
    /// - Uses the `checkForDuplicates` method to determine if duplicates exist in the array.
    /// - Display the result of the check to the user.
    ///
    /// @param args Command-line argument (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the elements of the table: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.print("Enter the elements of the table: ");

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        boolean hasDuplicate = checkForDuplicates(numbers);

        if (hasDuplicate) {
            System.out.println("There are duplicate elements in the array");
        } else {
            System.out.println("All the elements in the array are unique.");
        }
    }

    /// Check if an array contains duplicate elements.
    ///
    /// - Uses a `HashSet` to track elements encountered in the array.
    /// - If an element is already present in the set, it is a duplicate.
    ///
    /// ## Algorithm
    /// 1. Create an empty `HashSet` to store unique elements.
    /// 2. Iterate thought each element in the array.
    /// 3. Attempt to add each element to the set:
    ///     - If the addition fails (`!set.add(elements)`), a duplicate is found, and the method returns `true`.
    /// 4. If the loop completes without finding duplicate, return `false`.
    ///
    /// @param array The input array of integers to check for duplicates.
    /// @return `true` if duplicates are found; `false` if all elements are unique.
    public static boolean checkForDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int elements : array)  {
            if (!set.add(elements))  {
                return true;    // If the elements cannot be added to the set, it is a duplicate.
            }
        }
        return false;   // No duplicate found.
    }
}
