package chapter_08.v5;

public class Override {
    public static void main(String[] args) {
        B subOB = new B(1, 2, 3);
        subOB.show();       // this calls show() in B
    }
}
