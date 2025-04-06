package invertingCharacterString_in_java;

import java.util.Scanner;
/// # ReverseString
/// This program reverse a user-provided character string.
///
/// ## Features
/// - Prompts the user to input a string.
/// - Reverses the string using a two-pointer technique.
/// - Displays the reversed string.
public class ReverseString {
    /// The main entry point of the program.
    ///
    /// - Prompts the user to input a string.
    /// - Calls the `reverseString` method to reverse the input string.
    /// - Displays the reversed string.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character string: ");
        String input = scanner.nextLine();

        String reversed = reverseString(input);
        System.out.println("The reversed string is: " + reversed);
    }

    /// Reverses the given character string.
    ///
    /// - Converts the string into a character array.
    /// - Uses a two-pointer technique to swap characters:
    ///     - Starts with the first and last characters.
    ///     - Moves the pointers inward until they meet or cross.
    /// - Constructs and returns the reversed string from the character array.
    ///
    /// @param input The original string to reverse.
    /// @return      The reversed version of the input string.
    public static String reverseString(String input) {
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
