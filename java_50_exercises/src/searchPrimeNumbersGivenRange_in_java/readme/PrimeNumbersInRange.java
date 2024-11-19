package searchPrimeNumbersGivenRange_in_java.readme;

import java.util.Scanner;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the minimum value for the range: ");
        int min = scanner.nextInt();
        System.out.print("Enter the maximum value for the range: ");
        int max = scanner.nextInt();

        if (min < 2) {
            min = 2;    // 2 is the first prime number
        }
        System.out.println("Prime numbers in the range " + min + " to " + max + ": ");
        findAndDisplayPrimes(min, max);
    }
    private static void findAndDisplayPrimes(int min, int max) {
        for (int number = min; number <= max; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
