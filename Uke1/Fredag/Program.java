class Program{
	public static void main(String[] args){
		
		Bil bilenMin = new Bil("ABC123", "Honda");
		Motorsykkel mc = new Motorsykkel("DEF456", "Harley");

		Garasje<Bil> bilgarasje = new Garasje<Bil>(2);

		bilgarasje.setKjoretoy(bilenMin, 0);

		System.out.println(bilgarasje.getKjoretoy(0));

		//Bil lexus = new Bil("asd", "Lexus")
		//bilgarasje.setKjoretoy(lexus);

		Garasje blandaGarasje = new Garasje<>(2);

		blandaGarasje.setKjoretoy(bilenMin,0);
		blandaGarasje.setKjoretoy(mc, 1);

	}
}