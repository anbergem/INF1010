public abstract class KoffeinholdigDrikke implements Drikkbar{

	protected String beskrivelse;
	protected double koffeininnhold;
	protected String farge;

	public String kortInfo(){
		return this.beskrivelse;
	}

	public Aldersgrense kanSelgesTil(){
		return Aldersgrense.ALLE;
	}

	public double hentKoffeininnhold(){
		return this.koffeininnhold;
	}

	public String hentFarge(){
		return farge;
	}
}