public class DobbelLenkeListe<T>{

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

	public EnkelIterator<T> iterator(){
		return new DobbelLenkeListeIterator();
	}

	public class DobbelLenkeListeIterator implements EnkelIterator<T>{

		private Node<T> denne;

		DobbelLenkeListeIterator(){
			denne = hode.hentNeste();
		}

		public boolean harNeste(){
			return denne != hale;
		}

		public T neste(){
			T data = denne.hentData();
			denne = denne.hentNeste();
			return data;
		}

	}


}


























