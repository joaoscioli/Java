package chapter_14.v7;
// A subclass of Gen that overrides getOb().
public class Gen2<T> extends Gen<T> {
    Gen2(T o) {
        super(o);
    }

    // Override getOb().
    T getOb() {
        System.out.print("Gen2's getOb(): ");
        return ob;
    }
}
