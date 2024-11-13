package sequentialSearch_in_java;

import java.util.Scanner;
/// # SequentialSearch
///
/// This class implements a sequential (linear) search algorithm to find an element in an array.
/// It includes a `main` method to accept user input and search for a specified element.
public class SequentialSearch {
    /// Main method to execute the sequential search.
    ///
    /// - Prompts the user for the array size and elements.
    /// - Asks for the target element to search within the array.
    /// - Calls `sequentialSearch` to locate the element and displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the table: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the table:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the item to search for: ");
        int elementSearch = scanner.nextInt();
        int position = sequencialSearch(array, elementSearch);
        if (position != -1) {
            System.out.println("The element " + elementSearch + " has been not found at position " + position + " in the array.");
        } else {
            System.out.println("The element " + elementSearch + " was not found in the array.");
        }
    }

    /// Performs a sequential search for a target element in an array
    ///
    /// This method iterates through each element in the array to check if it matches the target.
    /// - If the target is found, it returns the index of the target element.
    /// - If the target is not found, it returns -1.
    ///
    /// @param arr      The array to search.
    /// @param target   The element to search for.
    /// @return         The index of the target element if found; otherwise, -1.
    public static int sequencialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;   // Element found, returns position
            }
        }
        return -1;  // Element not found
    }
}
