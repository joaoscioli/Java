package combSort_in_java;

public class CombSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};
        combSort(arr);
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        double shrink = 1.3; // shrink factor
        boolean swapped = true;
        while (gap > 1 || swapped) {
            // Apply the reduction factor to the gap
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1;
            }
            swapped = false;
            for (int i = 0; i + gap < n; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
}
