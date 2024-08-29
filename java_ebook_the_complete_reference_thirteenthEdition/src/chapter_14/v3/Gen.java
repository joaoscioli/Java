package chapter_14.v3;
// A simple generic class hierarchy
public class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    // Return ob.
    T getOb() {
        return ob;
    }
}
