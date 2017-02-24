public class Person{

	private String navn;
	private String farge;

	public Person(String navn, String farge){
		this.navn = navn;
		this.farge = farge;
	}

	public String skrivInfo(){
		return String.format("Classname: %s, Navn: %s, Farge: %s", getClass().getName(), navn, farge);
	}

}