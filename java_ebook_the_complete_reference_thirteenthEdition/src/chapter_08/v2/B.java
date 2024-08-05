package chapter_08.v2;
// A's   is not accessible here.
public class B extends A{
    int total;

    void sum() {
//        total = i + j;  // ERROR, j is not accessible here
    }
}
