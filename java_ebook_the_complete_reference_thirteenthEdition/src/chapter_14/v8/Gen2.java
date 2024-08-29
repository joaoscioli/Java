package chapter_14.v8;
// A subclass of Gen.
public class Gen2 extends Gen<String> {
    Gen2(String o) {
        super(o);
    }

    // A String-specific override of getOb().
    String getOb() {
        System.out.print("You called String getOb(): ");
        return ob;
    }
}
