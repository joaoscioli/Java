package calculatingComplementSet_in_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SetComplement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the universal set: ");
        int sizeUniversal = scanner.nextInt();

        HashSet<Integer> universalSet = new HashSet<Integer>();
        System.out.println("Enter the elements of the universal set:");
        for (int i = 0; i < sizeUniversal; i++) {
            universalSet.add(scanner.nextInt());
        }

        System.out.print("Enter the size of the set whose complement you want to calculate: ");
        int sizeSubset = scanner.nextInt();
        HashSet<Integer> subset = new HashSet<Integer>();

        System.out.println("Enter the elements of the set:");
        for (int i = 0; i < sizeSubset; i++) {
            subset.add(scanner.nextInt());
        }

        ArrayList<Integer> complement = findComplement(universalSet, subset);
        System.out.println("The complement of the given set with respect to the universal set is: " + complement);
    }
    public static ArrayList<Integer> findComplement(HashSet<Integer> universalSet, HashSet<Integer> subset) {
        ArrayList<Integer> complement = new ArrayList<Integer>();
        for (int num : universalSet) {
            if (subset.contains(num)) {
                complement.add(num);
            }
        }
        return complement;
    }
}
