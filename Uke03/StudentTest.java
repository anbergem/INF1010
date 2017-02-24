public class StudentTest{
	public static void main(String[] args) {
		Student student = new Student(23);
		Roedvin nattverdsvin = new Roedvin("Natureo Free", 0.05, "Roed", 2013, true);

		Flaske<AlkoholholdigDrikke> alkoholflaske = new Flaske<AlkoholholdigDrikke>(750);
		alkoholflaske.fyllMed(nattverdsvin);
		student.drikkAv(alkoholflaske);

		test(student.kanKjoere(), true, "om studenten kan kjoere etter nattverdsvin");

		Hvitvin riesling = new Hvitvin("Riesling", 11.5, "Hvit", 2012, true);
		alkoholflaske.fyllMed(riesling);
		student.drikkAv(alkoholflaske);

		test(student.kanKjoere(), true, "om studenten ikke kan kjoere etter riesling");

		student.sovUtRusen();

		test(student.kanKjoere(), true, "om studenten kan kjoere etter avrusning");

		System.out.println(nattverdsvin.kanSelgesTil());


	}

	public static void test(boolean testKall, boolean forventet, String beskjed){
		if (testKall == forventet){
			System.out.printf("Tester %s: Yes!\n", beskjed);
		}
		else System.out.printf("Tester %s: Huff da..! Forventet %b, fikk %b\n", beskjed, forventet, testKall);
	}
}