package Task4;

public class SyncMethod implements Runnable{

    public synchronized void firstSynchronized() {
        System.out.println("First synchronized method called");
        this.secondSynchronized();
    }

    public synchronized void secondSynchronized() {
        System.out.println("Second synchronized method called");
        this.thirdSynchronized();
    }

    public synchronized void thirdSynchronized() {
        System.out.println("Third synchronized method called");
    }
    
    @Override
    public void run() {
        this.firstSynchronized();
    }
    
    
    public static void main(String[] args) {
         SyncMethod syncMethod = new SyncMethod();
         Thread thread = new Thread(syncMethod);
         thread.start();
    }

}


