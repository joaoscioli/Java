package chapter_07;

public class CallByValue {
    public static void main(String[] args) {
        Test_2 ob = new Test_2();

        int a = 15, b = 20;

        System.out.println("a and b before call: " + a + " " + b);

        ob.meth(a, b);

        System.out.println("a and b after call: " + a + " " + b);
    }
}
