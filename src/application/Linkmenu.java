package application;


import java.text.NumberFormat;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class Linkmenu {
	
	/** 
	 * Methode "setHuidigMenu"
	 * Geeft de Button van het huidige geselecteerde menu een ander kleurtje
	 * @param linkbox - De VBox met alle Buttons en Labels links in het scherm
	 * @param currentMenu - Naam huidige menu
	 */
	public static void setHuidigMenu(VBox linkbox, String currentMenu) {
		
		for (int i = 0; i < linkbox.getChildren().size(); i++) {
			if (linkbox.getChildren().get(i) instanceof Button) {
				if (((Button)linkbox.getChildren().get(i)).getText().equals(currentMenu)) {
					((Button)linkbox.getChildren().get(i)).setId("huidigmenuButton");
				}
			}
		}			
	}
	

	public static void setLinks(VBox linkbox) {
		//Voegt buttons toe aan het linkmenu
		Button button;
		Label label;
		int count = 0;
		
		String[] buttons = {"Mijn team", "Opstelling", "Tussenstand", "Competitie", "Transfer Markt", "Biedingen", "Speel Ronde"}; 
		String[] fxml = {"MijnTeam", "Opstelling", "Tussenstand", "Competitie", "TransferMarkt", "Biedingen", "SpeelRonde"}; 
		String[] labels = {"Team: ", "Budget: "};
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		formatter.setMaximumFractionDigits(0);
		System.out.println(formatter.format(Main.driver.getPlayerTeam().getGeld()));
		String[] info = {Main.driver.getPlayerTeam().getTeamnaam() , formatter.format(Main.driver.getPlayerTeam().getGeld()) };
		
		for (int i=0; i<buttons.length; i++) {
			button = new Button(buttons[i]);
			button.setId("linkbutton");
			final String fxmlfile = fxml[i] + ".fxml";
			button.setOnAction((event) -> {
				Main.loadScreen(fxmlfile);
			});	
	
			linkbox.getChildren().add(count, button);
			count++;
		}
		
		//voegt labels toe
		for (int i=0; i<labels.length; i++) {
			label = new Label(labels[i] + info[i]);
			label.setId("linklabel");
			linkbox.getChildren().add(count, label);
			count++;
		}

		//Voeg opslaanbutton toe
		button = new Button("Spel opslaan");
		button.setId("linkbutton");
		final Popup popup = new Popup();
        popup.setX(800);
        popup.setY(400);
        Label message = new Label("Bezig met opslaan");
        message.setId("popup");
        popup.getContent().addAll(message);
		button.setOnAction((event) -> {
			popup.show(Main.primaryStage);
			Main.driver.save();

			Thread gameLoop = new Thread(() ->
			{
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Platform.runLater(() ->
		        {
		        	popup.hide();
		        });
			});
			
			gameLoop.start();
			
		});
		linkbox.getChildren().add(count, button);
		count++;
		
		//Voeg afsluitbutton toe
		button = new Button("Sluit af");
		button.setId("linkbutton");
		button.setOnAction((event) -> {
			System.exit(0);
		});
		linkbox.getChildren().add(count, button);
		count++;
	}
}
