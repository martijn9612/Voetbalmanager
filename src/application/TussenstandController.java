package application;    


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import core.Speler;
import core.Team;
import core.TussenstandComparator;

/**
 * Klasse "TussenstandController"
 * 
 * @author Thomas Oomens
 *
 */
public class TussenstandController {
	@FXML
	VBox linkbox;
	
	

    @FXML private TableView<TeamTabel> tableView;
    @FXML private TableColumn<TeamTabel, Integer> tPosition;
    @FXML private TableColumn<TeamTabel, String> tTeamnaam;
    @FXML private TableColumn<TeamTabel, Integer> tGespeeld;
    @FXML private TableColumn<TeamTabel, Integer> tDoelpunten;
    @FXML private TableColumn<TeamTabel, Integer> tTegendoelpunten;
    @FXML private TableColumn<TeamTabel, Integer> tPunten;
    @FXML private TableColumn<TeamTabel, Integer> tWins;
    @FXML private TableColumn<TeamTabel, Integer> tLosses;
    @FXML private TableColumn<TeamTabel, Integer> tGelijk;
    @FXML private TableColumn<TeamTabel, Integer> tDoelsaldo;
    

    @FXML
    public void initialize() {
		Linkmenu.setLinks(linkbox);
		Linkmenu.setHuidigMenu(linkbox, "Tussenstand");
		tPosition.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tPosition"));
		tTeamnaam.setCellValueFactory(new PropertyValueFactory<TeamTabel, String>("tTeamnaam"));
		tGespeeld.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tGespeeld"));
		tDoelpunten.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tDoelpunten"));
		tTegendoelpunten.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tTegendoelpunten"));
		tPunten.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tPunten"));
		tWins.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tWins"));
		tLosses.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tLosses"));
		tGelijk.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tGelijk"));
		tDoelsaldo.setCellValueFactory(new PropertyValueFactory<TeamTabel, Integer>("tDoelsaldo"));

		
        tableView.getItems().setAll(parseList());
    }
    
    protected List<TeamTabel> parseList(){
    	List<TeamTabel> list = new ArrayList<TeamTabel>();

    	ArrayList<Team> teams = Main.driver.getTeams();
    	Collections.sort(teams, new TussenstandComparator());
    	int count = 1;
    	for (Team team: teams) {
    		list.add(team.toTable(count));
    		count++;
    	}
    	return list;
    }
}
