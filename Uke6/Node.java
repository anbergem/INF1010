class Node<T>{

	private Node<T> neste, forrige;
	private T data;

	Node(){
		this(null);
		// this.data = null;
	}

	Node(T data){
		this.data = data;
	}

	public void settNeste(Node<T> neste){
		this.neste = neste;
	}

	public void settForrige(Node<T> forrige){
		this.forrige = forrige;
	}

	public Node<T> hentNeste(){
		return this.neste;
	}

	public Node<T> hentForrige(){
		return this.forrige;
	}

	public T hentData(){
		return this.data;
	}

	public boolean settInnMellom(Node<T> venstre, Node<T> hoyre){
		if (hoyre.hentForrige() == venstre &&
			venstre.hentNeste() == hoyre){
			hoyre.settForrige(this);
			this.settNeste(hoyre);
			this.settForrige(venstre);
			venstre.settNeste(this);
			return true;
		} else{
			return false;
		}
	}

	public T kobleUt(){
		Node<T> venstre = hentForrige();
		Node<T> hoyre = this.neste;
		// this.neste.settForrige(this.forrige)
		this.forrige = null;
		this.neste = null;
		venstre.settNeste(hoyre);
		hoyre.settForrige(venstre);
		return this.data;
	}

}























