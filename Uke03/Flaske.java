
public class Flaske<D> implements DrikkeBeholder<D>{

	private D innhold;
	private int kapasitet;

	public Flaske(int kapasitet){
		this.kapasitet = kapasitet;
	}

	public Flaske(int kapasitet, D innhold){
		this.innhold = innhold;
		this.kapasitet = kapasitet;
	}

	public int hentKapasitet(){
		return this.kapasitet;
	}

	public void fyllMed(D innhold){
		this.innhold = innhold;
	}

	public D toem(){
		D temp = innhold;
		innhold = null;
		return temp;
	}

}


















