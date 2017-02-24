public class HFStudent extends Student implements Hipster{

	private boolean kul;
	private static String fakultet = "HF";

	public HFStudent(String navn, String farge, String skole){
		super(navn, farge, skole);
	}

	public void taKaffePaaLokka(){
		kul = true;
	}

	public String hentFakultet(){
		return fakultet;
	}

	/* // Trenger ikke lenger
	public String skrivInfo(){
		return String.format("%s, Fakultet: %s", super.skrivInfo(), fakultet);
	}
	*/



}