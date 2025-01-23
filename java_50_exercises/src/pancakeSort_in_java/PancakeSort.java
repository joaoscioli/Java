package pancakeSort_in_java;

public class PancakeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, 44, 23, 6, 28, 0};
        pancakeSort(arr);
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void pancakeSort(int[] arr) {
        int n = arr.length;
        for (int currentSize = n; currentSize > 1; currentSize--) {
            int maxIndex = findMaxIndex(arr, currentSize);
            if (maxIndex != currentSize - 1) {
                // Invert elements from the beginning to the maximum element
                flip(arr, maxIndex);
                // Invert all elements of the current array
                flip(arr, currentSize - 1);
            }
        }
    }
    public static int findMaxIndex(int[] arr, int n) {
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static void flip(int[] arr, int end) {
        int start = 0;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
