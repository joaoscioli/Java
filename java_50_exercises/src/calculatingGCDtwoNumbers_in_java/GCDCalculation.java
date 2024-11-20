package calculatingGCDtwoNumbers_in_java;

import java.util.Scanner;
/// GCDCalculation
///
/// This class calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
/// The program prompts the user to input two integers and computes their GCD.
public class GCDCalculation {
    /// Main method that reads two integers from the user and calculates their GCD.
    ///
    /// - Prompts the user to enter two integers.
    /// - Calls `calculateGCD` to compute the greatest common divisor of the two integers.
    /// - Displays the result in the format: "The GCD of x and y is z".
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        int gcd = calculateGCD(number1, number2);
        System.out.println("The PGCD of " + number1 + " and " + number2 + " is " + gcd);
    }

    /// Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
    ///
    /// The algorithm works as follows:
    /// - While the second integer (`b`) is not zero:
    ///     - Store the value of `b` in a temporary variable.
    ///     - Replace `b` with the remainder of `a / b`.
    ///     - Replace `a` with the temporary variable.
    /// - When `b` become zero, `a` contains the GCD.
    ///
    /// @param a The first integer.
    /// @param b The second integer.
    /// @return  The greatest common divisor (GCD) of `a` and `b`
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
