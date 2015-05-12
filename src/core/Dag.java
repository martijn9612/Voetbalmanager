package core;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import application.Main;

/**\
 * Klasse "Dag"
 * @author Thomas Oomens, Saul van der Vies
 * Deze klasse definiëert een speeldag
 */
public class Dag {
	
	/**
	 * Attributen voor klasse "Dag"
	 * int tDag								De huidige dag
	 * ArrayList<Wedstrijd> tWedstrijden	Een arraylist met alle wedstrijden voor die dag
	 */
	protected int tDag;
	protected ArrayList<Wedstrijd> tWedstrijden = new ArrayList<Wedstrijd>();
	
	/**
	 * Constructor "Dag"
	 * De constructor voor deze klasse
	 * @param dag	De huidige dag
	 */
	public Dag(int dag) {
		tDag = dag;
	}
	
	/**
	 * Methode "getDag"
	 * Geeft de huidige dag
	 * @return 	De dag
	 */
	public int getDag(){
		return tDag;
	}
	
	/**
	 * Methode "addMatch"
	 * Voegt een wedstrijd tussen twee teams toe aan de speeldag
	 * @param team1
	 * @param team2
	 */
	public void addMatch(Team team1, Team team2) {
		Wedstrijd wedstrijd = new Wedstrijd(team1, team2, "normaal");
		team1.addWedstrijd(wedstrijd);
		team2.addWedstrijd(wedstrijd);
		tWedstrijden.add(wedstrijd);
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de dag
	 * @return	De Stringrepresentatie
	 */
	public String toString() {
		String result = "Dag "+ tDag +":\n";
		for(Wedstrijd wedstrijd: tWedstrijden) {
			result += wedstrijd.toString();
		}
		return result;
	}
	
	/**
	 * Methode "getWedstrijden"
	 * Geeft de arraylist met wedstrijden die bij de speeldag horen
	 * @return	De ArrayList
	 */
	public ArrayList<Wedstrijd> getWedstrijden() {
		return tWedstrijden;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van het team
	 * @return	De Xmlrepresentatie
	 */
	public String toXml() {
		String xml = "<dag>";
		
		xml += "<dagnr>"+ tDag +"</dagnr>";
		
		xml += "<wedstrijden>";
		for (Wedstrijd wedstrijd: tWedstrijden) {
			xml += wedstrijd.toXml();
		}
		xml += "</wedstrijden>";
		xml += "</dag>";
		
		return xml;
	}

	/**
	 * Methode "readXml"
	 * Methode voor het lezen van het Xml bestand
	 * @param node	De node voor het inlezen
	 */
	public void readXml(Node node) {
		Element eElement = (Element) node;
		
		NodeList wedstrijden = eElement.getElementsByTagName("wedstrijd");
		Wedstrijd wedstrijd;
		for (int temp = 0; temp < wedstrijden.getLength(); temp++) {
			Node n = wedstrijden.item(temp);
			wedstrijd = Wedstrijd.readXml(n);
			tWedstrijden.add(wedstrijd);
		}
	}
}
