import java.util.ArrayList;

public class IFIStudent extends Student{

	private ArrayList<String> programmeringsspraak;
	private static String fakultet = "MatNat";

	public IFIStudent(String navn, String farge, String skole){
		programmeringsspraak = new ArrayList<String>();
		super(navn, farge, skole);
	}

}