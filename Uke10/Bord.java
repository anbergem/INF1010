public class Bord {

	public final int ANTALL_MAALTID_TOTALT = 200;
	public final int MAKS_PAA_BORDET = 10;

	private int antallLaget= 0,
				antallPaaBordet = 0,
				antallServert = 0;

	public synchronized boolean settTallerken(Kokk kokk) {
		while (antallPaaBordet == MAKS_PAA_BORDET &&
				antallLaget < ANTALL_MAALTID_TOTALT) {
			try {
				System.out.println("Kokk nr: " + kokk.getId() + " venter");
				wait();
			}
			catch (InterruptedException e) {}
		}
		if (antallLaget < ANTALL_MAALTID_TOTALT) {
			// Bordet er ikke fullt, og vi skal fortsette
			// aa lage
			antallPaaBordet++;
			antallLaget++;

			System.out.println("Maaltid nr: " + antallLaget + 
				" lagt på bordet av kokk nr " + kokk.getId()
				+ " \t Antall tallerkner på bordet: " + antallPaaBordet);

			//notifyAll();
			notify();

			if (antallLaget == ANTALL_MAALTID_TOTALT) {
				// Vi er ferdig!
				return false;
			}
			// Vi fortsetter
			else return true;
		}
		else {
			// Vi er ferdig!
			return false;
		}

	}

	public synchronized boolean hentTallerken(Kelner kelner) {
		while (antallPaaBordet == 0 &&
			antallLaget < ANTALL_MAALTID_TOTALT) {
			try { 
				System.out.println("Kelner nr: " + kelner.getId() + " venter");
				wait();
			}
			catch (InterruptedException e) {}
		}
		if (antallPaaBordet > 0) {
			// Det er mat paa bordet!
			antallPaaBordet--;
			antallServert++;

			System.out.println("Maaltid nr: " + antallServert +
				" servert av kelner " + kelner.getId() +
				" \t\t Antall tallerkner paa bordet " + 
				antallPaaBordet);

			//notifyAll();
			notify();

			if (antallLaget == ANTALL_MAALTID_TOTALT &&
				antallPaaBordet == 0) {
				// Vi er ferdig!
				return false;
			}
			// Vi fortsetter!
			else return true;
		}
		// FERDIG
		else return false;
	}

	public int getAntallLaget() {return antallLaget;}

	public int getAntallPaaBordet() {return antallPaaBordet;}

	public int getAntallServert() {return antallServert;}
}





















