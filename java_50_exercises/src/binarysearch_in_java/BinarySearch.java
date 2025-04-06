package binarysearch_in_java;

import java.util.Scanner;
/// #BinarySearch
/// This class implements a binary search algorithm on a sorted array.
/// It contains a `main` method to take user input and find the position
/// of a specified element in the array.
public class BinarySearch {
    /// Main method that drives the binary search process.
    ///
    /// - Prompts the user to enter the size and elements of a sorted array.
    /// - Asks for the elements to search for.
    /// - Calls `binarySearch` to locate the element in the array and outputs the result.
    ///
    /// @param args Command-line arguments (not used.)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the sorted array:" );
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the sorted array (in ascending order):");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the item to search for:");
        int elementSearch = scanner.nextInt();
        int position = binarySearch(array, elementSearch);
        if(position != -1) {
            System.out.println("The element " + elementSearch + " has been found at position " + position + " in the array.");
        } else {
            System.out.println("The element " + elementSearch + " was not found in the array.");
        }
    }

    /// Searches for a target element in a sorted array using binary search.
    /// This method performs a binary search on a sorted array to find the index of the target element.
    /// It uses a loop to iteratively narrow down the search range until the element is found
    /// or the range is empty.
    ///
    /// - If the target is found, returns its index in the array.
    /// - If the target is not found, returns -1.
    ///
    /// @param arr    The sorted array to search.
    /// @param target The element to search for.
    /// @return       The index of the target element if found; otherwise, -1.
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
