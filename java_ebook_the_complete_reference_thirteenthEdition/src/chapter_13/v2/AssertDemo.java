package chapter_13.v2;
// A poor way to use assert!!!
public class AssertDemo {
    // get a random number generator
    static int val = 3;

    // Return an integer.
    static int getnum() {
        return val--;
    }

    public static void main(String[] args) {
        int n = 0;
        for (int i=0; i<10; i++) {
            assert (n = getnum()) > 0;  // This is not a good idea!
            System.out.println("n in " + n);
        }
    }
}
