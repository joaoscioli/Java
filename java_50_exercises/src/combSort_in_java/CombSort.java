package combSort_in_java;

/**
 * # CombSort
 * Implementation of the Comb Sort algorithm for sorting an array of integers.
 *
 * ## Features
 * - An improvement over Bubble Sort with a variable gap size.
 * - Uses a shrink factor to gradually reduce the gap.
 * - Continues swapping until the array is fully sorted.
 *
 * ## Example
 * ```
 * Input:  [8, 4, 1, 56, 3, -44, 23, -6, 28, 0]
 * Output: [-44, -6, 0, 1, 3, 4, 8, 23, 28, 56]
 * ```
 */
public class CombSort {

     ///
     /// The main entry point of the program.
     ///
     /// - Defines an array of integers.
     /// - Sorts the array using the Comb Sort algorithm.
     /// - Prints the sorted array.
     ///
     /// @param args Command-line arguments (not used).
     ///
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};

        // Perform Comb Sort
        combSort(arr);

        // Display the sorted array
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

     ///
     /// Sorts an array using the Comb Sort algorithm.
     ///
     /// ## Algorithm
     /// 1. Start with an initial gap equal to the array size.
     /// 2. Reduce the gap using the shrink factor (default: 1.3).
     /// 3. Compare and swap elements at a distance of 'gap'.
     /// 4. Repeat until the gap reaches 1 and no swaps are needed.
     ///
     /// ## Performance
     /// - **Best Case**: O(n log n)
     /// - **Worst Case**: O(n²)
     /// - **Space Complexity**: O(1) (in-place sorting)
     ///
     /// ## Parameters
     /// - `arr`: The array to be sorted.
     ///
    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        double shrink = 1.3; // Shrink factor
        boolean swapped = true;

        while (gap > 1 || swapped) {
            // Apply the reduction factor to the gap
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;

            // Compare and swap elements separated by 'gap'
            for (int i = 0; i + gap < n; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
}
