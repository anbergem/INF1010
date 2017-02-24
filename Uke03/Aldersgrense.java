public enum Aldersgrense{
	ALLE("Alle"),
	OVER18("Over 18"), 
	OVER20("Over 20");

	private String visual;
	public Aldersgrense(String visual) {
		this.visual = visual;
	}

	public String toString() {
		return visual;
	}
}

//Aldersgrense x = Aldersgrense.ALLE;