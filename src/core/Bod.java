package core;

import application.Biedingen2Tabel;
import application.BiedingenTabel;
import application.TeamTabel;

public class Bod {

	protected Team huidigTeam;
	protected Team aanbieder;
	protected int bod;
	protected Speler speler;
	protected String status;
	protected boolean oud;

	public Bod(Team team1, Team team2, Speler s, int b, String stat) {
		huidigTeam = team1;
		aanbieder = team2;
		bod = b;
		speler = s;
		status = stat;
		oud = false;
	}

	public Team getHuidigTeam() {
		return huidigTeam;
	}

	public Team getAanbieder() {
		return aanbieder;
	}

	public int getBod() {
		return bod;
		
	}

	public Speler getSpeler() {
		return speler;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String stat) {
		status = stat;
	}
	
	public boolean getOud() {
		return oud;
	}
	
	public void setOud(boolean b) {
		oud = b;
	}
	
	public BiedingenTabel toTable(int position) {
		return new BiedingenTabel(huidigTeam.getTeamnaam(), aanbieder.getTeamnaam(), speler.getNaam(), speler.getPrijs(), bod, status);
	}
}
