package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import core.Aanvaller;
import core.Keeper;
import core.Middenvelder;
import core.Team;
import core.Verdediger;
import core.Wedstrijd;

public class TeamTest {
	Aanvaller aanvaller = new Aanvaller();
	Verdediger verdediger = new Verdediger();
	Middenvelder middenvelder = new Middenvelder();
	Keeper keeper = new Keeper();
	Team team = new Team();
	
	@Test
	public void testGetSelected() {
		team.setSelected(true);
		assertTrue(team.getSelected());
		
		team.setSelected(false);
		assertFalse(team.getSelected());
	}
	
	@Test
	public void testZoekSpeler() {
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		team.addSpeler(aanvaller);
		
		assertTrue(team.zoekSpeler("Henk").equals(aanvaller));
	}
	
	@Test
	public void testGetOpstelling() {
		team.setOpstelling("testOpstelling");
		assertTrue(team.getOpstelling().equals("testOpstelling"));
		assertFalse(team.getOpstelling().equals("testOpstelling2"));
	}
	
	@Test
	public void testGetCompetition() {
		Team team2 = new Team();
		Wedstrijd wedstrijd1 = new Wedstrijd(team, team2, "normaal");
		Wedstrijd wedstrijd2 = new Wedstrijd(team, team2, "abnormaal");
		ArrayList<Wedstrijd> list1 = new ArrayList<Wedstrijd>();
		ArrayList<Wedstrijd> list2 = new ArrayList<Wedstrijd>();
		list1.add(wedstrijd1);
		list1.add(wedstrijd2);
		list2.add(wedstrijd2);
		team.addWedstrijd(wedstrijd1);
		team.addWedstrijd(wedstrijd2);
		
		assertTrue(team.getCompetition().equals(list1));
		assertFalse(team.getCompetition().equals(list2));
	}
	
	@Test
	public void testGetSpelers() {
		aanvaller.setAanval(20);
		aanvaller.setConditie(15);
		aanvaller.setVerdediging(10);
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setAanval(20);
		verdediger.setConditie(15);
		verdediger.setVerdediging(10);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setAanval(20);
		middenvelder.setConditie(15);
		middenvelder.setVerdediging(10);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		keeper.setKeeperskills(30);
		keeper.setStats("Klaas", "groen", "hoog", "Nederland", "doel", 22, 3000000, 1);
		team.addSpeler(aanvaller);
		team.addSpeler(verdediger);
		team.addSpeler(middenvelder);
		team.addSpeler(keeper);
		
		Team team2 = new Team();
		team2.addSpeler(aanvaller);
		team2.addSpeler(verdediger);
		team2.addSpeler(middenvelder);
		team2.addSpeler(keeper);
		
		Team team3 = new Team();
		team3.addSpeler(aanvaller);
		team3.addSpeler(verdediger);
		team3.addSpeler(middenvelder);
		
		assertTrue(team.getSpelers().equals(team2.getSpelers()));
		assertFalse(team.getSpelers().equals(team3.getSpelers()));
	}
	
