package FindingMedianUnsortedArray_in_java;

import java.util.Arrays;
import java.util.Scanner;

public class MedianFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the table: ");

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter the elements of the table: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int median = findMedian(numbers);
        System.out.println("The median of the table is: " + median);
    }

    public static int findMedian(int[] array) {
        // Sort the table
        Arrays.sort(array);
        int size = array.length;
        if (size % 2 == 0) {
            // If the table has an even number of elements, the median is the average of two central elements.
            int middleIndex1 = (size / 2) - 1;
            int middleIndex2 = size / 2;
            return (array[middleIndex1] + array[middleIndex2]) / 2;
        } else {
            // If the table has an odd number of elements, the median is the central element.
            int middleIndex = (size / 2);
            return array[middleIndex];
        }
    }
}
