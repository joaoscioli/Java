package findingMinimumMaximumArray_in_java;

import java.util.Scanner;
/// # MinMaxInArray
/// This program allows the user to find the minimum or maximum values in an array of integers.
/// The user chooses between searching for the minimum or maximum value, input the array,
/// and receives the desired result.
public class MinMaxInArray {
    /// The main entry point of the program.
    ///
    /// - Prompts the user to choose between finding the minimum or maximum value.
    /// - Based on the choice, it calls the respective method:
    ///     - `findAndDisplayMinimum()` for finding the minimum.
    ///     - `findAndDisplayMaximum()` for finding the maximum.
    /// - Displays an error message for invalid choices.
    ///
    /// @param args Command-line argument (not used).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to search for the minimum or maximum? (min/max): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("min")) {
            findAndDisplayMinimum();
        } else if (choice.equalsIgnoreCase("max")) {
            findAndDisplayMaximum();
        } else {
            System.out.println("Invalid choice. Please enter 'min' or 'max'.");
        }
    }

    /// Finds and displays the minimum value in an array.
    ///
    /// - Prompts the user to input the size of the array and its elements.
    /// - Iterates through the array to find the smallest element.
    /// - Displays the minimum value.
    private static void findAndDisplayMinimum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the table: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the table: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("The minimum in the table is: " + min);
    }

    /// Finds and displays to maximum value in an array.
    ///
    /// - Prompts the user to input the size of the array and its elements.
    /// - Iterates through the array to find the largest element.
    /// - Displays the maximum value.
    private static void findAndDisplayMaximum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the table: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the table: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("The maximum in the table is: " + max);
    }
}
