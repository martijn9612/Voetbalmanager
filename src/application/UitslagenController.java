package application;

import java.util.ArrayList;
import java.util.List;

import core.Bod;
import core.Speler;
import core.Team;
import core.Wedstrijd;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/** 
 * Klasse "SpeelRondeController"
 * 
 * Deze klasse zorgt dat er een ronde van de competitie gespeeld wordt.
 * 
 * @author Thomas Oomens
 *
 */
public class UitslagenController {
	@FXML
	VBox linkbox;
	

    @FXML private TableView<CompetitieTabel> tableView;
    @FXML private TableColumn<CompetitieTabel, String> tTeam1;
    @FXML private TableColumn<CompetitieTabel, String> tTeam2;
    @FXML private TableColumn<CompetitieTabel, String> tMessage;
    
    @FXML private TableView<StatsTabel> tableViewStats;
    @FXML private TableColumn<StatsTabel, String> tNaam;
    @FXML private TableColumn<StatsTabel, String> tStatsTeam1;
    @FXML private TableColumn<StatsTabel, String> tStatsTeam2;
    
    @FXML private TableView<BiedingenTabel> tableViewBiedingen;
    @FXML private TableColumn<BiedingenTabel, String> huidigTeam;
    @FXML private TableColumn<BiedingenTabel, String> aanbieder;
    @FXML private TableColumn<BiedingenTabel, String> tSpelernaam;
    @FXML private TableColumn<BiedingenTabel, Integer> spelerprijs;
    @FXML private TableColumn<BiedingenTabel, Integer> bod;
    @FXML private TableColumn<BiedingenTabel, String> status;
    
    @FXML private GridPane stats;

    @FXML
    public void initialize() {
    	
		Linkmenu.setLinks(linkbox);
		Linkmenu.setHuidigMenu(linkbox,"Speel Ronde");
		tTeam1.setCellValueFactory(new PropertyValueFactory<CompetitieTabel, String>("tTeam1"));
		tTeam2.setCellValueFactory(new PropertyValueFactory<CompetitieTabel, String>("tTeam2"));
		tMessage.setCellValueFactory(new PropertyValueFactory<CompetitieTabel, String>("tMessage"));
		

		
		tTeam1.setCellFactory(new Callback<TableColumn<CompetitieTabel, String>, TableCell<CompetitieTabel, String>>() {
	        public TableCell call(TableColumn param) {
	            return new TableCell<CompetitieTabel, String>() {

	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (!empty) {
	                    	if (item.equals(Main.driver.getPlayerTeam().getTeamnaam())) {
		                        this.setTextFill(Color.GREEN);
	                    	}
	                        setText(item);
	                    }
	                }
	            };
	        }
	    });
		
		tTeam2.setCellFactory(new Callback<TableColumn<CompetitieTabel, String>, TableCell<CompetitieTabel, String>>() {
	        public TableCell call(TableColumn param) {
	            return new TableCell<CompetitieTabel, String>() {

	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (!empty) {
	                    	if (item.equals(Main.driver.getPlayerTeam().getTeamnaam())) {
		                        this.setTextFill(Color.GREEN);
	                    	}
	                        setText(item);
	                    }
	                }
	            };
	        }
	    });
		
        tableView.getItems().setAll(parseList());
        
        
        tNaam.setCellValueFactory(new PropertyValueFactory<StatsTabel, String>("tNaam"));
		tStatsTeam1.setCellValueFactory(new PropertyValueFactory<StatsTabel, String>("tTeam1"));
		tStatsTeam2.setCellValueFactory(new PropertyValueFactory<StatsTabel, String>("tTeam2"));
		
        tableViewStats.getItems().setAll(Main.driver.getPlayerTeam().getCompetition().get(Main.driver.getCompetitie().getSpeelRonde()).getStatsList());
        
        huidigTeam.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, String>("huidigTeam"));
        aanbieder.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, String>("aanbieder"));
        tSpelernaam.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, String>("spelernaam"));
        spelerprijs.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, Integer>("spelerprijs"));
        bod.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, Integer>("bod"));
        status.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, String>("status"));
        
        tableViewBiedingen.getItems().setAll(parseUserList());
        
    }
    
    protected List<CompetitieTabel> parseList(){
    	List<CompetitieTabel> list = new ArrayList<CompetitieTabel>();

    	/* Temp
		 * Main.loadGame("newgame");
	     * Main.driver.setTeam(Main.driver.getTeams().get(0));
		 */
    	for (Wedstrijd wedstrijd: Main.driver.getCompetitie().getRonde()) {
    		list.add(wedstrijd.toTable(0));
    	}
    	
    	return list;
    }
    
    protected List<BiedingenTabel> parseUserList(){
    	List<BiedingenTabel> list = new ArrayList<BiedingenTabel>();
    	int count = 1;
    	for (Team team: Main.driver.getTeams()) {
    		for (Bod b: team.getBiedingen()) {
    			if(!b.getOud()) {
    				list.add(b.toTable(count));
    				count++;
    			}
    		}
    	}
    	return list;
    }
}
