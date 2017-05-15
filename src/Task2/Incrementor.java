package Task2;

public class Incrementor implements Runnable {
    int sharedInteger = 0;

    public Incrementor() {
        Thread threadOne = new Thread(this);
        Thread threadTwo = new Thread(this);
        threadOne.start();
        threadTwo.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 1000000; i++) {
                sharedInteger++;
            }
        
        System.out.println(sharedInteger);
        }
    }

    public static void main(String[] args) {
        Incrementor incrementor = new Incrementor();
    }
}
