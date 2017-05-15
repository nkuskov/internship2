package Task5;

public class SubThread extends Thread {
    public final static Object monitor = new Object();


    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println("message");
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }

    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        SecondThread secondThread = new SecondThread();
        subThread.start();
        secondThread.start();
    }
}


class SecondThread extends Thread {

    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (SubThread.monitor) {
            SubThread.monitor.notifyAll();
        }
    }

}
