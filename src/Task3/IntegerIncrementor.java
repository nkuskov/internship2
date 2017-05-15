package Task3;

public class IntegerIncrementor extends Thread {
    final static Object monitor = new Object();
    private int sharedInteger;

    public IntegerIncrementor(int sharedInteger) {
        this.sharedInteger = sharedInteger;
    }

    public int getSharedInteger() {
        return this.sharedInteger;
    }

    public void setSharedInteger(int sharedInteger) {
        this.sharedInteger = sharedInteger;
    }

    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            synchronized (monitor) {
                setSharedInteger(getSharedInteger() + 1);
                monitor.notify();
                try {
                    monitor.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }



    public static void main(String[] args) {
        int sharedInteger = 0;
        IntegerIncrementor incrementor = new IntegerIncrementor(sharedInteger);
        IntegerPrinter printer = new IntegerPrinter(incrementor);
        incrementor.start();
        printer.start();
    }

}


class IntegerPrinter extends Thread {
    IntegerIncrementor incrementor;

    public IntegerPrinter(IntegerIncrementor incrementor) {
        this.incrementor = incrementor;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (incrementor.monitor) {
                try {
                    incrementor.monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(incrementor.getSharedInteger());
                incrementor.monitor.notify();
            }
        }
        System.out.println("Done");
    }
}
