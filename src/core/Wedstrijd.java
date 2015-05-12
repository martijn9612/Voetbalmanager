package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import application.CompetitieTabel;
import application.Main;
import application.SpelerTabel;
import application.StatsTabel;

/**
 * Klasse "Wedstrijd"
 * Deze klasse zorgt voor het verloop van een wedstrijd
 * @author Thomas Oomens
 *
 */
public class Wedstrijd {
	
	/**
	 * Attributen voor klasse "Wedstrijd"
	 * Team tTeam1			Team 1
	 * Team tTeam2			Team 2
	 * String tType			Het Type wedstrijd
	 * Random tRand			Een Random getal
	 * ArrayList<Log> tLogs	Het Logbestand
	 * int tScore 1			De Score van Team 1
	 * int tScore 2			De Score van Team 2
	 * int tMoraal			De Moraalwaarde
	 * Messenger tMessenger	De Messenger
	 * boolean tGespeeld	De status van een wedstrijd
	 */
	protected Team tTeam1;
	protected Team tTeam2;
	protected String tType;
	protected Random tRand;
	protected ArrayList<Log> tLogs;
	protected int tScore1;
	protected int tScore2;
	protected int tMoraal;
	protected Messenger tMessenger;
	protected boolean tGespeeld = false;
	protected int tVerlenging1;
	protected int tVerlenging2;
	protected List<StatsTabel> tStatsList = new ArrayList<StatsTabel>();
    protected String[] tStats = { "Balbezit", "Gele kaarten", "Rode kaarten", "Blessures", "Aanvallen", "Doelpunten", "Schoten", "Schoten op doel", "Corners" };
	
	/**
	 * Constructor "Wedstrijd"
	 * De constructor voor deze klasse
	 * @param team1		Team 1
	 * @param team2		Team 2
	 * @param type		Het Type wedstrijd
	 */
	public Wedstrijd(Team team1, Team team2, String type) {
		tTeam1 = team1;
		tTeam2 = team2;
		tType = type;
		tRand = new Random(System.nanoTime());
		tLogs = new ArrayList<Log>();
		tMessenger = Driver.tMessenger;
	}
	
