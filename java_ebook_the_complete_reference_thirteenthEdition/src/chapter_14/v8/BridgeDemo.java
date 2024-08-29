package chapter_14.v8;
// Demonstrate a situation that requires a bridge method.
public class BridgeDemo {
    public static void main(String[] args) {
        // Create a Gen2 object for Strings.
        Gen2 strOb2 = new Gen2("Generics Test");
        System.out.println(strOb2.getOb());
    }
}
