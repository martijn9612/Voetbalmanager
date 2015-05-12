package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import application.Main;

/**
 * Klasse "Competitie"
 * Deze klasse definiëert een competitie
 * @author Thomas Oomens
 * 
 */
public class Competitie {
	

	protected Random tRand;
	
	/**
	 * Attributen voor klasse "Competitie"
	 * ArrayList<Dag> tSpeeldagen	Een ArrayList met speeldagen
	 * int tRonde					Het nummer van de huidige ronde
	 */
	protected ArrayList<Dag> tSpeeldagen = new ArrayList<Dag>();
	protected int tRonde = 0;
	
	
	public void build(ArrayList<Team> teams) {
		buildCompetitie(teams, 0);
		buildCompetitie(teams, 17);		
	}
	
	/**
	 * Methode "buildCompetitie"
	 * @param teams
	 * @param start
	 */
	public void buildCompetitie(ArrayList<Team> teams, int start) {
		long seed = System.nanoTime();
		Collections.shuffle(teams, new Random(seed));
		Collections.shuffle(teams, new Random(seed));
		Random rand = new Random(seed);
		Team main = teams.get(0);
		ArrayList<Team> teams2 = new ArrayList<Team>();
		for (int i=1; i<18; i++) {
			teams2.add(teams.get(i));
		}
		for (int i=start; i<(17+start); i++) {
			tSpeeldagen.add(new Dag(i));
			createMatch(i, main, teams2.get(0));
			for (int y=1; y<9; y++) {
				if (rand.nextInt(2) == 0) {
					createMatch(i, teams2.get(y), teams2.get(17-y));
				}
				else {
					createMatch(i, teams2.get(17-y), teams2.get(y));
				}
			}
			
			Collections.rotate(teams2, 1);
		}
	}
	
	/**
	 * Methode "createMatch"
	 * Maakt een wedstrijd aan en voegt deze toe aan een dag
	 * @param dag		De dag
	 * @param team1		Team 1
	 * @param team2		Team 2
	 */
	public void createMatch(int dag, Team team1, Team team2) {
		boolean switchteams = false;
		for (Wedstrijd wedstrijd: team1.getCompetition()) {
			if (wedstrijd.getTeam(1).getTeamnaam().equals(team1.getTeamnaam())
					&& wedstrijd.getTeam(2).getTeamnaam().equals(team2.getTeamnaam())) {
				switchteams = true;
			}
		}
		if (switchteams) {
			tSpeeldagen.get(dag).addMatch(team2, team1);			
		}
		else {
			tSpeeldagen.get(dag).addMatch(team1, team2);
		}
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de competitie
	 * @return	De Stringrepresentatie
	 */
	public String toString() {
		String result = "De competitie: \n";
		for (Dag dag: tSpeeldagen) {
			result += dag.toString();
		}
		return result;
	}
	
	/**
	 * Methode "speel"
	 * Voert alle wedstrijden van een dag uit
	 * @param dag	De dag
	 */
	public void speel(int dag) {
		for (Wedstrijd wedstrijd: tSpeeldagen.get(dag).getWedstrijden()) {
			wedstrijd.speel();
		}
		biedingen();
		Main.driver.save();
	}
	
	public void biedingen() {
		tRand = new Random(System.nanoTime());
		for (Team team: Main.driver.getTeams()) {
			for(Bod bod: team.getBiedingen()) {
				if (!bod.getStatus().equals("in afwachting")){
					bod.setOud(true);
				}
				if (bod.getSpeler().getPrijs() != 0 && bod.getStatus().equals("in afwachting")) {
					if (!team.equals(Main.driver.getPlayerTeam())) {
						if(0 < bod.getBod()) {
							int random = tRand.nextInt((int)((double)bod.getBod() / bod.getSpeler().getPrijs()  * 100));
							if (random > 50) {
								bod.setStatus("geaccepteerd");
								bod.getSpeler().setPositie("bank");
								bod.getHuidigTeam().verwijderSpeler(bod.getSpeler());
								bod.getAanbieder().addSpeler(bod.getSpeler());
								System.out.println("success!");
							}
							else {
								bod.setStatus("afgewezen");
								bod.getAanbieder().addGeld(bod.getBod());
								System.out.println("helaas!");
							}
						}
					}
					else { //speler zit in eigen team
						
					}
				}
			}
		}
	}
	
	/**
	 * Methode "speelRonde"
	 * Voert een spelronde uit
	 * @return	Het nummer van de huidige ronde
	 */
	public int speelRonde() {
		speel(tRonde);
		tRonde++;
		return tRonde - 1;
	}
	
	/**
	 * Methode "getRonde"
	 * Geeft een arraylist met wedstrijden van een ronde
	 * @return	De ArrayList
	 */
	public ArrayList<Wedstrijd> getRonde() {
		return tSpeeldagen.get(tRonde-1).getWedstrijden();
	}
	
	public int getSpeelRonde() {
		return tRonde - 1;
	}
	
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van het team
	 * @return	De Xmlrepresentatie
	 */
	public String toXml() {
		String xml = "<dagen>";
		for (Dag dag: tSpeeldagen) {
			xml += dag.toXml();
		}
		xml += "</dagen>";
		
		return xml;
	}

	/**
	 * Methode "readXml"
	 * Methode voor het lezen van het Xml bestand
	 * @param node	De node voor het inlezen
	 */
	public void readXml(Node node) {
		Element eElement = (Element) node;
		
		NodeList dagen = eElement.getElementsByTagName("dag");
		Dag dag;
		for (int temp = 0; temp < dagen.getLength(); temp++) {
			Node n = dagen.item(temp);
			dag = new Dag(temp);
			dag.readXml(n);
			tSpeeldagen.add(dag);
		}
	}
}
