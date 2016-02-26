public class Program{

	public static void main(String[] args) {
		DobbelLenkeListe<String> dll = new DobbelLenkeListe<String>();

		String[] s = {"Donald", "Brian", "Ole Johan", "Kristen"};
		for (String temp : s){
			dll.settInnBak(temp);
			System.out.printf("** Satte inn %s\n", temp);
		}

		skrivUt(dll);
	}

	public static void skrivUt(DobbelLenkeListe<String> dll){
		EnkelIterator<String> eit = dll.iterator();
		System.out.println("**Vi skriver ut listen:");
		while (eit.harNeste()){
			System.out.println(eit.neste());
		}
		System.out.println();
	}
}