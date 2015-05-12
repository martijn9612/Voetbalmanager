package core;
import java.util.ArrayList;
import java.util.Collections;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import application.SpelerTabel;
import application.TeamTabel;

/**
 * Klasse "Team"
 * Deze klasse definiëert een Team
 * @author Thomas Oomens, Saul van der Vies
 *
 */
public class Team {

	/**
	 * Attributen voor klasse "Team"
	 * ArrayList<Speler> tSpelers			Een arraylist met alle Spelers in het team
	 * ArrayList<Wedstrijd> tWedstrijden	Een arraylist met alle wedstrijden van het team
	 * String tTeamnaam						De Teamnaam
	 * String tOpstelling					De Opstelling
	 * int tGeld							Het budget van het team
	 * int tAanval							De Aanvalswaarde van het team
	 * int tVerdediging						De Verdedigingswaarde van het team
	 * int tKeeper							De waarde van de keeper
	 * int tGespeeld						Het aantal gespeelde wedstrijden
	 * int tDoelpunten						Het aantal gemaakte doelpunten
	 * int tTegendoelpunten					Het aantal geleden tegendoelpunten 
	 * int tPunten							Het aantal behaalde punten
	 * int tWins							Het aantal gewonnen wedstrijden
	 * int tLosses							Het aantal verloren wedstrijden
	 * int tGelijk							Het aantal gelijk gespeelde wedstrijden
	 * int tDoelsaldo						Het doelsaldo
	 */
	protected ArrayList<Speler> tSpelers;
	protected ArrayList<Wedstrijd> tWedstrijden = new ArrayList<Wedstrijd>();
	protected ArrayList<Bod> tBiedingen = new ArrayList<Bod>();
	protected String tTeamnaam;
	protected String tOpstelling;
	boolean tSelected = false;
	protected int tGeld = 0;
	protected int tAanval = 0;
	protected int tVerdediging = 0;	
	protected int tKeeper = 0;
	protected int tGespeeld = 0;
	protected int tDoelpunten = 0;
	protected int tTegendoelpunten = 0;
	protected int tPunten = 0;
	protected int tWins = 0;
	protected int tLosses = 0;
	protected int tGelijk = 0;
	protected int tDoelsaldo = 0;
	
	/**
	 * Constructor "Team"
	 * De constructor voor deze klasse
	 */
	public Team() {
		tSpelers = new ArrayList<Speler>();
	}
	
	/**
	 * Methode "addSpeler"
	 * Voegt een speler toe aan de ArrayList
	 * @param speler
	 */
	public void addSpeler(Speler speler) {
		this.tSpelers.add(speler);
	}
	
	public void addBod(Bod bod) {
		this.tBiedingen.add(bod);
	}
	
	public void verwijderBod(Bod bod) {
		tBiedingen.remove(bod);
	}
	
	/**
	 * Methode "setSelected"
	 * Zet selected op true als dit het team is waarmee de gebruiker speelt
	 */
	public void setSelected(boolean val) {
		tSelected = val;
	}
	
	/**
	 * Methode "getSelected"
	 * Geeft aan of een team geselecteerd is (true/false)
	 * @return boolean (geselecteerd of niet)
	 */
	public boolean getSelected() {
		return tSelected;
	}
	
	/**
	 * Methode "setStats"
	 * Stelt de teamnaam, opstelling, hoeveelheid geld, aanvals-, keepers- en verdedigingswaarde van een team in
	 * @param teamnaam
	 * @param opstelling
	 * @param geld
	 * @param aanval
	 * @param verdediging
	 * @param keeper
	 * @param gespeeld
	 * @param doelpunten
	 * @param tegendoelpunten
	 * @param punten
	 * @param wins
	 * @param losses
	 * @param gelijk
	 * @param doelsaldo
	 */
	public void setStats(String teamnaam, String opstelling, int geld, int aanval, int verdediging, int keeper, int gespeeld, int doelpunten, int tegendoelpunten, int punten, int wins, int losses, int gelijk, int doelsaldo) {
		tTeamnaam = teamnaam;
		tOpstelling = opstelling;
		tGeld = geld;
		tAanval = aanval;
		tVerdediging = verdediging;
		tKeeper = keeper;
		tGespeeld = gespeeld;
		tDoelpunten = doelpunten;
		tTegendoelpunten = tegendoelpunten;
		tPunten = punten;
		tWins = wins;
		tLosses = losses;
		tGelijk = gelijk;
		tDoelsaldo = doelsaldo;
	}
	
	
	/**
	 * Methode "getOpstelling"
	 * Geeft de opstelling
	 * @return De Opstelling
	 */
	public String getOpstelling() {
		return tOpstelling;
	}
	
