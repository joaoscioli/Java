package bubbleSortingOptimised_in_java;

/**
 * # BubbleSortOptimized
 * An optimized implementation of the Bubble Sort algorithm that minimizes unnecessary comparisons
 * by stopping early if the array is already sorted.
 *
 * ## Features
 * - Uses a flag (`swapped`) to track whether a swap was performed in the current iteration.
 * - If no swaps are made in an iteration, the array is already sorted, and the loop terminates early.
 *
 * ## Example
 * ```
 * Input:  [64, 34, 25, 12, 22, 11, 90]
 * Output: [11, 12, 22, 25, 34, 64, 90]
 * ```
 */
public class BubbleSortOptimized {

     ///
     /// The main entry point of the program.
     ///
     /// - Defines an array of integers.
     /// - Sorts the array using the optimized Bubble Sort algorithm.
     /// - Prints the sorted array.
     ///
     /// @param args Command-line arguments (not used).
     ///
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        // Perform Bubble Sort
        bubbleSort(arr);

        // Display the sorted array
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

     ///
     /// Sorts an array using the optimized Bubble Sort algorithm.
     ///
     /// ## Algorithm
     /// 1. Compare adjacent elements and swap them if needed.
     /// 2. Track if any swaps occur using a `swapped` flag.
     /// 3. If no swaps occur in an iteration, the array is already sorted, and the loop terminates early.
     ///
     /// ## Performance
     /// - **Best Case (Already Sorted)**: O(n)
     /// - **Worst Case (Reverse Sorted)**: O(n²)
     /// - **Space Complexity**: O(1) (in-place sorting)
     /// ## Parameters
     /// - `arr`: The array to be sorted.
     ///
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps were performed, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
