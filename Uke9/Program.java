import java.util.concurrent.CountDownLatch;

public class Program {

	public static void main(String[] args) {
		int not = 4; // number of threads
		CountDownLatch barrier = new CountDownLatch(not);
		Monitor monitor = new Monitor(barrier);

		//Increment increment = new Increment(monitor);
		//Thread thread = new Thread(increment);
		//thread.start();
		double t = System.nanoTime();
		for (int i = 0; i<not; i++) {
			new Thread(new Increment(monitor)).start();
		}
		
		try {
			barrier.await();
			System.out.println("\nFERDIG!!\n");
		} catch (Exception e) {

		}
		t = (System.nanoTime()-t)/1000000.;

		double t2 = System.nanoTime();
		int i = 0;
		while (i < monitor.MAX) {
			i++;
			//System.out.println("Main kjører, i: " + i);
		}
		t2 = (System.nanoTime()-t2)/1000000.;
		System.out.println("Tråder: " + t + " ms, Main: " + t2 + " ms");
	}
}












