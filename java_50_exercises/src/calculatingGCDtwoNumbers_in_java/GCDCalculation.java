package calculatingGCDtwoNumbers_in_java;

import java.util.Scanner;

public class GCDCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        int gcd = calculateGCD(number1, number2);
        System.out.println("The PGCD of " + number1 + " and " + number2 + " is " + gcd);
    }
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
