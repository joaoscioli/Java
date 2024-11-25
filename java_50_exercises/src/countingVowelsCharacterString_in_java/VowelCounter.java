package countingVowelsCharacterString_in_java;

import java.util.Scanner;
/// # VowelCounter
/// A program that counts the number of vowels in a given character string.
///
/// # Features
/// - Accepts user input as a string.
/// - Counts the vowels (`a`,`e`,`i`,`o`,`u`) regardless of their case.
/// - Outputs the total count of vowels in the string.
public class VowelCounter {
    /// The main entry point of the program.
    ///
    /// - Prompts the user to input a string.
    /// - Invokes the `countVowels` method to determine the number of vowels in the string.
    /// - Displays the result.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character string: ");

        String input = scanner.nextLine();
        int vowelCount = countVowels(input);
        System.out.println("The number of vowel in the string is: " + vowelCount);
    }
    /// Counts the number of vowels in a given string.
    ///
    /// - Converts the input string to lowercase to ensure case-insensitivity.
    /// - Iterates through each character of the string.
    /// - Checks if the character is a vowel(`a`, `e`, `i`, `o`, `u`).
    /// - Increments a counter for each vowel found.
    ///
    /// # Algorithm
    /// 1. Convert the string to lowercase.
    /// 2. Initialize a counter to zero.
    /// 3. Loop through each character in the counter.
    ///     - If the character is a vowel, increment the counter.
    /// 4. Return the counter value.
    ///
    /// @param str The input string to analyze.
    /// @return    The number of vowels in the string.
    public static int countVowels(String str) {
        str = str.toLowerCase();    // Convert the string to lower case to ignore case.
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
