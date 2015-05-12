package core;
import java.text.NumberFormat;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import application.SpelerTabel;

/**
 * Abstracte Klasse "Veldspeler"
 * Deze klasse heeft superklasse "Speler" en heeft subklassen "Aanvaller", "Middenvelder" en "Verdediger"
 * Deze klasse vormt de basis voor zijn subklassen
 * @author Thomas Oomens, Saul van der Vies
 *
 */
abstract class VeldSpeler extends Speler {
	
	/**
	 * Attributen voor klasse "Veldspeler"
	 * int tAanval		De Aanvalswaarde
	 * int tVerdediging	De Verdedigingswaarde
	 * int tConditie	De Conditie
	 */
	protected int tAanval;
	protected int tVerdediging;
	protected int tConditie;	
	
	/**
	 * Constructor "Veldspeler"
	 * De constructor voor deze klasse
	 */
	public VeldSpeler() {
		super();
	}
	
	/**
	 * Methode "getAanval"
	 * Geeft de aanvalswaarde van een veldspeler en verhoogt of verlaagt deze afhangend van diens positie
	 * @return	De Aanvalswaarde
	 */
	public int getAanval() {
		int aanval = tAanval;
		if ((tPositie == "bank" || tPositie.equals("spel")) || (!(tStatus.equals("groen") || tStatus.equals("geel")))) {
			aanval = 0;
		}
		else if (tPositie == "aanval") {
			aanval *= 2;
		}
		return aanval;
	}
	
	/**
	 * Methode "getVerdediging"
	 * Geeft de verdedigingswaarde van een veldspeler en verhoogt of verlaagt deze afhangend van diens positie
	 * @return	De Verdedigingswaarde
	 */
	public int getVerdediging() {
		int verdediging = tVerdediging;
		if (tPositie == "bank") {
			verdediging = 0;
		}
		else if (tPositie == "verdediging") {
			verdediging *= 2;
		}
		return verdediging;
	}
	
	/**
	 * Methode "getConditie"
	 * Geeft de conditie van een veldspeler
	 * @return	De Conditie
	 */
	public int getConditie() {
		return tConditie;
	}
	
	/**
	 * Methode "setAanval"
	 * Stelt de aanvalswaarde van een veldspeler in
	 * @param aanval	De Aanvaslwaarde
	 */
	public void setAanval(int aanval) {
		tAanval = aanval;
	}
	
	/**
	 * Methode "setVerdediging"
	 * Stelt de verdedigingswaarde van een veldspeler in
	 * @param verdediging	De Verdedigingswaarde
	 */
	public void setVerdediging(int verdediging) {
		tVerdediging = verdediging;
	}
	
	/**
	 * Methode "setConditie"
	 * Stelt de conditie van een veldspeler in
	 * @param conditie	De Conditie
	 */
	public void setConditie(int conditie) {
		tConditie = conditie;
	}
	
	/**
	 * Methode "readXml"
	 * Methode voor het lezen van het Xml bestand
	 * @param node	De node voor het inlezen
	 */
	public void readXml(Node node) {
		super.readXml(node);
		Element eElement = (Element)node;
		tAanval = Integer.parseInt(eElement.getElementsByTagName("aanval").item(0).getTextContent());
		tVerdediging = Integer.parseInt(eElement.getElementsByTagName("verdediging").item(0).getTextContent());
		tConditie = Integer.parseInt(eElement.getElementsByTagName("conditie").item(0).getTextContent());
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de veldspeler
	 * @return	De Stringrepresentatie
	 */
	@Override
	public String toString() {
		String result = super.toString();
		result += "Aanvalscore: "+ tAanval +"\nVerdedigingscore: "+ tVerdediging +"\nConditie: "+ tConditie +"\n";
		return result;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van de veldspeler
	 * @return	De Xmlrepresentatie
	 */
	@Override
	public String toXml() {
		String xml = super.toXml();
		xml += "<aanval>"+ tAanval +"</aanval>";
		xml += "<verdediging>"+ tVerdediging +"</verdediging>";
		xml += "<conditie>"+ tConditie +"</conditie>";
		return xml;
	}
	
	/**
	 * Methode "toTable"
	 * Geeft een column voor een tabel van de veldspeler
	 * @return De comlumn
	 */
	public SpelerTabel toTable(String type) {
		return super.toTable(type, tAanval, tVerdediging, tConditie, 0);
	}
}
