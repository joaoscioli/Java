package calculatingNumberDigitsInteger_in_java;

import java.util.Scanner;
/// # CountDigits
/// This program calculates the number of digits in a given integer.
/// The user is prompted to input an integer, and the program determine the number of digits by iterating through the
/// number.
public class CountDigits {
    /// Main method that handles user input and displays the count of digits in the entered integer.
    ///
    /// - Prompts the user to enter ant integer.
    /// - Call the `countDigits` method to compute the number of digits.
    /// - Prints the result to the console.
    ///
    /// @param args Command-line argument (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int count = countDigits(number);
        System.out.println("The number " + number + " contains " + count + " digits.");
    }

    /// Count the number of digits in a given integer.
    ///
    /// - Iterates through the number, removing one digit at a time by performing integer division by 10.
    /// - Increments a counter on each iteration to track the number of digits.
    /// - Handles negative numbers by processing their absolute value.
    ///
    /// @param num  The integer whose digits are to be counted.
    /// @return     The total number of digits in the input integer.

    public static int countDigits(int num) {
        int count = 0;
        while (num != 0) {
            count ++;   // Increment the counter at each iteration
            num /= 10;  // Delete the last digit
        }
        return count;
    }
}
