package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.util.*;
import core.Speler;

/**
 * Klasse "OpstellingSpelersController"
 * 
 * Klasse geeft functionaliteit aan OpstellingSpelers.fxml. In de scene die wordt ingeladen met OpstellingSpelers.fxml 
 * kan gekozen worden hoe de posities gerangschikt zijn op het voetbalveld, en welke spelers op welke positie staan. 
 * 
 * @author Martijn Janssen, Danielle van der Werff
 *
 */
public class OpstellingSpelersController {
	@FXML
	VBox linkbox;								// Het algemene menu waarin je navigeert tussen schermen
	@FXML
	GridPane veldOpstelling; 					// Het voetbalveld waarop opstelling en spelerkeuze zichtbaar zijn
	@FXML	
	VBox spelerBox;								// Lijst met spelers waaruit je kunt kiezen
	@FXML
	ScrollPane scrollPane;						// Scrollende lijst voor de vbox waar de spelers in staan
	@FXML	
	Button terugbutton;							// Knop om terug te gaan naar het hoofdscherm
	@FXML
	Button opslaanbutton;						// Knop om huidige selectie op te slaan
	@FXML 
	TextField notificatie;						// Hierin verschijnt een bericht als je nog niet alle locaties hebt opgevuld met een speler
		
	EventHandler<? super MouseEvent> tempSave;	// Slaat EventHandler op van een knop

	/**
	 * The constructor
	 */
	public OpstellingSpelersController() {

	}
	
	/**
	 * Methode "zoekSpeler"
	 * Zoek met de String "naam" van een speler naar de index van de bijbehorende Speler in de spelerBox 
	 * @param naam
	 * @return plek - de index van de speler in de spelerBox
	 */
	public int zoekSpeler(String naam){
		int plek = 99;
		for(int i = 0; i < spelerBox.getChildren().size(); i++){
			System.out.println(((Button)spelerBox.getChildren().get(i)).getText());
			if(((Button)spelerBox.getChildren().get(i)).getText().equals(naam)){
				return i;
			}
		}
		return plek;
	}
	
	/**
	 * Methode "plaatsButton"
	 * Plaats een button (representatie van een locatie op het voetbalveld) in het GridPane "voetbalveld" in de gewenste kolom en rij.
	 * @param kolom - Integer die kolom in GridPane aangeeft
	 * @param rij	- Integer die rij in GridPane aangeeft
	 */
	public void plaatsVBox(int kolom, int rij) {
		VBox positiePlek = new VBox();
		positiePlek.setId("opstellingPlek");
		veldOpstelling.add(positiePlek,kolom,rij);
		
		positiePlek.setOnDragOver(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				/* data is dragged over the target */
	
				/* accept it only if it is  not dragged from the same node 
				 * and if it has a string data */
				if (event.getGestureSource() != positiePlek && event.getDragboard().hasString()) {
					/* allow for both copying and moving, whatever user chooses */
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
	
				event.consume();
			}
		});
	
