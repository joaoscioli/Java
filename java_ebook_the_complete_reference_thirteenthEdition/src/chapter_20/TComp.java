package chapter_20;

import java.util.Comparator;

// Use a comparator to sort accounts by last name.
// Compare last whole words in two strings.
public class TComp implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j, k;

        // Find index of beginning of last name.
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');

        k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
        if (k == 0)     // last names match, check entire name
            return aStr.compareToIgnoreCase(bStr);
        else
            return k;
    }
    // No need to override equals.
}