	/**
	 * Methode "setRandom"
	 * Maakt een nieuw random getal aan met een seed
	 * @param seed
	 */
	public void setRandom(long seed) {
		tRand = new Random(seed);
		tMessenger.setRandom(seed);
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de uitkomst van de gespeelde wedstrijd
	 * @return	De Stringrepresentatie
	 */
	public String toString() {
		String result = "Wedstrijd: "+ tTeam1.getTeamnaam() +" - "+ tTeam2.getTeamnaam() +"\n";
		result += "Score: "+ tScore1 +" - "+ tScore2 +"\n";
		result += "Samenvatting: \n";
		for (Log log: tLogs) {
			result += log.toString();
		}		
		return result;
	}
	
	/**
	 * Methode "getLogs"
	 * Geeft de arraylist met logs van de wedstrijd
	 * @return	De ArrayList
	 */
	public ArrayList<Log> getLogs() {
		return tLogs;
	}
	
	public Team getTeam(int nr) {
		if (nr == 1) {
			return tTeam1;
		}
		return tTeam2;
	}

	/**
	 * Methode "toTable"
	 * Geeft een column voor een tabel van de wedstrijd
	 * @return De comlumn
	 */
	public CompetitieTabel toTable(int week) {
		String message = tScore1 +" - "+ tScore2;
		if (!tGespeeld) {
			message = "Wordt gespeeld in week "+ week;
		}
		return new CompetitieTabel(week, tTeam1.getTeamnaam(), tTeam2.getTeamnaam(), message);
	}
	
	/**
	 * Methode "Speel"
	 * Berekent en bekijkt wat er elke minuut gebeurt
	 */
	public void speel() {
		//Verlaag de statusduur met 1
		tTeam1.lowerStatus();
		tTeam2.lowerStatus();
		
		//Laat de teams hun opstelling instellen
		tTeam1.setOpstelling();
		tTeam2.setOpstelling();
		
		//Laat de teams hun aanvals- en verdedigingsscore berekenen
		tTeam1.berekenScores();
		tTeam2.berekenScores();
		
		//Bereken de verlenging: 0 tot 5 minuten
		tVerlenging1 = berekenVerlenging();
		tVerlenging2 = berekenVerlenging();
		
		//Stel de statslist in
		tStatsList.add(new StatsTabel("Teams", tTeam1.getTeamnaam(), tTeam2.getTeamnaam()));
		for (String stat: tStats) {
			tStatsList.add(new StatsTabel(stat, "0", "0"));
		}

		//Speel de eerste helft
		tMoraal = tRand.nextInt(40);
		boolean verlenging = false;
		for (int i=1; i<=45+tVerlenging1; i++) {
			if (i > 45) {
				verlenging = true;
			}
			speelMinuut(i, verlenging);
		}
		
		//Speel de tweede helft
		tMoraal = tRand.nextInt(40);
		verlenging = false;
		for (int i=46; i<=90+tVerlenging2; i++) {
			if (i > 90) {
				verlenging = true;
			}
			speelMinuut(i, verlenging);
		}
		
		//kent punten toe aan de hand van het resultaat
		tTeam1.setScore(tScore1, tScore2);
		tTeam2.setScore(tScore2, tScore1);
		
		/*
		 *	if (tType == "knockout") {
		 *		Als het om een knockout wedstrijd gaat, dient er extra te worden gespeeld
		 * 		Kan toegevoegd worden
		 *	}
		 */		
		
		tGespeeld = true;

		//Zet de status terug naar groen van spelers die een statusduur van 0 hebben
		tTeam1.removeStatus();
		tTeam2.removeStatus();
		
		//Zet het balbezit om in percentages

		int id = Arrays.asList(tStats).indexOf("Balbezit");
		int total = Integer.parseInt(tStatsList.get((id+1)).getTeam1()) + Integer.parseInt(tStatsList.get((id+1)).getTeam2());
		
		double team1 = (100.0 / total) * Integer.parseInt(tStatsList.get(id+1).getTeam1());
		
		tStatsList.get(id+1).setTeam1(Double.toString(((double)Math.ceil(team1*10))/10));
		tStatsList.get(id+1).setTeam2(Double.toString(((double)Math.floor((100 - team1)*10))/10));
	}
	
	public int getVerlenging1() {
		return tVerlenging1;
	}
	
	public int getVerlenging2() {
		return tVerlenging2;
	}
	
	/**
	 * Methode "berekenVerlenging"
	 * Berekent hoeveel minuten de verlenging bedraagt
	 * @return	Het aantal minuten verlenging
	 */
	public int berekenVerlenging() {
		int random = tRand.nextInt(20);
		int verlenging = 0;
		//De key geeft het aantal minuten aan, de value de kans van de value/20 dat dit aantal minuten gekozen wordt
		int[] verdeling = {1, 3, 6, 6, 3, 1};
		int low = 0;
		//Zoek welke hoeveelheid minuten hoort bij het random getal 'random'
		for (int i=0; i<6; i++) {
			if (random >= low && random < low+verdeling[i]) {
				verlenging = i;
				break;
			}
			low += verdeling[i];
		}
			
		return verlenging;
	}
	
	/**
	 * Methode "speelMinuut"
	 * Bekijkt en berekent wat er in een minuut gebeurt
	 * @param tijd			De Speelminuut
	 * @param verlenging	Verlengingsminuut (ja/nee)
	 */
	public void speelMinuut(int tijd, boolean verlenging) {
		//Decide which team gets to attack
		Team aanvaller;
		Team verdediger;
		int kansAanval = 5000;
		int kansGoal = 2500;
		int kansKeeper = 2500;
		int kansCorner = 250; //Kans is (kansCorner / 10) in procent
		int kansBlessure = 100;
		int kansGeel = 60;
		int kansRood = 100;
		int kansKaartBonus = 2;
		
		
		//Team 1 begint met 80 punten + een getal tussen de 0 en 40 afhankelijk van de moraal verhouding
		int totalTeam1 = (tTeam1.getSpelerScore() * (80 + tMoraal)) / 100;
		//Team 2 begint met 120 punten - het moraal van team 1
		int totalTeam2 = (tTeam2.getSpelerScore() * (120 - tMoraal)) / 100;
		
		int moraal;
		
		//Kijk wie er deze beurt aanvalt
		int statsA;
		int statsB;
		if (tRand.nextInt(totalTeam1 + totalTeam2) < totalTeam1) {
			//Team 1 valt aan
			moraal = 80 + tMoraal;
			aanvaller = tTeam1;
			verdediger = tTeam2;
			statsA = 1;
			statsB = 2;
		}
		else {
			//Team 2 valt aan
			moraal = 120 - tMoraal;
			aanvaller = tTeam2;
			verdediger = tTeam1;
			statsA = 2;
			statsB = 1;
		}
		setStats("Balbezit", statsA, 1);
		
		//Bereken de kans dat er een aanval is
		boolean corner = false;
		boolean goal = false;
		int aanvalScore = (aanvaller.getAanval() * moraal) / 100;
		int verdedigingScore = (aanvaller.getAanval() * (200-moraal)) / 100;
		double scoreMoraal = 1;
		if (Math.abs(tScore1 - tScore2) > 1) {
			if (aanvaller == tTeam1 && (tScore1 - tScore2) > 1) {
				scoreMoraal = 1.0/(tScore1 - tScore2);
				verdedigingScore *= (tScore1 - tScore2);
			}
			else if (aanvaller == tTeam2 && (tScore2 - tScore1) > 1) {
				scoreMoraal = 1.0/(tScore2 - tScore1);
				verdedigingScore *= (tScore2 - tScore1);
			}
		}
		if (aanvalScore*scoreMoraal > tRand.nextInt(kansAanval)) {
			tMessenger.nieuw();
			Speler speler = getRandomSpeler(aanvaller, "aanvaller");
			tMessenger.aanval(speler);
			String type = "";
			
			boolean success = true;
			
			Team team1 = aanvaller;
			Team team2 = verdediger;
			int bonus = 0;
			for (int i=0; i<2; i++) {
				int kaart = 0;
				boolean blessure = false;
				if ((speler.getAgressieNummer() + bonus * kansKaartBonus) > tRand.nextInt(kansGeel)) {
					if (speler.getStatus().equals("groen")) {
						if (tRand.nextInt(kansRood) <= 1 + bonus * kansKaartBonus) {
							kaart = 3;
							speler.setStatus("rood");
							speler.setStatusduur(1);
						}
						else {
							kaart = 1;
							speler.setStatus("geel");
							speler.setStatusduur(1);
						}
					}
					else if (speler.getStatus().equals("geel")) {
						kaart = 2;
						speler.setStatus("rood");
						speler.setStatusduur(1);
					}				
				}
				if (((1 + kaart * kansKaartBonus + bonus * kansKaartBonus) > tRand.nextInt(kansBlessure))) {
					//Genereert blessure bericht, zet dit in de speler en vervangt de speler
					Speler blessurespeler = getRandomSpeler(team2, "verdediging");
					setBlessure(blessurespeler);
					int statsteam = statsB;
					if (bonus == 1) {
						statsteam = statsA;
					}
					setStats("Blessures", statsteam, 1);
					team2.wisselSpeler(blessurespeler);
					blessure = true;
				}
				if (kaart > 0) {
					//Genereert kaart bericht, zet dit in de speler en vervangt de speler als de kaart rood is
					tMessenger.kaart(speler, kaart);
					int statsteam = statsA;
					if (bonus == 1) {
						statsteam = statsB;
					}
					String statsnaam = "Gele kaarten";
					if (kaart > 1) {
						statsnaam = "Rode kaarten";
					}
					setStats(statsnaam, statsteam, 1);
					team1.wisselSpeler(speler);
					break;
				}
				if (kaart > 0 || blessure) {
					break;
				}
				
				//Nu wordt de for nog een keer gedaan maar dan met de verdediging die de kaart krijgt en de aanvaller die de blessure krijgt
				team1 = verdediger;
				team2 = aanvaller;
				bonus = 1;
				speler = getRandomSpeler(verdediger, "verdediging");
			}
			
			if (success) {
				setStats("Aanvallen", statsA, 1);
				//Er is een aanval, nu wordt er gekeken of de verdediging de bal tegenhoudt
				if (tRand.nextInt(aanvalScore + verdedigingScore) < aanvalScore) {
					setStats("Schoten", statsA, 1);
					speler = getRandomSpeler(verdediger, "verdediger");
					tMessenger.verdediger(speler, true);
					//De aanvaller breekt door de verdediging heen, is het schot op goal?
					if (aanvalScore > tRand.nextInt(kansGoal)) {
						setStats("Schoten op doel", statsA, 1);
						tMessenger.schot(true);
						//Het schot is op goal, Stopt de keeper de bal?
						if (tRand.nextInt(aanvalScore + (verdediger.getKeeper() * kansKeeper * (200 - moraal)) / 10000) < aanvalScore) {
							//Goal! 
							goal = true;
							type = "doelpunt";
						}
						else {
							//De aanvaller schoot succesvol op goal, maar de bal werd geblokkeerd door de keeper. Corner?
							tMessenger.keeper();
							if (tRand.nextInt(1000) < kansCorner) {
								corner = true;
								type = "corner";
							}
						}
					}				
					else {
						//De aanvaller kwam voorbij de verdediging, maar stond buitenspel, schoot paal/lat of naast
						tMessenger.schot(false);
					}
				}
				else {
					speler = getRandomSpeler(verdediger, "verdediger");
					tMessenger.verdediger(speler, false);
					//Er was een aanval, maar deze is afgebroken door een verdediger. Corner?
					if (tRand.nextInt(1000) < kansCorner) {
						corner = true;
					}
				}
				//Als er een corner is
				if (corner) {
					setStats("Corners", statsA, 1);
					corner = false;
					tMessenger.cornerBal();
					speler = getRandomSpeler(aanvaller, "aanvaller");
					if (tRand.nextInt((int) (aanvalScore * 1.2) + verdediger.getKeeper() + verdedigingScore) < aanvalScore) {
						//Goal! 
						goal = true;
						tMessenger.corner(speler, true);
					}
					else {
						tMessenger.corner(speler, false);					
					}
				}
				//Als er gescoord is
				if (goal) {
					goal = false;
					//Todo - Berekenen welke speler de aanval deed + opslaan goal
					if (aanvaller == tTeam1) {
						tScore1++;
					}
					else {
						tScore2++;
					}
					setStats("Doelpunten", statsA, 1);
					tMessenger.goal(aanvaller, tScore1, tScore2);
				}
			}
			tLogs.add(new Log(tijd, tMessenger.getBericht(), type, verlenging));
		}
	}
	
	public Speler getRandomSpeler(Team team, String type) {
		int chance;
		if (type.equals("aanvaller")) {
			chance = tRand.nextInt(team.getAanval());
		}
		else {
			chance = tRand.nextInt(team.getVerdediging());			
		}
		int low = 0;
		String spelernaam = "";
		Speler returnspeler = null;
		for (Speler speler: team.getSpelers()) {
			if (type.equals("aanvaller")) {
				low += speler.getAanval();
			}
			else {
				low += speler.getVerdediging();		
			}
			if (chance < low) {
				returnspeler = speler;
				spelernaam = "("+ team.getTeamnaam() +") "+ speler.getNaam();
				break;
			}
		}
		if (returnspeler == null) {
			returnspeler = team.getSpelers().get(0);
		}
		return returnspeler;
	}
	
	public void setBlessure(Speler speler) {
		String[] blessures = { "gebroken neus", "gebroken enkel", "verrekte kniebanden", "Verliefd op Martijn" };
		String blessure = blessures[tRand.nextInt(blessures.length)];
		int duur = tRand.nextInt(5);
		speler.setStatus(blessure);
		speler.setStatusduur(duur);
		tMessenger.blessure(speler, blessure, duur);
	}
	
	public void setStats(String name, int team, int value) {
		int id = Arrays.asList(tStats).indexOf(name);
		if (id >= 0) {
			if (team == 1) {
				tStatsList.get((id+1)).plusTeam1(value);
			}
			else {
				tStatsList.get((id+1)).plusTeam2(value);			
			}
		}
	}
	
	public List<StatsTabel> getStatsList() {
		return tStatsList;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van het team
	 * @return	De Xmlrepresentatie
	 */
	public String toXml() {
		String xml = "<wedstrijd>";

		xml += "<team1>"+ tTeam1.getTeamnaam() +"</team1>";
		xml += "<team2>"+ tTeam2.getTeamnaam() +"</team2>";
		xml += "<type>"+ tType +"</type>";
		xml += "<score1>" + tScore1 + "</score1>";
		xml += "<score2>" + tScore2 + "</score2>";
		xml += "<moraal>" + tMoraal + "</moraal>";
		xml += "<gespeeld>" + tGespeeld + "</gespeeld>";
		xml += "<verlenging1>" + tVerlenging1 + "</verlenging1>";
		xml += "<verlenging2>" + tVerlenging2 + "</verlenging2>";
		
		xml += "</wedstrijd>";
		
		return xml;
	}
	
	public void setReadStats(int score1, int score2, int moraal, boolean gespeeld, int verlenging1, int verlenging2){
		tScore1 = score1;
		tScore2 = score2;
		tMoraal = moraal;
		tGespeeld = gespeeld;
		tVerlenging1 = verlenging1;
		tVerlenging2 = verlenging2;
	}
	
	static Wedstrijd readXml(Node node) {
		Element eElement = (Element) node;
		
		int score1 = Integer.parseInt(eElement.getElementsByTagName("score1").item(0).getTextContent());
		int score2 = Integer.parseInt(eElement.getElementsByTagName("score2").item(0).getTextContent());
		int moraal = Integer.parseInt(eElement.getElementsByTagName("moraal").item(0).getTextContent());
		int verlenging1 = Integer.parseInt(eElement.getElementsByTagName("verlenging1").item(0).getTextContent());
		int verlenging2 = Integer.parseInt(eElement.getElementsByTagName("verlenging2").item(0).getTextContent());
		boolean gespeeld = Boolean.parseBoolean(eElement.getElementsByTagName("gespeeld").item(0).getTextContent());
		String t1 = eElement.getElementsByTagName("team1").item(0).getTextContent();
		String t2 = eElement.getElementsByTagName("team2").item(0).getTextContent();
		String type = eElement.getElementsByTagName("type").item(0).getTextContent();
		Team team1 = null;
		Team team2 = null;
		
		for (Team team: Driver.tTeams) {
			if (team.getTeamnaam().equals(t1)) {
				team1 = team;
			}
			else if (team.getTeamnaam().equals(t2)) {
				team2 = team;
			}
		}
		Wedstrijd res = new Wedstrijd(team1, team2, type);
		res.setReadStats(score1, score2, moraal, gespeeld, verlenging1, verlenging2);
		team1.addWedstrijd(res);
		team2.addWedstrijd(res);
		return res;
	}
}
