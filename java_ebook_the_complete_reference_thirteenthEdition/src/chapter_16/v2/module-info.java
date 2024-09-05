// A's module-info file:
//module  A {
//    requires B;
//}

// B's module-info file.
//module B {
//    exports somepack;
//    requires C;
//}

// A's module-info file updated to explicity require C;
//module A {
//    requires B;
//    requires C;     // also require C
//}

// B's module-info file.
//module B {
//    exports somepack;
//    requires transitive C;
//}