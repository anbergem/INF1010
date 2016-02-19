import java.util.ArrayList;

public class Program{

	public static void main(String[] args) {
		IFIStudent ifistudent = new IFIStudent("Henrik", "Rosa", "UiO");

		ifistudent.leggTilSpraak(new Python());
		ifistudent.leggTilSpraak(new Java());

		ifistudent.skrivUtSpraak();

		System.out.println();
		System.out.println("Legger til flere språk");
		System.out.println();

		ifistudent.leggTilSpraak(new HTML());
		ifistudent.leggTilSpraak(new C());
		ifistudent.leggTilSpraak(new C());
		ifistudent.leggTilSpraak(new JavaScript());

		ifistudent.skrivUtSpraak();

		System.out.println("hea".compareTo("hae"));

	}

}