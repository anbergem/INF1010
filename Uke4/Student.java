abstract public class Student extends Person{

	private static int antStudenter = 0;
	private int studID;
	private String skole;
	//private String skole;

	public Student(String navn, String farge, String skole){
		super(navn, farge);
		this.skole = skole;
		studID = antStudenter;
		antStudenter++;
	}

	abstract String hentFakultet();

	public String skrivInfo(){
		return String.format("%s, Skole: %s, Fakultet: %s, IF: %d", super.skrivInfo(), skole, hentFakultet(), studID);
	}
}