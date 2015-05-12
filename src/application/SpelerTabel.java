package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Klasse "SpelerTabel"
 * @author Saul van der Vies
 * Maakt een tabel voor een speler
 */
public class SpelerTabel {
	
	/**
	 * Attributen voor klasse "SpelerTabel"
	 * String naam
	 * String status
	 * String agressie
	 * String land
	 * String positie
	 * String type
	 * int leeftijd
	 * String prijs
	 * int aanval
	 * int verdediging
	 * int conditie
	 * int keeperskills
	 */
	 private final StringProperty tNaam;
	 private final StringProperty tStatus;
	 private final StringProperty tAgressie;
	 private final StringProperty tLand;
	 private final StringProperty tPositie;
	 private final StringProperty tType;
	 private final IntegerProperty tLeeftijd;
	 private final StringProperty tPrijs;
	 private final IntegerProperty tAanval;
	 private final IntegerProperty tVerdediging;
	 private final IntegerProperty tConditie;
	 private final IntegerProperty tKeeperskills;
	 
	 /**
	  * Constructor 1 voor deze klasse
	  */
	 public SpelerTabel(){
		 this(null, null, null, null, null, null, 0, null, 0, 0, 0, 0);
	 }
	 
	 /**
	  * Constructor 2 voor deze klasse
	  * @param naam
	  * @param status
	  * @param agressie
	  * @param land
	  * @param positie
	  * @param type
	  * @param leeftijd
	  * @param prijs
	  * @param aanval
	  * @param verdediging
	  * @param conditie
	  * @param keeperskills
	  */
	 public SpelerTabel(String naam, String status, String agressie, String land, String positie, String type, int leeftijd, String prijs, int aanval, int verdediging, int conditie, int keeperskills){
		 this.tNaam = new SimpleStringProperty(naam);
		 this.tStatus = new SimpleStringProperty(status);
	     this.tAgressie = new SimpleStringProperty(agressie);
	     this.tLand = new SimpleStringProperty(land);
	     this.tPositie = new SimpleStringProperty(positie);
	     this.tType = new SimpleStringProperty(type);
	     this.tLeeftijd = new SimpleIntegerProperty(leeftijd);
	     this.tPrijs = new SimpleStringProperty(prijs);
	     this.tAanval = new SimpleIntegerProperty(aanval);
	     this.tVerdediging = new SimpleIntegerProperty(verdediging);
	     this.tConditie = new SimpleIntegerProperty(conditie);
	     this.tKeeperskills = new SimpleIntegerProperty(keeperskills);
	 }
	 
	 /**
	  * Methode "getNaam"
	  * Geeft de naam van een speler
	  * @return De naam
	  */
	 public String getNaam() {
	     return tNaam.get();
	 }
	 
	 /**
	  * Methode "setNaam"
	  * Stelt de naam van een speler in
	  * @param naam
	  */
	 public void setNaam(String naam) {
	     this.tNaam.set(naam);
	 }
	 
	 /**
	  * Methode "tNaamProperty"
	  * Geeft de StringProperty van de naam van een speler
	  * @return De StringProperty van de naam
	  */
	 public StringProperty tNaamProperty() {
	     return tNaam;
	 }
	 
	 /**
	  * Methode "getStatus"
	  * Geeft de status van een speler
	  * @return De status
	  */
	 public String getStatus() {
	     return tStatus.get();
	 }
	 
	 /**
	  * Methode "setStatus"
	  * Stelt de status van een speler in
	  * @param status
	  */
	 public void setStatus(String status) {
	     this.tStatus.set(status);
	 }
	 
	 /**
	  * Methode "tStatusProperty"
	  * Geeft de StringProperty van de status van een speler
	  * @return De StringProperty van de status
	  */
	 public StringProperty tStatusProperty() {
	     return tStatus;
	 }
	 
	 /**
	  * Methode "getAgressie"
	  * Geeft het agressieniveau van een speler
	  * @return Het agressieniveau
	  */
	 public String getAgressie() {
	     return tAgressie.get();
	 }
	 
	 /**
	  * Methode "setAgressie"
	  * Stelt het agressieniveau van een speler in
	  * @param agressie
	  */
	 public void setAgressie(String agressie) {
	     this.tAgressie.set(agressie);
	 }
	 
	 /**
	  * Methode "tAgressieProperty"
	  * Geeft de StringProperty van het agressieniveau van een speler
	  * @return De StringProperty van het agressieniveau
	  */
	 public StringProperty tAgressieProperty() {
	     return tAgressie;
	 }
	 
	 /**
	  * Methode "getLand"
	  * Geeft het land van herkomst van een speler
	  * @return Het land
	  */
	 public String getLand() {
	     return tLand.get();
	 }
	 
	 /**
	  * Methode "setLand"
	  * Stelt het land van herkomst van een speler in
	  * @param land
	  */
	 public void setLand(String land) {
	     this.tLand.set(land);
	 }
	 
	 /**
	  * Methode "tLandProperty"
	  * Geeft de StringProperty van het land van herkomst van een speler
	  * @return De StringProperty van het land
	  */
	 public StringProperty tLandProperty() {
	     return tLand;
	 }
	 
	 /**
	  * Methode "getPositie"
	  * Geeft de positie van een speler
	  * @return De positie
	  */
	 public String getPositie() {
	     return tPositie.get();
	 }
	 
	 /**
	  * Methode "setPositie"
	  * Stelt de positie van een speler in
	  * @param positie
	  */
	 public void setPositie(String positie) {
	     this.tPositie.set(positie);
	 }
	 
