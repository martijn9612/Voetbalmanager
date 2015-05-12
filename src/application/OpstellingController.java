package application;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane; 


/**
 * Klasse "OpstellingController"
 * 
 * @author Danielle van der Werff, Martijn Janssen
 *
 */
public class OpstellingController {
	

	@FXML
	VBox linkbox;					// Het algemene menu waarmee je door het spel navigeert

	@FXML
	GridPane opstellingen;			// GridPane met daarin de verschillende mogelijkheden voor de opstellingen
	
	/**
	 * The constructor
	 */
	public OpstellingController() {
		
	}
	
	@FXML
	private void initialize() {
		Linkmenu.setLinks(linkbox);
		Linkmenu.setHuidigMenu(linkbox, "Opstelling");

		String[] opstelling = {"4-3-3","4-5-1","4-4-2","3-2-5","3-3-4","3-4-3", "3-5-2", "4-2-4", "5-2-3"}; 
		
		int rij = 0;
		int kolom = 0;
		for (int i=0; i<opstelling.length; i++) {
			String keuze = opstelling[i];
			Button button = new Button(keuze);
			opstellingen.add(button,kolom,rij);	
			button.setId("opstellingkeuze");
			button.setOnAction((event) -> {
				Main.driver.getPlayerTeam().setOpstelling(keuze);
				Main.loadScreen("OpstellingSpelers.fxml");
			});	
			if (kolom == 2) {
				kolom = 0;
				rij++;
			} else {
				kolom++;
			}
		}		
	}	
}	

