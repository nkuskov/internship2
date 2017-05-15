package Task8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

	public static void main(String[] args) {
		Lock obj1 = new ReentrantLock();
		Lock obj2 = new ReentrantLock();

		Thread thread1 = new Thread(new ThreadDeadlock(obj1, obj2), "thread1");
		Thread thread2 = new Thread(new ThreadDeadlock(obj2, obj1), "thread2");

	}

	public class ThreadDeadlock implements Runnable {
		private Lock lock1;
		private Lock lock2;

		public ThreadDeadlock(Lock lock1, Lock lock2) {
			this.lock1 = lock1;
			this.lock2 = lock2;
		}

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			lock1.lock();
			System.out.println(name + " lock on " + lock1);
			lock2.lock();

			System.out.println(name + " lock on " + lock2);
		}

	}

}
