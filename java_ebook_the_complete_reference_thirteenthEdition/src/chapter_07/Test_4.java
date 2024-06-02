package chapter_07;
// Returning an object.
public class Test_4 {
    int a;

    Test_4(int i) {
        a = i;
    }

    Test_4 incrByTen() {
        Test_4 temp =  new Test_4(a + 10);
        return temp;
    }
}
