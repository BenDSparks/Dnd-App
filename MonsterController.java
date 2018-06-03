// Monster Scene

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.ParseException;
//import org.json.simple.parser.JSONParser;



public class MonsterController implements Initializable {

	@FXML
	private VBox vBox;
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
	private Label strLabel;
	@FXML
	private Label dexLabel;
	@FXML
	private Label conLabel;
	@FXML
	private Label intLabel;
	@FXML
	private Label wisLabel;
	@FXML
	private Label chaLabel;
	@FXML
	private HBox savingThrowsHBox;
	@FXML
	private Label savingThrowsLabel;
	@FXML
	private HBox skillListHBox;
	@FXML
	private Label skillListLabel;
	@FXML
	private HBox damageVulnerabilitiesHBox;
	@FXML
	private Label damageVulnerabilitiesLabel;
	@FXML
	private HBox damageResistancesHBox;
	@FXML
	private Label damageResistancesLabel;
	@FXML
	private HBox damageImmunitiesHBox;
	@FXML
	private Label damageImmunitiesLabel;
	@FXML
	private HBox conditionImmunitiesHBox;
	@FXML
	private Label conditionImmunitiesLabel;
	@FXML
	private HBox sensesHBox;
	@FXML
	private Label sensesLabel;
	@FXML
	private HBox languagesHBox;
	@FXML
	private Label languagesLabel;
	@FXML
	private HBox challengeRatingHBox;
	@FXML
	private Label challengeRatingLabel;
	@FXML
	private VBox abilitiesVBox;
	@FXML
	private VBox actionsVBox;
	@FXML
	private VBox legendaryActionsVBox;
	
	
	private Monster monster;
	private double width = 600;
	private double height = 700;
	
	public void initData(int monsterNumber) throws IOException {
		monster = new Monster(monsterNumber);
		setView();
	}
		  
	
	
