package gnomeSort_in_java;

public class GnomeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,1,56,3,44,23,6,28,0};
        gnomeSort(arr);
        System.out.println("Table sorted:");
        for(int num : arr) {
            System.out.print("num: " + num);
        }
    }
    public static void gnomeSort(int[] arr) {
        int n = arr.length;
        int index = 0;
        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                // Exchange items to sort them
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
