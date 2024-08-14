package chapter_12;
// An error produced by manual unboxing.
public class UnboxingError {
    public static void main(String[] args) {
        Integer iOb = 1000;     // autobox the value 1000
        int i = iOb.byteValue();    // manuallu unbox as bute !!!
        System.out.println(i);      // does not display 1000 !
    }
}
