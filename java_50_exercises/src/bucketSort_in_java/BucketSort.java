package bucketSort_in_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 ///
 /// # BucketSort
 /// An implementation of the Bucket Sort algorithm for sorting an array of integers.
 ///
 /// ## Features
 /// - Uses multiple buckets to distribute elements based on their values.
 /// - Sorts each bucket individually using a comparison-based sorting algorithm.
 /// - Merges sorted buckets to produce the final sorted array.
 ///
 /// ## Example
 /// ```
 /// Input:  [64, 34, 25, 12, 22, 11, 90, 80, 5]
 /// Output: [5, 11, 12, 22, 25, 34, 64, 80, 90]
 /// ```
 ///
public class BucketSort {

     ///
     /// The main entry point of the program.
     ///
     /// - Defines an array of integers.
     /// - Sorts the array using the Bucket Sort algorithm.
     /// - Prints the sorted array.
     ///
     /// @param args Command-line arguments (not used).
     ///
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 80, 5};

        // Perform Bucket Sort
        bucketSort(arr);

        // Display the sorted array
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

     ///
     /// Sorts an array using the Bucket Sort algorithm.
     ///
     /// ## Algorithm
     /// 1. Find the minimum and maximum values in the array.
     /// 2. Create a set of buckets based on the value range.
     /// 3. Place each element into the appropriate bucket.
     /// 4. Sort individual buckets using a standard sorting method (e.g., Collections.sort).
     /// 5. Merge the sorted buckets back into the original array.
     ///
     /// ## Performance
     /// - **Best Case**: O(n + k) (when data is uniformly distributed)
     /// - **Worst Case**: O(n²) (when all elements fall into a single bucket)
     /// - **Space Complexity**: O(n + k) (additional space for buckets)
     ///
     /// ## Parameters
     /// - `arr`: The array to be sorted.
     ///

     public static void bucketSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int n = arr.length;

        // Find the minimum and maximum values in the array
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

        // Place elements into buckets
        for (int i = 0; i < n; i++) {
            buckets.get(arr[i] - min).add(arr[i]);
        }

        // Sort each bucket individually
        for (int i = 0; i < range; i++) {
            Collections.sort(buckets.get(i));
        }

        // Merge sorted buckets into the original array
        int index = 0;
        for (int i = 0; i < range; i++) {
            for (int num : buckets.get(i)) {
                arr[index++] = num;
            }
        }
    }
}
