// Monster Scene

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class MonsterController implements Initializable {

	@FXML
	private Label monsterNameLabel;
	@FXML
	private Label sizeTypeAlignmentLabel;
	@FXML
	private Label acLabel;
	@FXML
	private Label hpLabel;
	@FXML
	private Label speedLabel;
	@FXML
	private Label strLabel, dexLabel, conLabel, intLabel, wisLabel, chaLabel;

	private int monsterNumber;
	private Monster monster;

	public void initData(int monsterNumber) throws IOException {
		this.monsterNumber = monsterNumber;
		getMonsterStats(this.monsterNumber);
		setView();
	}
	
	private void getMonsterStats(int monsterNumber) throws IOException {
		URL url = new URL("http://www.dnd5eapi.co/api/monsters/" + monsterNumber + "/");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		conn.setRequestMethod("GET"); 
		conn.connect();
		int responsecode = conn.getResponseCode(); 
		
		Scanner sc = new Scanner(url.openStream());
		String jsonString = "";
		System.out.println("\nJSON data in string format");
		while(sc.hasNext()){
		jsonString+=sc.nextLine();
		System.out.println(jsonString);
		}
		
		sc.close();
		
		// parsing file "JSONExample.json"
        Object obj;
		try {
			obj = new JSONParser().parse(jsonString);
			// typecasting obj to JSONObject
	        JSONObject jo = (JSONObject) obj;
	        // getting firstName and lastName
	        
	        
	        String name = "missing name";
	        if(jo.containsKey("name")) {
	        	name = (String) jo.get("name");
	        }
	        String size = "missing size";
	        if(jo.containsKey("size")) {
	        	size = (String) jo.get("size");
	        }
	        String type = "missing type";
	        if(jo.containsKey("type")){
	        	type = (String) jo.get("type");
	        }
	        String alignment = "missing alignment";
	        if(jo.containsKey("alignment")){
	        	alignment = (String) jo.get("alignment");
	        }
	        
	        long ac = -99;
	        long hp = -99;
	        
	        if(jo.containsKey("armor_class")) {
	        	ac = (long) jo.get("armor_class");
	        }
	        if(jo.containsKey("hit_points")) {
	        	hp = (long) jo.get("hit_points");
	        }
	        
	        
	        String speed = "missing speed";
	        if(jo.containsKey("speed")) {
	        	speed = (String) jo.get("speed");
	        }
	        
	        long strength = -99;
	        long dexterity = -99;
	        long constitution = -99;
	        long intelligence = -99;
	        long wisdom = -99;
	        long charisma = -99;
	        
	        if(jo.containsKey("strength")) {
	        	strength = (long) jo.get("strength");
	        }
	        if(jo.containsKey("dexterity")) {
	        	dexterity = (long) jo.get("dexterity");
	        }
	        if(jo.containsKey("constitution")) {
	        	constitution = (long) jo.get("constitution");
	        }
	        if(jo.containsKey("intelligence")) {
	        	intelligence = (long) jo.get("intelligence");
	        }
	        if(jo.containsKey("wisdom")) {
	        	wisdom = (long) jo.get("wisdom");
	        }
	        if(jo.containsKey("charisma")) {
	        	charisma = (long) jo.get("charisma");
	        }
	        
	        

	        monster = new Monster(name,size, type, alignment, ac, hp, speed, strength, dexterity, constitution, intelligence, wisdom, charisma); 
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error parsing JSON");
		}   
        System.out.println(monster.ac);	
	}
	
	public void setView() {
		monsterNameLabel.setText(monster.name);
		sizeTypeAlignmentLabel.setText(monster.size + " " + monster.type + ", " + monster.alignment);
		acLabel.setText(""+monster.ac);
		hpLabel.setText(""+monster.hp);
		speedLabel.setText(monster.speed);
		long strMod = (monster.strength-10)/2;
		if(strMod > 0) {
			strLabel.setText("" + monster.strength + "(+" + monster.strMod + ")");
		}
		else {
			strLabel.setText("" + monster.strength + "(+" + monster.strMod + ")");
		}
		long dexMod = (monster.dexterity-10)/2;
		if(dexMod > 0) {
			dexLabel.setText("" + monster.dexterity + "(+" + monster.dexMod + ")");
		}
		else {
			dexLabel.setText("" + monster.dexterity + "(" + monster.dexMod + ")");
		}
		long conMod = (monster.constitution-10)/2;
		if(dexMod > 0) {
			conLabel.setText("" + monster.constitution + "(+" + monster.conMod + ")");
		}
		else {
			conLabel.setText("" + monster.constitution + "(" + monster.conMod + ")");
		}
		long intMod = (monster.intelligence-10)/2;
		if(intMod > 0) {
			intLabel.setText("" + monster.intelligence + "(+" + monster.intMod + ")");
		}
		else {
			intLabel.setText("" + monster.intelligence + "(" + monster.intMod + ")");
		}
		long wisMod = (monster.wisdom-10)/2;
		if(wisMod > 0) {
			wisLabel.setText("" + monster.wisdom + "(+" + monster.wisMod + ")");
		}
		else {
			wisLabel.setText("" + monster.wisdom + "(" + monster.wisMod + ")");
		}
		long chaMod = (monster.charisma-10)/2;
		if(chaMod > 0) {
			chaLabel.setText("" + monster.charisma + "(+" + monster.chaMod + ")");
		}
		else {
			chaLabel.setText("" + monster.charisma + "(" + monster.chaMod + ")");
		}
	}

	public void setMonsterNumber(int monsterNumber) {
		this.monsterNumber = monsterNumber;
		System.out.println("Monster number = " + monsterNumber);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
