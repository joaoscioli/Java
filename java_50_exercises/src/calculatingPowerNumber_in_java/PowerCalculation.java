package calculatingPowerNumber_in_java;

import java.util.Scanner;
/// #PowerCalculation
/// This class calculates the result of raising a base number to an exponent using iterative multiplication.
/// The program accepts user input for the base and the exponent and computes the result.
public class PowerCalculation {
    /// Main method that prompts the user for the base and exponent and calculates the result.
    ///
    /// - Prompts the user to enter a base (a number) and an exponent (a non-negative integer).
    /// - Validates that the exponent is non-negative.
    /// - Call `calculatePower` to compute the base raised to the power of the exponent.
    /// - Displays the result or an error message if the expoente is invalid.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base (a number): ");
        double base = scanner.nextDouble();

        System.out.print("Enter the expoente (a non-negative integer): ");
        int expoente = scanner.nextInt();

        if (expoente < 0) {
            System.out.println("The expoente must be a non-negative integer.");
        } else {
            double result = calculatePower(base, expoente);
            System.out.println(base + " raised to the power " + expoente + " equals " + result);
        }
    }

    /// Calculates the result of raising a base number to a non-negative integer exponent.
    ///
    /// The method works as follows:
    /// - If the exponent is `0`, the result is `1` (any number raised to the power `0` is `1`).
    /// - For a positive exponent, iteratively multiplies the base by itself for `exponent` time.
    ///
    /// @param base     The base number to be raised.
    /// @param expoente The non-negative integer exponent.
    /// @return         The result of `base` raised to the power of `exponent`.

    public static double calculatePower(double base, int expoente) {
        if (expoente == 0) {
            return 1;
        } else {
            double result = 1;
            for (int i = 1; i <= expoente; i++) {
                result *= base;
            }
            return result;
        }
    }
}
