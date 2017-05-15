package Task6;

import java.sql.Time;


public class BusyWait extends Thread {
    
    private static class Shared {
        public long setAt;
        public long seenAt;
        public volatile boolean flag = false;
    }

    public static void main(String[] args) {
        final Shared shared = new Shared();
        Thread notifier = new Thread(new Runnable() {
            public void run() {
                System.out.println("Running");
                try {
                    Thread.sleep(500);
                    System.out.println("Setting flag");
                    shared.setAt = System.nanoTime();
                    shared.flag = true;
                } catch (Exception e) {
                }
            }
        });
        notifier.start();
        while (!shared.flag) {
        }
        shared.seenAt = System.nanoTime();
        System.out.println("Delay between set and seen: " + (shared.seenAt - shared.setAt));
    }
}
