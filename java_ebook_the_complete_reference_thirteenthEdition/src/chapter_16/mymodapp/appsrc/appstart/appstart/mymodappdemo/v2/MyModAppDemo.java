package chapter_16.mymodapp.appsrc.appstart.appstart.mymodappdemo.v2;
// Update to use SupportFuncs.

import chapter_16.mymodapp.appsrc.appfuncs.appfuncs.simplefuncs.v2.SimpleMathFuncs;
import chapter_16.mymodapp.appsrc.appsupport.appsupport.supportfuncs.SupportFuncs;

public class MyModAppDemo {
    public static void main(String[] args) {
        // Now, isFactor() is referred to via SupportFuncs,
        // not SimpleMathFuncs.
        if (SupportFuncs.isFactor(2, 10))
            System.out.println("2 is a factor of 10");

        System.out.println("Smallest factor common to both 35 and 105 is " + SimpleMathFuncs.lcf(35, 105));
        System.out.println("Largest factor common to both 35 and 105 is " + SimpleMathFuncs.gcf(35, 105));
    }
}
