package mergesort_in_java;

import java.util.Scanner;

/// # MergeSort
/// This class provides a static method to perform the Merge Sort algorithm on an integer array.
/// It also includes a main method to execute the algorithm using user-provided input.

public class MergeSort {
    /// Main method to initiate Merge Sort.
    /// - Prompts the user for the array size and element.
    /// - Calls the `mergeSort` method to sort the array.
    /// - Prints the sorted array.
    ///
    /// @param args Command-line argument (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /// Capture input user to size array
        System.out.print("Enter the size of the table: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        /// Capture input user to numbers of array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Call the merge sort function
        mergeSort(array, 0, n-1);
        System.out.println("Table sorted:");
        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
    }

    /// Sorts a portion of the array using the Merge Sort algorithm.
    ///
    /// This method recursively divides the array int halves, sorts each half
    /// and the merges the sorted halves.
    ///
    /// @param arr      The array to sort.
    /// @param left     The starting index of the portion to sort.
    /// @param right    The ending index of the portion to sort.
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            mergeSort(arr, left, middle, right);
        }
    }

    /// Merges two sorted halves of an array into a single sorted segment.
    ///
    /// - Creates temporary array for the left and right halves.
    /// - Merges elements back into the original array in sorted order.
    /// - Handles any remaining elements in either half.
    ///
    /// @param arr      The array containing the segments to merge.
    /// @param left     The starting index of the first segment.
    /// @param middle   The ending index of the first segment.
    /// @param right    The ending index of the second segment.
    public static void mergeSort(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Temporary arrays to hold the halves.
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to  temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }
        int i = 0, j = 0, k = left;

        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray, if my
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaning elements of rightArray, if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
