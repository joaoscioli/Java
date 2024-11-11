package sorting_by_selection_in_java;

import java.util.Scanner;
/// SelectionSort
///
/// This class provides an implementation of the selection sort algorithm for sorting an array of integers.
/// It includes a `main` method to demonstrate sorting a user-provided array.
///
/// Example:
/// ```java
/// Enter the size of the table: 5
/// Enter the elements of the table:
/// 34 12 24 9 5
/// Table sorted:
/// 5 9 12 24 34
/// ```
///
/// The code reads the size and elements of an array from user input, sorts it using the `selectionSort` method, and
/// the sorted array.
public class SelectionSort {
    /// Main method to execute the selection sort demonstration.
    ///
    /// - Reads an integer array from user input.
    /// - Sorts the array using selection sort.
    /// - Prints the sorted array.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the table: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the table:");
        for (int i = 0; i < n; i++ ) {
            array[i] = scanner.nextInt();
        }

        // Call up the sort by selection function
        selectionSort(array);
        System.out.println("Table sorted:");
        for (int i = 0; i < n; i++ ) {
            System.out.print(array[i] + " ");
        }
    }

    /// Sorts an array in ascending order using the selection sort algorithm.
    ///
    /// The selection sort algorithm duvides the array into a sorted and an unsorted section.
    /// It repeatedly selects the minimum element from the  unsorted section and moves it to the end of the sorted
    /// section.
    ///
    /// - **Time Complexity**: `O(n^2)`, where `n`is the number of elements in the array.
    /// - **Space Complexity**: `O(1)`, as it is an in-place sorting algorithm.
    ///
    /// @param arr The array of integers to be sorted.
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
