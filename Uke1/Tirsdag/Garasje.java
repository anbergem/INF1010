class Garasje{

	private int maksAntBiler;
	private Bil bil;

	public Garasje(int maks){
		this.maksAntBiler = maks;
	}

	public Bil getBil(){
		return this.bil;
	}

	public void setBil(Bil bil){
		this.bil = bil;
	}

	public Bil taUtBilenMin(){
		if (tom()){
			System.out.println("Ingen bil i garasjen");
		}
		else{
			Bil temp = this.bil;
			this.bil = null;
			return temp;
		}
		return null;
	}

	public boolean tom(){
		if (bil == null){
			return true;
		}
		else{
			return false;
		}
	}
}















