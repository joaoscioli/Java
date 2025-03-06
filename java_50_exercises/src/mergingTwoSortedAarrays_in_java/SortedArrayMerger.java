package mergingTwoSortedAarrays_in_java;

import java.util.Scanner;

/// # SortedArrayMerger
/// This program merges two sorted arrays into a single sorted array.
///
/// ## Features
/// - **Efficient Merging**: Uses a two-pointer approach.
/// - **Maintains Sorted Order**: The merged array remains sorted.
/// - **User Input**: Reads arrays from standard input.
///
/// ## Complexity
/// - **Time Complexity**: O(n + m), where `n` and `m` are the sizes of the two arrays.
/// - **Space Complexity**: O(n + m), as a new array is created for the merged result.
///
/// ## Example
/// ```
/// Input:
/// First array: [1, 3, 5]
/// Second array: [2, 4, 6]
///
/// Output:
/// Merged array: [1, 2, 3, 4, 5, 6]
/// ```
public class SortedArrayMerger {

    /// The main entry point of the program.
    ///
    /// - Reads two sorted arrays from the user.
    /// - Merges them using the **mergeSortedArrays()** function.
    /// - Prints the merged sorted array.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];

        System.out.println("Enter the elements of the first sorted array: ");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];

        System.out.println("Enter the elements of the second sorted array: ");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        int[] mergedArray = mergeSortedArrays(array1, array2);
        System.out.println("The sorted result table is: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }

    /// Merges two sorted arrays into a single sorted array.
    ///
    /// ## Parameters
    /// - `array1`: The first sorted array.
    /// - `array2`: The second sorted array.
    ///
    /// ## Returns
    /// A new sorted array containing all elements from `array1` and `array2`.
    ///
    /// ## Algorithm
    /// - Uses a **two-pointer technique** to efficiently merge both arrays.
    /// - Compares elements from both arrays and inserts the smaller one first.
    /// - If elements remain in either array, they are added to the result.
    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int[] result = new int[size1 + size2];

        int i = 0, j = 0, k = 0;

        while (i < size1 && j < size2) {
            if (array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < size1) {
            result[k++] = array1[i++];
        }

        while (j < size2) {
            result[k++] = array2[j++];
        }

        return result;
    }
}
