package chapter_07;
// Objects are passed through their references.
public class Test_3 {
    int a, b;

    Test_3(int i, int j) {
        a = i;
        b = j;
    }

    // pass an object
    void meth(Test_3 o) {
        o.a *= 2;
        o.b /= 2;
    }
}
