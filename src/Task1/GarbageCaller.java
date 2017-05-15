package Task1;

public class GarbageCaller extends Thread {
    public GarbageCaller() {
        this.start();
    }

    @Override
    public void run() {
        System.gc();
        System.runFinalization();
        System.out.println("Garbage Collector called");
    }
}