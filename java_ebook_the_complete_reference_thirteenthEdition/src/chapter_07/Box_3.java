package chapter_07;
// Here, Box allows one object to initialize another.
public class Box_3 {
    double width;
    double height;
    double depth;

    // Notice this constructor. It takes an object of type Box.
    Box_3(Box_3 ob) {       // pass object to constructor
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // constructor used when all dimension specified
    Box_3(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // constructor used when no dimensions specified
    Box_3() {
        width = -1;     // used -1 to indicate
        height = -1;    // an uninitialized
        depth = -1;     // box
    }

    // constructor used when cube is created
    Box_3(double len) {
        width = height = depth = len;
    }

    // compute and return volume
    double volume() {
        return width * height * depth;
    }
}
