package mergingTwoSortedAarrays_in_java;

import java.util.Scanner;

public class SortedArrayMerger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];

        System.out.println("Enter the elements of the first sorted array: ");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];

        System.out.println("Enter the elements of the second sorted array: ");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        int[] mergedArray = mergeSortedArrays(array1, array2);
        System.out.println("The sorted result table is: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int[] result = new int[size1 + size2];
        int i = 0, j = 0, k = 0;
        while (i < size1 && j < size2) {
            if (array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }
        while (i < size1) {
            result[k++] = array1[i++];
        }
        while (j < size2) {
            result[k++] = array2[j++];
        }
        return result;
    }
}
