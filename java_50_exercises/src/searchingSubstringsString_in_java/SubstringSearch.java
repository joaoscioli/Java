package searchingSubstringsString_in_java;

import java.util.Scanner;

public class SubstringSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character string: ");
        String mainString = scanner.nextLine();

        System.out.print("Enter the substring to search for: ");
        String subString = scanner.nextLine();

        findSubstringPositions(mainString, subString);
    }

    public static void findSubstringPositions(String mainString, String subString) {
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = mainString.indexOf(subString, lastIndex);
            if (lastIndex != -1) {
                System.out.println("The substring is at position: " + lastIndex);
                lastIndex++;
            }
        }
    }
}
