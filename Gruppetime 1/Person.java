//github.com/anbergem/inf1010
class Person{

	private String navn;
	private int personnr;

	private Garasje minGarasje;

	public Person(String navn,int personnr){
		this.navn = navn;
		this.personnr = personnr;
	}

	
	public String getNavn(){
		return navn;
	}

	public void setNavn(String nyttNavn){
		this.navn = nyttNavn;
	}

	public int getPersonnr(){
		return personnr;
	}

	public Garasje getMinGarasje(){
		return this.minGarasje;
	}

	public void setMinGarasje(Garasje garasje){
		this.minGarasje = garasje;
	}

	public void kjør(){
		/*
		if (minGarasje == null){
			System.out.println("Garasjen er tom")
			return;
		}
		*/
		System.out.println(minGarasje.getBil().getRegnr());
	}
}





















