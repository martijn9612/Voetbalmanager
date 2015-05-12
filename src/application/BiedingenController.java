package application;

import java.util.ArrayList;
import java.util.List;

import core.Bod;
import core.Speler;
import core.Team;
import core.Wedstrijd;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class BiedingenController {
	@FXML
	VBox linkbox;	

	@FXML private TableView<BiedingenTabel> tableView;
	@FXML private TableColumn<BiedingenTabel, String> huidigTeam;
    @FXML private TableColumn<BiedingenTabel, String> aanbieder;
    @FXML private TableColumn<BiedingenTabel, String> tSpelernaam;
    @FXML private TableColumn<BiedingenTabel, Integer> spelerprijs;
    @FXML private TableColumn<BiedingenTabel, Integer> bod;
    @FXML private TableColumn<BiedingenTabel, String> status;

    @FXML
    public void initialize() {
    	Linkmenu.setLinks(linkbox);
    	Linkmenu.setHuidigMenu(linkbox,"Biedingen");
    	
    	huidigTeam.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, String>("huidigTeam"));
    	aanbieder.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, String>("aanbieder"));
    	tSpelernaam.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, String>("spelernaam"));
    	spelerprijs.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, Integer>("spelerprijs"));
    	bod.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, Integer>("bod"));
    	status.setCellValueFactory(new PropertyValueFactory<BiedingenTabel, String>("status"));
    	
    	tableView.getItems().setAll(parseUserList());
    }
    
    protected List<BiedingenTabel> parseUserList(){
    	List<BiedingenTabel> list = new ArrayList<BiedingenTabel>();

    	int count = 1;
    	for (Team team: Main.driver.getTeams()) {
    		for (Bod b: team.getBiedingen()) {
    				list.add(b.toTable(count));
    				count++;
    		}
    	}
    	return list;
    }
}
