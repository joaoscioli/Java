package bubble_sorting_in_java;

import java.util.Scanner;

 /// A class for performing bubble sort on an array.
 ///
 /// ## Features
 /// - Prompts the user to enter the size and elements of an array.
 /// - Implements an optimized bubble sort algorithm with a swap check to
 /// - Avoid unnecessary iterations if the array is already sorted.
 /// - Uses `try-with-resources` to safely manage the `Scanner` resource.
 ///
 /// ### Usage
 /// To execute the code, run the `main` method, input the array size, and then
 /// the array elements one by one. The sorted array will be displayed.
 ///
public class TriBubbles {

    ///
    /// The main method to execute the bubble sort program.
    ///
    /// This method:
    /// - Prompts the user for array size and elements.
    /// - Sorts the array in ascending order using the bubble sort algorithm.
    /// - Prints the sorted array to the console.
    ///
    /// @param args Command-line arguments (not used in this program).
    ///
    public static void main(String[] args) {
        // Using try-with-resources to ensure Scanner is closed
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the size of the table: ");
            int n = scanner.nextInt();

            int[] array = new int[n];
            System.out.println("Enter the elements of the table:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            // Optimized Bubble Sort implementation
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        // Swap elements
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
                // If no elements were swapped, array is already sorted
                if (!swapped) break;
            }

            // Print the sorted array
            System.out.println("Table sorted:");
            for (int value : array) {
                System.out.print(value + " ");
            }
        }
    }
}
