package FindingMedianUnsortedArray_in_java;

import java.util.Arrays;
import java.util.Scanner;
/// # Median Finder
/// A program to calculate the median of an unsorted array of integers.
///
/// ## Features
/// - Prompts the user to enter the size of an array and its elements.
/// - Sorts the array to determine the median.
/// - Handles both even and odd-sized arrays.
public class MedianFinder {
    /// The main entry point of the program.
    ///
    /// - Reads the size and elements of an integer array from the user.
    /// - Calculate the median using the `findMedian` method.
    /// - Displays the calculated median.
    ///
    /// ## Steps
    /// 1. Prompt the user to input the size of the array.
    /// 2. Read the elements into the array.
    /// 3. Call `findMedian` to compute the median.
    /// 4. Display the result to the user.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the table: ");

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter the elements of the table: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int median = findMedian(numbers);
        System.out.println("The median of the table is: " + median);
    }

    /// Calculate the median of an unsorted array of integers.
    ///
    /// - Sorts the input array in ascending order.
    /// - Determines the median based on the size of the array:
    ///     - If the array size is odd, the median is the middle element.
    ///     - If the array size is even, the median is the average of the two middle elements.
    ///
    /// ## Algorithm
    /// 1. Sort the array using `Arrays.sort`.
    /// 2. Check if the size of the array is odd or even.
    /// 3. Compute the median based of the size:
    ///     - For odd-sized arrays, return the middle element.
    ///     - For even-sized arrays, return the average of the two central elements.
    ///
    /// @param array The input array of integers.
    /// @return      The median value as an integer.
    public static int findMedian(int[] array) {
        // Sort the table
        Arrays.sort(array);
        int size = array.length;
        if (size % 2 == 0) {
            // If the table has an even number of elements, the median is the average of two central elements.
            int middleIndex1 = (size / 2) - 1;
            int middleIndex2 = size / 2;
            return (array[middleIndex1] + array[middleIndex2]) / 2;
        } else {
            // If the table has an odd number of elements, the median is the central element.
            int middleIndex = (size / 2);
            return array[middleIndex];
        }
    }
}
