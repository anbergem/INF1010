/**
* Dette grensesnittet skal ta vare på et navn
* og du skal kunne hente ut navnet
* @author Andreas Bergem
* @version 1.0 // ikke så viktig
*/
public interface Navnlagrer{
	// String navnet; SKAL IKKE HA MED

	/**
	* Metoden lagrer navnet.
	* Metoden tar parameteret navn
	* og lagrer det i klassen
	* @param navn navnet som skal lagres
	*/
	public void lagreNavn(String navn);

	/**
	* Metoden henter det lagrede navnet.
	* Den sjekker ikke om det er et navn lagret
	* før den returnerer det. 
	* @return det lagrede navnet
	*/
	public String hentNavn();
	
}