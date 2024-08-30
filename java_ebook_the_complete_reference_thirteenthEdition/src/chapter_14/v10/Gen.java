package chapter_14.v10;
// Generics and arrays.
public class Gen<T extends Number> {
    T ob;
    T[] vals;   // OK

    Gen(T o, T[] nums) {
        ob = o;
        // This statement is illegal.
        // vals = new T[10];    // can't create an array of T
        // But, this statement is OK.
        vals = nums;    // OK to assign reference to existent array
    }
}
