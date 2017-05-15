package Task6;

public class BusyWaitFixed {

    private static class Shared {
        public long setAt;
        public long seenAt;
    }

    public static void main(String[] args) {
        (new BusyWaitFixed()).test();
    }

    private void test() {
        final Shared shared = new Shared();
        final BusyWaitFixed instance = this;
        Thread notifier = new Thread(new Runnable() {
            public void run() {
                System.out.println("Running");
                try {
                    Thread.sleep(500);
                    System.out.println("Setting flag");
                    shared.setAt = System.nanoTime();
                    synchronized (instance) {
                        instance.notify();
                    }
                } catch (Exception e) {
                }
            }
        });
        notifier.start();
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        shared.seenAt = System.nanoTime();
        System.out.println("Delay between set and seen: " + (shared.seenAt - shared.setAt));
    }
}


