package chapter_21;
// Demonstrate Timer and TimerTask
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    public void run() {
        System.out.println("Timer task executed.");
    }
}