	public void setView() {
		
		monsterNameLabel.setText(monster.name);
		sizeTypeAlignmentLabel.setText(monster.size + " " + monster.type + ", " + monster.alignment);
		acLabel.setText(""+monster.ac);
		hpLabel.setText(""+monster.hp);
		speedLabel.setText(monster.speed);
		
		if(monster.strength != null) {
			if(monster.strMod > 0) {
				strLabel.setText(monster.strength + "(+" + monster.strMod + ")");
			}
			else {
				strLabel.setText(monster.strength + "(" + monster.strMod + ")");
			}
		}
		if(monster.dexterity != null) {
			if(monster.dexMod > 0) {
				dexLabel.setText(monster.dexterity + "(+" + monster.dexMod + ")");
			}
			else {
				dexLabel.setText(monster.dexterity + "(" + monster.dexMod + ")");
			}
		}
		else {
			dexLabel.setText("N/A");
		}
		if(monster.constitution != null) {
			if(monster.conMod > 0) {
				conLabel.setText(monster.constitution + "(+" + monster.conMod + ")");
			}
			else {
				conLabel.setText(monster.constitution + "(" + monster.conMod + ")");
			}
		}
		else {
			conLabel.setText("N/A");
		}
		if(monster.intelligence != null) {
			if(monster.intMod > 0) {
				intLabel.setText(monster.intelligence + "(+" + monster.intMod + ")");
			}
			else {
				intLabel.setText(monster.intelligence + "(" + monster.intMod + ")");
			}
		}
		else {
			intLabel.setText("N/A");
		}
		if(monster.wisdom != null) {
			if(monster.wisMod > 0) {
				wisLabel.setText(monster.wisdom + "(+" + monster.wisMod + ")");
			}
			else {
				wisLabel.setText(monster.wisdom + "(" + monster.wisMod + ")");
			}
		}
		else {
			wisLabel.setText("N/A");
		}
		if(monster.charisma != null){
			if(monster.chaMod > 0) {
				chaLabel.setText(monster.charisma + "(+" + monster.chaMod + ")");
			}
			else {
				chaLabel.setText(monster.charisma + "(" + monster.chaMod + ")");
			}
		}
		else {
			chaLabel.setText("N/A");
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		String savingThrowString = "";
		Boolean hasSavingThrows = false;
		Boolean hasSavesBefore = false;
		
		if(monster.strSave != null) {
			savingThrowString += "Str +" + monster.strSave;
			hasSavingThrows = true;
			hasSavesBefore = true;
		}
		if(monster.dexSave != null) {
			if(hasSavesBefore) {
				savingThrowString += ", ";
			}
			savingThrowString += "Dex +" + monster.dexSave;
			hasSavingThrows = true;
			hasSavesBefore = true;
		}
		if(monster.conSave != null) {
			if(hasSavesBefore) {
				savingThrowString += ", ";
			}
			savingThrowString += "Con +" + monster.conSave;
			hasSavingThrows = true;
			hasSavesBefore = true;
		}
		if(monster.intSave != null) {
			if(hasSavesBefore) {
				savingThrowString += ", ";
			}
			savingThrowString += "Int +" + monster.intSave;
			hasSavingThrows = true;
			hasSavesBefore = true;
		}
		if(monster.wisSave != null) {
			if(hasSavesBefore) {
				savingThrowString += ", ";
			}
			savingThrowString += "Wis +" + monster.wisSave;
			hasSavingThrows = true;
			hasSavesBefore = true;
		}
		if(monster.chaSave != null) {
			if(hasSavesBefore) {
				savingThrowString += ", ";
			}
			savingThrowString += "Cha +" + monster.chaSave;
			hasSavingThrows = true;
			hasSavesBefore = true;
		}
		if(hasSavingThrows) {
			savingThrowsLabel.setText(savingThrowString);
		}
		else {
			vBox.getChildren().remove(savingThrowsHBox);
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String skillsString = "";
		Boolean hasSkills = false;
		Boolean hasSkillsBefore = false;
		
		if(monster.athletics != null) {
			skillsString += "Athletics +" + monster.athletics;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.sleighOfHand != null) {
			if(hasSavesBefore) {
				skillsString += ", ";
			}
			skillsString += "Sleight of hand +" + monster.sleighOfHand;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.stealth != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Stealth +" + monster.stealth;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.arcana != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Arcana +" + monster.arcana;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.history != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "History +" + monster.history;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.investigation != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Investigation +" + monster.investigation;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.nature != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Nature +" + monster.nature;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.religion != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Religion +" + monster.religion;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.animalHandling != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Animal Handling +" + monster.animalHandling;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.insight != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Insight +" + monster.insight;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.medicine != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Medicine +" + monster.medicine;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.perception != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Perception +" + monster.perception;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.survival != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Survival +" + monster.survival;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.deception != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Deception +" + monster.deception;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.intimidation != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Intimidation +" + monster.intimidation;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.performance != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Performance +" + monster.performance;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		if(monster.persuasion != null) {
			if(hasSkillsBefore) {
				skillsString += ", ";
			}
			skillsString += "Persuasion +" + monster.persuasion;
			hasSkills = true;
			hasSkillsBefore = true;
		}
		
		if(hasSkills) {
			skillListLabel.setText(skillsString);
		}
		else {
			vBox.getChildren().remove(skillListHBox);
		}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if(monster.damageVulnerabilities != null) {
			if(monster.damageVulnerabilities.equals("")) {
				vBox.getChildren().remove(damageVulnerabilitiesHBox);
			}
			else {
				damageVulnerabilitiesLabel.setText("Damage Vulnerabilities: " + monster.damageVulnerabilities);
			}
		}
		if(monster.damageImmunities != null) {
			if(monster.damageImmunities.equals("")) {
				vBox.getChildren().remove(damageImmunitiesHBox);
			}
			else {
				damageImmunitiesLabel.setText("Damage Immunities: " + monster.damageImmunities);
			}
		}
		if(monster.damageResistances != null) {
			if(monster.damageResistances.equals("")) {
				vBox.getChildren().remove(damageResistancesHBox);
			}
			else {
				damageResistancesLabel.setText("Damage Resistances: " + monster.damageResistances);
			}
		}
		if(monster.conditionImmunities != null) {
			if(monster.conditionImmunities.equals("")) {
				vBox.getChildren().remove(conditionImmunitiesHBox);
			}
			else {
				conditionImmunitiesLabel.setText("Condition Immunities: " + monster.conditionImmunities);
			}
		}
		if(monster.senses != null) {
			if(monster.senses.equals("")) {
				vBox.getChildren().remove(sensesHBox);
			}
			else {
				sensesLabel.setText(monster.senses);
			}
		}
		if(monster.languages != null) {
			if(monster.languages.equals("")) {
				vBox.getChildren().remove(languagesHBox);
			}
			else {
				languagesLabel.setText(monster.languages);
			}
		}
		if(monster.challengeRating != null) {
			Float cr = monster.challengeRating;
			if(cr == 0) {
				challengeRatingLabel.setText("0");				
			}
			else if(cr == 0.125) {
				challengeRatingLabel.setText("1/8");
			}
			else if (cr == .25) {
				challengeRatingLabel.setText("1/4");
			}
			else if (cr == .5) {
				challengeRatingLabel.setText("1/2");
			}
			else if (cr >= 1) {
				challengeRatingLabel.setText("" + cr);
			}
		}
		else {
			challengeRatingLabel.setText("N/A");
		}
		

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//special abilities
		if(monster.abilities != null) {			
			for (int i = 0; i < monster.abilities.length; i++) {
				HBox hBox1 = new HBox();
				Label nameLabel = new Label(monster.abilities[i].name);
				hBox1.getChildren().add(nameLabel);
				abilitiesVBox.getChildren().add(hBox1);
				HBox hBox2 = new HBox();
				Label descLabel = new Label(monster.abilities[i].desc);
				hBox2.getChildren().add(descLabel);
				abilitiesVBox.getChildren().add(hBox2);
			}
		}
		else {
			vBox.getChildren().remove(abilitiesVBox);
		}
				
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//actions
		if(monster.actions != null) {			
			for (int i = 0; i < monster.actions.length; i++) {
				HBox hBox1 = new HBox();
				hBox1.setPadding(new Insets(10, 0, 0, 0));
				Label nameLabel = new Label(monster.actions[i].name);
				hBox1.getChildren().add(nameLabel);
				actionsVBox.getChildren().add(hBox1);
				HBox hBox2 = new HBox();
				Label descLabel = new Label(monster.actions[i].desc);
				descLabel.setWrapText(true);
				descLabel.setMaxWidth(width-40);
				hBox2.getChildren().add(descLabel);
				actionsVBox.getChildren().add(hBox2);
			}
		}
		else {
			vBox.getChildren().remove(actionsVBox);
		}
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		//legendary actions
				if(monster.legendaryActions != null) {			
					for (int i = 0; i < monster.legendaryActions.length; i++) {
						HBox hBox1 = new HBox();
						hBox1.setPadding(new Insets(10, 0, 0, 0));
						Label nameLabel = new Label(monster.legendaryActions[i].name);						
						hBox1.getChildren().add(nameLabel);
						legendaryActionsVBox.getChildren().add(hBox1);
						HBox hBox2 = new HBox();
						Label descLabel = new Label(monster.legendaryActions[i].desc);
						descLabel.setWrapText(true);
						descLabel.setMaxWidth(width-40);
						hBox2.getChildren().add(descLabel);
						legendaryActionsVBox.getChildren().add(hBox2);
					}
				}
				else {
					vBox.getChildren().remove(actionsVBox);
				}	
		
		
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
