package chapter_12;

import java.lang.reflect.Method;

public class Marker {
    // Annotate a method using a maker.
    // Notice that no () is needed.
    @MyMaker
    public static void myMeth() {
        Marker ob = new Marker();

        try {
            Method m = ob.getClass().getMethod("myMeth");

            // Determine if the annotation is present.
            if (m.isAnnotationPresent(MyMaker.class))
                System.out.println("MyMarker is present.");
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
