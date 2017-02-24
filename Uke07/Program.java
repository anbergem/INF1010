public class Program{

	public static void main(String[] args) {
		DobbelLenkeListe<String> dll = new DobbelLenkeListe<String>();

		String[] s = {"Donald", "Brian", "Ole Johan", "Kristen"};

		for (String temp : s){
			dll.settInnForan(temp);
			//dll.settInnBak(temp); for aa faa motsatt rekkefolge ut.
			System.out.printf("** Satte inn %s\n", temp);
		}

		skrivUt(dll);

		dll.skrivUtAlle();
	}

	public static void skrivUt(DobbelLenkeListe<String> dll){
		//Iterator<String> eit = dll.iterator();
		System.out.println("**Vi skriver ut listen:");
		for (String s : dll){
			System.out.println(s);
		}
		
	}
}






















