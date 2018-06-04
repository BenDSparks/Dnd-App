
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane mainLayout;
	
	public int monsterNumber;
	
//	private AnchorPane monsterScene;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setResizable(false);
		this.primaryStage.setTitle("D&D guide");
		showMainWindow();
		showMonsterPicker();
//		showMonsterScene(3);
	}
	
	private void showMainWindow() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("RootLayout.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	public void changeMonsterScene(int monsterNumber) throws IOException {
		showMonsterScene(monsterNumber);
	}
	
	private void showMonsterScene(int monsterNumber) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MonsterScene.fxml"));
		AnchorPane monsterScene = loader.load();
//		monsterScene.getStylesheets().add(getClass().getResource("monsterStyle.css").toExternalForm());
		MonsterController controller = loader.getController();
		controller.initData(monsterNumber);
		mainLayout.setCenter(monsterScene);
	}
	
	private void showMonsterPicker() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MonsterPicker.fxml"));
		AnchorPane monsterPickerScene = loader.load();
		MonsterPickerController controller = loader.getController();
		controller.setMainController(this);
		controller.initialize();
		mainLayout.setLeft(monsterPickerScene);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void testMain() {
		System.out.println("TESTING IN MAIN");
	}
	
	
}


