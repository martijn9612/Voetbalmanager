package core;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Klasse "Driver"
 * Deze klasse vormt het stuurprogramma van de voetbalmanager
 * @author Thomas Oomens, Saul van der Vies
 *
 */
public class Driver {
	
	/**
	 * Attributen voor klasse "Driver"
	 * ArrayList<Team> tTeams	Een ArrayList met alle teams
	 * Messenger tMessenger		De Messenger
	 */
	protected static ArrayList<Team> tTeams;
	protected static Messenger tMessenger;
	protected Team tTeam;
	protected Competitie tCompetitie;
	protected String tSaveFile = "";
	
	/**
	 * Constructor "Driver"
	 * De constructor voor deze klasse
	 */
	public Driver() {
		tTeams = new ArrayList<Team>();
		load("src/logs.xml");
	}
	
	
	
	/**
	 * Methode "main"
	 * Maakt een driver aan en stelt een nieuwe spel in
	 */
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.setSaveFile("src/saves/savegame4.xml");
		driver.load("src/saves/savegame4.xml");
		//driver.newgame();
		/*
		driver.load("src/saves/newgame.xml");
		for (int i=0; i<1; i++) { 
			driver.wedstrijdTest();
		}*/
		
			
		//System.out.println(driver.toString());
		//driver.save();
	}
	
	/**
	 * Methode "newgame"
	 * Laadt een Xml-file in met de gegevens voor een nieuw spel
	 */
	public void newgame() {
		load("src/newgame.xml");
		tCompetitie = new Competitie();
		tCompetitie.build(tTeams);
		for(Team team: tTeams) {
			team.setOpstelling();
		}
	}
	
	public Competitie getCompetitie() {
		return tCompetitie;
	}
	
	/**
	 * Methode "getTeams()"
	 * Geeft een ArrayList met alle teams
	 * @return De ArrayList
	 */
	public ArrayList<Team> getTeams() {
		return tTeams;
	}
	
	/**
	 * Methode "setTeam"
	 * Stelt een team in om mee te spelen
	 * @param team
	 */
	public void setTeam(Team team) {
		tTeam = team;
		team.setSelected(true);
	}
	
	/**
	 * Methode "getPlayerTeam"
	 * Geeft het huidig geselecteerde team
	 * @return
	 */
	public Team getPlayerTeam() {
		return tTeam;
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de huidige staat van het spel
	 * @return	De Stringrepresentatie
	 */
	public String toString() {
		String result = "De huidige staat van dit spel is: \n\n";
		result += "Tussenstand: -\n\n";
		result += "Teams:\n\n";
		
		for (Team team: tTeams) {
			result += team.toString() + "---------------\n\n";
		}
		
		result += "Info: -\n\n";
		
		return result;
	}
	
	public void setSaveFile(String file) {
		tSaveFile = file;
	}
	
	/**
	 * Methode "load"
	 * Laadt een Xml-bestand in
	 * @param filename  De naam van het te laden Xml-bestand
	 */
	public void load(String bestandsnaam) {
	    try {
			File file = new File(bestandsnaam);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			doc.getDocumentElement().normalize();
			
			//Start xml parsing

			String type = doc.getDocumentElement().getNodeName();
			if (type.equals("game")) {
		    	tTeams = new ArrayList<Team>();
				NodeList teamList = doc.getElementsByTagName("team");
				Team team;
				for (int temp = 0; temp < teamList.getLength(); temp++) {
					Node node = teamList.item(temp);
					team = new Team();
					team.readXml(node);
					tTeams.add(team);
					if (team.getSelected()) {
						tTeam = team;
					}
				}
				
				tCompetitie = new Competitie();
				tCompetitie.readXml(doc.getElementsByTagName("competitie").item(0));
			}
			else if (type.equals("logs")) {
				Driver.tMessenger = new Messenger(doc.getDocumentElement());
			}
			
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	}
	
	/**
	 * Methode "save"
	 * Slaat een Xml-bestand op
	 * @param bestandsnaam	De naam van het op te slaan Xml-bestand
	 */
	public void save() {
	    try {
	    	int count = 1;
	    	String savefile;
	    	boolean found;
    		while (tSaveFile.equals("")) {
    			savefile = "savegame"+ count + ".xml";
		    	final File folder = new File("src/saves");
		    	found = false;
	    	    for (final File fileEntry : folder.listFiles()) {
	    	    	if (savefile.equals(fileEntry.getName())) {
	    	    		found = true;
	    	    		break;
	    	    	}
	    	    }
	    	    if (!found) {
	    	    	tSaveFile = savefile;
	    	    }
	    	    count++;
	    	}
	    	String xml = "<game>";
	    	xml += "<competitie>";
	    	xml += tCompetitie.toXml();
	    	xml += "</competitie>";
	    	
	    	//Start adding the teams
	    	xml += "<teams>";
	    	
	    	for (Team team: tTeams) {
	    		xml += team.toXml();
	    	}
	    	
	    	//All teams are added
	    	xml += "</teams>";
	    	
	    	xml += "</game>";
	    	
	    	PrintWriter out = new PrintWriter("src/saves/"+ tSaveFile);
	    	out.print(xmlFormat(xml));
	    	out.close();
	    	
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	}
	
	/**
	 * Methode "xmlFormat"
	 * Maakt een fatsoenlijk Xml-bestand van een lange xml-streng
	 * @param input
	 * @return output
	 */
	public static String xmlFormat(String input) {
	    try {
	        Source xmlInput = new StreamSource(new StringReader(input));
	        StringWriter stringWriter = new StringWriter();
	        StreamResult xmlOutput = new StreamResult(stringWriter);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        transformerFactory.setAttribute("indent-number", 2);
	        Transformer transformer = transformerFactory.newTransformer(); 
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.transform(xmlInput, xmlOutput);
	        return xmlOutput.getWriter().toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e); // simple exception handling, please review it
	    }
	}
}
