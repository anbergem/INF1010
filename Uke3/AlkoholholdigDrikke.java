public abstract class AlkoholholdigDrikke implements Drikkbar{
	
	protected String beskrivelse;
	protected double volum;
	protected String farge;

	public double hentVolum(){
		return this.volum;
	}

	public String hentFarge(){
		return this.farge;
	}

	public String kortInfo(){
		return beskrivelse;
	}

	public Aldersgrense kanSelgesTil(){
		if (volum >= 22){
			return Aldersgrense.OVER20;
		}
		else if (volum >= 0.7){
			return Aldersgrense.OVER18;
		}
		else return Aldersgrense.ALLE;
	}
}