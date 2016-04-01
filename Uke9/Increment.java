
public class Increment implements Runnable {

	static int counter;
	int id;
	Monitor monitor;

	public Increment(Monitor monitor) {
		id = counter++;
		this.monitor = monitor;
	}

	public void run() {
		int i;

		while ((i = monitor.getI(this)) != -1) {
			monitor.add(this);
		}
	}

	public String toString() {
		return "Thråd nr: " + id;
	}
}