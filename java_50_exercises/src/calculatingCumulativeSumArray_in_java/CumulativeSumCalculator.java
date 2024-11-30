package calculatingCumulativeSumArray_in_java;

import java.util.Scanner;

public class CumulativeSumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the table: ");

        int size = scanner.nextInt();
        int[] array = new int[size];
        int[] cumulativeSum = new int[size];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        calculateCumulativeSum(array, cumulativeSum);
        System.out.println("the cumulative sum table is: ");
        for (int num : cumulativeSum) {
            System.out.print(num + " ");
        }
    }

    public static void calculateCumulativeSum(int[] input, int[] output) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            output[i] = sum;
        }
    }
}
