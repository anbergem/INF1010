public class Roedvin extends Vin{

	private boolean fyldig;

	public Roedvin(String beskrivelse, double volum, String farge, int aargang,boolean fyldig){
		this.beskrivelse = beskrivelse;
		this.volum = volum;
		this.farge = farge;
		this.aargang = aargang;
		this.fyldig = fyldig;
	}

	public boolean erFyldig(){
		return this.fyldig;
	}

}