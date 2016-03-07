import java.util.Iterator;

public class DobbelLenkeListe<T> implements Iterable<T>{

	protected int storrelse;
	protected Node<T> ende, hode, hale;

	DobbelLenkeListe(){
		this.storrelse = 0;
		this.ende = new Node<T>();
		ende.settNeste(ende);
		ende.settForrige(ende);
		this.hode = ende;
		this.hale = ende;
	}

	public boolean erTom(){
		return storrelse == 0;
		/*
		if (storrelse == 0){
			return true;
		} else return false;
		*/
	}

	public void settInnForan(T data){
		Node<T> ny = new Node<T>(data);
		ny.settInnMellom(hode, hode.hentNeste());
		storrelse++;
	}

	public void settInnBak(T data){
		Node<T> ny = new Node<T>(data);
		ny.settInnMellom(hale.hentForrige(), hale);
		storrelse++;
	}

	public T taUtForan(){
		if (erTom()){
			return null;
		}
		storrelse--;
		return hode.hentNeste().kobleUt();
	}

	public T taUtBak(){
		if (erTom()){
			return null;
		}
		storrelse--;
		return hale.hentForrige().kobleUt();
	}

	public void skrivUtAlle(){
		System.out.println("REKURSJON!");
		hode.hentNeste().skriv();
	}

	public Iterator<T> iterator() {
		return new DobbelLenkeListeIterator();
	}
/*
	void skrivUt(){
		EnkelIterator eit = this.iterator();
		while (eit.harNeste()){
			System.out.println(eit.neste());
		}
	}
*/

	private class DobbelLenkeListeIterator implements Iterator<T>{
		private Node<T> denne;

		DobbelLenkeListeIterator(){
			denne = hode.hentNeste();
		}

		public boolean hasNext(){
			return denne != hale;
			/*
			if (denne == hale){
				return false;
			}
			else return true;
			*/
		}

		public T next(){
			T temp = denne.hentData();
			denne = denne.hentNeste();
			return temp;
		}
	}

}

































































