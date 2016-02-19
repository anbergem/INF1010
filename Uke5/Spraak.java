abstract public class Spraak implements Comparable<Spraak>{

	protected int rang;

	public int compareTo(Spraak spraak){
		return rang - spraak.hentRang();
	}

	public int hentRang(){
		return rang;
	}

	public String toString(){
		return String.format("%s, rang: %s", getClass().getName(), rang);
	}

}