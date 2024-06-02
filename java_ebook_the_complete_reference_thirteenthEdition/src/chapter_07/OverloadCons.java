package chapter_07;

public class OverloadCons {
    public static void main(String[] args) {
        // created boxes using the various constructor
        Box_2 mybox1 = new Box_2(10, 20, 30);
        Box_2 mybox2 = new Box_2();
        Box_2 mycube = new Box_2(7);

        double vol;

        // get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume of mybox1 is " + vol);

        // get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume of mybox2 is " + vol);

        // get volume of cube
        vol = mycube.volume();
        System.out.println("Volume of mycube is " + vol);
    }
}
