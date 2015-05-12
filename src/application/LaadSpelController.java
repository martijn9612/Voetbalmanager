package application;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/** 
 * Klasse "LaadSpelController"
 * 
 * Klasse geeft functionaliteit aan LaadSpel.fxml. Hiermee kan de gebruiker een nieuw spel laden.
 * 
 * @author Danielle van der Werff
 *
 */
public class LaadSpelController {
	
	@FXML
	private Button terugbutton; // Om terug te gaan naar BeginScherm
	
	@FXML 
	private GridPane savegames;
	
	/**
	 * The constructor
	 */
	public LaadSpelController() {
		
	}
	
	// TODO: Voeg Button toe om terug te gaan naar het beginscherm
	@FXML
	private void initialize() {
		
		
		
		Button button;
    	final File folder = new File("src/saves");
    	int count = 0;
    	String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	    for (final File fileEntry : folder.listFiles()) {
	    	button = new Button("Opgeslagen spel "+ letters[count]);
	    	button.setOnAction((event) -> {
	    		Main.driver.setSaveFile(fileEntry.getName());
	    		Main.driver.load("src/saves/" + fileEntry.getName());
				Main.loadScreen("MijnTeam.fxml");
			});
	    	button.setId("laadbutton");
	    	savegames.add(button, count%5+1, (int)Math.ceil(((double)count+1)/5));
	    	count++;
	    }
		
		terugbutton.setOnAction((event) -> {
			Main.loadScreen("BeginScherm.fxml", "style.css");
		});
	}
}
