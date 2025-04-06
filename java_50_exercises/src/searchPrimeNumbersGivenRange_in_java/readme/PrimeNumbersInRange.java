package searchPrimeNumbersGivenRange_in_java.readme;

import java.util.Scanner;
/// # PrimeNumbersInRange
/// This class identifies and displays all prime numbers within a specified range.
/// The program accepts a range of integers as input and outputs all prime numbers in that range.
public class PrimeNumbersInRange {
    /// Main method that prompts the user for a range of integers and finds all prime numbers within the range.
    ///
    /// - Prompts the user to enter the minimum and maximum values for the range.
    /// - Ensures the minimum value is at least 2 (the smallest prime number).
    /// - Calls `findAndDisplayPrimes` to identify and print prime numbers within the range.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the minimum value for the range: ");
        int min = scanner.nextInt();
        System.out.print("Enter the maximum value for the range: ");
        int max = scanner.nextInt();

        if (min < 2) {
            min = 2;    // 2 is the first prime number
        }
        System.out.println("Prime numbers in the range " + min + " to " + max + ": ");
        findAndDisplayPrimes(min, max);
    }

    /// Finds and displays all prime numbers within a specified range
    ///
    /// - Iterates through all integers from `min` to `max`.
    /// - For each integer, calls `isPrime` to check if it is a prime number.
    /// - Prints the prime numbers to the console.
    ///
    /// @param min  The minimum value of the range.
    /// @param max  The maximum value of the range.
    private static void findAndDisplayPrimes(int min, int max) {
        for (int number = min; number <= max; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    /// Determines if a given integer is a prime number.
    ///
    /// - A prime number is greater than 1 and divisible only by 1 and itself.
    /// - Uses an efficient algorithm by iterating up to the square root of the number.
    ///
    /// @param num  The integer to check.
    /// @return `true` if the number is prime, `false` otherwise.
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
