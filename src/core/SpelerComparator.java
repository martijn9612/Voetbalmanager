package core;

import java.util.Comparator;
import java.util.List;

/**
 * Klasse "TussenstandComparator"
 * Deze klasse vergelijkt het aantal aanvals of verdedigingspunten met een andere speler
 * @author Thomas Oomens
 * 
 */

public class SpelerComparator implements Comparator<Speler> {
	
	/**
	 * Methode "compare"
	 * Vergelijkt de hoeveelheid punten van twee teams
	 * @param a		Team 1
	 * @param b		Team 2
	 */
    @Override
    public int compare(Speler a, Speler b) {
    	int puntena;
    	int puntenb;
    	if (a.getClass().getName().equals("core.Aanvaller")) {
    		puntena = a.getAanval();
    		puntenb = b.getAanval();
    	}
    	else if (a.getClass().getName().equals("core.Middenvelder")) {
    		puntena = a.getAanval() + a.getVerdediging();
    		puntenb = b.getAanval() + b.getVerdediging();  
    	}
    	else if (a.getClass().getName().equals("core.Verdediger")) {
    		puntena = a.getVerdediging();
    		puntenb = b.getVerdediging();    		
    	}
    	else {  //Keeper
    		puntena = ((Keeper) a).getKeeperskills();
    		puntenb = ((Keeper) b).getKeeperskills();
    	}
    	if (puntena > puntenb) {
    		return -1;
    	}
    	else if (puntena == puntenb) {
    		return 0;
    	}
    	return 1;
    }
}