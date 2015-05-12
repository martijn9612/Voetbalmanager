package core;
import java.text.NumberFormat;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import application.SpelerTabel;

/**
 * Abstracte Klasse "Speler"
 * Deze klasse heeft subklassen "VeldSpeler" en "Keeper"
 * Deze klasse vormt de basis voor zijn subklassen
 * @author Thomas Oomens, Saul van der Vies
 *
 */
public abstract class Speler {
	
	/**
	 * Attributen voor klasse "Speler"
	 * String tNaam			De Naam
	 * String tStatus		De Status
	 * String tAgressie		De Agressiewaarde
	 * String tLand			Het Land van herkomst
	 * String tPositie		De Positie
	 * int tLeeftijd		De Leeftijd
	 * int tPrijs			De Prijs
	 * int tLocatie			De locatie van de speler op het veld (aangegeven met nummertje). 1 tot 11 is opgesteld, en 99 is op de bank. 
	 */
	protected String tNaam;
	protected String tStatus;
	protected String tAgressie;
	protected String tLand;
	protected String tPositie = "bank";
	protected int tStatusduur;
	protected int tLeeftijd;
	protected int tPrijs;
	protected int tLocatie;
	
	/**
	 * Constructor "Speler"
	 * De constructor voor deze klasse
	 */
	public Speler() {
	}
	
	/**
	 * Abstracte Methodes "getAanval" en "getVerdediging"
	 */
	abstract int getAanval();
	abstract int getVerdediging();
	
	/**
	 * Methode "setLocatie"
	 * Stelt locatie van de speler op het veld in, aangegeven met een nummer.
	 * @param locatie
	 */
	public void setLocatie(int locatie) {
		tLocatie = locatie;
	}
	
	/**
	 * Methode "getLocatie"
	 * Geeft locatie van de speler op het veld terug, aangegeven met een nummer.
	 * @param locatie
	 */
	public int getLocatie() {
		return tLocatie;
	}	
	
	/**
	 * Methode "setStats"
	 * Stelt de naam, status, agressie, land van herkomst, positie, leeftijd en prijs van een speler in
	 * @param naam
	 * @param status
	 * @param agressie
	 * @param land
	 * @param positie
	 * @param leeftijd
	 * @param prijs
	 */
	public void setStats(String naam, String status, String agressie, String land, String positie, int leeftijd, int prijs, int locatie) {
		tNaam = naam;
		tStatus = status;
		tAgressie = agressie;
		tLand = land;
		tPositie = positie;
		tLeeftijd = leeftijd;
		tPrijs = prijs;
		tLocatie = locatie;
	}
	
	/**
	 * Methode "getNaam"
	 * Geeft de naam van de speler
	 * @return	De Naam
	 */
	public String getNaam() {
		return tNaam;
	}
	
	/**
	 * Methode "getStatus"
	 * Geeft de status van de speler
	 * @return De Status
	 */
	public String getStatus() {
		return tStatus;
	}
	
	/** 
	 * Methode "getPositie"
	 * Geeft de positie van de speler
	 * @return De Positie
	 */
	public String getPositie() {
		return tPositie;
	}
	
	/**
	 * Methode "getAgressie"
	 * Geeft het agressieniveau van de speler
	 * @return	Het agressieniveau
	 */
	public String getAgressie() {
		return tAgressie;
	}
	
	/**
	 * Methode "getAgressieNumber"
	 * Geeft een indicatie vor de agressie aan de hand van het agressieniveau
	 * @return	Het agressienummer
	 */
	public int getAgressieNummer() {
		int res = 0;
		if (this.getAgressie().equals("laag")){
			res = 1;
		}
		else if (this.getAgressie().equals("gemiddeld")){
			res = 3;
		}
		else {
			res = 5;
		}
		return res;
	}
	
	/**
	 * Methode "setPositie"
	 * Stelt de positie van de speler in 
	 */
	public void setPositie(String positie) {
		tPositie = positie;
	}
	
