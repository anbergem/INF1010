class OrdnetDobbelLenkeListe<T extends Comparable<T>> extends DobbelLenkeListe<T>{

	OrdnetDobbelLenkeListe(){
		super();
	}

	public void settInnPaaRiktigPlass(T data){
		Node<T> ny = new Node<T>(data);
		finnRiktigPlassTilNode(ny);
		storrelse++;
	}
	public void finnRiktigPlassTilNode(Node<T> ny){
		T nyData = ny.hentData();
		Node<T> temp = hode;
		while ((temp = temp.hentNeste()) != hale &&
			    nyData.compareTo(temp.hentData()) > 0){
		}
		ny.settInnMellom(temp.hentForrige(), temp);
	/*
        while ((denne = denne.hentNeste()) != hale) {
            if (t.compareTo(denne.hentInnhold()) <= 0) {
                break;
            }
        }
    */
	}

	public void innstikksorter(){

	}

}







