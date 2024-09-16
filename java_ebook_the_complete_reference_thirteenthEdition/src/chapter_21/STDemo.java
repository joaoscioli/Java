package chapter_21;

import java.util.StringTokenizer;

// Demonstrate StringTokenizer.
public class STDemo {
    static String in = "title=Java: The Complete Reference;" +
            "author=Schildt;" +
            "publisher=McGraw Hill;" +
            "copyright=2022";

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(in,"=;");

        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            String val = st.nextToken();
            System.out.println(key + "\t" + val);
        }
    }
}
