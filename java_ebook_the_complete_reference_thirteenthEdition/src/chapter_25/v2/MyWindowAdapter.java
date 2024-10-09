package chapter_25.v2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// When the close box in the frame is clicked,
// close the window and exit the program.
class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
