package application;

import javafx.beans.property.*;

/**
 * Klasse "TeamTabel"
 * @author Saul
 * Maakt een tabel voor een team
 */
public class TeamTabel {
	
	/**
	 * Attributen voor klasse "TeamTabel"
	 * Integer positie
	 * String teamnaam
	 * Integer gespeeld
	 * Integer doelpunten
	 * Integer tegendoelpunten
	 * Integer punten
	 * Integer wins
	 * Integer losses
	 * Integer gelijk
	 * Integer doelsaldo
	 */
	private final IntegerProperty tPosition;
	private final StringProperty tTeamnaam;
	private final IntegerProperty tGespeeld;
	private final IntegerProperty tDoelpunten;
	private final IntegerProperty tTegendoelpunten;
	private final IntegerProperty tPunten;
	private final IntegerProperty tWins;
	private final IntegerProperty tLosses;
	private final IntegerProperty tGelijk;
	private final IntegerProperty tDoelsaldo;
	
	/**
	 * Constructor 1 voor deze klasse
	 */
	public TeamTabel() {
		this(0, null, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	/**
	 * Constructor 2 voor deze klasse
	 * @param position
	 * @param teamnaam
	 * @param gespeeld
	 * @param doelpunten
	 * @param tegendoelpunten
	 * @param punten
	 * @param wins
	 * @param losses
	 * @param gelijk
	 * @param doels
	 */
	public TeamTabel(int position, String teamnaam, int gespeeld, int doelpunten, int tegendoelpunten, int punten, int wins, int losses, int gelijk, int doels){
		this.tPosition = new SimpleIntegerProperty(position);
		this.tTeamnaam = new SimpleStringProperty(teamnaam);
		this.tGespeeld = new SimpleIntegerProperty(gespeeld);
		this.tDoelpunten = new SimpleIntegerProperty(doelpunten);
		this.tTegendoelpunten = new SimpleIntegerProperty(tegendoelpunten);
		this.tPunten = new SimpleIntegerProperty(punten);
		this.tWins = new SimpleIntegerProperty(wins);
		this.tLosses = new SimpleIntegerProperty(losses);
		this.tGelijk = new SimpleIntegerProperty(gelijk);
		this.tDoelsaldo = new SimpleIntegerProperty((doels));
	}
	
	 /**
	  * Methode "getTeamnaam"
	  * Geeft de naam van een team
	  * @return De naam
	  */
	 public String getTeamnaam() {
	     return tTeamnaam.get();
	 }
	 
	 /**
	  * Methode "setTeamnaam"
	  * Stelt de naam van een team in
	  * @param teamnaam
	  */
	 public void setTeamnaam(String teamnaam) {
	     this.tTeamnaam.set(teamnaam);
	 }
	 
	 /**
	  * Methode "tTeamnaamProperty"
	  * Geeft de StringProperty van de naam van een team
	  * @return De StringProperty van de naam
	  */
	 public StringProperty tTeamnaamProperty() {
	     return tTeamnaam;
	 }
	 
	 /**
	  * Methode "getPosition"
	  * Geeft de positie van een team
	  * @return De positie
	  */
	 public int getPosition() {
	     return tPosition.get();
	 }
	 
	 /**
	  * Methode "setPosition"
	  * Stelt de positie van een team in
	  * @param position
	  */
	 public void setPosition(int position) {
	     this.tPosition.set(position);
	 }
	 
	 /**
	  * Methode "tPositionProperty"
	  * Geeft de IntegerProperty van de positie van een team
	  * @return De IntegerProperty van de positie
	  */
	 public IntegerProperty tPositionProperty() {
	     return tPosition;
	 }
	 
	 /**
	  * Methode "getGespeeld"
	  * Geeft het aantal gespeelde wedstrijden van een team
	  * @return Het aantal gespeelde wedstrijden
	  */
	 public int getGespeeld() {
	     return tGespeeld.get();
	 }
	 
	 /**
	  * Methode "setGespeeld"
	  * Stelt het aantal gespeelde wedstrijden van een team in
	  * @param gespeeld
	  */
	 public void setGespeeld(int gespeeld) {
	     this.tGespeeld.set(gespeeld);
	 }
	 
	 /**
	  * Methode "tGespeeldProperty"
	  * Geeft de IntegerProperty van het aantal gespeelde wedstrijden van een team
	  * @return De IntegerProperty van het aantal gespeelde wedstrijden
	  */
	 public IntegerProperty tGespeeldProperty() {
	     return tGespeeld;
	 }
	 
	 /**
	  * Methode "getDoelpunten"
	  * Geeft het aantal gemaakte doelpunten van een team
	  * @return Het aantal gemaakte doelpunten
	  */
	 public int getDoelpunten() {
	     return tDoelpunten.get();
	 }
	 
	 /**
	  * Methode "setDoelpunten"
	  * Stelt het aantal gemaakte doelpunten van een team in
	  * @param doelpunten
	  */
	 public void setDoelpunten(int doelpunten) {
	     this.tDoelpunten.set(doelpunten);
	 }
	 
	 /**
	  * Methode "tDoelpuntenProperty"
	  * Geeft de IntegerProperty van het aantal gemaakte doelpunten van een team
	  * @return De IntegerProperty van het aantal gemaakte doelpunten
	  */
	 public IntegerProperty tDoelpuntenProperty() {
	     return tDoelpunten;
	 }
	 
	 /**
	  * Methode "getTegendoelpunten"
	  * Geeft het aantal geleden tegendoelpunten van een team
	  * @return Het aantal geleden tegendoelpunten
	  */
	 public int getTegendoelpunten() {
	     return tTegendoelpunten.get();
	 }
	 
	 /**
	  * Methode "setTegendoelpunten"
	  * Stelt het aantal geleden tegendoelpunten van een team in
	  * @param tegendoelpunten
	  */
	 public void setTegendoelpunten(int tegendoelpunten) {
	     this.tTegendoelpunten.set(tegendoelpunten);
	 }
	 
	 /**
	  * Methode "tTegendoelpuntenProperty"
	  * Geeft de IntegerProperty van het aantal geleden tegendoelpunten van een team
	  * @return De IntegerProperty van het aantal geleden tegendoelpunten
	  */
	 public IntegerProperty tTegendoelpuntenProperty() {
	     return tTegendoelpunten;
	 }
	 
	 /**
	  * Methode "getPunten"
	  * Geeft het aantal punten van een team
	  * @return Het aantal punten
	  */
	 public int getPunten() {
	     return tPunten.get();
	 }
	 
	 /**
	  * Methode "setPunten"
	  * Stelt het aantal punten van een team in
	  * @param punten
	  */
	 public void setPunten(int punten) {
	     this.tPunten.set(punten);
	 }
	 
	 /**
	  * Methode "tPuntenProperty"
	  * Geeft de IntegerProperty van het aantal punten van een team
	  * @return De IntegerProperty van het aantal punten
	  */
	 public IntegerProperty tPuntenProperty() {
	     return tPunten;
	 }
	 
	 /**
	  * Methode "getWins"
	  * Geeft het aantal gewonnen wedstrijden van een team
	  * @return Het aantal gewonnen wedstrijden
	  */
	 public int getWins() {
	     return tWins.get();
	 }
	 
	 /**
	  * Methode "setWins"
	  * Stelt het aantal gewonnen wedstrijden van een team in
	  * @param wins
	  */
	 public void setWins(int wins) {
	     this.tWins.set(wins);
	 }
	 
	 /**
	  * Methode "tWinsProperty"
	  * Geeft de IntegerProperty van het aantal gewonnen wedstrijden van een team
	  * @return De IntegerProperty van het aantal gewonnen wedstrijden
	  */
	 public IntegerProperty tWinsProperty() {
	     return tWins;
	 }
	 
	 /**
	  * Methode "getLosses"
	  * Geeft het aantal verloren wedstrijden van een team
	  * @return Het aantal verloren wedstrijden
	  */
	 public int getLosses() {
	     return tLosses.get();
	 }
	 
	 /**
	  * Methode "setLosses"
	  * Stelt het aantal verloren wedstrijden van een team in
	  * @param losses
	  */
	 public void setLosses(int losses) {
	     this.tLosses.set(losses);
	 }
	 
	 /**
	  * Methode "tLossesProperty"
	  * Geeft de IntegerProperty van het aantal verloren wedstrijden van een team
	  * @return De IntegerProperty van het aantal verloren wedstrijden
	  */
	 public IntegerProperty tLossesProperty() {
	     return tLosses;
	 }
	 
	 /**
	  * Methode "getGelijk"
	  * Geeft het aantal gelijk gespeelde wedstrijden van een team
	  * @return Het aantal gelijk gespeelde wedstrijden
	  */
	 public int getGelijk() {
	     return tGelijk.get();
	 }
	 
	 /**
	  * Methode "setGelijk"
	  * Stelt het aantal gelijk gespeelde wedstrijden van een team in
	  * @param gelijk
	  */
	 public void setGelijk(int gelijk) {
	     this.tGelijk.set(gelijk);
	 }
	 
	 /**
	  * Methode "tGelijkProperty"
	  * Geeft de IntegerProperty van het aantal gelijk gespeelde wedstrijden van een team
	  * @return De IntegerProperty van het aantal gelijk gespeelde wedstrijden
	  */
	 public IntegerProperty tGelijkProperty() {
	     return tGelijk;
	 }
	 
	 /**
	  * Methode "getDoelsaldo"
	  * Geeft het doelsaldo van een team
	  * @return Het doelsaldo
	  */
	 public int getDoelsaldo() {
	     return tDoelsaldo.get();
	 }
	 
	 /**
	  * Methode "setDoelsaldo"
	  * Stelt het doelsaldo van een team in
	  * @param doelsaldo
	  */
	 public void setDoelsaldo(int doelsaldo) {
	     this.tDoelsaldo.set(doelsaldo);
	 }
	 
	 /**
	  * Methode "tDoelsaldoProperty"
	  * Geeft de IntegerProperty van het doelsaldo van een team
	  * @return De IntegerProperty van het doelsaldo
	  */
	 public IntegerProperty tDoelsaldoProperty() {
	     return tDoelsaldo;
	 }
}
