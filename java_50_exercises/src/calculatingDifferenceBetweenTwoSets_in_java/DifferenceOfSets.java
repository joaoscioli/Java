package calculatingDifferenceBetweenTwoSets_in_java;
/// # DifferenceOfSets Class
///
/// This class provides functionality to calculate the difference between two sets of integers.
/// The main program reads two sets user input and computes their difference, which consists of elements in the
/// first set that are not in the second set.
///
/// ## Usage
/// Compile and run the program. The user is prompted to enter the size and elements of two sets. The program then outputs
/// the difference between the two sets.
///
/// ## Example
/// ```
/// Enter the size of the first set: 3
/// Enter the elements of the first set:
/// 1 2 3
/// Enter the size of the second set: 2
/// Enter the elements of the second set:
/// 2 4
/// The difference between the two sets is: [1, 3]
/// ```
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/// ## `main` Method
/// The entry point of the program.
///
/// ### Parameters
/// - `args`: Command-line arguments (not used in this program).
///
/// ### Description
/// 1. Reads two sets of integers from user input.
/// 2. Computes the difference between the two sets using the `findDifference` method.
/// 3. Prints the resulting difference to the console.
public class DifferenceOfSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the first set: ");
        int size1 = scanner.nextInt();
        HashSet<Integer> set1 = new HashSet<>();
        System.out.println("Enter the elements of the first set: ");
        for (int i = 0; i < size1; i++) {
            set1.add(scanner.nextInt());
        }

        System.out.print("Enter the size of the second set: ");
        int size2 = scanner.nextInt();
        HashSet<Integer> set2 = new HashSet<>();
        System.out.println("Enter the elements of the second set:");
        for (int i = 0; i < size2; i++) {
            set2.add(scanner.nextInt());
        }

        ArrayList<Integer> difference = findDifference(set1, set2);
        System.out.println("The difference between the two sets is: " + difference);
    }
    /// ## `findDifference` Method
    /// Computes the difference between two sets of integers.
    /// The difference consist of elements in the first set that are not in the second set.
    ///
    /// ### Parameters
    /// -`set1`: The first set of integers.
    /// -`set2`: The second set of integers.
    ///
    /// ### Returns
    /// An `ArrayList<Integer>` containing the elements present in `set1` but not in `set2`.
    ///
    /// ### Example
    /// ```java
    /// HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
    /// HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2, 4));
    /// ArrayList<Integer> difference = findDifference(set1, set2);
    /// System.out.println(difference);     // Output: [1, 3]
    /// ```
    public static ArrayList<Integer> findDifference(HashSet<Integer> set1, HashSet<Integer> set2) {
        ArrayList<Integer> difference = new ArrayList<Integer>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                difference.add(num);
            }
        }
        return difference;
    }
}
