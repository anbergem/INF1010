public abstract class Vin extends AlkoholholdigDrikke{

	protected int aargang;

	public int hentAargang(){
		return this.aargang;
	}

	public String kortInfo(){
		return String.format("%s fra %d-aargang", this.beskrivelse, this.aargang);
	}

}