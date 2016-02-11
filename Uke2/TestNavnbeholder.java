class TestNavnbeholder{

	static boolean testString(String actual, String expected){
		if (actual != null && expected != null && actual.equals(expected)) {
			return true;
		}
		//else return false;
		return false;

	}

	public static void main(String[] args) {
		
		Navnbeholder nb = new Navnbeholder();

		//System.out.println();
		//System.out.print(" \n");
		System.out.format("Tester opprinnelig Nullpointer: ");
		if (nb.hentNavn() == null){
			System.out.format("Passed!\n");
		}
		else System.out.format("Failed!\n");

		// lage et navn og sjekk at det returneres
		// bruke .equals()
		System.out.format("Teste at et navn returneres: ");
		String navn = "Nils";
		nb.lagreNavn(navn);
		if (testString(nb.hentNavn(), navn)){
			System.out.format("Passed!\n");
		}
		else System.out.format("Failed!\n");

		// Sjekke at den ikke returnerer null når vi
		// har et navn i klassen.

		// Gi den en feil verdi:
		// Gi klassen en annen type enn String.

		// Sjekke at navnet ikke forsvinner når vi 
		// henter det.

		// At et nytt navn blir lagret når vi 
		// legger inn et nytt navn
	}
}










