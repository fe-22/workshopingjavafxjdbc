package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller;//Itens de menu
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAboult;
	
	@FXML
	public void onMenuItemSellerAction() {//metodos que trata os eventos do menu
		System.out.println("Seller");
	}
	@FXML
	public void onMenuItemDepartment() {
		loadView("/gui/DepartmentList.fxml");//Chamada da tela department list
	}
	@FXML
	public void OnMenuItemAbout() {
		loadView("/gui/About.fxml");//chamada da tela About
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}
	
	private void loadView(String absoluteName) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		VBox newVBox = loader.load();
		
		Scene mainScene = Main.getMainScene();//pega as referencias da cena da segunda tela.
		VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();//pega as referencias do ScrollPane da view principal
		
		Node mainMenu = mainVBox.getChildren().get(0);//guarda uma referencia para o menu, manipulação da cena principal.
		mainVBox.getChildren().clear();//limpa todos os filhos do Vbox.
		mainVBox.getChildren().add(mainMenu);//adiciona os filhos 
		mainVBox.getChildren().addAll(newVBox.getChildren());//adiciona uma coleção dos filhos do Vbox.
		
		
	}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}

	}
	
}
