class Program{
	public static void main(String[] args){
		

		String a = "hei";
		System.out.println(a);


		Person andreas = new Person("Andreas", 12345);

		System.out.println(andreas.getNavn());
		andreas.setNavn("Nils");
		System.out.println(andreas.getNavn());
		Person nils = andreas;

		Garasje garasje = new Garasje(1);

		//andreas.setMinGarasje = garasje; <- FEIL!
		andreas.setMinGarasje(garasje);
		Bil bil = new Bil(1234, andreas);

		garasje.setBil(bil);
		//andreas.getMinGarasje().setBil(bil);

		andreas.kjør();


		

	}
}