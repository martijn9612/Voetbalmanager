package core;
import java.text.NumberFormat;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import application.SpelerTabel;

/**
 * Klasse "Keeper"
 * Deze klasse heeft superklasse "Speler"
 * Deze klasse definiëert een keeper
 * @author Thomas Oomens, Saul van der Vies
 *
 */
public class Keeper extends Speler {
	
	/**
	 * Attribuut voor klasse "Keeper"
	 * int tKeeperskills	De Vaardigheidswaarde
	 */
	protected int tKeeperskills;
	
	/**
	 * Constructor "Keeper"
	 * De constructor voor deze klasse
	 */
	public Keeper() {
		super();
	}

	/**
	 * Methode "getKeeperskills"
	 * Geeft de vaardigheidswaarde van de keeper
	 * @return	De Vaardigheidswaarde
	 */
	public int getKeeperskills() {
		if (tPositie == "keeper" && ((tStatus.equals("groen") || tStatus.equals("geel")))) {
			return tKeeperskills;
		}
		return 0;
	}
	
	/**
	 * Methode "setKeeperskills"
	 * Stelt de vaardigheidswaarde van een keeper in
	 * @param keeperskills	De Vaardigheidswaarde
	 */
	public void setKeeperskills(int keeperskills) {
		tKeeperskills = keeperskills;
	}

	/**
	 * Methode "readXml"
	 * Methode voor het lezen van het Xml bestand (via klasse Speler)
	 * @param node	De node voor het inlezen
	 */
	public void readXml(Node node) {
		super.readXml(node);
		Element eElement = (Element) node;
		tKeeperskills = Integer.parseInt(eElement.getElementsByTagName("keeperskills").item(0).getTextContent());
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de keeper
	 * @return	De Stringrepresentatie
	 */
	@Override
	public String toString() {
		String result = "Spelertype: Keeper \n";
		result += super.toString();
		return result;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van de keeper
	 * @return	De Xmlrepresentatie
	 */
	@Override
	public String toXml() {
		String xml = super.toXml();
		xml += "<type>keeper</type>";
		xml += "<keeperskills>"+ tKeeperskills +"</keeperskills>";
		return xml;
	}
	
	/**
	 * Methode "getAanval"
	 * Geeft de aanvalswaarde van de keeper (altijd 0)
	 * @return	De Aanvalswaarde (altijd 0)
	 */
	@Override
	public
	int getAanval() {
		return 0;
	}
	
	/**
	 * Methode "getVerdediging"
	 * Geeft de verdedigingswaarde van de keeper (altijd 0)
	 * @return	De Verdedigingswaarde (altijd 0)
	 */
	@Override
	public
	int getVerdediging() {
		return 0;
	}
	
	/**
	 * Methode "toTable"
	 * Geeft een column voor een tabel van de keeper
	 * @return De comlumn
	 */
	public SpelerTabel toTable() {
		return super.toTable("Keeper", 0, 0, 0, tKeeperskills);
	}
}
