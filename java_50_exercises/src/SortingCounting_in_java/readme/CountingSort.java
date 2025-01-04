package SortingCounting_in_java.readme;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 8, 3, 1};
        countingSort(arr);
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void countingSort(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];

        // Find the maximum and minimum values in the table
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];
        // Count the occurrences of each value
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Update counters to indicate the last position of each value
        for (int i = 1; i < range; i++) {
            count[i] += count[i-1];
        }
        // Build the sorted table using counters
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        // Copy the sorted table to the original table
        System.arraycopy(output, 0, arr, 0, n);
    }
}
