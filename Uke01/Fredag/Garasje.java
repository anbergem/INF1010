class Garasje<T>{

	private int maksAntBiler;
	private T[] flereKjoretoy;

	public Garasje(int maks){
		this.maksAntBiler = maks;
		flereKjoretoy = (T[]) new Object[maks];
	}

	public T getKjoretoy(int plass){
		return this.flereKjoretoy[plass];
	}

	public void setKjoretoy(T kjoretoy, int plass){
		if (this.flereKjoretoy[plass] == null){
			this.flereKjoretoy[plass]=kjoretoy;
			System.out.println(kjoretoy + " satt inn i garasjen paa plass nummer " + plass);
		}
		else {
			System.out.println("Garasjeplassen er full");
			return;
		}
	}

	public T taUtKjoretoyetMitt(int plass){
		if (flereKjoretoy[plass] == null){
			System.out.println("Ingen kjoretoy paa garasjeplassen");
		}
		else{
			T temp = this.flereKjoretoy[plass];
			this.flereKjoretoy[plass] = null;
			return temp;
		}
		return null;
	}
	/*
	public boolean tom(){
		if (kjoretoy == null){
			return true;
		}
		else{
			return false;
		}
	}
	*/
}















