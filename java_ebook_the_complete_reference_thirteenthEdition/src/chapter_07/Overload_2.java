package chapter_07;

public class Overload_2 {
    public static void main(String[] args) {
        OverloadDemo_2 ob = new OverloadDemo_2();
        int i = 88;

        ob.test();
        ob.test(10, 20);

        ob.test(i);             // this will invoke test(double)
        ob.test(123.2);      // this will invoke test(double)
    }
}
