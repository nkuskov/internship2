package Task7;

import java.io.IOException;

public class Semaphore {
	
	CountingSemaphore countingSemaphore = new CountingSemaphore(1);
	
	private void mutualExclusion(){
		try{
			countingSemaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
			Thread.sleep(1000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}finally{
			System.out.println(Thread.currentThread().getName() + " outside mutual exclusive region");
			countingSemaphore.release();
			
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		final Semaphore test = new Semaphore();
		
		new Thread(){
			public void run(){
				test.mutualExclusion();
			}
		}.start();
		
		new Thread(){
			public void run(){
				test.mutualExclusion();
			}
		}.start();
		
		new Thread(){
			public void run(){
				test.mutualExclusion();
			}
		}.start();
		
		new Thread(){
			public void run(){
				test.mutualExclusion();
			}
		}.start();

	}
	
	
	
	
	
	public class CountingSemaphore{
		private int signals = 0;
		
		CountingSemaphore(int signals){
			this.signals = signals;
		}
		
		public synchronized void acquire() throws InterruptedException{
			while(this.signals == 0) wait();
			this.signals--;
		}
		
		public synchronized void release(){
			this.signals++;
			this.notify();
		}
		
		
	}
	

}
