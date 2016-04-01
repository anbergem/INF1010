public class Kokk implements Runnable {

	public static int kokketeller = 0;

	private int id;
	Bord bord;

	public Kokk(Bord bord) {
		this.bord = bord;

		id = kokketeller++;
		// id = kokkteller;
		// kokketeller++;

	}

	public int getId() {return id;}

	public void run() {
		try {
			while (bord.settTallerken(this)) {
				// Det tar litt tid aa lage mat :)
				Thread.sleep((long) (1000*Math.random()));
			}
		}
		catch (InterruptedException e) {}

		// Kokken er ferdig
		System.out.println("Kokk " + id + " er ferdig!");
	}

}

























