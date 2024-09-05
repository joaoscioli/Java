package chapter_16.mymodapp.appsrc.userfuncsimp.userfuncsimp.binaryfuncsimp;
// AbsMinus provides a concrete implementation of
// BinaryFunc. It returns the result of abs(a) - abs(b).

import chapter_16.mymodapp.appsrc.userfuncs.userfuncs.binaryfuncs.BinaryFunc;

public class AbsMinus implements BinaryFunc {
    // Return name of this function.
    public String getName() {
        return "absMinus";
    }

    // Implement the AbsMinus function.

    public int func(int a, int b) {
        return Math.abs(a) - Math.abs(b);
    }
}
