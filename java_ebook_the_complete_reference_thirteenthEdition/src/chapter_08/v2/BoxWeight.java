package chapter_08.v2;

import chapter_08.Box;

// BoxWeight now uses super to initialize its Box attributes.
public class BoxWeight extends Box {
    double weight;      // weight of Box

    // initialize width, height, and depth using super()
    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);         // call superclass constructor
        weight = m;
    }
}
