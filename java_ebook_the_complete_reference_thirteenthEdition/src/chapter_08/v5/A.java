package chapter_08.v5;
// Method overriding.
public class A {
    int i, j;
    public A(int a, int b) {
        i = a;
        j = b;
    }

    // display i and j
    public void show() {
        System.out.println("i and j: " + i + " " + j);
    }
}
