package exponentialSearchAlgorithm_in_java;

/// # ExponentialSearch
/// Implementation of the Exponential Search algorithm for searching an element in a sorted array.
///
/// ## Features
/// - Efficient for searching in large sorted arrays.
/// - First, finds a range where the target value might exist using exponential growth.
/// - Then, applies binary search within the identified range.
///
/// ## Complexity
/// - **Best Case:** O(1) (if the element is found at the first index).
/// - **Average Case:** O(log i), where `i` is the range found.
/// - **Worst Case:** O(log n), where `n` is the array size.
///
/// ## Example
/// ```
/// Input:
/// Sorted Array: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
/// Target: 13
///
/// Output:
/// Element found at index: 6
/// ```
public class ExponentialSearch {

    /// The main entry point of the program.
    ///
    /// - Initializes a sorted array and a target value.
    /// - Executes the Exponential Search algorithm.
    /// - Prints the index of the found element or a "not found" message.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        int result = exponentialSearch(sortedArray, target);
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    /// Performs Exponential Search on a sorted array.
    ///
    /// ## Algorithm
    /// 1. Check if the first element is the target.
    /// 2. Find the search range by exponentially increasing the index (`i`).
    /// 3. Perform a binary search within the identified range.
    ///
    /// ## Parameters
    /// - `arr`: The sorted array in which the search is performed.
    /// - `target`: The element to search for.
    ///
    /// ## Returns
    /// - The index of `target` if found, otherwise `-1`.
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;

        // If the element is present at the first position
        if (arr[0] == target) {
            return 0;
        }

        // Find the range for the exponential search
        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }

        // Apply binary search to the found range
        return binarySearch(arr, target, i / 2, Math.min(i, n - 1));
    }

    /// Performs Binary Search on a subarray.
    ///
    /// ## Parameters
    /// - `arr`: The sorted array in which the search is performed.
    /// - `target`: The element to search for.
    /// - `left`: The left bound of the search range.
    /// - `right`: The right bound of the search range.
    ///
    /// ## Returns
    /// - The index of `target` if found, otherwise `-1`.
    public static int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // Element not found
    }
}