	/**
	 * Methode "getCompetition"
	 * Geeft een arraylist met de wedstrijden van het team
	 * @return	De ArrayList
	 */
	public ArrayList<Wedstrijd> getCompetition() {
		return tWedstrijden;
	}
	
	/**
	 * Methode "setOpstelling"
	 * Stelt de opstelling van een team in
	 * @param opstelling
	 */
	public void setOpstelling(String opstelling) {
		tOpstelling = opstelling;
	}

	/**
	 * Methode "getSpelers"
	 * Geeft een ArrayList met de spelers uit het team
	 * @return	De Spelers
	 */
	public ArrayList<Speler> getSpelers() {
		return tSpelers;
	}
	
	public ArrayList<Bod> getBiedingen() {
		return tBiedingen;
	}
	
	/**
	 * Methode zoekSpeler
	 * Geeft de Speler met de naam waarop je zoekt terug
	 * @return De speler
	 */
	public Speler zoekSpeler(String naam){
		for(int i = 0; i < tSpelers.size(); i++){
			if(tSpelers.get(i).getNaam().equals(naam)){
				return (Speler) tSpelers.get(i);
			}
		}
		return null;
	}
	
	public void verwijderSpeler(Speler speler) {
		tSpelers.remove(speler);
	}
	
	/**
	 * Methode "getTeamnaam"
	 * Geeft de teamnaam
	 * @return	De Teamnaam
	 */
	public String getTeamnaam() {
		return tTeamnaam;
	}
	
	/**
	 * Methode "getGeld"
	 * Geeft het budget van het team
	 * @return	Het Budget
	 */
	public int getGeld() {
		return tGeld;
	}
	
	/**
	 * Methode "berekenScores"
	 * Berekent de aanvals- en verdedigingswaarde van het team
	 */
	public void berekenScores() {
		tAanval = 0;
		tVerdediging = 0;
		for (Speler speler: tSpelers) {
			tAanval += speler.getAanval();
			tVerdediging += speler.getVerdediging();
			if (speler instanceof Keeper) {
				tKeeper = ((Keeper) speler).getKeeperskills();
			}
		}
	}
	
