package core;
import java.text.NumberFormat;

import org.w3c.dom.Node;

import application.SpelerTabel;

/**
 * Klasse "Aanvaller"
 * Deze klasse heeft als superklasse "Veldspeler"
 * Deze klasse definiëert een aanvallende veldspeler
 * @author Thomas Oomens, Saul van der Vies
 * 
 */
public class Aanvaller extends VeldSpeler {
	
	/**
	 * Contructor "Aanvaller"
	 * De constructor voor deze klasse
	 */
	public Aanvaller() {
		super();
	}
	
	/**
	 * Methode "readXml"
	 * Methode voor het lezen van de Xml bestand
	 * @param node	De node voor het inlezen
	 */
	public void readXml(Node node) {		
		super.readXml(node);
	}
	
	/**
	 * Methode "getAanval"
	 * Geeft de verhoogde aanvalswaarde van de (aanvallende) speler als deze een aanvalspositie heeft
	 * @return	De Aanvalswaarde
	 */
	@Override
	public int getAanval() {
		int aanval = super.getAanval();
		if (tPositie == "aanval") {
			aanval *= 1.5;
		}
		return aanval;
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de (aanvallende) speler
	 * @return	De Stringrepresentatie
	 */
	@Override
	public String toString() {
		String result = "Spelertype: Aanvaller \n";
		result += super.toString();
		return result;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van de (aanvallende) speler
	 * @return	De Xmlrepresentatie
	 */
	@Override
	public String toXml() {
		String xml = super.toXml();
		xml += "<type>aanvaller</type>";
		return xml;
	}
	
	/**
	 * Methode "toTable"
	 * Geeft een column voor een tabel van de aanvaller
	 * @return De comlumn
	 */
	@Override
	public SpelerTabel toTable() {
		return super.toTable("Aanvaller");
	}
}