	public void setStatus(String status) {
		tStatus = status;
	}
	
	public void setStatusduur(int statusduur) {
		tStatusduur = statusduur;
	}
	
	public int getStatusduur() {
		return tStatusduur; 
	}
	
	public int getPrijs() {
		return tPrijs;
	}
		
	/**
	 * Methode "readXml"
	 * Methode voor het lezen van het Xml bestand 
	 * @param node	De node voor het inlezen
	 */
	public void readXml(Node node) {
		Element eElement = (Element) node;
		tNaam = eElement.getElementsByTagName("naam").item(0).getTextContent();
		tStatus = eElement.getElementsByTagName("status").item(0).getTextContent();
		tAgressie = eElement.getElementsByTagName("agressie").item(0).getTextContent();
		tLand = eElement.getElementsByTagName("land").item(0).getTextContent();
		tPositie = eElement.getElementsByTagName("positie").item(0).getTextContent();
		tStatusduur = Integer.parseInt(eElement.getElementsByTagName("statusduur").item(0).getTextContent());
		tLeeftijd = Integer.parseInt(eElement.getElementsByTagName("leeftijd").item(0).getTextContent());
		tPrijs = Integer.parseInt(eElement.getElementsByTagName("prijs").item(0).getTextContent());
		tLocatie = Integer.parseInt(eElement.getElementsByTagName("locatie").item(0).getTextContent());
	}
	
	/**
	 * Methode "toString"
	 * Geeft een Stringrepresentatie van de speler
	 * @return	De Stringrepresentatie
	 */
	@Override
	public String toString() {
		String result = "Naam: "+ tNaam +"\n";
		result += "Status: "+ tStatus +"\n";
		result += "Agressie: "+ tAgressie +"\n";
		result += "Land: "+ tLand +"\n";
		result += "Leeftijd: "+ tLeeftijd +"\n";
		result += "Prijs: "+ tPrijs +"\n"; 
		result += "Positie: "+ tPositie +"\n"; 
		if (tLocatie >= 1 || tLocatie <= 11 ) {
			result += "Locatie op veld: " + tLocatie + "\n"; 
		}
		return result;
	}
	
	/**
	 * Methode "toXml"
	 * Geeft een Xmlrepresentatie van de speler
	 * @return	De Xmlrepresentatie
	 */
	public String toXml() {
		String xml = "<naam>"+ tNaam +"</naam>";
		xml += "<status>"+ tStatus +"</status>";
		xml += "<agressie>"+ tAgressie +"</agressie>";
		xml += "<land>"+ tLand +"</land>";
		xml += "<positie>" + tPositie + "</positie>";
		xml += "<statusduur>" + tStatusduur + "</statusduur>";
		xml += "<leeftijd>"+ tLeeftijd +"</leeftijd>";
		xml += "<prijs>"+ tPrijs +"</prijs>";
		xml += "<locatie>"+ tLocatie +"</locatie>";
		return xml;
	}
	
	/**
	 * Methode "toTable"
	 * Geeft een column voor een tabel van de speler
	 * @return De comlumn
	 */
	public SpelerTabel toTable(String type, int aanval, int verdediging, int conditie, int keeper) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		formatter.setMaximumFractionDigits(0);
		String status = tStatus;
		if (tStatusduur > 0) {
			status += " ("+ tStatusduur +")";
		}
		return new SpelerTabel(tNaam, status, tAgressie, tLand, tPositie, type, tLeeftijd, formatter.format(tPrijs), aanval, verdediging, conditie, keeper);
	}
	
	/**
	 * Methode "toTable"
	 * Deze methode zorgt er voor dat er niets wordt teruggegeven als men probeert een column voor een tabel toe te voegen zonder de juiste argumenten
	 * @return De comlumn
	 */
	public SpelerTabel toTable() {
		return null;
	}
}
