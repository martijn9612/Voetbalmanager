package core;

import java.util.ArrayList;
import java.util.Random;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Klasse "Messenger"
 * Deze klasse zorgt voor het loggen van alles dat er gebeurt
 * @author Thomas Oomens
 *
 */
public class Messenger {
	
	/**
	 * Attributen voor klasse "Messenger"
	 * String tBericht								Een Bericht
	 * Random tRand									Een Random getal
	 * ArrayList<String> tAanvalLogs				De AanvalLogs
	 * ArrayList<String> tVerdedigingLogs			De VerdedigingLogs
	 * ArrayList<String> tVerdedigingMisluktLogs	De VerdedigingMisluktLogs
	 * ArrayList<String> tKeeperLogs				De KeeperLogs
	 * ArrayList<String> tBlessureLogs				De BlessureLogs
	 * ArrayList<String> tKaartLogs					De KaartLogs
	 * ArrayList<String> tSchotLogs					De SchotLogs
	 * ArrayList<String> tSchotMisluktLogs			De SchotMisluktLogs
	 * ArrayList<String> tGoalLogs					De GoalLogs
	 * ArrayList<String> tCornerLogs				De CornerLogs
	 * ArrayList<String> tCornerMisluktLogs			De CornerMisluktLogs
	 * ArrayList<String> tCornerStartLogs			De CornerStartLogs
	 */
	protected String tBericht;
	protected Random tRand;
	protected ArrayList<String> tAanvalLogs = new ArrayList<String>();
	protected ArrayList<String> tVerdedigingLogs = new ArrayList<String>();
	protected ArrayList<String> tVerdedigingMisluktLogs = new ArrayList<String>();
	protected ArrayList<String> tKeeperLogs = new ArrayList<String>();
	protected ArrayList<String> tBlessureLogs = new ArrayList<String>();
	protected ArrayList<String> tKaartGeel1Logs = new ArrayList<String>();
	protected ArrayList<String> tKaartGeel2Logs = new ArrayList<String>();
	protected ArrayList<String> tKaartRoodLogs = new ArrayList<String>();
	protected ArrayList<String> tSchotLogs = new ArrayList<String>();
	protected ArrayList<String> tSchotMisluktLogs = new ArrayList<String>();
	protected ArrayList<String> tGoalLogs = new ArrayList<String>();
	protected ArrayList<String> tCornerLogs = new ArrayList<String>();
	protected ArrayList<String> tCornerMisluktLogs = new ArrayList<String>();
	protected ArrayList<String> tCornerStartLogs = new ArrayList<String>();
	
	/**
	 * Constructor "Messenger"
	 * De constructor vor deze klasse
	 * @param xml	Het Xml Element
	 */
	public Messenger(Element xml) {
		
		//Save the xml to arrays
		setLogs("AanvalLogs", tAanvalLogs, xml); 
		setLogs("VerdedigingLogs", tVerdedigingLogs, xml);
		setLogs("VerdedigingMisluktLogs", tVerdedigingMisluktLogs, xml);
		setLogs("KeeperLogs", tKeeperLogs, xml);
		setLogs("BlessureLogs", tBlessureLogs, xml);
		setLogs("KaartGeel1Logs", tKaartGeel1Logs, xml);
		setLogs("KaartGeel2Logs", tKaartGeel2Logs, xml);
		setLogs("KaartRoodLogs", tKaartRoodLogs, xml);
		setLogs("SchotLogs", tSchotLogs, xml);
		setLogs("SchotMisluktLogs", tSchotMisluktLogs, xml);
		setLogs("GoalLogs", tGoalLogs, xml);
		setLogs("CornerLogs", tCornerLogs, xml);
		setLogs("CornerMisluktLogs", tCornerMisluktLogs, xml);
		setLogs("CornerStartLogs", tCornerStartLogs, xml);
		
		tRand = new Random();
	}
	
	/**
	 * Methode "setRandom"
	 * Maakt een nieuw random getal aan met een seed
	 * @param seed
	 */
	public void setRandom(long seed) {
		tRand = new Random(seed);
	}
	
	
	/**
	 * Methode "setLogs"
	 * Stopt elementen uit de Xml in logs en geeft deze een naam
	 * @param naam	De Tagnaam
	 * @param log	De log
	 * @param xml	Het Element
	 */
	public void setLogs(String naam, ArrayList<String> log, Element xml) {
		Element eElement = (Element) xml.getElementsByTagName(naam).item(0);
		NodeList logList = eElement.getElementsByTagName("log");
		for (int temp = 0; temp < logList.getLength(); temp++) {
			log.add(((Element)logList.item(temp)).getTextContent());
		}
	}
	
