class TestDrikker{

	public static void main(String[] args) {
		Roedvin amorone = new Roedvin("Amarone della Valpolicella", 15, "Roed", 2005, true);

		if (amorone.erFyldig()){
			System.out.printf("Fyldig ");
		}
		else System.out.printf("Mindre fyldig ");

		System.out.printf("%s. %.1f%% volum.\n",
							amorone.kortInfo(),
							amorone.hentVolum());
		System.out.printf("Kan selges til %s\n",
							amorone.kanSelgesTil());
	}


}