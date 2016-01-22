class Bil{

	private String regnr;
	private String type;

	public Bil(String regnr, String type){
		this.regnr = regnr;
		this.type = type;
	}

	public String getRegnr(){
		return this.regnr;
	}

	public String getType(){
		return this.type;
	}

	public String toString(){
		return getClass().getName() + ", " + type + ", " + regnr;
	}
}