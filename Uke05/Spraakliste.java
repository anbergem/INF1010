// CompareTo: 
// negative integer as this object is less than the
// specified object
public class Spraakliste<E extends Spraak>{

	private Node forste;

	private class Node{

		E element;
		Node neste;

		Node(E element){
			this.element = element;
		}		

	}


	public void leggTil(E element){
		Node nyNode = new Node(element);
		if (forste == null){
			forste = nyNode;
		}
		else if(forste.element.compareTo(nyNode.element) < 0){
			nyNode.neste = forste;
			forste = nyNode;
		}
		else{
			Node temp = forste;
			while (temp.neste != null && 
				   temp.neste.element.compareTo(nyNode.element) > 0){
				temp = temp.neste;
			}
			nyNode.neste = temp.neste;
			temp.neste = nyNode;

			// DETTE OMRÅDE HER
		}
	}

	public void skrivUtSpraak(){
		Node temp = forste;
		while (temp != null){
			System.out.println(temp.element);
			temp = temp.neste;
		}
	}

	public void skrivUtSpraak_alt() {
		Node temp = forste;
		while (true){
			try {
				System.out.println(temp.element);
				temp = temp.neste;
			}
			catch (NullPointerException e) {
				break;
			}
		}
	}
}


































