package Task1;

public class MainThread extends Thread {
    MainThread() {
        System.out.println("Start-up message");
        this.start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Message " + (i + 1));
            try {
                this.sleep(2);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    };

    protected void finalize() throws Throwable {
        System.out.println("Shut-down message");
    };

    public static void main(String[] args) throws Throwable {
        MainThread threadOne = new MainThread();
        MainThread threadTwo = new MainThread();
        MainThread threadThree = new MainThread();
        GarbageCaller garbageOne = new GarbageCaller();
        GarbageCaller garbageTwo = new GarbageCaller();
        GarbageCaller garbageThree = new GarbageCaller();
    }
}
