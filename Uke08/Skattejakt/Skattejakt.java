public class Skattejakt {

	static String string = "";
	int[][] kart = {{34,21,32,41,25},
					{14,42,43,14,31},
					{54,45,52,42,23},
					{33,15,51,31,35},
					{21,52,33,13,23}};

	public static void main(String[] args) {
		string += "11";
		int tall = new Skattejakt().finnNesteTall(0, 0);
		System.out.println(string);
		System.out.println("WOOHOO DU FANT SKATTEN. DEN ER PÅ PLASS " + string.substring(string.length()-2, string.length()));
		//string[-2:] // fungere ikke i java
	}

	public int finnNesteTall(int i, int j) {
		int tallet = kart[i][j];
		// Splitte opp tallet
		int tall1 = tallet/10;
		int tall2 = tallet%10;
		
		tall1 --; tall2--;

		// Basistilfelle: 
		// Naar tallet == finnNesteTall(tall1, tall2)
		if (tall1 == i && tall2 == j) return kart[tall1][tall2]; 
		string = string + "," + tallet;
		finnNesteTall(tall1, tall2);
		
		return tallet;
	}
}