	@Test
	public void testGetTeamnaam() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getTeamnaam().equals("Ajax"));
		assertFalse(team.getTeamnaam().equals("Feyenoord"));
	}
	
	@Test
	public void testGetGeld() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getGeld() == 10000000);
		assertFalse(team.getGeld() == 5000000);
		assertEquals(team.getGeld(), 10000000);
	}
	
	
	@Test
	public void testBerekenScoresTrue() {
		aanvaller.setAanval(20);
		aanvaller.setConditie(15);
		aanvaller.setVerdediging(10);
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setAanval(20);
		verdediger.setConditie(15);
		verdediger.setVerdediging(10);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setAanval(20);
		middenvelder.setConditie(15);
		middenvelder.setVerdediging(10);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		keeper.setKeeperskills(30);
		keeper.setStats("Klaas", "groen", "hoog", "Nederland", "doel", 22, 3000000, 1);
		team.addSpeler(aanvaller);
		team.addSpeler(verdediger);
		team.addSpeler(middenvelder);
		team.addSpeler(keeper);
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getSpelerScore() == 1200);
		assertFalse(team.getSpelerScore() == 1000);
		
		team.berekenScores();
		
		assertTrue(team.getSpelerScore() == 165);
		assertFalse(team.getSpelerScore() == 1200);
	}
	
	@Test
	public void testGetAanval() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getAanval() == 500);
		assertFalse(team.getAanval() == 700);
	}
	
	@Test
	public void testGetVerdediging() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getVerdediging() == 700);
		assertFalse(team.getVerdediging() == 500);
	}

	@Test
	public void testGetSpelerScore() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getSpelerScore() == 1200);
		assertFalse(team.getSpelerScore() == 500);
	}
	
	
	@Test
	public void testGetGespeeld() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getGespeeld() == 5);
		assertFalse(team.getGespeeld() == 10);
		assertEquals(team.getGespeeld(), 5);
		
	}
	

	@Test
	public void testGetDoelpunten() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getDoelpunten() == 10);
		assertFalse(team.getDoelpunten() == 5);
	}
	
	
	@Test
	public void testGetTegendoelpunten() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getTegendoelpunten() == 3);
		assertFalse(team.getTegendoelpunten() == 5);
	}
	
	@Test
	public void testGetPunten() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getPunten() == 7);
		assertFalse(team.getPunten() == 5);
	}
	
	
	@Test
	public void testGetWins() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getWins() == 4);
		assertFalse(team.getWins() == 5);
	}
	
	
	@Test
	public void testGetLossesTrue() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getLosses() == 0);
		assertFalse(team.getLosses() == 1);
	}
	
	
	@Test
	public void testGetGelijk() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getGelijk() == 1);
		assertFalse(team.getGelijk() == 5);
	}
	
	@Test
	public void testGetDoelsaldo() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getDoelsaldo() == 7);
		assertFalse(team.getDoelsaldo() == 6);
	}
	
	@Test
	public void testSetScore() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		team.setScore(2, 1);
		assertTrue(team.getPunten() == 10);
		assertTrue(team.getWins() == 5);
		assertTrue(team.getDoelsaldo() == 8);
		assertFalse(team.getPunten() == 7);
		assertFalse(team.getWins() == 4);
		assertFalse(team.getDoelsaldo() == 7);
				
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		team.setScore(2, 2);
		assertTrue(team.getPunten() == 8);
		assertTrue(team.getGelijk() == 2);
		assertTrue(team.getDoelsaldo() == 7);
		assertFalse(team.getPunten() == 7);
		assertFalse(team.getGelijk() == 1);
		assertFalse(team.getDoelsaldo() == 8);
		
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		team.setScore(1, 2);
		assertTrue(team.getPunten() == 7);
		assertTrue(team.getLosses() == 1);
		assertTrue(team.getDoelsaldo() == 6);
		assertFalse(team.getPunten() == 8);
		assertFalse(team.getLosses() == 0);
		assertFalse(team.getDoelsaldo() == 7);
	}


	@Test
	public void testGetKeeper() {
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertTrue(team.getKeeper() == 300);
		assertFalse(team.getKeeper() == 500);
	}
	
	@Test
	public void testToString() {
		aanvaller.setAanval(20);
		aanvaller.setConditie(15);
		aanvaller.setVerdediging(10);
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setAanval(20);
		verdediger.setConditie(15);
		verdediger.setVerdediging(10);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setAanval(20);
		middenvelder.setConditie(15);
		middenvelder.setVerdediging(10);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		keeper.setKeeperskills(30);
		keeper.setStats("Klaas", "groen", "hoog", "Nederland", "doel", 22, 3000000, 1);
		team.addSpeler(aanvaller);
		team.addSpeler(verdediger);
		team.addSpeler(middenvelder);
		team.addSpeler(keeper);
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertEquals("Teamnaam: Ajax\nGeld: 10000000\nSpelers:\n\nSpelertype: Aanvaller \nNaam: Henk\nStatus: groen\nAgressie: hoog\nLand: Nederland\nLeeftijd: 22\nPrijs: 3000000\nPositie: aanval\nLocatie op veld: 5\nAanvalscore: 20\nVerdedigingscore: 10\nConditie: 15\n\nSpelertype: Verdediger \nNaam: Piet\nStatus: groen\nAgressie: hoog\nLand: Nederland\nLeeftijd: 22\nPrijs: 3000000\nPositie: verdediging\nLocatie op veld: 6\nAanvalscore: 20\nVerdedigingscore: 10\nConditie: 15\n\nSpelertype: Middenvelder \nNaam: Jan\nStatus: groen\nAgressie: hoog\nLand: Nederland\nLeeftijd: 22\nPrijs: 3000000\nPositie: middenveld\nLocatie op veld: 7\nAanvalscore: 20\nVerdedigingscore: 10\nConditie: 15\n\nSpelertype: Keeper \nNaam: Klaas\nStatus: groen\nAgressie: hoog\nLand: Nederland\nLeeftijd: 22\nPrijs: 3000000\nPositie: doel\nLocatie op veld: 1\n\n", team.toString());
	}
	
	@Test
	public void testToXml() {
		aanvaller.setAanval(20);
		aanvaller.setConditie(15);
		aanvaller.setVerdediging(10);
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setAanval(20);
		verdediger.setConditie(15);
		verdediger.setVerdediging(10);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setAanval(20);
		middenvelder.setConditie(15);
		middenvelder.setVerdediging(10);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		keeper.setKeeperskills(30);
		keeper.setStats("Klaas", "groen", "hoog", "Nederland", "doel", 22, 3000000, 1);
		team.addSpeler(aanvaller);
		team.addSpeler(verdediger);
		team.addSpeler(middenvelder);
		team.addSpeler(keeper);
		team.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		
		assertEquals("<team><teamnaam>Ajax</teamnaam><opstelling>4-3-3</opstelling><geld>10000000</geld><spelers><speler><naam>Henk</naam><status>groen</status><agressie>hoog</agressie><land>Nederland</land><leeftijd>22</leeftijd><prijs>3000000</prijs><positie>aanval</positie><locatie>5</locatie><aanval>20</aanval><verdediging>10</verdediging><conditie>15</conditie><type>aanvaller</type></speler><speler><naam>Piet</naam><status>groen</status><agressie>hoog</agressie><land>Nederland</land><leeftijd>22</leeftijd><prijs>3000000</prijs><positie>verdediging</positie><locatie>6</locatie><aanval>20</aanval><verdediging>10</verdediging><conditie>15</conditie><type>verdediger</type></speler><speler><naam>Jan</naam><status>groen</status><agressie>hoog</agressie><land>Nederland</land><leeftijd>22</leeftijd><prijs>3000000</prijs><positie>middenveld</positie><locatie>7</locatie><aanval>20</aanval><verdediging>10</verdediging><conditie>15</conditie><type>middenvelder</type></speler><speler><naam>Klaas</naam><status>groen</status><agressie>hoog</agressie><land>Nederland</land><leeftijd>22</leeftijd><prijs>3000000</prijs><positie>doel</positie><locatie>1</locatie><type>keeper</type><keeperskills>30</keeperskills></speler></spelers></team>", team.toXml());
	}
}
