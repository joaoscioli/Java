package convertingDecimalNumberBinary_in_java;

import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();

        String binaryNumber = convertDecimalToBinary(decimalNumber);
        System.out.println("The binary representation is: " + binaryNumber);
    }
    public static String convertDecimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);    // Add the remainder at the beginning of the string
            decimal /= 2;
        }
        return binary.toString();
    }
}
