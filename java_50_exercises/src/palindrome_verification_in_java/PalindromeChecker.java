package palindrome_verification_in_java;

import java.util.Scanner;
/// # PalindromeChecker
/// A program that check if a given character string is a palindrome.
///
/// ## Features
/// - Reads a user-provided string.
/// - Cleans the input by removing punctuation, spaces, and converting it to lowercase.
/// - Verifies whether the cleaned string reads the same forward and backward.
/// - Outputs the result indicating whether the string is a palindrome.
public class PalindromeChecker {
    /// The main entry point of the program.
    ///
    /// - Prompts the user to enter a string.
    /// - Invokes the `isPalindrome` method to check if the string is a palindrome.
    /// - Displays the result of the palindrome verification.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character string: ");
        String input = scanner.nextLine();

        boolean isPalindrome = isPalindrome(input);
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }

    /// Check if a given string is a palindrome.
    ///
    /// - Removes all non-alphanumeric character from the input.
    /// - Converts the string to lowercase for case-insensitive comparison.
    /// - Uses a two-pointer technique to compare characters from both ends.
    ///
    /// ## Algorithm
    /// 1. Clean the string:
    ///     - Remove space and punctuation.
    ///     - Convert to lowercase.
    /// 2. Initialize two pointers:
    ///     - One pointing to the start (`left`) and one to the end (´right`).
    /// 3. Compare characters:
    ///     - If the character differ, return `false`.
    ///     - Move the pointers inward.
    /// 4. Return `true` if all characters match.
    ///
    /// @param str  The string to check for palindrome properties.
    /// @return `true` if the  string is a palindrome, otherwise `false`.
    public static boolean isPalindrome(String str) {
        // Remove punctuation, case and spaces
        str = str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left = 0;
        int right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
