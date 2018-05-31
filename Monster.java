import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Monster {

	public String name;
	public String size;
	public String type;
	public String alignment;
	public long ac;
	public long hp;
	public String speed;
	public long strength;
	public long dexterity;
	public long constitution;
	public long intelligence;
	public long wisdom;
	public long charisma;
	public long strMod;
	public long dexMod;
	public long conMod;
	public long intMod;
	public long wisMod;
	public long chaMod;
	
	public Monster (String monsterName, String size, String type, String alignment, long ac, long hp, String speed, long strength, long dexterity, long constitution, long intelligence, long wisdom, long charisma) {
		
		this.name = monsterName;
		this.size = size;
		this.type = type;
		this.alignment = alignment;
		this.ac = ac;
		this.hp = hp;
		this.speed = speed;
		this.strength = strength;
		if(strength%2==1) {
			this.strMod = (strength-11)/2;
		}
		else {
			strMod = (strength-10)/2;
		}
		this.dexterity = dexterity;
		if(dexterity%2==1) {
			this.dexMod = (dexterity-11)/2;
		}
		else {
			dexMod = (dexterity-10)/2;
		}
		this.constitution = constitution;
		if(constitution%2==1) {
			conMod = (constitution-11)/2;
		}
		else {
			conMod = (constitution-10)/2;
		}
		this.intelligence = intelligence;
		if(intelligence%2==1) {
			intMod = (intelligence-11)/2;
		}
		else {
			intMod = (intelligence-10)/2;
		}
		this.wisdom = wisdom;
		if(wisdom%2==1) {
			this.wisMod = (wisdom-11)/2;
		}
		else {
			wisMod = (wisdom-10)/2;
		}
		this. charisma = charisma;
		if(charisma%2==1) {
			chaMod = (charisma-11)/2;
		}
		else {
			chaMod = (charisma-10)/2;
		}
		
		
	}
	
}
