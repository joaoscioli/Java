package ternarySearchSortedArray_in_java;

public class TernarySearch {
    public static void main(String[] args) {
        int[]  sortedArray = {1,3,5,7,9,11,13,15,17,19};
        int target = 13;
        int result = ternarySearch(sortedArray, target);
        if(result == -1) {
            System.out.println("Element found at index: " + result);
        }
    }

    public static int ternarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int partitionSize = (right - left) / 3;
            int mid1 = left + partitionSize;
            int mid2 = right - partitionSize;
            if (arr[mid1] == target) {
                return arr[mid1];
            } else if (arr[mid2] == target) {
                return arr[mid2];
            } else if (target < arr[mid1]) {
                right = mid1 - 1;
            } else if (target > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1; // Element not found
    }
}
