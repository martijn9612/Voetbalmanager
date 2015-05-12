package application;    

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Klasse "BeginSchermController"
 * 
 * @author Martijn Janssen, Danielle van der Werff
 *
 */
public class BeginSchermController {

	@FXML 
	private Button nieuwspelButton;		// Begin nieuw spel
	
	@FXML
	private Button laadButton;			// Laad opgeslagen spel
		
	@FXML
	private Button exitButton;			// Sluit het spel af
	
	@FXML
	private void initialize() {
		nieuwspelButton.setOnAction((event) -> {
			Main.newgame();
			Main.loadScreen("TeamSelect.fxml");
		});
		
		laadButton.setOnAction((event) -> {
			Main.loadScreen("LaadSpel.fxml");
		});
		
		exitButton.setOnAction((event) -> {
			System.exit(0);
		});
		
	}
	
	
}
