package chapter_08;
//Create a subclass by extending class A
public class B extends A{
    int k;

    void showk() {
        System.out.println("K: " + k);
    }

    void sum() {
        System.out.println("i+j+k: " + (i+j+k));
    }
}
