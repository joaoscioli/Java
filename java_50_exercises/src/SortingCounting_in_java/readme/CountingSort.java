package SortingCounting_in_java.readme;

/// # CountingSort
/// This program implements **Counting Sort**, a non-comparative sorting algorithm.
///
/// ## Features
/// - Efficient for sorting integers with a limited range.
/// - Uses a **counting array** to track occurrences of elements.
/// - Works in **O(n + k)** time complexity, where `n` is the number of elements and `k` is the range of values.
///
/// ## Complexity
/// - **Time Complexity**:
///   - Best case: O(n + k)
///   - Worst case: O(n + k)
/// - **Space Complexity**: O(n + k) (requires extra space for counting and output arrays)
///
/// ## Example
/// ```
/// Input: [4, 2, 2, 8, 3, 1]
///
/// Output:
/// Table sorted:
/// 1 2 2 3 4 8
/// ```
public class CountingSort {

    /// The main entry point of the program.
    ///
    /// - Initializes an array with unsorted values.
    /// - Calls `countingSort()` to sort the array.
    /// - Displays the sorted array.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 8, 3, 1 };
        countingSort(arr);
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /// Implements **Counting Sort**, sorting an array of integers.
    ///
    /// ## Parameters
    /// - `arr`: The array of integers to be sorted.
    ///
    /// ## Algorithm
    /// 1. **Find the min and max values** in the array to determine the range.
    /// 2. **Create a counting array** to store occurrences of each number.
    /// 3. **Modify the counting array** to store positions of elements in the sorted output.
    /// 4. **Construct the sorted array** using the counting array.
    /// 5. **Copy the sorted values** back to the original array.
    ///
    /// ## Constraints
    /// - Works best when the range `(max - min)` is not significantly larger than `n`.
    public static void countingSort(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];

        // Find the maximum and minimum values in the array
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        // Count the occurrences of each value
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Update counters to indicate the last position of each value
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array using counters
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}
