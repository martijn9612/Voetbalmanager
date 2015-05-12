package application;    


import java.util.ArrayList;
import java.util.List;

import core.Wedstrijd;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * Klasse "MijnTeamController"
 * 
 * @author Thomas Oomens
 *
 */
public class CompetitieController {
	@FXML
	VBox linkbox;	

    @FXML private TableView<CompetitieTabel> tableView;
    @FXML private TableColumn<CompetitieTabel, String> tWeek;
    @FXML private TableColumn<CompetitieTabel, String> tTeam1;
    @FXML private TableColumn<CompetitieTabel, String> tTeam2;
    @FXML private TableColumn<CompetitieTabel, String> tMessage;

    @FXML
    public void initialize() {
		Linkmenu.setLinks(linkbox);
		Linkmenu.setHuidigMenu(linkbox, "Competitie");
		tWeek.setCellValueFactory(new PropertyValueFactory<CompetitieTabel, String>("tWeek"));
		tTeam1.setCellValueFactory(new PropertyValueFactory<CompetitieTabel, String>("tTeam1"));
		tTeam2.setCellValueFactory(new PropertyValueFactory<CompetitieTabel, String>("tTeam2"));
		tMessage.setCellValueFactory(new PropertyValueFactory<CompetitieTabel, String>("tMessage"));
		
        tableView.getItems().setAll(parseList());
    }
    
    protected List<CompetitieTabel> parseList(){
    	List<CompetitieTabel> list = new ArrayList<CompetitieTabel>();

    	/* Temp
		 * Main.loadGame("newgame");
	     * Main.driver.setTeam(Main.driver.getTeams().get(0));
		 */
    	int count = 1;
    	for (Wedstrijd wedstrijd: Main.driver.getPlayerTeam().getCompetition()) {
    		list.add(wedstrijd.toTable(count));
    		count++;
    	}
    	
    	return list;
    }
}
