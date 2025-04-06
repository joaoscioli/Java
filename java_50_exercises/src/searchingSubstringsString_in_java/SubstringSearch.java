package searchingSubstringsString_in_java;

import java.util.Scanner;
/// # SubstringSearch
/// A program that search for all occurrences of a substring within a given string and displays their position.
///
/// ## Features
/// - Accepts a main string and a substring as input from the user.
/// - Finds and prints all starting positions of the substring in the main string.
/// - Supports overlapping substring occurrences.
public class SubstringSearch {
    /// The main entry point of the program.
    ///
    /// - Prompts the user to input a main string and a substring to search for.
    /// - Calls the `findSubstringPositions` method to locate all occurrences of the substring.
    ///
    /// @param args Command-line argument (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character string: ");
        String mainString = scanner.nextLine();

        System.out.print("Enter the substring to search for: ");
        String subString = scanner.nextLine();

        findSubstringPositions(mainString, subString);
    }
    /// Finds and prints all starting positions of a substring within a main string.
    ///
    /// - Uses the `String.indexOf` method search for the substring starting at a specific position.
    /// - Iterates through the main string to find all occurrences of the substring, including overlapping ones.
    /// - Prints the zero-based starting index of each occurrence.
    ///
    /// ## Algorithm
    /// 1. Initialize a variable `lastIndex` to track the current search position (initially 0).
    /// 2. Use a `while` loop to search for the substring:
    ///     - Call `mainString.indexOf(subString, lastIndex)` to find the next occurrence.
    ///     - If an occurrence is found (`lastIndex != -1`), print its position.
    ///     - Increment `lastIndex` to continue searching for subsequent occurrences, supporting overlaps.
    /// 3. Exit the loop when no more occurrences are found.
    ///
    /// @param mainString The string in which to search for the substring.
    /// @param subString The substring to search for.
    public static void findSubstringPositions(String mainString, String subString) {
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = mainString.indexOf(subString, lastIndex);
            if (lastIndex != -1) {
                System.out.println("The substring is at position: " + lastIndex);
                lastIndex++;
            }
        }
    }
}
