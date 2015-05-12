package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import core.Wedstrijd;


public class SpeelRondeController {
	@FXML
	Button uitslagen;

	@FXML
	VBox commentaarbox;

	@FXML
	ScrollPane commentaarscroll;
	
	
	int ronde = Main.driver.getCompetitie().speelRonde();
	Wedstrijd wedstrijd = Main.driver.getPlayerTeam().getCompetition().get(ronde);

	@FXML
	private void initialize() {
		uitslagen.setOnAction((event) -> {
			Main.loadScreen("Uitslagen.fxml");
		});
		Thread gameLoop = new Thread(() ->
		{;
			speel();
		});
		commentaarscroll.fitToWidthProperty();
		gameLoop.start();
	}

	public void speel() {
		int count = 0;
		for (int i = 1; i <= 45 + wedstrijd.getVerlenging1(); i++) {
			if (wedstrijd.getLogs().get(count).getMinuut() == i) {
				if ((i > 45 && wedstrijd.getLogs().get(count).isVerlenging()) || i <= 45) {
					final int c = count;
					Platform.runLater(() ->
			        {
			        	nieuwCommentaar(commentaarbox, wedstrijd.getLogs().get(c).toString());
			        	
			        });
					count++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}

		for (int i = 46; i <= 90 + wedstrijd.getVerlenging2(); i++) {
			if (count < wedstrijd.getLogs().size()) {
				if (wedstrijd.getLogs().get(count).getMinuut() == i) {
					if ((i > 90 && wedstrijd.getLogs().get(count).isVerlenging()) || i <= 90) {
						final int c = count;
						Platform.runLater(() ->
				        {
							nieuwCommentaar(commentaarbox, wedstrijd.getLogs().get(c).toString());
				        });
						count++;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public static void nieuwCommentaar(VBox commenter, String s) {
		int count = 0;
		HBox commentaar = new HBox();
		commentaar.setId("commentaarHBox");
		Label commentaarText = new Label();
		commentaarText.setText(s);
		commentaarText.setId("commentaartext");
		commentaar.getChildren().add(commentaarText);
		commenter.getChildren().add(count, commentaar);
		count++;
	}
}
