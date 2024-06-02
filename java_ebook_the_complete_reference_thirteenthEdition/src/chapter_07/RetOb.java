package chapter_07;

public class RetOb {
    public static void main(String[] args) {
        Test_4 ob1 = new Test_4(2);
        Test_4 ob2;

        ob2 = ob1.incrByTen();
        System.out.println("ob1.a: " + ob1.a);
        System.out.println("ob2.a: " + ob2.a);

        ob2 = ob2.incrByTen();
        System.out.println("ob2.a after second increase: " + ob2.a);
    }
}
