abstract class Arbeider extends Thread{

	int id;
	Ordbuffer forrige, neste;
	String minsteOrd;

	Arbeider(int id) {
		this.id = id;
	}

	String hentOrd() {
		forrige.hentOrd();
	}

	void giOrd(String ord) {
		neste.giOrd(ord);
	}

	public void run() {
		minsteOrd = hentOrd();
		String nesteOrd = hentOrd();

		while (nesteOrd != null) {
			if (nesteOrd.compareTo(minsteOrd) < 0) {
				giOrd(minsteOrd);
				minsteOrd = nesteOrd;
			} else {
				giOrd(nesteOrd);
			}
			nesteOrd = hentOrd();
		}


		System.out.println("Traad " + id + 
			", minsteord:" + minsteord);
		giOrd(null);
	}

}

class ForsteArbeider extends Arbeider {
	File filnavn;
	Scanner scanner;

	ForsteArbeider(String filnavn, Ordbuffer neste) {
		super(1);
		this.neste = neste;
		fil = new File(filnavn);
		try {
			scanner = new Scanner(fil);
		} catch (Exception e) {
			System.out.println("Finner ikke filen");
			System.exit(1);
		}
	}

	String hentOrd() {
		if (scanne.hasNextLine) return scanner.nextLine();
		else return null;
	}

}

class IndreArbeider extends Arbeider {
	IndreArbeider(int id, Ordbuffer forrige, Ordbuffer neste) {
		super(id);
		this.forrige = forrige;
		this.neste = neste;
	}
}

class SisteArbeider extends Arbeider {
	PrinterWriter printer;

	SisteArbeider(int id, String filnavn, Ordbuffer forrige) {
		this.id = id;
		this.forrige = forrige;
		try {
			printer = new PrintWriter(new File(filnavn));
		} catch (Exception e) {
			System.out.println("hei");
			System.exit(1);
		}
	}

	void giOrd(String ord) {
		if (ord != null) printer.println(ord);
		else printer.close();
	}
}

class Ordbuffer {
	ArrayList<String> ordene = new ArrayList<String>();

	public synchronized void giOrd(String ord) {
		while (ordene.size() == 10) {
			try {
				wait();
			}
			catch (Exception e) {
				System.exit(1);
			}
		}
		ordene.add(ord);
		notify();
	}

	public synchronized String hentOrd() {
		while (ordene.size() == 0) {
			try {
				wait();
			}
			catch (Exception e) {
				System.exit(1);
			}
		}
		String ord = ordene.remove(0);
		notify();
		return ord;		
	}
}



























