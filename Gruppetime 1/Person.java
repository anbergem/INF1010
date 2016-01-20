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
		if (minGarasje == null){
			System.out.println("Garasjen er tom");
			return;
		}
		
		System.out.println(minGarasje.getBil());
		System.out.println(minGarasje.getBil().getRegnr());
		
		// minGarasje.getBil() er av typen Bil!
		Bil minBil = minGarasje.getBil();
		System.out.println(minBil.getRegnr());

		// Her er forskjellen at jeg tar bilen ut av garasjen
		minBil = minGarasje.taUtBilenMin(); // Kunne laget en ny bil
		System.out.println("Tar ut bilen...");
		System.out.println("Sjekker nå om bilen er tom...");
		System.out.println("Den er... " + minGarasje.getBil());

		System.out.println("DA KJØRER VI RUNDT!! WEEEEE!!!");

		System.out.println("Kjøreturen er ferdig. Skal nå sette tilbake bilen");

		minGarasje.setBil(minBil);
		System.out.println("Nå skal bilen være på plass");
		System.out.println("I garasjen finner vi... " + minGarasje.getBil());
	}
}





















