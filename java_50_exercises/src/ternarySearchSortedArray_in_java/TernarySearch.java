package ternarySearchSortedArray_in_java;

/// # Ternary Search
/// This program implements **Ternary Search**, a divide-and-conquer algorithm for searching in a sorted array.
///
/// ## Features
/// - Works only on **sorted arrays**.
/// - Divides the search range into **three parts** instead of two (as in Binary Search).
/// - Has a **time complexity of O(log₃ n)**, making it faster than Binary Search in some cases.
///
/// ## Complexity
/// - **Best case**: O(1) (when the target is found in the first comparison)
/// - **Average and Worst case**: O(log₃ n)
/// - **Space Complexity**: O(1) (iterative approach, no extra storage required)
///
/// ## Example
/// ```
/// Input:
///   sortedArray = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
///   target = 13
///
/// Output:
///   Element found at index: 6
/// ```
public class TernarySearch {

    /// The main entry point of the program.
    ///
    /// - Initializes a sorted array of integers.
    /// - Calls `ternarySearch()` to find a target element.
    /// - Prints the index of the found element or a failure message.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        int result = ternarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }

    /// Implements **Ternary Search** to find a target element in a sorted array.
    ///
    /// ## Parameters
    /// - `arr`: The sorted array of integers.
    /// - `target`: The value to search for.
    ///
    /// ## Returns
    /// - The **index** of the target element if found.
    /// - `-1` if the element is not found.
    ///
    /// ## Algorithm
    /// 1. Divide the search space into **three parts** using two midpoints (`mid1` and `mid2`).
    /// 2. Compare `target` with `arr[mid1]` and `arr[mid2]`:
    ///    - If `target == arr[mid1]`, return `mid1`.
    ///    - If `target == arr[mid2]`, return `mid2`.
    /// 3. Narrow the search space based on the value of `target`:
    ///    - If `target < arr[mid1]`, search in the **left third**.
    ///    - If `target > arr[mid2]`, search in the **right third**.
    ///    - Otherwise, search in the **middle section**.
    ///
    /// ## Constraints
    /// - The input array **must be sorted** before applying Ternary Search.
    public static int ternarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int partitionSize = (right - left) / 3;
            int mid1 = left + partitionSize;
            int mid2 = right - partitionSize;

            if (arr[mid1] == target) {
                return mid1;
            } else if (arr[mid2] == target) {
                return mid2;
            } else if (target < arr[mid1]) {
                right = mid1 - 1;
            } else if (target > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1; // Element not found
    }
}
