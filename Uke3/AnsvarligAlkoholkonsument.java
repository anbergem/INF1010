
public interface AnsvarligAlkoholkonsument{

	public int getAlder();

	public double hentPromille();

	public void drikkAv(Flaske<AlkoholholdigDrikke> alkoholflaske);

	public void sovUtRusen();

}