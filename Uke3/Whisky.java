public class Whisky extends AlkoholholdigDrikke{

	private String opprinnelsesland;

	public Whisky(String beskrivelse, double volum, String farge, String opprinnelsesland){
		//super(beskrivelse, volum, farge);
		//this.opprinnelsesland = opprinnelsesland;
		this.beskrivelse = beskrivelse;
		this.volum = volum;
		this.farge = farge;
		this.opprinnelsesland = opprinnelsesland;
	}

	public String hentOpprinnelsesland(){
		return this.opprinnelsesland;
	}

	public String kortInfo(){
		return String.format("%s fra %s", this.beskrivelse, this.opprinnelsesland);
	}

}