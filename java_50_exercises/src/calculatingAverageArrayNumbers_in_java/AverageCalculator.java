package calculatingAverageArrayNumbers_in_java;

import java.util.Scanner;
/// # AverageCalculator
/// A program that calculates the average of an array of numbers.
///
/// ## Features
/// - Accepts user input to define the size of an array and its elements.
/// - Computes the average of the array's elements.
/// - Handles edge cases, such as an empty array.
public class AverageCalculator {
    /// The main entry point of the program
    ///
    /// - Prompts the user to input the size of the array.
    /// - Reads the array elements from the user.
    /// - Calculates the sum of the elements.
    /// - Invokes the `calculateAverage` method to compute the average.
    /// - Displays the calculated average.
    ///
    /// @param args Command-line argument (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the table: ");
        int size = scanner.nextInt();

        double[] numbers = new double[size];
        double sum = 0;

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];
        }
        double average = calculateAverage(sum, size);
        System.out.println("The average number is: " + average);
    }

    /// Calculates the average of numbers.
    ///
    /// - Takes the total sum and the count of numbers as inputs.
    /// - Divides the sum by the count to compute the average.
    /// - Returns 0.0 if the count is zero, to avoid division by zero.
    ///
    /// ## Algorithm
    /// 1. Check if the count of numbers is greater than zero.
    /// 2. If true, divide the sum by the count and return the result.
    /// 3. false, return 0.0 to handle an empty array case.
    ///
    /// @param sum      The total sum of the array's element.
    /// @param count    The total number of elements in the array.
    /// @return         The calculated average, or 0.0 if the count is zero.
    public static double calculateAverage(double sum, int count) {
        if (count > 0) {
            return sum / count;
        } else {
            return 0.0;     // Avoid division by zero if the array is empty
        }
    }
}
