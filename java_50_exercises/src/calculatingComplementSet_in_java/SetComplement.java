/// # SetComplement Class
///
/// This class provides functionality to calculate the complement of a set with respect to a universal set.
/// The complement consists of elements that are in the universal set but not in the given subset.
///
/// ## Usage
/// Compile and run the program. The user is prompted to enter and elements of a universal set and a subset.
/// The program calculate and displays the complement of the subset with respect to the universal set.
///
/// ## Example
/// ```
/// Enter the size of the universal set: 5
/// Enter the elements of the universal set:
/// 1 2 3 4 5
/// Enter the size of the set whose complement you want to calculate: 2
/// Enter the elements of the set:
/// 2 4
/// The complement of the given set with respect to the universal set is: [1, 2, 5]
/// ```
package calculatingComplementSet_in_java;

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
/// 1. Reads a universal set and a subset from user input.
/// 2. Computes the complement of the subset with respect to the universal set using the `findComplement` method.
/// 3. Prints the complement to the console.
public class SetComplement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the universal set: ");
        int sizeUniversal = scanner.nextInt();

        HashSet<Integer> universalSet = new HashSet<>();
        System.out.println("Enter the elements of the universal set:");
        for (int i = 0; i < sizeUniversal; i++) {
            universalSet.add(scanner.nextInt());
        }

        System.out.print("Enter the size of the set whose complement you want to calculate: ");
        int sizeSubset = scanner.nextInt();
        HashSet<Integer> subset = new HashSet<>();

        System.out.println("Enter the elements of the set:");
        for (int i = 0; i < sizeSubset; i++) {
            subset.add(scanner.nextInt());
        }

        ArrayList<Integer> complement = findComplement(universalSet, subset);
        System.out.println("The complement of the given set with respect to the universal set is: " + complement);
    }
    /// ## `findComplement` Method
    /// Calculates the complement of a subset with respect to a universal set.
    /// The complement includes all elements present in the universal set but not in the subset.
    ///
    /// ### Parameters
    /// - `universalSet`: The universal set of integers.
    /// - `subset`: The subset of integers whose complement is to be calculated.
    ///
    /// ### Returns
    /// An `ArrayList<Integer>` containing the elements of the universal set that are not in the subset.
    ///
    /// ### Example
    /// ```java
    /// HashSet<Integer> universalSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
    /// HashSet<Integer> subSet = new HashSet<>(Arrays.asList(2, 4));
    /// ArrayList<Integer> complement = findComplement(universalSet, subset);
    /// System.out.println(complement); // Output: [1, 3, 5]
    /// ```
    public static ArrayList<Integer> findComplement(HashSet<Integer> universalSet, HashSet<Integer> subset) {
        ArrayList<Integer> complement = new ArrayList<>();
        for (int num : universalSet) {
            if (subset.contains(num)) {
                complement.add(num);
            }
        }
        return complement;
    }
}
