package chapter_16.mymodapp.appsrc.userfuncs.userfuncs.binaryfuncs;
// This interface defines the form of a service provider that
// obtains BinaryFunc instances.

import chapter_16.mymodapp.appsrc.userfuncs.userfuncs.binaryfuncs.BinaryFunc;

public interface BinFuncProvider {
    // Obtain a BinaryFunc.
    public BinaryFunc get();
}
