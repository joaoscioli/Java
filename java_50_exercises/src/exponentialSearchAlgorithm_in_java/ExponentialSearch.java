package exponentialSearchAlgorithm_in_java;

public class ExponentialSearch {
    public static void main(String[] args) {
        int[] sortedArray = {1,3,5,7,9,11,13,15,17,19};
        int target = 13;
        int result = exponentialSearch(sortedArray, target);
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;
        // If the element is present in the first position
        if (arr[0] == target) {
            return 0;
        }
        // Find the range for the exponential search
        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }
        // Apply the binary search to the range found
        return binaySeach(arr, target, i/2, Math.min(i, n-1));
    }

    public static int binaySeach(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // Element not found
    }
}
