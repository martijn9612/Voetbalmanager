package application;    


import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import core.Speler;

/**
 * Klasse "MijnTeamController"
 * 
 * @author Thomas Oomens
 *
 */
public class MijnTeamController {
	@FXML
	VBox linkbox;
	
	

    @FXML private TableView<SpelerTabel> tableView;
    @FXML private TableColumn<SpelerTabel, String> tNaam;
    @FXML private TableColumn<SpelerTabel, String> tStatus;
    @FXML private TableColumn<SpelerTabel, String> tAgressie;
    @FXML private TableColumn<SpelerTabel, String> tLand;
    @FXML private TableColumn<SpelerTabel, String> tPositie;
    @FXML private TableColumn<SpelerTabel, String> tType;
    @FXML private TableColumn<SpelerTabel, Integer> tLeeftijd;
    @FXML private TableColumn<SpelerTabel, String> tPrijs;
    @FXML private TableColumn<SpelerTabel, Integer> tAanval;
    @FXML private TableColumn<SpelerTabel, Integer> tVerdediging;
    @FXML private TableColumn<SpelerTabel, Integer> tConditie;
    @FXML private TableColumn<SpelerTabel, Integer> tKeeperskills;


    @FXML
    public void initialize() {
		Linkmenu.setLinks(linkbox);
		Linkmenu.setHuidigMenu(linkbox,"Mijn team");
		
		
		tNaam.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>("tNaam"));
		tStatus.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>("tStatus"));
		tAgressie.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>("tAgressie"));
		tLand.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>("tLand"));
		tPositie.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>("tPositie"));
		tType.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>("tType"));
		tLeeftijd.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>("tLeeftijd"));
		tPrijs.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>("tPrijs"));
		tAanval.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>("tAanval"));
		tVerdediging.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>("tVerdediging"));
		tConditie.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>("tConditie"));
		tKeeperskills.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>("tKeeperskills"));


		tStatus.setCellFactory(new Callback<TableColumn<SpelerTabel, String>, TableCell<SpelerTabel, String>>() {
	        public TableCell call(TableColumn param) {
	            return new TableCell<SpelerTabel, String>() {

	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (!empty) {
		                    if (item.equals("geel")) {
		                        this.setTextFill(Color.YELLOW);
		                    }
		                    else if (item.equals("rood")) {
		                        this.setTextFill(Color.RED);	                    
		                    }
		                    else if (item.equals("groen")) {
		                        this.setTextFill(Color.GREEN);	                    
		                    }
		                    else {
		                        this.setTextFill(Color.ORANGE);	                    
		                    }
	                    }
                        setText(item);
	                }
	            };
	        }
	    });
		
		tConditie.setCellFactory(new Callback<TableColumn<SpelerTabel, Integer>, TableCell<SpelerTabel, Integer>>() {
	        public TableCell call(TableColumn param) {
	            return new TableCell<SpelerTabel, Integer>() {

	                @Override
	                public void updateItem(Integer item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (!empty) {
		                    if (item > 80) {
		                        this.setTextFill(Color.GREEN);
		                    }
		                    else if (item > 50) {
		                        this.setTextFill(Color.YELLOW);	                    
		                    }
		                    else {
		                        this.setTextFill(Color.RED);	                    
		                    }
	                        setText(Integer.toString(item));
	                    }
	                }
	            };
	        }
	    });
		
        tableView.getItems().setAll(parseUserList());
    }
    
    protected List<SpelerTabel> parseUserList(){
    	List<SpelerTabel> list = new ArrayList<SpelerTabel>();

    	/* Temp
		 * Main.loadGame("newgame");
	     * Main.driver.setTeam(Main.driver.getTeams().get(0));
		 */
    	for (Speler speler: Main.driver.getPlayerTeam().getSpelers()) {
    		list.add(speler.toTable());
    	}
    	
    	return list;
    }
}