		// TODO Aanval en verdedigingssterkte verwerken in gegevens hier en in de lijst eveneens met gele kaarten
		positiePlek.setOnDragDropped(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				
				Dragboard db = event.getDragboard();
				boolean success = false;
				
				if (db.hasString()) {
					
					Speler gesleepteSpeler = Main.driver.getPlayerTeam().zoekSpeler(db.getString());
					Label spelerLabel = new Label(gesleepteSpeler.getNaam());
					spelerLabel.setId("opstellingSpelerLabel");
					if(positiePlek.getChildren().toString() != "[]"){
						//Krijg naam van speler die er eerst in stond
						String oudeSpeler = positiePlek.getChildren().toString();
						oudeSpeler = oudeSpeler.split("'")[1];
						//System.out.println(oudeSpeler);
						
						//Zet de knop weer aan van de speler
						spelerBox.getChildren().get(zoekSpeler(oudeSpeler)).setOnDragDetected(tempSave);
						spelerBox.getChildren().get(zoekSpeler(oudeSpeler)).setId("spelerknop");						
					}
					
					positiePlek.getChildren().setAll(spelerLabel);
					success = true;		
				}
				event.setDropCompleted(success);
				event.consume();
			}
		});
		
	}
	
	@FXML
	private void initialize() {
		Linkmenu.setLinks(linkbox);
		Linkmenu.setHuidigMenu(linkbox, "Opstelling");

		// TODO gele kaarten van spelers verwerken, evt met plaatje

		terugbutton.setOnAction((event) -> {
			Main.loadScreen("Opstelling.fxml");
		});
			
		// Maak ObservableList van de spelers waaruit gekozen kan worden (dus alleen spelers met status "groen" of "geel")
		ObservableList<Speler> alleSpelers = FXCollections.observableArrayList();
		ArrayList<Speler> spelers = Main.driver.getPlayerTeam().getSpelers();
		for (Speler speler: spelers) {
			if (speler.getStatus().equals("groen") || speler.getStatus().equals("geel")) {
				alleSpelers.add(speler);
			}
		}
		
		String opstelling = Main.driver.getPlayerTeam().getOpstelling();
		String[] data = opstelling.split("-");
		
		veldOpstelling.getChildren().clear(); // Maak eerst gridpane leeg ivm eventuele vorige keuzes
		for(int i = 0; i < 11; i++){
			//Breedte van de kolommen
			veldOpstelling.getColumnConstraints().add(new ColumnConstraints(50));
		}
		veldOpstelling.setLayoutY(5);
		
		//tempGridlines, om opmaak te zien van de opstelling. Zet op true voor lijnen
		veldOpstelling.setGridLinesVisible(true);
				
		// Keeperlocatie toevoegen:
		plaatsVBox(5,1);
		
		for(int i = 0; i <= 2; i++){
			//Startpositie voor eerste speler in rij
			int posCount = 6 - Integer.parseInt(data[i]);
			for(int x = 0; x < Integer.parseInt(data[i]); x++){
				
				plaatsVBox(posCount + 2 * x, i+2);
			}
		}
		
		for (Speler speler: alleSpelers) {
			String info = speler.getNaam();
			Button knop = new Button(info);
			knop.setId("spelerknop");
			spelerBox.getChildren().add(knop);

			//Drag functie voor elke knop
			knop.setOnDragDetected(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					Dragboard db = knop.startDragAndDrop(TransferMode.ANY);
					
					ClipboardContent content = new ClipboardContent();
					content.putString(knop.getText());
					db.setContent(content);
					
					System.out.println(knop.getText());
					
					event.consume();
			}
			});
			
			/*
			knop.setOnDragOver(new EventHandler<DragEvent>() {
				public void handle(DragEvent event){
					if(event.getGestureSource() != knop && event.getDragboard().hasString()){
						event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
					}
				}
			});
			*/
			
			knop.setOnDragDone(new EventHandler<DragEvent>() {
				public void handle(DragEvent event){
					if(event.getTransferMode().equals(TransferMode.MOVE)){
						knop.setId("opgesteld");
					}
					event.consume();
					
					//Zet knop uit
					tempSave = knop.getOnDragDetected();
					knop.setOnDragDetected(null);
				}
			});
			
			opslaanbutton.setOnAction((event) -> {
				boolean teWeinigSpelers = false;
				for ( int i = 0; i< veldOpstelling.getChildren().size();i++) {
					if(veldOpstelling.getChildren().get(i) instanceof VBox) { 
						if (((VBox)veldOpstelling.getChildren().get(i)).getChildren().toString().equals("[]")) {
							teWeinigSpelers = true;
						}
					}
				}

				if (teWeinigSpelers) {
					notificatie.setText("Je hebt niet genoeg spelers op het veld gezet!");
					
				} else {
					notificatie.setText("Je opstelling wordt opgeslagen!");
					
					for (int i = 1; i < veldOpstelling.getChildren().size(); i++){  // Begin bij 1, want eerste object hoort niet bij de opstelling
						String naamSpeler = ((VBox)veldOpstelling.getChildren().get(i)).getChildren().toString();
						naamSpeler = naamSpeler.split("'")[1];
						Speler huidigeSpeler = Main.driver.getPlayerTeam().zoekSpeler(naamSpeler);
						huidigeSpeler.setLocatie(i);
							
						int rij = veldOpstelling.getRowIndex(veldOpstelling.getChildren().get(i)); // de rij waar de huidige speler in staat
						if (rij == 1) { 						// Keeper
							huidigeSpeler.setPositie("doel");
						} else if (rij == 2) { 					// Verdediging
							huidigeSpeler.setPositie("verdediging");
						} else if (rij == 3) { 					// Middenveld
							huidigeSpeler.setPositie("middenveld");
						} else if (rij == 4) {					// Aanval
							huidigeSpeler.setPositie("aanval");
						}
					}
					Main.loadScreen("MijnTeam.fxml");
				}
				
				
			});
			
			// TODO aanval en verdedigingsscore toevoegen?
			// TODO als je hovert over button extra info tonen?
			// Ik zou een beetje een middenweg nemen, toon onder de naam de standaard positie en a:# v:# --> met de hoover de totale info laten zien --martijn
		}		
	}	
}	
