package chapter_02;
/* Demonstrate the for loop.
*  Call this file "ForTest.java".
* */
public class ForTest {
    public static void main(String[] args) {
        int x;
        for (x = 0; x<10; x = x++)
            System.out.println("This is x: " + x);
    }
}
