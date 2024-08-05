package chapter_08.v6;

import chapter_08.v5.A;

public class B extends A {
    int k;

    B(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    public void show() {
        super.show();       // this calls A's show()
        System.out.println("k: " + k);
    }
}