	/**
	 * Methode "setOpstelling" 
	 * Beslist de opstelling van dat team en welke spelers op welke positie staan
	 */
	public void setOpstelling() {
		if (tSelected) {
			return;
		}
		String[] opstellingen = {"4-3-3","4-5-1","4-4-2","3-2-5","3-3-4","3-4-3", "3-5-2", "4-2-4", "5-2-3"}; 
		ArrayList<Speler> aanvallers = new ArrayList<Speler>();
		ArrayList<Speler> middenvelders = new ArrayList<Speler>();
		ArrayList<Speler> verdedigers = new ArrayList<Speler>();
		ArrayList<Speler> keepers = new ArrayList<Speler>();
		for (Speler speler: tSpelers) {
	    	if (speler.getClass().getName().equals("core.Aanvaller")) {
				speler.setPositie("aanval");
	    		aanvallers.add(speler);
	    	}
	    	else if (speler.getClass().getName().equals("core.Middenvelder")) {
				speler.setPositie("middenveld");
	    		middenvelders.add(speler);	    		
	    	}
	    	else if (speler.getClass().getName().equals("core.Verdediger")) {
				speler.setPositie("verdediger");
	    		verdedigers.add(speler);	    		
	    	}
	    	else {
				speler.setPositie("keeper");
	    		keepers.add(speler);	    		
	    	}
	    	
		}
		Collections.sort(aanvallers, new SpelerComparator());
		Collections.sort(middenvelders, new SpelerComparator());
		Collections.sort(verdedigers, new SpelerComparator());
		Collections.sort(keepers, new SpelerComparator());
		int count;
		int punten = 0;
		int maxPunten = 0;
		String bestOpstelling = "";
		for (String opstelling: opstellingen) {
			punten = 0;
			String[] ops = opstelling.split("-");
			//Aanval
			count = Math.min(Integer.parseInt(ops[2]), aanvallers.size());
			for (int i=0; i<count; i++) {
				punten += aanvallers.get(i).getAanval();
			}
			//Middenveld
			count = Math.min(Integer.parseInt(ops[1]), middenvelders.size());
			for (int i=0; i<count; i++) {
				punten += middenvelders.get(i).getAanval();
				punten += middenvelders.get(i).getVerdediging();
			}
			//Verdediging
			count = Math.min(Integer.parseInt(ops[0]), verdedigers.size());
			for (int i=0; i<count; i++) {
				punten += verdedigers.get(i).getVerdediging();
			}
			
			if (punten > maxPunten) {
				maxPunten = punten;
				bestOpstelling = opstelling;
			}
		}
		
		String[] ops = bestOpstelling.split("-");

		for (Speler speler: tSpelers) {
			speler.setPositie("bank");
		}
		
		//Aanval
		count = Math.min(Integer.parseInt(ops[2]), aanvallers.size());
		for (int i=0; i<count; i++) {
			aanvallers.get(i).setPositie("aanval");
		}
		//Middenveld
		count = Math.min(Integer.parseInt(ops[1]), middenvelders.size());
		for (int i=0; i<count; i++) {
			middenvelders.get(i).setPositie("middenveld");
		}
		//Verdediging
		count = Math.min(Integer.parseInt(ops[0]), verdedigers.size());
		for (int i=0; i<count; i++) {
			verdedigers.get(i).setPositie("verdediging");
		}
		keepers.get(0).setPositie("keeper");
	}
	
	public Speler wisselSpeler(Speler stopSpeler) {
		ArrayList<Speler> spelers = new ArrayList<Speler>();
		for (Speler speler: tSpelers) {
			if (speler.getPositie().equals("bank") && 
					(speler.getStatus().equals("groen") || speler.getStatus().equals("geel")) && 
					speler.getClass().getName().equals(stopSpeler.getClass().getName())) {
				speler.setPositie("spel");
	    		spelers.add(speler);
			}
		}
		Collections.sort(spelers, new SpelerComparator());
		for (Speler speler: spelers) {
			speler.setPositie("bank");			
		}
		stopSpeler.setPositie("bank");
		if (spelers.size() > 0) {
			Speler wisselSpeler = spelers.get(0);
			wisselSpeler.setPositie(stopSpeler.getPositie());
			return wisselSpeler;
		}
		else {
			return stopSpeler;
		}		
	}	
	
	/**
	 * Methode "lowerStatus"
	 * Als een speler een status heeft dan moet deze na een aantal keer verdwijnen
	 * Deze functie verlaagt de statusduur met 1 voor alle spelers die een andere status dan 'groen' hebben
	 */
	public void lowerStatus() {
		for(Speler speler: tSpelers) {
			if (!speler.getStatus().equals("groen")) {
				speler.setStatusduur(speler.getStatusduur() - 1);
			}
		}
	}
	
	/**
	 * Methode "removeStatus"
	 * Als de statusduur van een speler op 0 staat, dient de status terug gezet te worden naar 'groen'
	 */
	public void removeStatus() {
		for (Speler speler: tSpelers) {
			if (speler.getStatusduur() == 0 && !speler.getStatus().equals("groen")) {
				speler.setStatus("groen");
			}
		}
	}
	
	
	/**
	 * Methode "addWedstrijd"
	 * Voegt een wedstrijd toe aan het team
	 * @param wedstrijd
	 */
	public void addWedstrijd(Wedstrijd wedstrijd) {
		tWedstrijden.add(wedstrijd);
	}
	
	/**
	 * Methode "getAanval"
	 * Geeft de aanvalswaarde van het team
	 * @return	De Aanvalswaarde
	 */
	public int getAanval() {
		return tAanval;
	}
	
	/**
	 * Methode "getVerdediging"
	 * Geeft de verdedigingswaarde van het team
	 * @return	De Verdedigingswaarde
	 */
	public int getVerdediging() {
		return tVerdediging;
	}
	
