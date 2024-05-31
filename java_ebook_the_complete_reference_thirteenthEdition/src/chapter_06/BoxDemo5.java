package chapter_06;

public class BoxDemo5 {
    public static void main(String[] args) {
        Box_4 mybox1 = new Box_4();
        Box_4 mybox2 = new Box_4();
        double vol;

        // initialize each box
        mybox1.setDim(10, 20, 15);
        mybox2.setDim(3, 6, 9);

        // get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume is " + vol);

        // get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume is " + vol);
    }
}
