package sortingHeapHeapSort_in_java;

/// # HeapSort
/// This program implements **Heap Sort**, an efficient comparison-based sorting algorithm.
///
/// ## Features
/// - Uses a **binary heap** data structure to sort elements.
/// - Follows **O(n log n)** time complexity for all cases.
/// - Performs sorting **in-place** without extra memory.
///
/// ## Complexity
/// - **Time Complexity**:
///   - Best case: O(n log n)
///   - Average case: O(n log n)
///   - Worst case: O(n log n)
/// - **Space Complexity**: O(1) (no extra storage required)
///
/// ## Example
/// ```
/// Input: [8, 4, 1, 56, 3, 44, 23, 6, 28, 0]
///
/// Output:
/// Table sorted:
/// 0 1 3 4 6 8 23 28 44 56
/// ```
public class HeapSort {

    /// The main entry point of the program.
    ///
    /// - Initializes an array with unsorted values.
    /// - Calls `heapSort()` to sort the array.
    /// - Displays the sorted array.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, 44, 23, 6, 28, 0};
        heapSort(arr);
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /// Implements **Heap Sort**, sorting an array of integers.
    ///
    /// ## Parameters
    /// - `arr`: The array of integers to be sorted.
    ///
    /// ## Algorithm
    /// 1. **Build a max heap** from the input array.
    /// 2. **Extract the maximum element** (root of the heap) and place it at the end.
    /// 3. **Heapify** the remaining elements to maintain the heap structure.
    /// 4. **Repeat the process** until the entire array is sorted.
    ///
    /// ## Constraints
    /// - Efficient for large datasets, but not stable (relative order of equal elements is not preserved).
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap from the array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    /// Maintains the **heap property** by ensuring a valid max heap structure.
    ///
    /// ## Parameters
    /// - `arr`: The array representation of the heap.
    /// - `n`: The size of the heap.
    /// - `i`: The index of the current node being heapified.
    ///
    /// ## Algorithm
    /// 1. **Identify the largest element** among the node and its children.
    /// 2. **Swap** the largest element with the current node if necessary.
    /// 3. **Recursively heapify** the affected subtree.
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
}
