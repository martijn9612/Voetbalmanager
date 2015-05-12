package application;

import javafx.beans.property.*;

public class CompetitieTabel {

	private final IntegerProperty tWeek;
	private final StringProperty tTeam1;
	private final StringProperty tTeam2;
	private final StringProperty tMessage;
	
	public CompetitieTabel(){
		this(0, null, null, null);
	}
	
	public CompetitieTabel(int week, String team1, String team2, String message){
		this.tWeek = new SimpleIntegerProperty(week);
		this.tTeam1 = new SimpleStringProperty(team1);
		this.tTeam2 = new SimpleStringProperty(team2);
		this.tMessage = new SimpleStringProperty(message);
	}
	
	 public String getWeek() {
	     return tTeam1.get();
	 }

	 public void setWeek(String week) {
	     this.tTeam1.set(week);
	 }

	 public IntegerProperty tWeekProperty() {
	     return tWeek;
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
	
	 public String getMessage() {
	     return tMessage.get();
	 }

	 public void setMessage(String message) {
	     this.tMessage.set(message);
	 }

	 public StringProperty tMessageProperty() {
	     return tMessage;
	 }
	 
}
