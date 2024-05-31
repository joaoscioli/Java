package chapter_06;
/* Here, Box uses a constructor to initialize the
*  dimensions of a box. */
public class Box_5 {
    double width;
    double height;
    double depth;

    // This is the constructor for Box.
    Box_5() {
        System.out.println("Constructing Box");
        width = 10;
        height = 10;
        depth = 10;
    }

    // compute and return volume
    double volume() {
        return width * height * depth;
    }
}
