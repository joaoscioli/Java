package calculatingFactorialNumber_in_java;

import java.util.Scanner;
/// # Factorial
/// This class provides a method to calculate the factorial of a given positive integer.
/// It includes a `main` method to take user input and display the factorial result.
public class Factorial {
    /// Main method that prompts the user for a positive integer and calculates its factorial.
    ///
    /// - If the user enters a negative integer, displays an error message.
    /// - If the input is valid, calls `calculateFactorial` to compute and display the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if(n < 0) {
            System.out.println("The factorial is only defined for positive integers.");
        } else {
            long result = calculateFactorial(n);
            System.out.println("The factorial of " + n + " is " + result);
        }
    }

    /// Calculates the factorial of a non-negative integer.
    ///
    /// This method calculates the factorial of a given integer `n` by iterating from 2 to `n`
    /// and accumulating the product.
    ///
    /// - Returns 1 if `n` is 0 or 1, as the factorial of both is 1.
    /// - For any other positive integer, computes the factorial iteratively.
    ///
    /// @param n    The integer for which to calculate the factorial (must be non-negative).
    /// @return     The factorial of `n` as a `long`.
    public static long calculateFactorial(int n) {
        if (n==0 || n==1) {
            return 1;   // The factorial of 0 and 1 is 1
        }
        long factorial = 1;
        for (int i=2; i<=n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
