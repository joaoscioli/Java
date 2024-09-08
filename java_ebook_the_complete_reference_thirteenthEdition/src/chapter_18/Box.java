package chapter_18;
// Override toString() for Box class.
public class Box {
    double width;
    double height;
    double depth;

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    public String toString() {
        return "Dimensions are " + width + " by " +
                depth + " by " + height + ".";
    }
}
