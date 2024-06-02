package chapter_07;

public class OverloadCons2 {
    public static void main(String[] args) {
        // create boxes using the various constructors
        Box_3 mybox1 = new Box_3(10, 20, 15);
        Box_3 mybox2 = new Box_3();
        Box_3 mycube = new Box_3(7);

        Box_3 myclone = new Box_3(mybox1);      // create copy of mybox1
        double vol;

        // get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume of mybox1 is " + vol);

        // get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume of mybox2 is " + vol);

        // get volume of cube
        vol = mycube.volume();
        System.out.println("Volume of cube is " + vol);

        // get volume of clone
        vol = myclone.volume();
        System.out.println("Volume of clone is " + vol);
    }
}
