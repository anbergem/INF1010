import java.util.ArrayList;

public class IFIStudent extends Student{

	private ArrayList<String> programmeringsspraak;
	private static String fakultet = "MatNat";

	public IFIStudent(String navn, String farge, String skole){
		super(navn, farge, skole);
		programmeringsspraak = new ArrayList<String>();

	}

	public String hentFakultet(){
		return fakultet;
	}

	public void leggTilSpraak(String spraak){
		programmeringsspraak.add(spraak);
	}
	/* // Trenger ikke lenger
	public String skrivInfo(){
		return String.format("%s, Fakultet: %s", super.skrivInfo(), fakultet);
	}
	*/

}