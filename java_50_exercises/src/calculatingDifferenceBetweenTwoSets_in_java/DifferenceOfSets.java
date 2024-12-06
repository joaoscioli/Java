package calculatingDifferenceBetweenTwoSets_in_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

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
