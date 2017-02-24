import java.util.ArrayList;

public class Program{

	public static void main(String[] args) {
		IFIStudent ifiStudPeker = new IFIStudent("Henrik", "Rosa", "UiO");

		Student studPeker = ifiStudPeker;

		System.out.println(ifiStudPeker.skrivInfo());
		System.out.println(studPeker.skrivInfo());

		Person personpeker = new Person("Andreas", "Svart");

		System.out.println(personpeker.skrivInfo());

		//studPeker = (Student) personpeker; //Ikke lov

		IFIStudent nyIfistudpeker;
		if (studPeker instanceof IFIStudent){
			nyIfistudpeker = (IFIStudent)studPeker;
		}

		nyIfistudpeker = new IFIStudent("Nils", "Oransje", "UiO");
		System.out.println(nyIfistudpeker.skrivInfo());

		ArrayList<Student> klasserom = new ArrayList<Student>();
		klasserom.add(ifiStudPeker);
		klasserom.add(nyIfistudpeker);
		klasserom.add(new HFStudent("Katrine", "Hvit", "UiO"));
		klasserom.add(studPeker);

		System.out.println();
		for (Student st : klasserom){
			System.out.println(st.skrivInfo());
		}



















	}

}