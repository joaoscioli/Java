package chapter_16.mymodapp.appsrc.userfuncsimp.userfuncsimp.binaryfuncsimp;
// This is a provider for the AbsMinus function.
import chapter_16.mymodapp.appsrc.userfuncs.userfuncs.binaryfuncs.BinFuncProvider;
import chapter_16.mymodapp.appsrc.userfuncs.userfuncs.binaryfuncs.BinaryFunc;

public class AbsMinusProvider implements BinFuncProvider {
    // Provide an AbsMinus object.
    public BinaryFunc get() {
        return new AbsMinus();
    }
}
