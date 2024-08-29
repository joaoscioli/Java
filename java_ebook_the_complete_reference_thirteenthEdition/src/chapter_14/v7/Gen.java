package chapter_14.v7;
// Overriding a generic method in a generic class.
public class Gen<T> {
    T ob;   // declare an object of type T

    // Pass the constructor a reference to
    // an object of type T.
    Gen(T o) {
        ob = o;
    }

    // Return ob.
    T getOb() {
        System.out.print("Gen's getOb(): ");
        return ob;
    }
}
