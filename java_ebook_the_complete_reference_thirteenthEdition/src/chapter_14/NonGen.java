package chapter_14;
// NonGen is functionally equivalent to Gen
// but does not use generics.
public class NonGen {
    Object ob;  // ob is now of type Object

    // Pass the constructor a reference to
    // an object of type Object
    NonGen(Object o) {
        ob = o;
    }

    // Return type Object.
    Object getOb() {
        return ob;
    }

    // Show type of ob.
    void showType() {
        System.out.println("Type of ob is " + ob.getClass().getName());
    }
}
