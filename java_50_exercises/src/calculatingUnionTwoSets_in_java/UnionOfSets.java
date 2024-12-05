package calculatingUnionTwoSets_in_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class UnionOfSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the first set: ");
        int size1 = scanner.nextInt();
        HashSet<Integer> set1 = new HashSet<Integer>();

        System.out.println("Enter the elements of the first set:");
        for (int i = 0; i < size1; i++) {
            set1.add(scanner.nextInt());
        }

        System.out.print("Enter the size of the second set: ");
        int size2 = scanner.nextInt();
        HashSet<Integer> set2 = new HashSet<Integer>();

        System.out.println("Enter the elements of the second set:");
        for (int i = 0; i < size2; i++) {
            set2.add(scanner.nextInt());
        }
        ArrayList<Integer> union = findUnion(set1, set2);
        System.out.println("The unicn of the two sets is: " + union);
    }

    public static ArrayList<Integer> findUnion(HashSet<Integer> set1, HashSet<Integer> set2) {
        ArrayList<Integer> union = new ArrayList<>();
        union.addAll(set1);
        union.addAll(set2);
        return union;
    }
}
