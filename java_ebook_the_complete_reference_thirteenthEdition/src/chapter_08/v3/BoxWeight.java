package chapter_08.v3;

import chapter_08.Box;

// BoxWeight now fully implements all constructor
public class BoxWeight extends Box {
    public double weight;      // weight of box

    // construct clone of an object
    public BoxWeight(BoxWeight ob) {       // pass object to constructor
        super(ob);
        weight = ob.weight;
    }

    // constructor when all parameters are specified
    public BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);     // call superclass constructor
        weight = m;
    }

    // default constructor
    public BoxWeight() {
        super();
        weight = -1;
    }

    // constructor used when cube is created
    public BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }
}
