package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Aanvaller;
import core.Keeper;
import core.Middenvelder;
import core.Verdediger;

public class SpelerTest {
	Aanvaller aanvaller = new Aanvaller();
	Verdediger verdediger = new Verdediger();
	Middenvelder middenvelder = new Middenvelder();
	Keeper keeper = new Keeper();
	
	@Test
	public void testGetAanval() {
		aanvaller.setAanval(20);
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setAanval(20);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setAanval(20);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		
		keeper.setStats("Klaas", "groen", "hoog", "Nederland", "doel", 22, 3000000, 1);
		
		assertTrue(aanvaller.getAanval() == 60);
		assertFalse(aanvaller.getAanval() == 10);
		assertTrue(verdediger.getAanval() == 20);
		assertFalse(verdediger.getAanval() == 10);
		assertTrue(middenvelder.getAanval() == 30);
		assertFalse(middenvelder.getAanval() == 10);
		assertTrue(keeper.getAanval() == 0);
		assertFalse(keeper.getAanval() == 10);
		
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "bank", 22, 3000000, 5);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "bank", 22, 3000000, 6);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "bank", 22, 3000000, 7);
		assertTrue(aanvaller.getAanval() == 0);
		assertFalse(aanvaller.getAanval() == 10);
		assertTrue(verdediger.getAanval() == 0);
		assertFalse(verdediger.getAanval() == 10);
		assertTrue(middenvelder.getAanval() == 0);
		assertFalse(middenvelder.getAanval() == 10);
	}
	
	@Test
	public void testGetVerdediging() {
		aanvaller.setVerdediging(20);
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setVerdediging(20);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setVerdediging(20);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		
		keeper.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 1);
		
		assertTrue(aanvaller.getVerdediging() == 20);
		assertFalse(aanvaller.getVerdediging() == 10);
		assertTrue(verdediger.getVerdediging() == 60);
		assertFalse(verdediger.getVerdediging() == 10);
		assertTrue(middenvelder.getVerdediging() == 30);
		assertFalse(middenvelder.getVerdediging() == 10);
		assertTrue(keeper.getVerdediging() == 0);
		assertFalse(keeper.getVerdediging() == 10);
		
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "bank", 22, 3000000, 5);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "bank", 22, 3000000, 6);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "bank", 22, 3000000, 7);
		assertTrue(aanvaller.getVerdediging() == 0);
		assertFalse(aanvaller.getVerdediging() == 10);
		assertTrue(verdediger.getVerdediging() == 0);
		assertFalse(verdediger.getVerdediging() == 10);
		assertTrue(middenvelder.getVerdediging() == 0);
		assertFalse(middenvelder.getVerdediging() == 10);
	}
	
	@Test
	public void testGetConditie() {
		aanvaller.setConditie(20);
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setConditie(20);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setConditie(20);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		
		assertTrue(aanvaller.getConditie() == 20);
		assertFalse(aanvaller.getConditie() == 10);
		assertTrue(verdediger.getConditie() == 20);
		assertFalse(verdediger.getConditie() == 10);
		assertTrue(middenvelder.getConditie() == 20);
		assertFalse(middenvelder.getConditie() == 10);
	}
	
	@Test
	public void testGetNaam() {
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setStats("Piet", "groen", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setStats("Jan", "groen", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		keeper.setStats("Klaas", "groen", "hoog", "Nederland", "doel", 22, 3000000, 1);
		
		assertTrue(aanvaller.getNaam().equals("Henk"));
		assertFalse(aanvaller.getNaam().equals("Willem"));
		assertTrue(verdediger.getNaam().equals("Piet"));
		assertFalse(verdediger.getNaam().equals("Willem"));
		assertTrue(middenvelder.getNaam().equals("Jan"));
		assertFalse(middenvelder.getNaam().equals("Willem"));
		assertTrue(keeper.getNaam().equals("Klaas"));
		assertFalse(keeper.getNaam().equals("Willem"));
	}
	
	@Test
	public void testGetStatus() {
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setStats("Piet", "oranje", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setStats("Jan", "rood", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		keeper.setStats("Klaas", "geel", "hoog", "Nederland", "doel", 22, 3000000, 1);
		
		assertTrue(aanvaller.getStatus().equals("groen"));
		assertFalse(aanvaller.getStatus().equals("blauw"));
		assertTrue(verdediger.getStatus().equals("oranje"));
		assertFalse(verdediger.getStatus().equals("blauw"));
		assertTrue(middenvelder.getStatus().equals("rood"));
		assertFalse(middenvelder.getStatus().equals("blauw"));
		assertTrue(keeper.getStatus().equals("geel"));
		assertFalse(keeper.getStatus().equals("blauw"));
	}
	
	@Test
	public void testGetPositie() {
		aanvaller.setStats("Henk", "groen", "hoog", "Nederland", "aanval", 22, 3000000, 5);
		verdediger.setStats("Piet", "oranje", "hoog", "Nederland", "verdediging", 22, 3000000, 6);
		middenvelder.setStats("Jan", "rood", "hoog", "Nederland", "middenveld", 22, 3000000, 7);
		keeper.setStats("Klaas", "geel", "hoog", "Nederland", "doel", 22, 3000000, 1);
		
		assertTrue(aanvaller.getPositie().equals("aanval"));
		assertFalse(aanvaller.getPositie().equals("verdediging"));
		assertTrue(verdediger.getPositie().equals("verdediging"));
		assertFalse(verdediger.getPositie().equals("aanval"));
		assertTrue(middenvelder.getPositie().equals("middenveld"));
		assertFalse(middenvelder.getPositie().equals("doel"));
		assertTrue(keeper.getPositie().equals("doel"));
		assertFalse(keeper.getPositie().equals("middenveld"));
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
		
		assertEquals("Spelertype: Aanvaller \nNaam: Henk\nStatus: groen\nAgressie: hoog\nLand: Nederland\nLeeftijd: 22\nPrijs: 3000000\nPositie: aanval\nAanvalscore: 20\nVerdedigingscore: 10\nConditie: 15\n", aanvaller.toString());
		assertEquals("Spelertype: Verdediger \nNaam: Piet\nStatus: groen\nAgressie: hoog\nLand: Nederland\nLeeftijd: 22\nPrijs: 3000000\nPositie: verdediging\nAanvalscore: 20\nVerdedigingscore: 10\nConditie: 15\n", verdediger.toString());
		assertEquals("Spelertype: Middenvelder \nNaam: Jan\nStatus: groen\nAgressie: hoog\nLand: Nederland\nLeeftijd: 22\nPrijs: 3000000\nPositie: middenveld\nAanvalscore: 20\nVerdedigingscore: 10\nConditie: 15\n", middenvelder.toString());
		assertEquals("Spelertype: Keeper \nNaam: Klaas\nStatus: groen\nAgressie: hoog\nLand: Nederland\nLeeftijd: 22\nPrijs: 3000000\nPositie: doel\n", keeper.toString());
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
		
		assertEquals("<naam>Henk</naam><status>groen</status><agressie>hoog</agressie><land>Nederland</land><leeftijd>22</leeftijd><prijs>3000000</prijs><positie>aanval</positie><aanval>20</aanval><verdediging>10</verdediging><conditie>15</conditie><type>aanvaller</type>", aanvaller.toXml());
		assertEquals("<naam>Piet</naam><status>groen</status><agressie>hoog</agressie><land>Nederland</land><leeftijd>22</leeftijd><prijs>3000000</prijs><positie>verdediging</positie><aanval>20</aanval><verdediging>10</verdediging><conditie>15</conditie><type>verdediger</type>", verdediger.toXml());
		assertEquals("<naam>Jan</naam><status>groen</status><agressie>hoog</agressie><land>Nederland</land><leeftijd>22</leeftijd><prijs>3000000</prijs><positie>middenveld</positie><aanval>20</aanval><verdediging>10</verdediging><conditie>15</conditie><type>middenvelder</type>", middenvelder.toXml());
		assertEquals("<naam>Klaas</naam><status>groen</status><agressie>hoog</agressie><land>Nederland</land><leeftijd>22</leeftijd><prijs>3000000</prijs><positie>doel</positie><type>keeper</type><keeperskills>30</keeperskills>", keeper.toXml());
	}
}
