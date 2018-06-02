import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Monster {

	public String name;
	public String size;
	public String type;
	public String subtype;
	public String alignment;
	public Integer ac;
	public Integer hp;
	public String speed;
	
	public Integer strength;
	public Integer dexterity;
	public Integer constitution;
	public Integer intelligence;
	public Integer wisdom;
	public Integer charisma;
	public int strMod;
	public int dexMod;
	public int conMod;
	public int intMod;
	public int wisMod;
	public int chaMod;
	
	public Integer strSave;
	public Integer dexSave;
	public Integer conSave;
	public Integer intSave;
	public Integer wisSave;
	public Integer chaSave;
	
	//strength
	public Integer athletics;
	//dexterity
	public Integer acrobatics;
	public Integer sleighOfHand;
	public Integer stealth;
	//intelligence
	public Integer arcana;
	public Integer history;
	public Integer investigation;
	public Integer nature;
	public Integer religion;
	//wisdom
	public Integer animalHandling;
	public Integer insight;
	public Integer medicine;
	public Integer perception;
	public Integer survival;
	//charisma
	public Integer deception;
	public Integer intimidation;
	public Integer performance;
	public Integer persuasion;
	
	public String damageVulnerabilities;
	public String damageResistances;
	public String damageImmunities;
	public String conditionImmunities;
	public String senses;
	public String languages;
	public Float challengeRating;
	
	public Ability[] abilities;
		
	public String testString;
	
	public Monster(int monsterNumber) throws IOException {
		//connect to API and retrive json
		URL url = new URL("http://www.dnd5eapi.co/api/monsters/" + monsterNumber + "/");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		conn.setRequestMethod("GET"); 
		conn.connect();
		int responsecode = conn.getResponseCode(); 
		
		Scanner sc = new Scanner(url.openStream());
		String jsonString = "";
		System.out.println("\nJSON  string format");
		while(sc.hasNext()){
		jsonString+=sc.nextLine();
		System.out.println(jsonString);
		}
		sc.close();
		
		//create jsonObject out of jsonString
        JSONObject jsonObject = new JSONObject(jsonString);
        
        //name, size, type, alignment, ac, hp, speed
        if(jsonObject.has("name")) {
        	name = jsonObject.getString("name");
        }
        if(jsonObject.has("size")) {
        	size = jsonObject.getString("size");
        }
        if(jsonObject.has("type")){
        	type = jsonObject.getString("type");
        }
        if(jsonObject.has("alignment")){
        	alignment = jsonObject.getString("alignment");
        }
        if(jsonObject.has("armor_class")) {
        	ac = jsonObject.getInt("armor_class");
        }
        if(jsonObject.has("hit_points")) {
        	hp = jsonObject.getInt("hit_points");
        }
        if(jsonObject.has("speed")) {
        	speed = jsonObject.getString("speed");
        }
        //str dex con int wis cha and the mods
        if(jsonObject.has("strength")) {
        	strength = jsonObject.getInt("strength");
        }
        if(jsonObject.has("dexterity")) {
        	dexterity = jsonObject.getInt("dexterity");
        }
        if(jsonObject.has("constitution")) {
        	constitution = jsonObject.getInt("constitution");
        }
        if(jsonObject.has("intelligence")) {
        	intelligence = jsonObject.getInt("intelligence");
        }
        if(jsonObject.has("wisdom")) {
        	wisdom = jsonObject.getInt("wisdom");
        }
        if(jsonObject.has("charisma")) {
        	charisma = jsonObject.getInt("charisma");
        }
        if(strength != null) {
	        if(strength%2==1) {
				this.strMod = (strength-11)/2;
			}
			else {
				strMod = (strength-10)/2;
			}
        }
        if(dexterity != null) {
			if(dexterity%2==1) {
				this.dexMod = (dexterity-11)/2;
			}
			else {
				dexMod = (dexterity-10)/2;
			}
        }
		if(constitution != null) {
			if(constitution%2==1) {
				conMod = (constitution-11)/2;
			}
			else {
				conMod = (constitution-10)/2;
			}
		}
		if(intelligence != null) {
			if(intelligence%2==1) {
				intMod = (intelligence-11)/2;
			}
			else {
				intMod = (intelligence-10)/2;
			}
		}
		if(wisdom != null) {
			if(wisdom%2==1) {
				this.wisMod = (wisdom-11)/2;
			}
			else {
				wisMod = (wisdom-10)/2;
			}
		}
		if(charisma != null) {
			if(charisma%2==1) {
				chaMod = (charisma-11)/2;
			}
			else {
				chaMod = (charisma-10)/2;
			}
		}
		//saves
		if(jsonObject.has("strength_save")) {
        	strSave = jsonObject.getInt("strength_save");
        }
		if(jsonObject.has("dexterity_save")) {
        	dexSave = jsonObject.getInt("dexterity_save");
        }
		if(jsonObject.has("constitution_save")) {
        	conSave = jsonObject.getInt("constitution_save");
        }
		if(jsonObject.has("intelligence_save")) {
        	intSave = jsonObject.getInt("intelligence_save");
        }
		if(jsonObject.has("wisdom_save")) {
        	wisSave = jsonObject.getInt("wisdom_save");
        }
		if(jsonObject.has("charisma_save")) {
        	chaSave = jsonObject.getInt("charisma_save");
        }
		//strength
		if(jsonObject.has("athletics")) {
			athletics = jsonObject.getInt("athletics");
        }
		//dexterity
		if(jsonObject.has("acrobatics")) {
        	acrobatics = jsonObject.getInt("acrobatics");
        }
		if(jsonObject.has("sleighOfHand")) {
        	sleighOfHand = jsonObject.getInt("sleighOfHand");
        }
		if(jsonObject.has("stealth")) {
        	stealth = jsonObject.getInt("stealth");
        }
		//intelligence
		if(jsonObject.has("arcana")) {
        	arcana = jsonObject.getInt("arcana");
        }
		if(jsonObject.has("history")) {
        	history = jsonObject.getInt("history");
        }
		if(jsonObject.has("investigation")) {
        	investigation = jsonObject.getInt("investigation");
        }
		if(jsonObject.has("nature")) {
        	nature = jsonObject.getInt("nature");
        }
		if(jsonObject.has("religion")) {
        	religion = jsonObject.getInt("religion");
        }
		//wisdom
		if(jsonObject.has("animalHandling")) {
        	animalHandling = jsonObject.getInt("animalHandling");
        }
		if(jsonObject.has("insight")) {
        	insight = jsonObject.getInt("insight");
        }
		if(jsonObject.has("medicine")) {
        	medicine = jsonObject.getInt("medicine");
        }
		if(jsonObject.has("perception")) {
        	perception = jsonObject.getInt("perception");
        }
		if(jsonObject.has("survival")) {
        	survival = jsonObject.getInt("survival");
        }
		//charisma
		if(jsonObject.has("deception")) {
        	deception = jsonObject.getInt("deception");
        }
		if(jsonObject.has("intimidation")) {
        	intimidation = jsonObject.getInt("intimidation");
        }
		if(jsonObject.has("performance")) {
        	performance = jsonObject.getInt("performance");
        }
		if(jsonObject.has("persuasion")) {
        	persuasion = jsonObject.getInt("persuasion");
        }
		
		//damage vulnerabilities, resitances, immunities, condition immunities
		if(jsonObject.has("damage_vulnerabilities")) {
        	damageVulnerabilities = jsonObject.getString("damage_vulnerabilities");
        }
		if(jsonObject.has("damage_resistances")) {
        	damageResistances = jsonObject.getString("damage_resistances");
        }
		if(jsonObject.has("damage_immunities")) {
        	damageImmunities = jsonObject.getString("damage_immunities");
        }
		if(jsonObject.has("condition_immunities")) {
        	conditionImmunities = jsonObject.getString("condition_immunities");
        }
		//senses, languages, challengeRating
        if(jsonObject.has("senses")) {
        	senses = jsonObject.getString("senses");
        }
        if(jsonObject.has("languages")) {
        	languages = jsonObject.getString("languages");
        }
        if(jsonObject.has("challenge_rating")) {
        	challengeRating = jsonObject.getFloat("challenge_rating");
        }
        //special abilities
        if(jsonObject.has("special_abilities")) {
			JSONArray specialAbilities = jsonObject.getJSONArray("special_abilities");
			abilities = new Ability[specialAbilities.length()];
			for (int i = 0; i < specialAbilities.length(); ++i) {
				//get ith special ability from json
			    JSONObject abilityJSON = specialAbilities.getJSONObject(i);		    
			    int attackBonus = abilityJSON.getInt("attack_bonus");
			    String desc = abilityJSON.getString("desc");
//	        	System.out.println("Ability desc: " + desc);
			    String abilityName = abilityJSON.getString("name"); 
			    Ability ability = new Ability(attackBonus, desc, abilityName);
			    abilities[i] = ability;
			}
			System.out.println("TEST");
			for(int i = 0; i < abilities.length; i++) {
	        	System.out.println("Ability desc: " + abilities[i].desc);
	        }
        }
        
        
        
	}

}
