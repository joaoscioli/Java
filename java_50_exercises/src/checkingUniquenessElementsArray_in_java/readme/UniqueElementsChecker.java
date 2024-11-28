package checkingUniquenessElementsArray_in_java.readme;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueElementsChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the elements of the table: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.print("Enter the elements of the table: ");

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        boolean hasDuplicate = checkForDuplicates(numbers);

        if (hasDuplicate) {
            System.out.println("There are duplicate elements in the array");
        } else {
            System.out.println("All the elements in the array are unique.");
        }
    }

    public static boolean checkForDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int elements : array)  {
            if (!set.add(elements))  {
                return true;    // If the elements cannot be added to the set, it is a duplicate.
            }
        }
        return false;   // No duplicate found.
    }
}
