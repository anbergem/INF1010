import java.util.Iterator;

public class SimpleArrayList<T> implements Iterable<T>{

	private int teller;
	private int antallPlasser;
	private Object[] minArray;

	public SimpleArrayList(){
		this.antallPlasser = 10;
		minArray = new Object[antallPlasser];
	}

	public void leggTil(Object element){
		minArray[teller++] = element;
		System.out.printf("%s ble lagt til\n", element);
	}

	public Iterator<T> iterator(){
		return new MinIterator<T>();
	}

	private class MinIterator<T> implements Iterator<T>{

		private int minTeller;

		public boolean hasNext(){
			return minTeller < teller;
		}

		@SuppressWarnings("unchecked")
		public T next(){
			return (T) minArray[minTeller++];
		}

		public void remove(){
			minArray[minTeller-1] = null;
		}
	}

}
















