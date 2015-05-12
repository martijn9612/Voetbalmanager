package application;


import core.Team;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/** 
 * Klasse "NieuwSpelController"
 * 
 * Klasse geeft functionaliteit aan NieuwSpel.fxml. De gebruiker kan hiermee een team kiezen.
 * Vervolgens wordt de gebruiker doorgestuurd naar het volgende scherm.
 * 
 * @author Martijn Janssen, Danielle van der Werff,Niek van der Laan, Thomas Oomens
 *
 */
public class TeamSelectController {

	@FXML
	private Button terugbutton; 	// Om terug te gaan naar BeginScherm
	
	@FXML
	private GridPane tTeamGrid;  		// Het grid waarin alle teams staan waarop je kan kiezen
	
	
	
	
	
	/** 
	 * The constructor 
	 */
	public TeamSelectController() {
		
	}
	
	protected void load(Team team) {
		Main.driver.setTeam(team);
		Main.loadScreen("MijnTeam.fxml");
	}
	
	
	@FXML
	private void initialize() {
		
		terugbutton.setOnAction((event) -> {
			Main.loadScreen("BeginScherm.fxml");
		});
		
		Button button;
		
		int count = 0;
		for(Team team: Main.driver.getTeams()) {
			button = new Button(team.getTeamnaam());
			button.setId("teambutton");
			button.setOnAction((event) -> {
				load(team);
			});	
			tTeamGrid.add(button, count%6, (int)Math.floor(count/6));	
			count++;
		}
	}
}
