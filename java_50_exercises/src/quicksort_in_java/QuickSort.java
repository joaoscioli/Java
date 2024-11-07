package quicksort_in_java;

import java.util.Scanner;

///
/// # QuickSort
/// This class implements the QuickSort sorting algorithm.
///
/// QuickSort is an efficient sorting algorithm that uses the divide-and-conquer strategy.
///
/// ## Example Usage
/// ```java
/// public class Main {
///     public static void main(String[] args) {
///         QuickSort.sort(array);
///    }
/// }
/// ```
///

public class QuickSort {
    ///
    /// `Main` method that reads the array size and elements from user input,
    /// sorts the array using QuickSort, and prints the sorted array.
    ///
    /// ### Parameters:
    /// - `args`: command-line arguments (not used).
    ///
    /// ### Example:
    /// ```java
    /// QuickSort.main(new String[0]);
    /// ```
    ///
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the size of the table: ");
            while (!in.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                in.next();
            }
            int n = in.nextInt();
            int[] array = readArray(in, n);

            quickSort(array, 0, n - 1);
            System.out.println("Table sorted:");
            printArray(array);
        }
    }


    ///
    /// Reads an integer array from user input.
    ///
    /// ### Parameters:
    /// - `in`: Scanner used to read user input.
    /// - `size`: the size of the array.
    ///
    /// ### Returns:
    /// - An integer array containing the values read.
    ///
    /// ### Example:
    /// ```java
    /// int[] array = QuickSort.readArray(scanner, 5);
    /// ```
    private static int[] readArray(Scanner in, int size) {
        int[] array = new int[size];
        System.out.println("Enter the elements of the table:");
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    ///
    /// Prints the elements of an integer array.
    ///
    /// ### Parameters:
    /// - `array`: the integer array to be printed.
    ///
    /// ### Example:
    /// ```java
    /// QuickSort.printArray(array);
    /// ```
    ///
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    ///
    /// Sort an integer array using the QuickSort algorithm.
    ///
    /// ### Parameters:
    /// - `arr`: the integer array to be sorted.
    /// - `low`: starting index of the array to be sorted.
    /// - `high`: ending index of the array to be sorted.
    ///
    /// ### Example:
    /// ```java
    /// QuickSort.quickSort(array, 0, array.length -1);
    /// ```
    ///
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    ///
    /// Partitions the array around a pivot and return the pivot index.
    ///
    /// ### Parameters:
    /// - `arr`: the integer array to be partitioned.
    /// - `low`: starting index of the array.
    /// - `high`: ending index of the array.
    ///
    /// ### Returns:
    /// - The pivot index after partitioning.
    ///
    /// ### Example:
    /// ```java
    /// int pivotIndex = QuickSort.partition(array, 0, array.length - 1);
    /// ```
    ///
    public static int partition(int[] arr, int low, int high) {
        int pivot = medianOfThree(arr, low, high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    ///
    /// Select a pivot using the Median of Three technique for better performance with nearly sorted array.
    ///
    /// ### Parameters:
    /// - `arr`: the integer array.
    /// - `low`: starting index of the array.
    /// - `high`: ending index of the array.
    ///
    /// ### Returns:
    /// - The pivot value.
    ///
    /// ### Example:
    /// ```java
    /// int pivot = QuickSort.medianOfThree(array, 0, array.length - 1);
    /// ```
    ///
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        swap(arr, mid, high);
        return arr[high];
    }

    ///
    /// Swaps the position of elements in an array.
    ///
    /// ### Parameters:
    /// -`arr`: the integer array.
    /// -`i`: index of one of the elements to swap.
    /// -`j`: index of the other element to swap.
    ///
    /// ### Example:
    /// ```java
    /// QuickSort.swap(array, 0, 1);
    /// ```
    ///
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
