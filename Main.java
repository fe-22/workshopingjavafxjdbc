package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load();
			
			scrollPane.setFitToHeight(true);//ajuste para a tela inteira do MenuBar
			scrollPane.setFitToWidth(true);
			
			mainScene = new Scene(scrollPane);//criado o objeto Scene, instaciado como argumento o objeto precipal da view.
			primaryStage.setScene(mainScene);//setado como cena principal
			primaryStage.setTitle("Sample JavaFx application");//titulo do palco
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {//pega as referencias para abrir a segunda tela.
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
