package Task9;

public class DataRace extends Thread {
	static int raceCount = 0;
		
	public void run(){
		while(raceCount<100){
			raceCount++;
			System.out.println("" + Thread.currentThread().getName() + " raceCount: " + raceCount);
		}
	}

	public static void main(String[] args) {
		DataRace thread1 = new DataRace();
		DataRace thread2 = new DataRace();
		
		thread1.start();
		thread2.start();
	}
	
	

}
