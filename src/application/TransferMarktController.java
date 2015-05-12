package application;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import core.Bod;
import javafx.util.Callback;
import core.Speler;
import core.Team;

/**
 * Klasse "TransferMarktController"
 * 
 * @author Thomas Oomens
 *
 */
public class TransferMarktController {
	@FXML
	VBox linkbox;

	@FXML
	Button bodbutton;

	@FXML
	Label mededeling2;

	@FXML
	Button kiezen;

	@FXML
	Label spelernaam;

	@FXML
	TextField boduitbrengen;

	@FXML
	private TableView<SpelerTabel> tableView;
	@FXML
	private TableColumn<SpelerTabel, String> tNaam;
	@FXML
	private TableColumn<SpelerTabel, String> tStatus;
	@FXML
	private TableColumn<SpelerTabel, String> tAgressie;
	@FXML
	private TableColumn<SpelerTabel, String> tLand;
	@FXML
	private TableColumn<SpelerTabel, String> tPositie;
	@FXML
	private TableColumn<SpelerTabel, String> tType;
	@FXML
	private TableColumn<SpelerTabel, Integer> tLeeftijd;
	@FXML
	private TableColumn<SpelerTabel, String> tPrijs;
	@FXML
	private TableColumn<SpelerTabel, Integer> tAanval;
	@FXML
	private TableColumn<SpelerTabel, Integer> tVerdediging;
	@FXML
	private TableColumn<SpelerTabel, Integer> tConditie;
	@FXML
	private TableColumn<SpelerTabel, Integer> tKeeperskills;

	@FXML
	private ComboBox<String> selectTeam;

	@FXML
	public void initialize() {
		Linkmenu.setLinks(linkbox);
		Linkmenu.setHuidigMenu(linkbox, "Transfer Markt");
		tNaam.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>(
				"tNaam"));
		tStatus.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>(
				"tStatus"));
		tAgressie
				.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>(
						"tAgressie"));
		tLand.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>(
				"tLand"));
		tPositie.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>(
				"tPositie"));
		tType.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>(
				"tType"));
		tLeeftijd
				.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>(
						"tLeeftijd"));
		tPrijs.setCellValueFactory(new PropertyValueFactory<SpelerTabel, String>(
				"tPrijs"));
		tAanval.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>(
				"tAanval"));
		tVerdediging
				.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>(
						"tVerdediging"));
		tConditie
				.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>(
						"tConditie"));
		tKeeperskills
				.setCellValueFactory(new PropertyValueFactory<SpelerTabel, Integer>(
						"tKeeperskills"));
		

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
		                        this.setTextFill(Color.PURPLE);	                    
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

		kiezen.setOnAction((event) -> {
			spelernaam.setText(tableView.getSelectionModel().getSelectedItem()
					.getNaam());
		});

		bodbutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				System.out.println(spelernaam.getText());
				int bod = Integer.parseInt(boduitbrengen.getText());
				Team team1 = null;
				String spelerNaam = spelernaam.getText();
				
				for (Team team : Main.driver.getTeams()) {
					if (team.getTeamnaam().equals(selectTeam.getValue())) {
						team1 = team;
					}
					
				}
				Team team2 = Main.driver.getPlayerTeam();
				Speler speler = team1.zoekSpeler(spelernaam.getText());
				team2.addGeld(-bod);
				team1.addBod(new Bod(team1, team2, speler, bod, "in afwachting"));
				mededeling2.setText("U heeft " + bod + " geboden op " + speler.getNaam());
			}
		}); 
		
		selectTeam.getItems().clear();
		for (Team team : Main.driver.getTeams()) {
			selectTeam.getItems().add(team.getTeamnaam());
		}
		selectTeam.setValue(Main.driver.getTeams().get(0).getTeamnaam());

		selectTeam.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				for (Team team : Main.driver.getTeams()) {
					if (team.getTeamnaam().equals(t1)) {
						tableView.getItems().setAll(parseUserList(team));
					}
				}
			}
		});

		tableView.getItems().setAll(
				parseUserList(Main.driver.getTeams().get(0)));
	}

	protected List<SpelerTabel> parseUserList(Team team) {
		List<SpelerTabel> list = new ArrayList<SpelerTabel>();

		/*
		 * Temp Main.loadGame("newgame");
		 * Main.driver.setTeam(Main.driver.getTeams().get(0));
		 */
		for (Speler speler : team.getSpelers()) {
			list.add(speler.toTable());
		}

		return list;
	}
}
