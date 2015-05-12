package application;
	
import java.io.File;

import core.Driver;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * Klasse "Main" 
 * 
 * Vanuit deze klasse wordt de GUI gelaunched.
 * 
 * @author Martijn Janssen, Niek van der Laan 
 *
 */
public class Main extends Application {
	public static Stage primaryStage;
	public static BorderPane pane;
	public static Driver driver;
	
	@Override
	public void start(Stage primaryStage) {
		
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("Soccer Manager");
		
		initRootLayout();
		
	}
	
	/** 
	 * Methode waarmee de root layout wordt ingeladen vanuit een FXML file, samen met een CSS stylesheet
	 * Scene wordt in de primary stage geladen.
	 */
	public void initRootLayout() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("BeginScherm.fxml"));
			pane = (BorderPane) loader.load();
			
			//Set het Id van de pane voor de style
			pane.setId("pane");
			
			// Show the scene
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.show();
			primaryStage.setResizable(false);
			
			//Load Style
			File f = new File("src/application/style.css");
			scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void newgame() {
		Main.driver.newgame();
	}
	
	public static void loadGame(String xml) {
		Main.driver.load("src/saves/"+ xml +".xml");
	}
	
	/**
	 * Methode waarmee een nieuwe scene in de Main stage wordt geladen.
	 * @param sceneFile - String die de naam representeert van de in te lezen FXML file 
	 * @param styleFile - String die de naam representeert van de CSS stylesheet
	 */
	public static void loadScreen(String sceneFile, String styleFile){
		try{
			// Ga naar nieuw scherm
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(sceneFile));
			Main.pane = (BorderPane) loader.load();
			
			//Set het Id van de pane voor de style
			pane.setId("pane");
			
			// Show the scene
			// Scene newScene = new Scene(Main.rootLayout);
			Main.primaryStage.getScene().setRoot(Main.pane);
			Main.primaryStage.show();
			
			// Load Style
			File f = new File("src/application/" + styleFile);
			Main.pane.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void loadScreen(String sceneFile) {
		loadScreen(sceneFile, "style.css");
	}
	
	
	public static void main(String[] args) {
		Main.driver = new Driver();
		launch(args);
	}
}
