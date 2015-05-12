package core;

import java.util.Comparator;
import java.util.List;

/**
 * Klasse "TussenstandComparator"
 * Deze klasse vergelijkt het aantal punten tussen twee teams
 * @author Thomas Oomens
 * 
 */

public class TussenstandComparator implements Comparator<Team> {
	
	/**
	 * Methode "compare"
	 * Vergelijkt de hoeveelheid punten van twee teams
	 * @param a		Team 1
	 * @param b		Team 2
	 */
    @Override
    public int compare(Team a, Team b) {
    	if (a.getPunten() > b.getPunten()) {
    		return -1;
    	}
    	else if (a.getPunten() == b.getPunten()) {
    		return 0;
    	}
    	return 1;
    }
}