	/**
	 * Methode "getSpelerScore"
	 * Geeft de totale score van een team (Aanvals- en verdedigingswaarde gecombineerd)
	 * @return	De totalre score
	 */
	public int getSpelerScore() {
		return tAanval + tVerdediging;
	}
	
	/**
	 * Methode "getKeeper"
	 * Geeft de waarde van de keeper
	 * @return	De Waarde
	 */
	public int getKeeper() {
		return tKeeper;
	}
	
	/**
	 * Methode "getGespeeld"
	 * Geeft de hoeveelheid gespeelde wedstrijden
	 * @return	De Waarde
	 */
	public int getGespeeld() {
		return tGespeeld;
	}
	
	/**
	 * Methode "getDoelpunten"
	 * Geeft de hoeveelheid gemaakte doelpunten
	 * @return	De Waarde
	 */
	public int getDoelpunten() {
		return tDoelpunten;
	}
	
	/**
	 * Methode "getTegendoelpunten"
	 * Geeft de hoeveelheid geleden tegendoelpunten
	 * @return	De Waarde
	 */
	public int getTegendoelpunten() {
		return tTegendoelpunten;
	}
	
	/**
	 * Methode "getPunten"
	 * Geeft de hoeveelheid behaalde punten
	 * @return	De Waarde
	 */
	public int getPunten() {
		return tPunten;
	}
	
	/**
	 * Methode "getWins"
	 * Geeft de hoeveelheid gewonnen wedstrijden
	 * @return	De Waarde
	 */
	public int getWins() {
		return tWins;
	}
	
	/**
	 * Methode "getLosses"
	 * Geeft de hoeveelheid verloren wedstrijden
	 * @return	De Waarde
	 */
	public int getLosses() {
		return tLosses;
	}
	
	/**
	 * Methode "getGelijk"
	 * Geeft de hoeveelheid gelijk gespeelde wedstrijden
	 * @return	De Waarde
	 */
	public int getGelijk() {
		return tGelijk;
	}
	
	/**
	 * Methode "getDoelsaldo"
	 * Geeft het doelsaldo van het team
	 * @return	Het doelsaldo
	 */
	public int getDoelsaldo() {
		return tDoelsaldo;
	}
	
	/**
	 * Methode "setScore"
	 * Werkt het aantal gespeelde wedstrijden, het aantal gewonnen, verloren of gelijkgespeelde wedstrijden, 
	 * het aantal punten en het doelsaldo van het team bij aan de hand van een hoeveelheid doelpunten en tegendoelpunten.
	 * Werkt de score van het team bij na het gespeeld hebben van en wedstrijd
	 * @param dp	Het aantal doelpunten
	 * @param tdp	Het aantal tegendoelpunten
	 */
	public void setScore(int dp, int tdp) {
		tGespeeld++;
		tDoelpunten += dp;
		tTegendoelpunten += tdp;
		if (dp > tdp) {
			tPunten += 3;
			tWins++;
		}
		else if (dp == tdp) {
			tPunten++;
			tGelijk++;
		}
		else {
			tLosses++;
		}
		tDoelsaldo = tDoelpunten - tTegendoelpunten;
		
	}
	
	public void addGeld(int geld) {
		tGeld += geld;
	}
	
