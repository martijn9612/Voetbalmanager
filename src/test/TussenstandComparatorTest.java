package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.Team;
import core.TussenstandComparator;

public class TussenstandComparatorTest {

	@Test
	public void compareTest() {
		Team team1 = new Team();
		Team team2 = new Team();
		TussenstandComparator comp = new TussenstandComparator();
		
		team1.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		team2.setStats("Feyenoord", "3-4-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		assertEquals(comp.compare(team1, team2), -1);
		
		team1.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		team2.setStats("Feyenoord", "3-4-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		assertEquals(comp.compare(team1, team2), 1);
		
		team1.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		team2.setStats("Feyenoord", "3-4-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		assertEquals(comp.compare(team1, team2), 0);
	}

}
