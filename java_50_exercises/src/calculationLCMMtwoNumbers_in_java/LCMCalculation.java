package calculationLCMMtwoNumbers_in_java;

import java.util.Scanner;
/// LCMCalculation
///
/// This class calculate the last common multiple (LCM) of two numbers provided by the user.
/// It uses the relationship between the greatest common divisor (GCD) and LCM to compute the result.
public class LCMCalculation {
    /// Main method that prompts the user for two integers and calculates their LCM.
    ///
    /// - Reads two integers from the user.
    /// - Calls `calculateLCM` to compute the least common multiple (LCM) of the integers.
    /// - Displays the result to the user.
    ///
    /// @param args Command-linea arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        int lcm = calculateLCM(number1, number2);
        System.out.println("The PPCM of " + number1 + " and " + number2 + " is " + lcm);
    }

    /// Calculates the least common multiple (LCM) of two integers using their GCD.
    ///
    /// The method first determines the greatest common divisor (GCD) of the two numbers using
    /// the Euclidean algorithm. Then, it calculates the LCM using the formula:
    ///
    /// `LCM(a, b) = (a * b) / GCD(a, b)`
    ///
    /// @param a The first integer.
    /// @param b The second integer.
    /// @return  The least common multiple (LCM) of `a` and `b`.
    public static int calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);
        return (a * b) / gcd;
    }

    /// Helper method to calculate the greatest common divisor (GCD) of two integers.
    ///
    /// Uses the Euclidean algorithm to iteratively compute the GCD:
    /// - While `b` is not zero, assigns `b` to `a` and `a % b` to `b`.
    ///
    /// @param a The first integer.
    /// @param b The second integer.
    /// @return  The greatest common divisor (GCD) of `a` and `b`.
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
