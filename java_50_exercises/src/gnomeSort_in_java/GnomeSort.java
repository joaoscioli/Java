package gnomeSort_in_java;

/// # GnomeSort
/// Implementation of **Gnome Sort**, a simple comparison-based sorting algorithm.
///
/// ## Features
/// - **Sorting Algorithm:** Gnome Sort (similar to Insertion Sort).
/// - **In-place Sorting:** No additional memory usage.
/// - **Adaptive:** Performs well on nearly sorted data.
///
/// ## Complexity
/// - **Best Case (Nearly Sorted):** O(n)
/// - **Worst Case:** O(n²)
/// - **Space Complexity:** O(1) (In-place sorting)
///
/// ## Example
/// ```
/// Input:  [8, 4, 1, 56, 3, 44, 23, 6, 28, 0]
/// Output: [0, 1, 3, 4, 6, 8, 23, 28, 44, 56]
/// ```
public class GnomeSort {

    /// The main entry point of the program.
    ///
    /// - Initializes an array with unsorted elements.
    /// - Sorts the array using **Gnome Sort**.
    /// - Prints the sorted array.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, 44, 23, 6, 28, 0};
        gnomeSort(arr);
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /// Sorts an array using **Gnome Sort**.
    ///
    /// ## Algorithm
    /// - Compares adjacent elements.
    /// - If they are in order, move forward.
    /// - If not, swap them and move backward.
    ///
    /// ## Parameters
    /// - `arr`: The array to be sorted.
    public static void gnomeSort(int[] arr) {
        int n = arr.length;
        int index = 0;

        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                // Swap adjacent elements
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
