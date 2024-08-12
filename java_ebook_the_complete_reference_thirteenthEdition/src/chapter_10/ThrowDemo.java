package chapter_10;
// Demonstrate throw.
public class ThrowDemo {
    static void demoproc() {
        try {
            throw new NullPointerException("demo");
        } catch (NumberFormatException e) {
            System.out.println("Caught inside demoproc.");
            throw e;    // rethrow the exception
        }
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NumberFormatException e) {
            System.out.println("Recaught: " + e);
        }
    }
}
