package calculatingSumDigitsNumber_in_java;

import java.util.Scanner;
/// # SumOfDigits
/// This program calculates the sum of the digits of a given integer.
/// The user is prompted to input an integer, and the program computes the sum of its digits
/// using an iterative approach.
public class SumOfDigits {
    /// Main method that handles user input and displays the sum of the digits of the entered integer.
    ///
    /// - Prompts the user to enter an integer.
    /// - Call the `calculateSumOfDigits` method to compute the sum of the digits of the input.
    /// - Prints the calculated sum to the console.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int sum = calculateSumOfDigits(number);
        System.out.println("The sum of the numbers in: " + number + " is " + sum);
    }

    /// Calculates the sum of the digits of a given integer.
    ///
    /// - Extracts each digit of the integer using modulus and division operations.
    /// - Adds each extracted digit to a cumulative sum.
    /// - Handles negative numbers by processing their absolute value.
    ///
    /// @param num  The integer whose digits will be summed.
    /// @return     The sum of the digits of the input integer.
    private static int calculateSumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;   // Get the last digit
            sum += digit;           // Add the digit to the sum
            num /= 10;              // Delete the last digit
        }
        return sum;
    }
}
