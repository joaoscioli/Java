package pancakeSort_in_java;


/// # PancakeSort
/// An implementation of the Pancake Sorting algorithm, which sorts an array using only flip operations.
/// The algorithm repeatedly moves the largest unsorted element to its correct position by flipping subarrays.
///
/// ## Features
/// - Uses only array reversals (flips) to sort the elements.
/// - Sorts the array in-place without extra memory usage.
///
/// ## Example
/// ```
/// Input:  [8, 4, 1, 56, 3, 44, 23, 6, 28, 0]
/// Output: [0, 1, 3, 4, 6, 8, 23, 28, 44, 56]
/// ```
///
public class PancakeSort {

    ///
    /// The main entry point of the program.
    ///
    /// - Defines an array of integers.
    /// - Sorts the array using the Pancake Sort algorithm.
    /// - Prints the sorted array.
    ///
    /// @param args Command-line arguments (not used).
    ///
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, 44, 23, 6, 28, 0};

        // Perform Pancake Sort
        pancakeSort(arr);

        // Display the sorted array
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    ///
    /// Sorts an array using the Pancake Sorting algorithm.
    ///
    /// ## Algorithm
    /// 1. Find the maximum element in the unsorted portion.
    /// 2. Flip the array up to the maximum element to bring it to the front.
    /// 3. Flip the entire unsorted portion to move the maximum element to its correct position.
    /// 4. Repeat until all elements are sorted.
    ///
    /// ## Performance
    /// - **Time Complexity**: O(n²) in the worst case.
    /// - **Space Complexity**: O(1) as it is an in-place sorting algorithm.
    ///
    /// ## Parameters
    /// - `arr`: The array to be sorted.
    ///
    public static void pancakeSort(int[] arr) {
        int n = arr.length;
        for (int currentSize = n; currentSize > 1; currentSize--) {
            int maxIndex = findMaxIndex(arr, currentSize);

            if (maxIndex != currentSize - 1) {
                // Bring the maximum element to the front if it's not already there.
                flip(arr, maxIndex);

                // Move the maximum element to its correct position.
                flip(arr, currentSize - 1);
            }
        }
    }

    ///
    /// Finds the index of the maximum element in the array up to the given limit.
    ///
    /// ## Parameters
    /// - `arr`: The array containing the elements.
    /// - `n`: The limit up to which the maximum element should be found.
    ///
    /// ## Returns
    /// - The index of the maximum element within the specified range.
    ///
    public static int findMaxIndex(int[] arr, int n) {
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    ///
    /// Reverses the elements of the array from the start index to the given end index.
    ///
    /// ## Parameters
    /// - `arr`: The array containing the elements to be flipped.
    /// - `end`: The index up to which the array should be flipped.
    ///
    public static void flip(int[] arr, int end) {
        int start = 0;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
