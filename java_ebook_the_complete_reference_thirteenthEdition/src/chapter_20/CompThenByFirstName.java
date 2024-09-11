package chapter_20;

import java.util.Comparator;
// Sort by entire name when last names are equals.
public class CompThenByFirstName implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j;
        return aStr.compareToIgnoreCase(bStr);
    }
}
