package bucketSort_in_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 80, 5};
        bucketSort(arr);
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void bucketSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int n = arr.length;
        // Find the minimum and maximum values in the table
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        int range = max - min + 1;
        // Create buckets
        List<List<Integer>> buckets = new ArrayList<>(range);
        for (int i = 0; i < range; i++) {
            buckets.add(new ArrayList<>());
        }
        // Place items in drawers
        for (int i = 0; i < n; i++) {
            buckets.get(arr[i] - min).add(arr[i]);
        }
        // Sort the items in each drawer
        for (int i = 0; i < range; i++) {
            Collections.sort(buckets.get(i));
        }
        // Combine the sorted elements of the drawers to obtain the sorted array
        int index = 0;
        for (int i = 0; i < range; i++) {
            for (int num : buckets.get(i)) {
                arr[index++] = num;
            }
        }
    }
}
