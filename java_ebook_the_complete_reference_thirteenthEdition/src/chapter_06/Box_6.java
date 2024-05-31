package chapter_06;
/* Here, Box uses a parameterized constructor to
*  initialize the dimensions of a box. */
public class Box_6 {
    double width;
    double height;
    double depth;

    // This is the constructor for Box.
    Box_6(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // compute and return volume
    double volume() {
        return width * height * depth;
    }
}
