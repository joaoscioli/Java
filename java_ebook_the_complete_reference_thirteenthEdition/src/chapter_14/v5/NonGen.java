package chapter_14.v5;
// A non-generic class can be the superclass
// of a generic subclass.

// A non-generic class.
public class NonGen {
    int num;

    NonGen(int i) {
        num = i;
    }

    int getnum() {
        return num;
    }
}
