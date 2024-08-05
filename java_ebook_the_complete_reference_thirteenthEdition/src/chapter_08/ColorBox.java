package chapter_08;
// Here, Box is extended to include color.
public class ColorBox extends Box{
    int color;      // color of Box

    ColorBox(double w, double h, double d, int c) {
        width = w;
        height = h;
        depth = d;
        color = c;
    }
}
