package chapter_11.v2;

public class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    // synchronize calls to call()
    public void run(){
        synchronized (target) { // synchronized block
            target.call(msg);
        }
    }
}
