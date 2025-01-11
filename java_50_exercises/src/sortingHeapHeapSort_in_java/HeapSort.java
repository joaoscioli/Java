package sortingHeapHeapSort_in_java;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, 44, 23, 6, 28, 0};
        heapSort(arr);
        System.out.println("Table sorted:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // Create a max heap from the table
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Exchange the root (maximum element) with the current element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Call heapify to reduce the size of the unsorted heap
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
