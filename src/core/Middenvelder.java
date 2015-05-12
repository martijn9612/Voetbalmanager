package core;
import java.text.NumberFormat;

import org.w3c.dom.Node;

import application.SpelerTabel;

/**
 * Klasse "Middenvelder"
 * Deze klasse heeft superklasse "VeldSpeler"
 * Deze klasse definiëert een middenveld-spelende veldspeler
 * @author Thomas Oomens, Saul van der Vies
 *
 */
public class Middenvelder extends VeldSpeler {
	
	/**
	 * Constructor "Middenvelder"
	 * De constructor voor deze klasse
	 */
	public Middenvelder() {
		super();
	}
	
	/**
	 * Methode "readXml"
	 * Methode voor het lezen van het Xml bestand (via klasse VeldSpeler)
	 * @param node	De node voor het inlezen
	 */
	public void readXml(Node node) {
		super.readXml(node);
	}
	
	/**
	 * Methode "getAanval"
	 * Geeft de verhoogde aanvalswaarde van de (middenveld-spelende) speler als deze een middenveldspositie heeft 
	 * @return	De Aanvalswaarde
	 */
	@Override
	public int getAanval() {
		int aanval = super.getAanval();
		if (tPositie == "middenveld") {
			aanval *= 1.5;
		}
		return aanval;
	}
	
	/**
	 * Methode "getVerdediging"
	 * Geeft de verhoogde verdedigingswaarde van de (middenveld-spelende) speler als deze een middenveldspositie heeft 
	 * @return	De Verdedigingswaarde
	 */
	@Override
	public int getVerdediging() {
		int verdediging = super.getVerdediging();
		if (tPositie == "middenveld") {
			verdediging *= 1.5;
		}
		return verdediging;
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de (middenveld-spelende) speler
	 * @return	De Stringrepresentatie
	 */
	@Override
	public String toString() {
		String result = "Spelertype: Middenvelder \n";
		result += super.toString();
		return result;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van de (middenveld-spelende) speler
	 * @return	De Xmlrepresentatie
	 */
	@Override
	public String toXml() {
		String xml = super.toXml();
		xml += "<type>middenvelder</type>";
		return xml;
	}
	
	/**
	 * Methode "toTable"
	 * Geeft een column voor een tabel van de middenvelder
	 * @return De comlumn
	 */
	public SpelerTabel toTable() {
		return super.toTable("Middenvelder");
	}
}
