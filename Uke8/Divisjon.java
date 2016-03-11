public class Divisjon {

	public static void main(String[] args) {
		
		new Divisjon().divider_100_med(10);
		/*
		try {
			new Divisjon().divider_100_med(10);
		}
		catch (ArithmeticException e) {
			System.out.println("HEI");	
		}
		*/
	}

	public int divider_100_med(int i) {
		/*
		if (i > -10) {
			try {
				System.out.println("Dividerer 100 med " + 
				divider_100_med(i-1) + ", " + 100/i);
			} 
			catch (ArithmeticException e) {
				System.out.println("HEI");
			}
		}
		*/
		// Et eller annet saann her..............
		//if (i == 0) throw (ArithmeticException e);
		if (i > -10) {
			System.out.println("Dividerer 100 med " + 
				divider_100_med(i-1) + ", " + 100/i);
		}

		return i;
	}
}













