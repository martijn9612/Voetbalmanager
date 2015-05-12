package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Aanvaller;
import core.Driver;
import core.Keeper;
import core.Middenvelder;
import core.Team;
import core.Verdediger;
import core.Wedstrijd;

public class WedstrijdTest {
	Team team1 = new Team();
	Team team2 = new Team();
	Aanvaller aanvaller = new Aanvaller();
	Verdediger verdediger = new Verdediger();
	Middenvelder middenvelder = new Middenvelder();
	Keeper keeper = new Keeper();
	Driver driver = new Driver();
	Wedstrijd wedstrijd = new Wedstrijd(team1, team2, "normaal");
	
	@Test
	public void testToString() {
		assertEquals("Wedstrijd: null - null\nScore: 0 - 0\nSamenvatting: \n", wedstrijd.toString());
	}
	
	@Test
	public void testAlles(){
		team1.setStats("Ajax", "4-3-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		team2.setStats("Feyenoord", "3-4-3", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
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
		team1.addSpeler(aanvaller);
		team1.addSpeler(verdediger);
		team1.addSpeler(middenvelder);
		team1.addSpeler(keeper);
		team2.addSpeler(aanvaller);
		team2.addSpeler(verdediger);
		team2.addSpeler(middenvelder);
		team2.addSpeler(keeper);
		wedstrijd.setRandom(8);
		wedstrijd.speel();
		assertTrue("[13: (Feyenoord) Jan krijgt de bal toegespeeld, (Ajax) Piet zet zijn voet ervoor en de aanval is gestopt.Corner. De corner wordt genomen en gekopt door (Feyenoord) Jan. De bal komt perfect in de hoek.Goalll!!!! Het staat nu 0-1\n, 20:  krijgt de bal toegespeeld, hij speelt de verdediging sierlijk voorbij en het schot, maar helaas, hij raakt de paal.\n, 45: (Feyenoord) Jan krijgt de bal toegespeeld, hij speelt de verdediging sierlijk voorbij en daar volgt het schot, maar wat een geweldige redding van de keeper.\n, 79:  krijgt de bal toegespeeld, hij maakt een panna en loopt de verdediding voorbij en daar volgt het schot, maar wat een geweldige redding van de keeper.Corner. De corner wordt genomen en gekopt door (Ajax) Klaas, maar hij kopt over. Goede poging.\n, 90+1:  krijgt de bal toegespeeld, (Feyenoord) Jan zet zijn voet ervoor en de aanval is gestopt.\n]".equals(wedstrijd.getLogs().toString()));
		team1.setStats("AZ", "3-5-2", 10000000, 500, 700, 300, 5, 10, 3, 7, 4, 0, 1, 7);
		wedstrijd.speel();
		assertFalse("[13: (Feyenoord) Jan krijgt de bal toegespeeld, (Ajax) Piet zet zijn voet ervoor en de aanval is gestopt.Corner. De corner wordt genomen en gekopt door (Feyenoord) Jan. De bal komt perfect in de hoek.Goalll!!!! Het staat nu 0-1\n, 20:  krijgt de bal toegespeeld, hij speelt de verdediging sierlijk voorbij en het schot, maar helaas, hij raakt de paal.\n, 45: (Feyenoord) Jan krijgt de bal toegespeeld, hij speelt de verdediging sierlijk voorbij en daar volgt het schot, maar wat een geweldige redding van de keeper.\n, 79:  krijgt de bal toegespeeld, hij maakt een panna en loopt de verdediding voorbij en daar volgt het schot, maar wat een geweldige redding van de keeper.Corner. De corner wordt genomen en gekopt door (Ajax) Klaas, maar hij kopt over. Goede poging.\n, 90+1:  krijgt de bal toegespeeld, (Feyenoord) Jan zet zijn voet ervoor en de aanval is gestopt.\n]".equals(wedstrijd.getLogs().toString()));
	}
}
