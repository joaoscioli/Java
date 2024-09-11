package chapter_20;

import java.util.Comparator;

// Use a custom comparator.
// A reverse comparator for strings.
public class MyComp implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        // Reverse the comparison.
        return bStr.compareTo(aStr);
    }
    // No need to override equals or the default methods.
}
