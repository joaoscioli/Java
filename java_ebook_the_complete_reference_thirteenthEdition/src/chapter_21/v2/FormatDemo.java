package chapter_21.v2;

import java.util.Formatter;

// Use automatic resource management with Formatter.
public class FormatDemo {
    public static void main(String[] args) {
        try (Formatter fmt = new Formatter()){
            fmt.format("Formatting %s is easy %d %f", "with Java", 10, 98.6);
            System.out.println(fmt);
        }
    }
}
