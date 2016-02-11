public class Student implements AnsvarligAlkoholkonsument, Sjaafoer{

	protected double promille;
	protected boolean iFengsel;
	protected int alder;

	public Student(int alder){
		this.alder = alder;
	}

	public double hentPromille(){
		return this.promille;
	}

	public int getAlder(){
		return this.alder;
	}

	public void drikkAv(Flaske<AlkoholholdigDrikke> alkoholflaske){
		int flaskevolum = alkoholflaske.hentKapasitet();
		AlkoholholdigDrikke ad = alkoholflaske.toem();

		if (ad != null){
			double alkoholdinnhold = ad.hentVolum();
			double promilleoekning = 0.014 * flaskevolum * alkoholdinnhold/100;
			promille += promilleoekning;
			System.out.printf("Drikker %d ml %s. ", flaskevolum, ad.kortInfo());
		} else System.out.println("Flasken er tom...");
		System.out.printf("Student har %.1f i promille.\n", promille);
	}

	public void sovUtRusen(){
		System.out.println("Studenten sover ut ruse");
		this.promille = 0;
	}

	public boolean kanKjoere(){
		if (promille < 0.2){
			return true;
		} else return false;
	}

}












