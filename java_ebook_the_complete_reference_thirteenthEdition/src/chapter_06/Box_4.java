package chapter_06;
// This program uses a parameterized method.
public class Box_4 {
    double width;
    double height;
    double depth;

    // compute and return volume.
    double volume() {
        return width * height * depth;
    }

    // sets dimensions of box
    void setDim( double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
}
