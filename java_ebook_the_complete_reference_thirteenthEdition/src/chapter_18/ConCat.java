package chapter_18;
// Using concatenation to prevent long lines.
public class ConCat {
    public static void main(String[] args) {
        String longStr = "This could have been " +
                "a very long line that would have " +
                "wrapped around. But string concatenation " +
                "prevents this.";

        System.out.println(longStr);
    }
}
