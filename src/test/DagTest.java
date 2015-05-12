package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import core.Dag;
import core.Keeper;
import core.Team;
import core.Wedstrijd;

public class DagTest {
	Dag dag = new Dag(1);
	Team team1 = new Team();
	Team team2 = new Team();
	Team team3 = new Team();
	
	@Test
	public void testDag() {
		assertTrue(dag.getDag() == 1);
		assertFalse(dag.getDag() == 2);
	}

	@Test
	public void testAddMatch() {
		dag.addMatch(team1, team2);
		
		assertTrue(dag.getWedstrijden().size() == 1);
		assertFalse(dag.getWedstrijden().size() == 0);
	}

	@Test
	public void testToString() {
		dag.addMatch(team1, team2);
		assertEquals("Dag 1:\nWedstrijd: null - null\nScore: 0 - 0\nSamenvatting: \n", dag.toString());
	}

	@Test
	public void testGetWedstrijden() {
		dag.addMatch(team1, team2);
		Dag dag2 = new Dag(1); 
		Dag dag3 = new Dag(1);
		dag2.addMatch(team1, team2);
		team3.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		dag3.addMatch(team1, team3);
		
		assertTrue(dag.getWedstrijden().toString().equals(dag2.getWedstrijden().toString()));
		assertFalse(dag.getWedstrijden().toString().equals(dag3.getWedstrijden().toString()));
	}
}