	/**
	 * Methode "toTable"
	 * Geeft een column voor een tabel van het team
	 * @return De comlumn
	 */
	public TeamTabel toTable(int position) {
		return new TeamTabel(position, tTeamnaam, tGespeeld, tDoelpunten, tTegendoelpunten, tPunten, tWins, tLosses, tGelijk, tDoelsaldo);
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van het team
	 * @return	De Stringrepresentatie
	 */
	@Override
	public String toString() {
		String result = "Teamnaam: "+ tTeamnaam +"\nGeld: "+ tGeld +"\nSpelers:\n\n";
		for(Speler speler: tSpelers) {
			result += speler.toString() +"\n";
		}
		return result;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van het team
	 * @return	De Xmlrepresentatie
	 */
	public String toXml() {
		String xml = "<team>";
		xml += "<teamnaam>"+ tTeamnaam +"</teamnaam>";
		xml += "<opstelling>" + tOpstelling + "</opstelling>";
		xml += "<selected>" + tSelected + "</selected>";
		xml += "<geld>"+ tGeld +"</geld>";
		xml += "<aanval>"+ tAanval +"</aanval>";
		xml += "<verdediging>"+ tVerdediging +"</verdediging>";
		xml += "<keeper>"+ tKeeper +"</keeper>";
		xml += "<gespeeld>"+ tGespeeld +"</gespeeld>";
		xml += "<doelpunten>"+ tDoelpunten +"</doelpunten>";
		xml += "<tegendoelpunten>"+ tTegendoelpunten +"</tegendoelpunten>";
		xml += "<punten>"+ tPunten +"</punten>";
		xml += "<wins>"+ tWins +"</wins>";
		xml += "<losses>"+ tLosses +"</losses>";
		xml += "<gelijk>"+ tGelijk +"</gelijk>";
		xml += "<doelsaldo>"+ tDoelsaldo +"</doelsaldo>";
		
		xml += "<spelers>";
		for (Speler speler: tSpelers) {
			xml += "<speler>"+ speler.toXml() +"</speler>";
		}
		xml += "</spelers>";
		
		xml += "<wedstrijden>";
		for (Wedstrijd wedstrijd: tWedstrijden) {
			xml += "<wedstrijd>"+ wedstrijd.toXml() +"</wedstrijd>";
		}
		xml += "</wedstrijden>";
		
		xml += "</team>";
		return xml;
	}
	
	/**
	 * Methode "readXml"
	 * Methode voor het lezen van het Xml bestand
	 * @param node	De node voor het inlezen
	 */
	public void readXml(Node node) {
		Element eElement = (Element) node;
		
		//Stelt de teamnaam in
		tTeamnaam = eElement.getElementsByTagName("teamnaam").item(0).getTextContent();
		tOpstelling = eElement.getElementsByTagName("opstelling").item(0).getTextContent();
		tGeld = Integer.parseInt(eElement.getElementsByTagName("geld").item(0).getTextContent());
		tSelected = Boolean.parseBoolean(eElement.getElementsByTagName("selected").item(0).getTextContent());
		tAanval = Integer.parseInt(eElement.getElementsByTagName("aanval").item(0).getTextContent());
		tVerdediging = Integer.parseInt(eElement.getElementsByTagName("verdediging").item(0).getTextContent());
		tKeeper = Integer.parseInt(eElement.getElementsByTagName("keeper").item(0).getTextContent());
		tGespeeld = Integer.parseInt(eElement.getElementsByTagName("gespeeld").item(0).getTextContent());
		tDoelpunten = Integer.parseInt(eElement.getElementsByTagName("doelpunten").item(0).getTextContent());
		tTegendoelpunten = Integer.parseInt(eElement.getElementsByTagName("tegendoelpunten").item(0).getTextContent());
		tPunten = Integer.parseInt(eElement.getElementsByTagName("punten").item(0).getTextContent());
		tWins = Integer.parseInt(eElement.getElementsByTagName("wins").item(0).getTextContent());
		tLosses = Integer.parseInt(eElement.getElementsByTagName("losses").item(0).getTextContent());
		tGelijk = Integer.parseInt(eElement.getElementsByTagName("gelijk").item(0).getTextContent());
		tDoelsaldo = Integer.parseInt(eElement.getElementsByTagName("doelsaldo").item(0).getTextContent());
		
		//Maakt objecten aan voor alle spelers, lees de gegevens uit met Xml-readers en sla ze op in tSpelers
		NodeList spelerList = eElement.getElementsByTagName("speler");
		for (int temp = 0; temp < spelerList.getLength(); temp++) {
			Node spelerNode = spelerList.item(temp);
			Speler speler = null;
			String type = ((Element)spelerNode).getElementsByTagName("type").item(0).getTextContent();
			switch (type) {
			case "aanvaller":
				speler = new Aanvaller();
				break;
			case "middenvelder":
				speler = new Middenvelder();
				break;
			case "verdediger":
				speler = new Verdediger();
				break;
			case "keeper":
				speler = new Keeper();
				break;
			}
			if (speler != null) {
				speler.readXml(spelerNode);
				tSpelers.add(speler);
			}
		}
	}
}