	 /**
	  * Methode "tPositieProperty"
	  * Geeft de StringProperty van de positie van een speler
	  * @return De StringProperty van de positie
	  */
	 public StringProperty tPositieProperty() {
	     return tPositie;
	 }
	 
	 /**
	  * Methode "getType"
	  * Geeft het type van een speler
	  * @return Het type
	  */
	 public String getType() {
	     return tType.get();
	 }
	 
	 /**
	  * Methode "setType"
	  * Stelt het type van een speler in
	  * @param type
	  */
	 public void setType(String type) {
	     this.tType.set(type);
	 }
	 
	 /**
	  * Methode "tTypeProperty"
	  * Geeft de StringProperty van het type van een speler
	  * @return De StringProperty van het type
	  */
	 public StringProperty tTypeProperty() {
	     return tType;
	 }
	 
	 /**
	  * Methode "getLeeftijd"
	  * Geeft de leeftijd van een speler
	  * @return De leeftijd
	  */
	 public int getLeeftijd() {
	     return tLeeftijd.get();
	 }
	 
	 /**
	  * Methode "setLeeftijd"
	  * Stelt de leeftijd van een speler in
	  * @param leeftijd
	  */
	 public void setLeeftijd(int leeftijd) {
	     this.tLeeftijd.set(leeftijd);
	 }
	 
	 /**
	  * Methode "tLeeftijdProperty"
	  * Geeft de IntegerProperty van de leeftijd van een speler
	  * @return De IntegerProperty van de leeftijd
	  */
	 public IntegerProperty tLeeftijdProperty() {
	     return tLeeftijd;
	 }
	 
	 /**
	  * Methode "getPrijs"
	  * Geeft de prijs van een speler
	  * @return De prijs
	  */
	 public String getPrijs() {
	     return tPrijs.get();
	 }
	 
	 /**
	  * Methode "setPrijs"
	  * Stelt de prijs van een speler in
	  * @param prijs
	  */
	 public void setPrijs(String prijs) {
	     this.tPrijs.set(prijs);
	 }
	 
	 /**
	  * Methode "tPrijsProperty"
	  * Geeft de StringProperty van de prijs van een speler
	  * @return De StringProperty van de prijs
	  */
	 public StringProperty tPrijsProperty() {
	     return tPrijs;
	 }
	 
	 /**
	  * Methode "getAanval"
	  * Geeft de aanvalswaarde van een speler
	  * @return De aanvalswaarde
	  */
	 public int getAanval() {
	     return tAanval.get();
	 }
	 
	 /**
	  * Methode "setAanval"
	  * Stelt de aanvalswaarde van een speler in
	  * @param aanval
	  */
	 public void setAanval(int aanval) {
	     this.tAanval.set(aanval);
	 }
	 
	 /**
	  * Methode "tAanvalProperty"
	  * Geeft de IntegerProperty van de aanvalswaarde van een speler
	  * @return De StringProperty van de aanvalswaarde
	  */
	 public IntegerProperty tAanvalProperty() {
	     return tAanval;
	 }
	 
	 /**
	  * Methode "getVerdediging"
	  * Geeft de verdedigingswaarde van een speler
	  * @return De verdedigingswaarde
	  */
	 public int getVerdediging() {
	     return tVerdediging.get();
	 }
	 
	 /**
	  * Methode "setVerdediging"
	  * Stelt de verdedigingswaarde van een speler in
	  * @param verdediging
	  */
	 public void setVerdediging(int verdediging) {
	     this.tVerdediging.set(verdediging);
	 }
	 
	 /**
	  * Methode "tVerdedigingProperty"
	  * Geeft de IntegerProperty van de verdedigingswaarde van een speler
	  * @return De StringProperty van de verdedigingswaarde
	  */
	 public IntegerProperty tVerdedigingProperty() {
	     return tVerdediging;
	 }
	 
	 /**
	  * Methode "getConditie"
	  * Geeft de conditiewaarde van een speler
	  * @return De conditieswaarde
	  */
	 public int getConditie() {
	     return tConditie.get();
	 }
	 
	 /**
	  * Methode "setConditie"
	  * Stelt de conditiewaarde van een speler in
	  * @param conditie
	  */
	 public void setConditie(int conditie) {
	     this.tConditie.set(conditie);
	 }
	 
	 /**
	  * Methode "tConditieProperty"
	  * Geeft de IntegerProperty van de conditiewaarde van een speler
	  * @return De StringProperty van de conditiewaarde
	  */
	 public IntegerProperty tConditieProperty() {
	     return tConditie;
	 }
	 
	 /**
	  * Methode "getKeeperskills"
	  * Geeft de keeperskillswaarde van een speler
	  * @return De keeperskillswaarde
	  */
	 public int getKeeperskills() {
	     return tKeeperskills.get();
	 }
	 
	 /**
	  * Methode "setKeeperskills"
	  * Stelt de keeperskillswaarde van een speler in
	  * @param keeperskills
	  */
	 public void setKeeperskills(int keeperskills) {
	     this.tKeeperskills.set(keeperskills);
	 }
	 
	 /**
	  * Methode "tKeeperskillsProperty"
	  * Geeft de IntegerProperty van de keeperskillswaarde van een speler
	  * @return De StringProperty van de keeperskillswaarde
	  */
	 public IntegerProperty tKeeperskillsProperty() {
	     return tKeeperskills;
	 }
}
