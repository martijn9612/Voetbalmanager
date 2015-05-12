package application;

import core.Team;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BiedingenTabel {

	private final StringProperty huidigTeam;
	private final StringProperty aanbieder;
	private final StringProperty spelernaam;
	private final IntegerProperty spelerprijs;
	private final IntegerProperty bod;
	private final StringProperty status;
	
	public BiedingenTabel() {
		this(null, null, null, 0, 0, null);
	}
	
	public BiedingenTabel(String team1, String team2, String snaam, int p, int b, String stat){
		this.huidigTeam = new SimpleStringProperty(team1);
		this.aanbieder = new SimpleStringProperty(team2);
		this.spelernaam = new SimpleStringProperty(snaam);
		this.spelerprijs = new SimpleIntegerProperty(p);
		this.bod = new SimpleIntegerProperty(b);
		this.status = new SimpleStringProperty(stat);
	}
	
	public String getHuidigTeam() {
	     return huidigTeam.get();
	 }
	 
	 public void setHuidigTeam(String teamnaam) {
	     this.huidigTeam.set(teamnaam);
	 }
	 
	 public StringProperty tNaamProperty() {
	     return huidigTeam;
	 }
	 public String getAanbieder() {
	     return aanbieder.get();
	 }
	 
	 public void setAanbieder(String teamnaam) {
	     this.aanbieder.set(teamnaam);
	 }
	 
	 public StringProperty aanbiederProperty() {
	     return aanbieder;
	 }
	 
	 public String getSpelernaam() {
	     return spelernaam.get();
	 }
	 
	 public void setSpelernaam(String teamnaam) {
	     this.spelernaam.set(teamnaam);
	 }
	 
	 public StringProperty spelernaamProperty() {
	     return spelernaam;
	 }
	 
	 public int getSpelerprijs() {
	     return spelerprijs.get();
	 }
	 
	 public void setSpelerprijs(int sprijs) {
	     this.spelerprijs.set(sprijs);
	 }
	 
	 public IntegerProperty spelerprijsProperty() {
	     return spelerprijs;
	 }
	 
	 public int getBod() {
	     return bod.get();
	 }
	 
	 public void setBod(int bod) {
	     this.bod.set(bod);
	 }
	 
	 public IntegerProperty bodProperty() {
	     return bod;
	 }
	 
	 public String getStatus() {
	     return status.get();
	 }
	 
	 public void setStatus(String stat) {
	     this.status.set(stat);
	 }
	 
	 public StringProperty statusProperty() {
	     return status;
	 }
	 
}

