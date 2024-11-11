package insertionsorting_in_java;

import java.util.Scanner;
/// InsertionSort
///
/// This class provides an implementation of the insertion sort algorithm for sorting an array of integers.
/// It includes a `main` method to demonstrate sorting a user-provided array.
///
/// ## Example
/// ```java
/// Enter the size of the table: 5
/// Enter the elements of the table: 29 10 14 37 13
/// Table sorted: 10 13 14 29 37
/// ```
///
/// The code reads the size and elements of an array from user input, sorts it using `insertionSort` method, and
/// then displays the sorted array.
public class InsertionSort {
    /// Main method to execute the insertion sort demonstration.
    ///
    /// - Reads an integer array from user input.
    /// - Sorts the array using insertion sort.
    /// - Prints the sorted array.
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

        // Call the insertion sort function
        insertionSort(array);
        System.out.println("Table sorted: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
    /// Sorts an array in ascending order using the insertion sort algorithm.
    ///
    /// The insertion sort algorithm iteratively takes an element from the unsorted section of the array
    /// and inserts it into the sorted section at the correct position.
    ///
    /// - **Time Complexity**: `O(n^2)`, where `n` is the number of elements in the array.
    /// - **Space Complexity**: `O(1)`, as it is an in-place sorting algorithm.
    ///
    /// @param array The array of integers to be sorted.
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
