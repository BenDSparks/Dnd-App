import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MonsterPickerController implements Initializable{

	@FXML
	private VBox vBox;
	
	private Main mainController;
	
	private int width = 200;
	private int height = 600;
	
	private Integer monsterCount;
	private String monstersList[];
	
	
	public void initialize() throws IOException{
        getMonsters();
    }
	
	public void setMainController(Main main) {
		this.mainController = main;
	}
	


	private void getMonsters() throws IOException {
		//connect to API and retrive json
		URL url = new URL("http://www.dnd5eapi.co/api/monsters");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		conn.setRequestMethod("GET"); 
		conn.connect();
		int responsecode = conn.getResponseCode(); 
		
		Scanner sc = new Scanner(url.openStream());
		String jsonString = "";
		while(sc.hasNext()){
			jsonString+=sc.nextLine();
		}
		sc.close();
		
		//create jsonObject out of jsonString
	    JSONObject jsonObject = new JSONObject(jsonString);
	    
	    //name, size, type, alignment, ac, hp, speed
	    if(jsonObject.has("count")) {
	    	monsterCount = jsonObject.getInt("count");
//	    	System.out.println("" + monsterCount);
	    }
		
	    JSONArray monsterResults = jsonObject.getJSONArray("results");
		monstersList = new String[monsterResults.length()];
		for (int i = 0; i < monsterResults.length(); ++i) {
		    JSONObject monsterJSON = monsterResults.getJSONObject(i);
		    String monsterName = "";
		    if(monsterJSON.has("name")) {
		    	monsterName = monsterJSON.getString("name");
		    	monstersList[i] = monsterName;
		    }
		}
	    
//		for (int i = 0; i < monstersList.length; i++) {
//			System.out.println("Monster Name: " + monstersList[i]);
//		}
		
		
		HBox[] hBoxArray = new HBox[monstersList.length];
	    Button[] buttonArray = new Button[monstersList.length];
	    
	    for (int i = 0; i < monstersList.length; i++) {
	    	int number = i;
			buttonArray[i] = new Button(monstersList[i]);
			buttonArray[i].setOnMouseClicked(e -> getMonster(number));
			buttonArray[i].setPrefWidth(width-19);
			hBoxArray[i] = new HBox(buttonArray[i]);
			vBox.getChildren().add(hBoxArray[i]);
		}
	}

	private void getMonster(int monsterNumber) {
		System.out.println("Monster number: " +  (monsterNumber + 1));
		try {
			mainController.changeMonsterScene(monsterNumber + 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	
}
