package chapter_12.v6;

import java.lang.reflect.Method;

public class Meta3 {
    // Annotate a method using the default values.

    @MyAnno()
    public static void myMeth() {
        Meta3 ob = new Meta3();

        // Obtain the annotation for this method
        // and display the values of the members.
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
}
