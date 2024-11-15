package calculatingSumSeriesIntegers_in_java;

import java.util.Scanner;
/// # SumOfIntegers
///
/// This class calculates the sum of a series of integers entered by the user.
/// It includes a `main` method to accept user input and compute the sum.
public class SumOfIntegers {
    /// Main method that calculates the sum of a user-specified number of integers.
    ///
    /// - Prompts the user to enter the number of integers (`n`).
    /// - Collects `n` integers from the user, calculates their sum, and displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers to be  added: ");
        int n = scanner.nextInt();
        int[] integers = new int[n];
        int sum = 0;

        System.out.println("Enter the integers one by one:");
        for (int i = 0; i < n; i++) {
            integers[i] = scanner.nextInt();
            sum += integers[i];
        }

        System.out.println("The sum of the integers is: " + sum);
    }
}
