package calculatingPowerNumber_in_java;

import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base (a number): ");
        double base = scanner.nextDouble();

        System.out.print("Enter the expoente (a non-negative integer): ");
        int expoente = scanner.nextInt();

        if (expoente < 0) {
            System.out.println("The expoente must be a non-negative integer.");
        } else {
            double result = calculatePower(base, expoente);
            System.out.println(base + " raised to the power " + expoente + " equals " + result);
        }
    }

    public static double calculatePower(double base, int expoente) {
        if (expoente == 0) {
            return 1;
        } else {
            double result = 1;
            for (int i = 1; i <= expoente; i++) {
                result *= base;
            }
            return result;
        }
    }
}
