package core;

/**
 * Klasse "Log"
 * Deze klasse definiëert een log object
 * @author Thomas Oomens, Saul van der Vies
 *
 */
public class Log {
	
	/**
	 * Attributen voor klasse "Log"
	 * int tMinuut			De Minuut
	 * String tBericht		Het Bericht
	 * String tType			Het Type
	 * boolean tVerlenging	Verlenging (ja/nee)
	 */
	protected int tMinuut;
	protected String tBericht;
	protected String tType;	
	protected boolean tVerlenging;	
	
	/**
	 * Contructor "Log"
	 * De constructor voor deze klasse
	 * @param minuut		De Minuut
	 * @param bericht		Het Bericht
	 * @param type			The Type
	 * @param verlenging	Verlenging (ja/nee)
	 */
	public Log(int minuut, String bericht, String type, boolean verlenging) {
		tBericht = bericht;
		tType = type;
		tMinuut = minuut;
		tVerlenging = verlenging;
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van een log
	 * @return	De Stringrepresentatie
	 */
	public String toString() {
		String result = "";
		if (tVerlenging) {
			int verlenging = tMinuut%45;
			result += (tMinuut-verlenging) +"+"+ verlenging +": ";
		}
		else {
			result += tMinuut +": ";
		}
		result += tBericht +"\n";
		return result;
	}
	
	/**
	 * Methode "getMinuut"
	 * Geeft de huidige minuut
	 * @return	De Minuut
	 */
	public int getMinuut() {
		return tMinuut;
	}
	
	/**
	 * Methode "getBericht"
	 * Geeft het huidige bericht
	 * @return	Het Bericht
	 */
	public String getBericht() {
		return tBericht;
	}
	
	/**
	 * Methode "getType"
	 * Geeft het type bericht
	 * @return	Het Type
	 */
	public String getType() {
		return tType;
	}
	
	public boolean isVerlenging() {
		return tVerlenging;
	}
}
