public class Kelner implements Runnable {

	public static int kelnerteller = 0;

	private int id;
	private Bord bord;

	public Kelner(Bord bord) {
		this.bord = bord;

		id = kelnerteller++;
	}

	public int getId() {return id;}

	public void run() {
		try {
			while (bord.hentTallerken(this)) {
				// Det tar litt tid å servere!
				Thread.sleep((long) (1000*Math.random()));
			}
		}
		catch (InterruptedException e) {}

		// Kelner er ferdig
		System.out.println("Kelner " + id + " er ferdig!");
	}
}







































