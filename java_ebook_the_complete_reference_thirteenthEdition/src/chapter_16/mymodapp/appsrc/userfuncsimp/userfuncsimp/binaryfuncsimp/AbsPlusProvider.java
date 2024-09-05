package chapter_16.mymodapp.appsrc.userfuncsimp.userfuncsimp.binaryfuncsimp;
// This is a provider for the AbsPlus function.
import chapter_16.mymodapp.appsrc.userfuncs.userfuncs.binaryfuncs.BinFuncProvider;
import chapter_16.mymodapp.appsrc.userfuncs.userfuncs.binaryfuncs.BinaryFunc;

public class AbsPlusProvider implements BinFuncProvider {
    // Provide an AbsPlus object.
    public BinaryFunc get() {
        return new AbsPlus();
    }
}
