public class Hvitvin extends Vin{

	private boolean toerr;

	public Hvitvin(String beskrivelse, double volum, String farge, int aargang,boolean toerr){
		super();
		this.beskrivelse = beskrivelse;
		this.volum = volum;
		this.farge = farge;
		this.aargang = aargang;
		this.toerr = toerr;
	}

	public boolean erToerr(){
		return this.toerr;
	}
}