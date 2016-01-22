class Bil{

	private int regnr;
	private Person sjåfør;

	public Bil(int regnr, Person sjåfør){
		this.regnr = regnr;
		this.sjåfør = sjåfør;
	}

	public Bil(int regnr){
		this.regnr = regnr;
	}

	public int getRegnr(){
		return this.regnr;
	}

	public Person getSjåfør(){
		return this.sjåfør;
	}
}