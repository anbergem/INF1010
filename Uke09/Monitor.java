import java.util.concurrent.CountDownLatch;

public class Monitor {

	final int MAX = 200000000;
	int i = 0;
	CountDownLatch barrier;

	public Monitor(CountDownLatch barrier) {
		this.barrier = barrier;
	}

	synchronized public void add(Increment inc) {
		i++;
		//System.out.println(inc + " adderte 'i' til: " + i);
	}

	synchronized public int getI(Increment inc){
		if (i < MAX) {
			//System.out.println(inc + " henter 'i' når den er: " + i);
			return i;
		}
		barrier.countDown();
		return -1;
	}

}