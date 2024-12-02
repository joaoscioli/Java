package convertingDecimalNumberBinary_in_java;

import java.util.Scanner;
/// # DecimalToBinaryConverter
/// A program that converts a decimal (base-10) number to its binary (base-2) representation.
///
/// ## Features
/// - Accept a decimal number as input from the user.
/// - Convert the decimal number to its binary equivalent using an iterative approach.
/// - Displays the binary representation.
public class DecimalToBinaryConverter {
    /// The main entry point of the program.
    ///
    /// - Prompts the user to enter a decimal number.
    /// - Converts the entered decimal number to binary using the `convertDecimalToBinary` method.
    /// - Displays the binary representation.
    ///
    /// @param args Command-line argument (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();

        String binaryNumber = convertDecimalToBinary(decimalNumber);
        System.out.println("The binary representation is: " + binaryNumber);
    }
    /// Convert a decimal number its binary representation.
    ///
    /// - Uses an iterative approach to calculate the binary equivalent.
    /// - The process involves repeatedly dividing the decimal number by 2 and storing the remainder.
    /// - The remainders are collected is reverse order to form the binary representation.
    ///
    /// ## Algorithm
    /// 1. Initialize an empty `StringBuilder` to store the binary digits.
    /// 2. While the decimal number is greater than zero:
    ///     - Compute the remainder of the number when divided by 2 (0 or 1).
    ///     - Prepend the remainder to the binary representation.
    ///     = Divide the decimal number by 2.
    /// 3. Return the binary representation as a string.
    ///
    /// @param decimal The decimal number to convert (non-negative integer).
    /// @return The binary representation of the input decimal number as a string.
    public static String convertDecimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);    // Add the remainder at the beginning of the string
            decimal /= 2;
        }
        return binary.toString();
    }
}
