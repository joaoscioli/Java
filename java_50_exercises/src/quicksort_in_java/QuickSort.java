package quicksort_in_java;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the size of the table: ");
            while (!in.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                in.next();
            }
            int n = in.nextInt();
            int[] array = readArray(in, n);

            quickSort(array, 0, n - 1);
            System.out.println("Table sorted:");
            printArray(array);
        }
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static int[] readArray(Scanner in, int size) {
        int[] array = new int[size];
        System.out.println("Enter the elements of the table:");
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = medianOfThree(arr, low, high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        swap(arr, mid, high);
        return arr[high];
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
