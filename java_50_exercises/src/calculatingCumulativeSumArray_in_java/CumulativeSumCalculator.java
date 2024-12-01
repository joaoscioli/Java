package calculatingCumulativeSumArray_in_java;

import java.util.Scanner;
/// # CumulativeSumCalculator
/// A program to calculate the cumulative sum of elements in an array.
///
/// ## Features
/// - Accepts an integer array as input from the use.
/// - Compute the cumulative sum, where each element at index `i` in the output is the
/// sum of all elements from index `0` to `i` in the input array.
/// - Displays the cumulative sum array to the user.
public class CumulativeSumCalculator {
    /// The main entry point of the program.
    ///
    /// - Prompts the user to enter the size and element of the array.
    /// - Initializes the cumulative sum array.
    /// - Invokes the `calculateCumulativeSum` method to compute the cumulative sum.
    /// - Displays the resulting cumulative sum array.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the table: ");

        int size = scanner.nextInt();
        int[] array = new int[size];
        int[] cumulativeSum = new int[size];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        calculateCumulativeSum(array, cumulativeSum);
        System.out.println("the cumulative sum table is: ");
        for (int num : cumulativeSum) {
            System.out.print(num + " ");
        }
    }
    /// Calculates the cumulative sum of the input array.
    ///
    /// - The  cumulative sum at index `i` is the sum of all elements from index `0` to `i`.
    /// - Populates the output array with the computed values.
    ///
    /// ## Algorithm
    /// 1. Initialize a variable `sum` to store the running total.
    /// 2. Iterable through the input array:
    ///     - Add the current element to `sum`.
    ///     - Store the update `sum` in the corresponding index the output array.
    ///
    /// @param input The input array of integers.
    /// @param output The array to store the cumulative sums.
    public static void calculateCumulativeSum(int[] input, int[] output) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            output[i] = sum;
        }
    }
}
