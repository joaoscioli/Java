package chapter_08.v5;

public class B extends A{
    int k;
     B(int a, int b, int c) {
         super(a, b);
         k = c;
     }

     // display k - this overrides show() in A
     public void show() {
        System.out.println("k: " + k);
    }
}
