package application;

import javafx.beans.property.*;

public class StatsTabel {

	private final StringProperty tNaam;
	private final StringProperty tTeam1;
	private final StringProperty tTeam2;
	
	public StatsTabel(){
		this(null, null, null);
	}
	
	public StatsTabel(String naam, String team1, String team2){
		this.tNaam = new SimpleStringProperty(naam);
		this.tTeam1 = new SimpleStringProperty(team1);
		this.tTeam2 = new SimpleStringProperty(team2);
	}
	
	public void plusTeam1(int value) {
		tTeam1.set(Integer.toString(Integer.parseInt(tTeam1.getValue()) + value));
	}
	
	public void plusTeam2(int value) {
		tTeam2.set(Integer.toString(Integer.parseInt(tTeam2.getValue()) + value));
	}
	
	public String getNaam() {
	    return tNaam.get();
	}
	
	public void setNaam(String message) {
	    this.tNaam.set(message);
	}
	
	public StringProperty tNaamProperty() {
	    return tNaam;
	}
	
	public String getTeam1() {
	    return tTeam1.get();
	}
	
	public void setTeam1(String team1) {
	    this.tTeam1.set(team1);
	}
	
	public StringProperty tTeam1Property() {
	    return tTeam1;
	}
	
	public String getTeam2() {
	    return tTeam2.get();
	}
	
	public void setTeam2(String team2) {
	    this.tTeam2.set(team2);
	}
	
	public StringProperty tTeam2Property() {
	    return tTeam2;
	}
	 
}