	/**
	 * Methode "nieuw"
	 * Haalt het bericht leeg
	 */
	public void nieuw() {
		tBericht = "";
	}
	
	/**
	 * Methode "setBericht"
	 * Vervangt een deel van een bericht in een log
	 * @param replace		De te vervangen String	
	 * @param replaceWith	De te plaatsen String
	 * @param logs			De Log
	 */
	public void setBericht(String replace, String replaceWith, ArrayList<String> logs) {
		int chance = tRand.nextInt(logs.size());
		String[] replaceList = replace.split(";");
		String[] replaceWithList = replaceWith.split(";");
		String bericht = logs.get(chance);
		for (int i=0; i<replaceList.length; i++) {
			 bericht = bericht.replace("%"+ replaceList[i] +"%", replaceWithList[i]);
		}
		tBericht += bericht;
	}
	
	/**
	 * Methode "aanval"
	 * Registreert een bericht over een aanval door een speler
	 * @param team		Het Team dat de aanval doet
	 */
	public void aanval(Speler speler) {
		if (speler != null) {
			setBericht("spelernaam", speler.getNaam(), tAanvalLogs);
		}
	}	
	
	public void kaart(Speler speler, int type){
		if (type == 1){
			setBericht("spelernaam", speler.getNaam(), tKaartGeel1Logs);
		}
		if (type == 2){
			setBericht("spelernaam", speler.getNaam(), tKaartGeel2Logs);
		}
		else {
			setBericht("spelernaam", speler.getNaam(), tKaartRoodLogs);
		}
		
	}
	
	public void blessure(Speler speler, String blessure, int duur){
		setBericht("spelernaam;blessure;duur", speler.getNaam() + ";" + blessure +";"+ duur, tBlessureLogs);
	}
	
	/**
	 * Methode "verdediger"
	 * Registreert een bericht over een verdediging door een speler
	 * @param team		Het Team dat de verdediging doet
	 * @param success	Succes van de verdediging (ja/nee)
	 */
	public void verdediger(Speler speler, boolean success) {
		if (success) {
			setBericht("spelernaam", speler.getNaam(), tVerdedigingLogs);
		}
		else {
			setBericht("spelernaam", speler.getNaam(), tVerdedigingMisluktLogs);		
		}
	}
	
	/**
	 * Methode "getBericht"
	 * Geeft een bericht
	 * @return	Het Bericht
	 */
	public String getBericht() {
		return tBericht;
	}
	
	/**
	 * Methode "goal"
	 * Registreert een goal dat gemaakt wordt
	 * @param team		The Team dat de goal maakt
	 * @param score1	De Score van team 1
	 * @param score2	De Score van team 2 
	 */
	public void goal(Team team, int score1, int score2) {
		setBericht("team;score1;score2", team.getTeamnaam() +";"+ score1 +";"+ score2, tGoalLogs);
	}
	
	/**
	 * Methode "cornerBal"
	 * Registreert een bericht over een corner die gegeven wordt
	 */
	public void cornerBal() {
		setBericht("", "", tCornerStartLogs);			
	}
	
	/**
	 * Methode "corner"
	 * Registreert een bericht over het success van een gegeven corner
	 * @param team		Het Team dat de corner krijgt
	 * @param success	Success van de corner (ja/nee)
	 */
	public void corner(Speler speler, boolean success) {
		if (success) {
			setBericht("spelernaam", speler.getNaam(), tCornerLogs);		
		}
		else {
			setBericht("spelernaam", speler.getNaam(), tCornerMisluktLogs);			
		}
	}
	
	/**
	 * Methode "keeper"
	 * Registreert een bericht over de keeper
	 */
	public void keeper() {
		setBericht("", "", tKeeperLogs);		
	}
	
	/**
	 * Methode "schot"
	 * Registreert een bericht over het success van een schot
	 * @param success	Success van het schot (ja/nee)
	 */
	public void schot(boolean success) {
		if (success) {
			setBericht("", "", tSchotLogs);
		}
		else {
			setBericht("", "", tSchotMisluktLogs);			
		}
	}
}
