import java.util.ArrayList;

public class IFIStudent extends Student{

	private Spraakliste<Spraak> programmeringsspraak;
	private static String fakultet = "MatNat";

	public IFIStudent(String navn, String farge, String skole){
		super(navn, farge, skole);
		programmeringsspraak = new Spraakliste<Spraak>();

	}

	public String hentFakultet(){
		return fakultet;
	}

	public void leggTilSpraak(Spraak spraak){
		programmeringsspraak.leggTil(spraak);
	}

	public void skrivUtSpraak(){
		programmeringsspraak.skrivUtSpraak();
	}

	public void skrivUtSpraak_alt() {
		programmeringsspraak.skrivUtSpraak_alt();
	}

	/* // Trenger ikke lenger
	public String skrivInfo(){
		return String.format("%s, Fakultet: %s", super.skrivInfo(), fakultet);
	}
	*/

}