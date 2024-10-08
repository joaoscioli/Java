package chapter_25;
// Demonstrate some virtual key codes.

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventsDemo extends Frame implements KeyListener {
    String msg = "";
    String keyState = "";

    public KeyEventsDemo() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    // Handle a key press.
    public void keyPressed(KeyEvent ke) {
        keyState = "Key Down";

        int key = ke.getKeyCode();
        switch (key) {
            case KeyEvent.VK_F1:
                msg += "<F1>";
                break;
            case KeyEvent.VK_F2:
                msg += "<F2>";
                break;
            case KeyEvent.VK_F3:
                msg += "<F3>";
                break;
            case KeyEvent.VK_PAGE_DOWN:
                msg += "<PgDn>";
                break;
            case KeyEvent.VK_PAGE_UP:
                msg += "<PgUp>";
                break;
            case KeyEvent.VK_LEFT:
                msg += "<Left Arrow>";
                break;
            case KeyEvent.VK_RIGHT:
                msg += "<Right Arrow>";
                break;
        }
        repaint();
    }

    // Handle a key release.
    public void keyReleased(KeyEvent ke) {
        keyState = "Key Up";
        repaint();
    }

    // Handle key typed.
    public void keyTyped(KeyEvent ke) {
        msg += ke.getKeyChar();
        repaint();
    }

    // Display keystrokes.
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args) {
        KeyEventsDemo appwin = new KeyEventsDemo();

        appwin.setSize(200, 150);
        appwin.setTitle("KeyEventsDemo");
        appwin.setVisible(true);
    }
}
