package chapter_06;

public class BoxDemo3 {
    public static void main(String[] args) {
        Box_2 mybox1 = new Box_2();
        Box_2 mybox2 = new Box_2();

        // assign values to mybox1's  instance variables
        mybox1.width = 10;
        mybox1.height = 20;
        mybox1.depth = 15;

        /* assign different values to mybox2's
        * instance variable */
        mybox2.width = 3;
        mybox2.height = 6;
        mybox2.depth = 9;

        // display volume of first box
        mybox1.volume();

        // display volume of second box
        mybox2.volume();
    }
}
