class Navnbeholder implements Navnlagrer{

	private String navnet;

	public void lagreNavn(String navn){
		navnet = navn;
	}

	public String hentNavn(){
		return navnet;
	}

}