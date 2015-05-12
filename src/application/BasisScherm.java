package application;    

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * Klasse "BasisScherm"
 * 
 * Dummy scherm, de basis van alle andere schermen kan hieruit worden gehaald.
 * 
 * @author Martijn Janssen
 *
 */
public class BasisScherm {
	@FXML
	VBox linkbox;

	@FXML
	private void initialize() {
		Linkmenu.setLinks(linkbox);
	}
}
