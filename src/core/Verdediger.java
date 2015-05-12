package core;
import org.w3c.dom.Node;

import application.SpelerTabel;

/**
 * Klasse "Verdediger"
 * Deze klasse heeft superklasse "VeldSpeler"
 * Deze klasse definiëert een verdedigende veldspeler
 * @author Thomas Oomens, Saul van der Vies
 *
 */
public class Verdediger extends VeldSpeler {
	
	/**
	 * Constructor "Verdediger"
	 * De constructor voor deze klasse
	 */
	public Verdediger() {
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
	 * Methode "getVerdediging"
	 * Geeft de verhoogde verdedigingswaarde van de (verdedigende) speler als deze een verdedigende positie heeft 
	 * @return	De Verdedigingspositie
	 */
	@Override
	public int getVerdediging() {
		int verdediging = super.getVerdediging();
		if (tPositie == "verdediging") {
			verdediging *= 1.5;
		}
		return verdediging;
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de (verdedigende) speler
	 * @return	De Stringrepresentatie
	 */
	@Override
	public String toString() {
		String result = "Spelertype: Verdediger \n";
		result += super.toString();
		return result;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van de (verdedigende) speler
	 * @return	De Xmlrepresentatie
	 */
	@Override
	public String toXml() {
		String xml = super.toXml();
		xml += "<type>verdediger</type>";
		return xml;
	}	
	
	/**
	 * Methode "toTable"
	 * Geeft een column voor een tabel van de verdediger
	 * @return De comlumn
	 */
	public SpelerTabel toTable() {
		return super.toTable("Verdediger");
	}
}
